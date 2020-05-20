package com.thl.bfs.medium;

import sun.applet.Main;

import java.util.*;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 分析：对于二维网络寻找路径的问题可以基本上可以从图的解决方案类似来考虑：dfs或者bfs
 *
 * 思路一：广度优先搜索：
 *
 */
public class Num_200 {
	private int nums = 0;

	public static void main(String[] args) {
		char[] data = {'1','2','3'};
		char[] chars = Arrays.copyOf(data, data.length);
		data[1] = '5';
		for (char c : chars)
			System.out.println(c);


	}
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		int rows = grid.length;
		int cols = grid[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '1')
					bfs(grid, i, j);
			}
		}
		return nums;
	}

	private void bfs (char[][] grid, int row, int col) {
		int rows = grid.length;
		int cols = grid[0].length;
		nums++;
		LinkedList<Pair> queue = new LinkedList<>();
		queue.addLast(new Pair(row, col));
		while (!queue.isEmpty()) {
			Pair first = queue.pollFirst();
			int i = first.i;
			int j = first.j;
			if (i > 0 && grid[i-1][j] == '1') {
				grid[i-1][j] = '2';
				queue.addLast(new Pair(i-1, j));
			}

			if (i < rows-1 && grid[i+1][j] == '1') {
				grid[i+1][j] = '2';
				queue.addLast(new Pair(i+1, j));
			}

			if (j > 0 && grid[i][j-1] == '1') {
				grid[i][j-1] = '2';
				queue.addLast(new Pair(i, j-1));
			}

			if (j < cols-1 && grid[i][j+1] == '1') {
				grid[i][j+1] = '2';
				queue.addLast(new Pair(i, j+1));
			}
		}
	}
}
