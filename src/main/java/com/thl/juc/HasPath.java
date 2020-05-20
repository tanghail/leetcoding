package com.thl.juc;

import java.util.ArrayList;

public class HasPath {
	public static void main(String[] args) {
		char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
		char[] str = {'b', 'z', 'c', 'e', 'd'};
		boolean result = hasPath(matrix, 3, 4, str);
		if(result) {
			System.out.println("存在该字符串");
		}else {
			System.out.println("不存在该字符串");
		}
	}

	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){

		char[][] arrs = new char[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j<cols; j ++)
				arrs[i][j] = matrix[i*cols + j];
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j<cols; j ++) {
				boolean exist = hasPath(arrs, str, i, j, 0);
				if (exist)
					return true;
			}
		}
		return false;
	}

	public static boolean hasPath(char[][] arrs, char[] str, int row, int col, int pos) {
		if (pos >= str.length)
			return true;

		if (row < 0 || row >= arrs.length || col < 0 || col >= arrs[0].length)
			return false;
		if (arrs[row][col] != str[pos])
			return false;

		return hasPath(arrs, str, row+1, col, pos+1)
				|| hasPath(arrs, str, row-1, col, pos+1)
				|| hasPath(arrs, str, row, col+1, pos+1)
				|| hasPath(arrs, str, row, col-1, pos+1);
	}


}
