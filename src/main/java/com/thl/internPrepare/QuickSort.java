package com.thl.internPrepare;

public class QuickSort {


	public void getstar(int[][] base, int[][] endLoc, int min, int[] position, int i, int j, int length){
		int row = base.length;
		int col = base[0].length;
		if (i < 0 || i == row || j < 0 || j == col || base[i][j] == 1 || base[i][j] == 2 )
			return;

		if (endLoc[i][j] == 1) {
			if (min > length) {
				min = length;
				position[0] = i;
				position[1] = j;
			}

			return;
		}

		base[i][j] = 2;
		getstar(base, endLoc, min, position, i+1, j, length+1);
		getstar(base, endLoc, min, position, i-1, j, length+1);
		getstar(base, endLoc, min, position, i, j+1, length+1);
		getstar(base, endLoc, min, position, i, j-1, length+1);
	}

}
