package com.thl.pinduoduo;

import java.io.File;

public class Test04 {
	public static void main(String[] args) {
		Test04 test = new Test04();
		char[] a = {'a','l','i','b','a','b','a'};
		test.swap(a, 0);
		for (char c : a)
			System.out.println(c);


	}

	public static void swap(char[] input, int index) {
		if (input.length < index+1 || index < 0)
			return;

		int size = input.length;
		int len = size-index-1;
		for (int i = index+1; i >= 1; i--) {
			char temp = input[i-1];
			for (int j = 0; j < len; j++){
				input[i+j-1] = input[i+j];
			}

			input[i+len-1] = temp;
		}
	}
}
