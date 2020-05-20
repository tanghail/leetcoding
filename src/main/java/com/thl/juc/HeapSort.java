package com.thl.juc;


public class HeapSort {
	public static void main(String[] args) {
		int[] arr = {2,3,5,9,2,5,6};
		HeapSort heapSort = new HeapSort();
		arr = heapSort.heapSort(arr);
		for (int v : arr)
			System.out.print(v + " ");

	}

	/**
	 *
	 * @param arr 待排数组
	 * @param pos 开始调整的位置
	 * @param len 数组中需要调整的大小，我可能只需要调整前len个数据
	 */
	public void heapAdjust (int[] arr, int pos, int len) {
		int max = pos;
		int left = 2*pos;
		int right = 2*pos + 1;
		if (left < len && arr[left] > arr[max])
			max = left;

		if (right < len && arr[max] < arr[right])
			max = right;

		if (pos != max) {
			int temp = arr[pos];
			arr[pos] = arr[max];
			arr[max] = temp;
			heapAdjust(arr, max, len);
		}

	}

	public void buildHeap(int[] arr) {
		if (arr == null || arr.length == 0)
			return;
		int len = arr.length;
		for (int i=len/2 -1 ;i>=0; i-- )
			heapAdjust(arr, i, len-1);

	}

	public int[] heapSort(int[] arr){
		if (arr == null || arr.length == 0)
			return null;

		int len = arr.length;
		buildHeap(arr);
		for (int i = len - 1; i>=0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapAdjust(arr, 0, i-1);
		}

		return arr;


	}

}
