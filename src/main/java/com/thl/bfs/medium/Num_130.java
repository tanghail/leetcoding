package com.thl.bfs.medium;

import java.util.*;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * 思路一：广度优先搜索
 *
 * 思路二：广度优先搜索：标记和边缘元素'O'相连接的序列
 *
 */
public class Num_130 {
	public static void main(String[] args) {
		char[][] board = new char[][] {
				{'X','O','X','O','X','O'},
				{'O','X','O','X','O','X'},
				{'X','O','X','O','X','O'},
				{'O','X','O','X','O','X'}
		};

		for (char[] value : board) {
			for (char v : value)
				System.out.print(v + " ");

			System.out.println();
		}

		System.out.println("=================");

		Num_130 test = new Num_130();
		test.solve2(board);
		for (char[] value : board) {
			for (char v : value)
				System.out.print(v + " ");

			System.out.println();
		}


	}

	public void solve2(char[][] board) {
		if (board == null || board.length == 0)
			return;

		int rows = board.length;
		int cols = board[0].length;
		for (int i = 0; i < rows; i++) {
			if (i == 0 || i == rows -1) {
				for (int j = 0; j < cols; j++) {
					if (board[i][j] == 'O')
						dfs2(board, i, j);
				}
			}

			if (board[i][0] == 'O')
				dfs2(board, i, 0);

			if (board[i][cols-1] == 'O')
				dfs2(board, i, cols-1);
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';

				if (board[i][j] == 'Y') {
					board[i][j] = 'O';
				}

			}
		}
	}

	public void dfs2(char[][] board, int i, int j) {
		if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != 'O')
			return;

		board[i][j] = 'Y';
		dfs2(board, i+1, j);
		dfs2(board, i-1, j);
		dfs2(board, i, j+1);
		dfs2(board, i, j-1);
	}


	public void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;

		int rows = board.length;
		int cols = board[0].length;
		LinkedList<Object> queue = new LinkedList<>();

		//保存不能被填充的O节点
		int[][] visited = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 'O') {
					if (visited[i][j] == 1)
						continue;

					dfs(board, i, j, visited);

				}


			}
		}


	}

	public boolean dfs(char[][] board, int i, int j, int[][] visited) {
		//深度优先算法
		visited[i][j] = 1;
		if (i==0 || j == 0 || i == board.length -1 || j == board[0].length -1)
			return false;

		board[i][j] = 'X';
		if (board[i - 1][j] == 'O') {
			if (!dfs(board, i-1, j, visited)) {
				board[i][j] = 'O';
				return false;
			}
		}

		if (board[i + 1][j] == 'O') {
			if (!dfs(board, i+1, j, visited)) {
				board[i][j] = 'O';
				return false;
			}
		}

		if (board[i][j-1] == 'O') {
			if (!dfs(board, i, j-1, visited)) {
				board[i][j] = 'O';
				return false;
			}
		}

		if (board[i][j+1] == 'O') {
			if (!dfs(board, i, j+1, visited)) {
				board[i][j] = 'O';
				return false;
			}
		}

		return true;

	}


}
