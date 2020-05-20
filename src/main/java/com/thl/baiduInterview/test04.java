package com.thl.baiduInterview;


public class test04 {

	public static void main(String[] args) {
		int[] data = {4,1,5,2,3,2};
		int[] res = getDoubleDataIndex(data);
		for (int v : res)
			System.out.println(v);
	}

	public static int[] getDoubleDataIndex(int[] data) {
		int len = data.length;
		int[] res = new int[2];
		for (int i = 0; i < len; i++) {
			if (data[i] > len)
				continue;

			if (data[i]-1 != i && data[data[i]-1] == data[i]) {
				res[0] = i;
				res[1] = data[i]-1;
				break;
			}

			if (data[data[i]-1] > len) {
				res[1] = i;
				res[0] = data[data[i]-1] - len -1;
				break;
			}

			data[data[i]-1] = len+ 1  + i;
		}

		return res;
	}
}
