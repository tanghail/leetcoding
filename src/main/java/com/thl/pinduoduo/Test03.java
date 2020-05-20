package com.thl.pinduoduo;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test03 {
	public static String getFileList(String path) {
		File file = new File(path);
		StringBuilder sb = new StringBuilder();

		if (!file.exists() || file.isDirectory())
			return sb.toString();

		List<File> dirs = getDir(file, sb);
		for (File dir : dirs)
			sb.append(getFileList(dir.getAbsolutePath()));

		return sb.toString();
	}


	public static List<File> getDir(File file, StringBuilder stringBuilder){
		File[] files = file.listFiles();
		ArrayList<File> arr = new ArrayList<>();
		for (File child : files) {
			if (child.isDirectory())
				arr.add(child);
			else stringBuilder.append(child);
		}

		return arr;
	}
}
