package com.avi.codedx.bambooplugin.utils;

import com.avi.codedx.bambooplugin.utils.CodeDxBuildStatistics.Group;
import com.avi.codedx.client.api.GroupedCount;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CodeDxReportWriter {

	private final static String REPORT_FILE_NAME = "codedx-teamcity-report.html";

	private final static String CSS = "table{ border-collapse:collapse; width: 50%; margin:25px 25% 25px 25%; table-layout:fixed; }"
	                                + "td, th { border: 1px solid #dddddd; text-align:left; padding: 5px; }"
	                                + "a { display: block; text-align: center; }";

	private final static String HTML_BASE = "<html><head><style>%s</style><title>Code Dx Report</title></head><body>%s</body></html>";
	private final static String STATS_TABLE_BASE = "<table><tr><th>%s</th><th>Findings</th><th>Delta</th></tr>%s</table>";
	private final static String STATS_TABLE_ROWS_BASE = "<tr><td>%s</td><td>%s</td><td>%s</td></tr>";
	private final static String LINK_TO_CODEDX = "<a target=\"_blank\" href=\"%s\">%s</a>";

	private final String reportArchiveName;
	private final CodeDxBuildStatistics statsBeforeAnalysis;
	private final CodeDxBuildStatistics statsAfterAnalysis;
	private final String url;

	public CodeDxReportWriter(String reportArchiveName, CodeDxBuildStatistics statsBeforeAnalysis, CodeDxBuildStatistics statsAfterAnalysis, String url, int projectId) {
		this.reportArchiveName = reportArchiveName;
		this.statsBeforeAnalysis = statsBeforeAnalysis;
		this.statsAfterAnalysis = statsAfterAnalysis;
		this.url = url + "/projects/" + projectId;
	}

	public void writeReport(File workspace) throws IOException {
		try {
			Path workspacePath = Paths.get(workspace.getCanonicalPath());
			File reportZip = createReportZip(workspacePath);

			try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(reportZip))) {
				File reportHtml = createHtmlReport();
				ZipEntry reportEntry = new ZipEntry(REPORT_FILE_NAME);
				zout.putNextEntry(reportEntry);

				try (FileInputStream fis = new FileInputStream(reportHtml)) {
					Archiver.addFileToZip(zout, fis);
				}
			}
		} catch (IOException e) {
			throw new IOException("An error occurred while attempting to create the report file", e);
		}
	}

	private File createReportZip(Path workspacePath) throws IOException {
		Path pathToReportZip = Paths.get(workspacePath.toString(), reportArchiveName + ".zip");
		File reportZip = pathToReportZip.toFile();

		if (reportZip.exists()) {
			reportZip.delete();
		}

		reportZip.createNewFile();

		return reportZip;
	}

	private File createHtmlReport() throws IOException {
		String linkBack = String.format(LINK_TO_CODEDX, this.url, "View latest in Code Dx");

		String severityTableRows = makeSeverityTableRows();
		String severityTable = String.format(STATS_TABLE_BASE, "Severity", severityTableRows);

		String statusTableRows = makeStatusTableRows();
		String statusTable = String.format(STATS_TABLE_BASE, "Status", statusTableRows);

		String html = String.format(HTML_BASE, CSS, linkBack + severityTable + statusTable);

		File tempHtmlFile = Files.createTempFile("", ".html").toFile();
		tempHtmlFile.deleteOnExit();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempHtmlFile))){
			bw.write(html);
		}
		return tempHtmlFile;
	}

	private String makeSeverityTableRows() {
		StringBuilder sb = new StringBuilder();
		sb.append(makeRow(Group.SEVERITY, CodeDxConstants.CRITICAL))
			.append(makeRow(Group.SEVERITY, CodeDxConstants.HIGH))
			.append(makeRow(Group.SEVERITY, CodeDxConstants.MEDIUM))
			.append(makeRow(Group.SEVERITY, CodeDxConstants.LOW))
			.append(makeRow(Group.SEVERITY, CodeDxConstants.INFO))
			.append(makeRow(Group.SEVERITY, CodeDxConstants.TOTAL));

		return sb.toString();
	}

	private String makeStatusTableRows() {
		StringBuilder sb = new StringBuilder();

		sb.append(makeRow(Group.STATUS, CodeDxConstants.NEW))
			.append(makeRow(Group.STATUS, CodeDxConstants.FIXED))
			.append(makeRow(Group.STATUS, CodeDxConstants.MITIGATED))
			.append(makeRow(Group.STATUS, CodeDxConstants.IGNORED))
			.append(makeRow(Group.STATUS, CodeDxConstants.FALSE_POSITIVE))
			.append(makeRow(Group.STATUS, CodeDxConstants.UNRESOLVED))
			.append(makeRow(Group.STATUS, CodeDxConstants.ESCALATED))
			.append(makeRow(Group.STATUS, CodeDxConstants.ASSIGNED))
			.append(makeRow(Group.STATUS, CodeDxConstants.TOTAL));

		return sb.toString();
	}

	private String makeRow(Group group, String rowName) {
		List<GroupedCount> beforeCurrentAnalysis = new ArrayList<>();
		List<GroupedCount> afterCurrentAnalysis = new ArrayList<>();

		if (group == Group.STATUS) {
			beforeCurrentAnalysis = this.statsBeforeAnalysis.getGroupedStatusCounts();
			afterCurrentAnalysis = this.statsAfterAnalysis.getGroupedStatusCounts();
		} else if (group == Group.SEVERITY) {
			beforeCurrentAnalysis = this.statsBeforeAnalysis.getGroupedSeverityCounts();
			afterCurrentAnalysis = this.statsAfterAnalysis.getGroupedSeverityCounts();
		}

		Integer previousNumberOfFindingsForName = CodeDxBuildStatistics.getNumberOfFindingsForGroupAndName(beforeCurrentAnalysis, rowName);
		Integer currentNumberOfFindingsForName = CodeDxBuildStatistics.getNumberOfFindingsForGroupAndName(afterCurrentAnalysis, rowName);
		Integer findingsDelta = currentNumberOfFindingsForName - previousNumberOfFindingsForName;

		return String.format(STATS_TABLE_ROWS_BASE, rowName, currentNumberOfFindingsForName.toString(), findingsDelta.toString());
	}
}