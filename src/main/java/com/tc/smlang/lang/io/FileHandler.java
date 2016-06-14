package com.tc.smlang.lang.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class FileHandler {
	
	public static String loadClassFile(String path) {
		String contents = readToString(path);
		contents = stripWhitespace(contents);
		
		return contents;
	}
	
	public static String readToString(String path) {
		path = FilenameUtils.separatorsToSystem(path);
		File file = new File(path);
		String contents = null;
		try {
			contents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return contents;
	}
	
	public static String stripWhitespace(String contentToStrip) {
		return contentToStrip.replaceAll("\\s+", "");
	}
}
