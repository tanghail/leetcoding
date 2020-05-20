package com.thl.bfs.medium;

import java.util.*;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 *
 * 输出:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 *
 * 思考：本题应当是一个递归思想应用的题型，当前节点值是离0最近的，那周围的四个非0的值应该是当前的值加1；因此可以采用广度优先的算法
 *
 * 思路一：多元广度优先算法
 */
public class Num_542 {
	public int[][] updateMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return matrix;

		int rows = matrix.length;
		int cols = matrix[0].length;
		LinkedList<Pair> queue = new LinkedList<>();
		int[][] visited = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 0) {
					queue.addLast(new Pair(i, j));
					visited[i][j] = 1;
				}
			}
		}

		while (!queue.isEmpty()) {
			Pair pair = queue.pollFirst();
			int i = pair.i;
			int j = pair.j;
			visited[i][j] = 1;
			if (i > 0 && visited[i-1][j] == 0 && matrix[i-1][j] != 0) {
				matrix[i-1][j] = matrix[i][j]+1;
				visited[i-1][j] = 1;
				queue.addLast(new Pair(i-1, j));
			}

			if (i < rows-1 && visited[i+1][j] == 0 && matrix[i+1][j] != 0) {
				matrix[i+1][j] = matrix[i][j]+1;
				visited[i+1][j] = 1;
				queue.addLast(new Pair(i+1, j));
			}

			if (j > 0 && visited[i][j-1] == 0 && matrix[i][j-1] != 0) {
				matrix[i][j-1] = matrix[i][j]+1;
				visited[i][j-1] = 1;
				queue.addLast(new Pair(i, j-1));
			}

			if (j < cols-1 && visited[i][j+1] == 0 && matrix[i][j+1] != 0) {
				matrix[i][j+1] = matrix[i][j]+1;
				visited[i][j+1] = 1;
				queue.addLast(new Pair(i, j+1));
			}

		}


		return matrix;
	}

}

class Pair {
	int i;
	int j;

	public Pair(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
