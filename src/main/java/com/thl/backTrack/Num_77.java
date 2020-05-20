package com.thl.backTrack;

import java.util.Stack;


public class Num_77 {
	public static void main(String[] args) {
		String str = "/..//";
		System.out.println(simplifyPath(str));
	}

	public static String simplifyPath(String path) {
		if (!path.startsWith("/")) {
			System.out.println("wrong format");
			return null;
		}

		String[] split = path.split("/");
		Stack<String> res = new Stack<String>();
		for (String str : split) {
			if ( ".".equals(str))
				continue;

			if ("".equals(str))
				continue;

			if ("..".equals(str)) {
				if (res.isEmpty()){
				} else
					res.pop();
				continue;
			}

			res.add("/" + str);
		}

		int size = res.size();
		if (size == 0)
			return "/";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(res.get(i));
		}

		return sb.toString();


	}

}
