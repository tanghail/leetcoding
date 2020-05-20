package com.thl.backTrack;

import java.util.LinkedList;

/**
 * 腐烂的橘子
 *
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 * 思路一：多源广度优先搜索
 * （1）首先通过一次遍历查找到所有的已经腐烂的橘子，放入到一个队列中
 *
 */


public class Num_994 {
	public static void main(String[] args) {
		Num_994 test = new Num_994();
		int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
		System.out.println(test.orangesRotting(grid));


	}

	public int orangesRotting(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		LinkedList<Pair> queue = new LinkedList<Pair>();
		Integer count = 0;
		/**
		 * 第一层节点表示已经腐烂的橘子
		 */
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 2)
					queue.add(new Pair(i, j));

				//统计新鲜橘子的个数
				if (grid[i][j] == 1)
					count++;
			}
		}

		if (count == 0)
			return 0;

		int minute = 0;
		while (!queue.isEmpty()) {
			minute++;
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Pair curOrange = queue.pollFirst();
				//从四个方向将橘子腐烂
				count = check(grid, curOrange.x, curOrange.y, count, queue);
				if (count == 0)
					return minute;
			}

		}

		return -1;

	}

	/**
	 * 从四个方向检查是否有未被腐烂的橘子
	 * @param grid
	 * @param x
	 * @param y
	 * @param count
	 */
	public int check(int[][] grid, int x, int y, int count, LinkedList<Pair> queue){
		if (x < grid.length-1 && grid[x+1][y] == 1) {
			count--;
			grid[x+1][y] = 2;
			queue.addLast(new Pair(x+1, y));
		}
		if (x > 0 && grid[x-1][y] == 1) {
			count--;
			grid[x-1][y] = 2;
			queue.addLast(new Pair(x-1, y));
		}
		if (y < grid[0].length-1 && grid[x][y+1] == 1) {
			count--;
			grid[x][y+1] = 2;
			queue.addLast(new Pair(x, y+1));
		}
		if (y > 0 && grid[x][y-1] == 1) {
			count--;
			grid[x][y-1] = 2;
			queue.addLast(new Pair(x, y-1));
		}

		return count;
	}


}

class Pair {
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int x;
	int y;
}
