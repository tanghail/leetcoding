package com.thl.backTrack;

/**
 *
 *
 */


public class SearchMatrix {
	public static void main(String[] args) {
		int[][] matrixs = {{1,1}};
		SearchMatrix matrix = new SearchMatrix();
		boolean b = matrix.searchMatrix(matrixs, 0);
		System.out.println(b);
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0)
			return false;

		int cols = matrix[0].length;
		return searchMatrix(matrix,target, 0, cols-1);
	}

	public boolean searchMatrix(int[][] matrix, int target, int startRow, int startCol) {
		if (startRow == matrix.length || startCol < 0)
			return false;

		if (matrix[startRow][startCol] == target) {
			return true;
		}

		if (target < matrix[startRow][startCol])
			return searchMatrix(matrix, target, startRow, startCol-1);
		else
			return searchMatrix(matrix, target, startRow+1, startCol);

	}


}
