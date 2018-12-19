package com.avi.codedx.bambooplugin.utils;

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

	public static File archive(File workspace, String paths, String excludePaths, String prefix) throws IOException {
		List<File> files = getFiles(workspace, paths, excludePaths);

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

	// TODO: implement actual file filtering (Possibly ANT style)
	private static List<File> getFiles(File workspace, String paths, String excludePaths) throws IOException {
		AntPathMatcher matcher = new AntPathMatcher();

		List<File> collectedFiles = new ArrayList<>();
		File[] files = workspace.listFiles();
		for (File file : files)
		{
			if (matches(matcher, paths, excludePaths, file.getCanonicalPath())) {
				collectedFiles.add(file);

				// recursively add subdirectories
				if(file.isDirectory())
				{
					collectedFiles.addAll(getFiles(file, paths, excludePaths));
				}
			}
		}

		return collectedFiles;
	}

	// Helper
	private static boolean matches(AntPathMatcher matcher, String includePaths, String excludePaths, String filePathToTest) {
		String[] toInclude = includePaths.split(",");
		String[] toExclude = excludePaths.split(",");
		for (int i = 0; i < toInclude.length; i++) {
			if (matcher.match(toInclude[i].trim(), filePathToTest)) {
				// Have to check against each exclude path.  Only pass if all exclude fail.
				boolean success = true;
				for (int j = 0; j < toExclude.length; j++) {
					if (matcher.match(toExclude[j].trim(), filePathToTest)) {
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
}
