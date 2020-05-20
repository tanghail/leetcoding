package com.thl.backTrack;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * 思路：路径探索问题，典型的回溯法来解决(同时需要状态设置和状态重置,在第一次做的时候没有考虑到这种情况导致没有通过)
 *
 */


public class Num_79 {
	public static void main(String[] args) {
		Num_79 test = new Num_79();
		char[][] chars = {
		{'C','A','A'},
		{'A','A','A'},
		{'B','C','D'}
	};
		boolean aaa = test.exist(chars, "AAB");
		System.out.println(aaa);
	}

	public boolean exist(char[][] board, String word) {
		if ((board == null || board.length == 0) && word != null)
			return false;

		int rows = board.length;
		int cols = board[0].length;
		int[][] status = new int[rows][cols];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(dfs(board, word, i, j, 0, status))
					return true;
			}
		}

		return false;

	}

	public boolean dfs(char[][] board, String word, int row, int col, int index, int[][] status){
		if (row < 0 || row == board.length || col < 0 || col == board[0].length || status[row][col] == 1)
			return false;

		if (word.charAt(index) != board[row][col]) {
			return false;
		}

		if (index == word.length()-1) {
			return true;
		}

		status[row][col] = 1;
		boolean result =  dfs(board, word, row+1, col, index+1,status) ||
				dfs(board, word, row-1, col, index+1,status) ||
				dfs(board, word, row, col+1, index+1,status) ||
				dfs(board, word, row, col-1, index+1,status);

		status[row][col] = 0;
		return result;
	}

}
