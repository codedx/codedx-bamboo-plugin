package com.codedx.plugins.bamboo.utils;

import org.apache.log4j.Logger;
import org.springframework.util.AntPathMatcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archiver {

	private static final Logger _logger = Logger.getLogger(Archiver.class);

	public static File archive(File workspace, String paths, String excludePaths, String prefix) throws IOException {

		_logger.info(String.format("archive(...) called.  paths: %s || excludePaths: %s || prefix: %s", emptyIfNull(paths), emptyIfNull(excludePaths), emptyIfNull(prefix)));

		List<File> files = getFiles(workspace, workspace, paths, excludePaths);

		Path workspaceDir = Paths.get(workspace.getCanonicalPath());
		Path tempFile = Files.createTempFile(prefix, ".zip");
		File zip = tempFile.toFile();

		try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zip))) {
			for (File file : files) {
				if(file.isDirectory())
				{
					continue;
				}
				Path pathToFile = Paths.get(file.getCanonicalPath());
				String pathInZip = workspaceDir.relativize(pathToFile).toString();
				ZipEntry e = new ZipEntry(pathInZip);
				zout.putNextEntry(e);

				try (FileInputStream fis = new FileInputStream(file)) {
					addFileToZip(zout, fis);
				}
			}
		}
		return zip;
	}

	public static void addFileToZip(ZipOutputStream zout, FileInputStream fis) throws IOException {
		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zout.write(bytes, 0, length);
		}
		zout.closeEntry();
		fis.close();
	}

	private static String[] splitFileWildcards(final String string) {
		if (string != null) {
			final String[] split = string.split(",");
			for(int i = 0; i < split.length; i++) {
				split[i] = split[i].trim();
			}
			return split;
		}
		return new String[0];
	}

	private static List<File> getFiles(File rootPath, File directory, String paths, String excludePaths) throws IOException {
		AntPathMatcher matcher = new AntPathMatcher();

		List<File> collectedFiles = new ArrayList<>();
		File[] files = directory.listFiles();
		for (File file : files)
		{
			if (matches(matcher, paths, excludePaths, file.getCanonicalPath().substring(rootPath.getCanonicalPath().length()))) {
				collectedFiles.add(file);

				// recursively add subdirectories
				if(file.isDirectory())
				{
					collectedFiles.addAll(getFiles(rootPath, file, paths, excludePaths));
				}
			}
		}

		return collectedFiles;
	}

	// Helper to filter which files are uploaded
	private static boolean matches(AntPathMatcher matcher, String includePaths, String excludePaths, String filePathToTest) {

		// Paths are separated by commas.
		String[] toInclude = includePaths.split(",");
		String[] toExclude = excludePaths.split(",");

		// For the AntPathMatcher, it is recommended to prefix paths with "/" when it makes sense to do so.
		// Adding this is needed to match functionality with our other plug-ins (example: without it "**" won't match on some systems).
		boolean needsStartingSlash = matcher.match("/**", filePathToTest) && !matcher.match("**", filePathToTest);
		for (int i = 0; i < toInclude.length; i++) {
			toInclude[i] = toInclude[i].trim(); // Trim while we are here iterating
			if (needsStartingSlash && !toInclude[i].startsWith("/")) {
				toInclude[i] = "/" + toInclude[i];
			}
		}
		for (int i = 0; i < toExclude.length; i++) {
			toExclude[i] = toExclude[i].trim(); // Trim while we are here iterating
			if (!toExclude[i].isEmpty() && needsStartingSlash && !toExclude[i].startsWith("/")) {
				toExclude[i] = "/" + toExclude[i];
			}
		}

		// Check if we match any of the "include" paths.
		for (int i = 0; i < toInclude.length; i++) {
			if (matcher.match(toInclude[i], filePathToTest)) {
				// Have to check against each exclude path.  Only pass if all exclusion patterns fail to match.
				boolean success = true;
				for (int j = 0; j < toExclude.length; j++) {
					if (matcher.match(toExclude[j], filePathToTest)) {
						success = false;
						break;
					}
				}
				if (success) {
					return true;
				}
			}
		}
		return false;
	}

	// Private helpers
	private static String emptyIfNull(String value) {
		if (value == null) {
			return "";
		}
		return value;
	}
}
