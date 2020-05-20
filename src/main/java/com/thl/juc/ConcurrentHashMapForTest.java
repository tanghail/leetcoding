package com.thl.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class ConcurrentHashMapForTest {
	public static void main(String[] args) {
		int[] arr = {1};
		ConcurrentHashMapForTest test = new ConcurrentHashMapForTest();
		System.out.println(test.majorityElement(arr));
	}

	public int majorityElement(int[] nums) {
		HashMap map = new HashMap<Integer, Integer>();
		int len = nums.length;
		for (int value : nums) {
			if (map.keySet().contains(value)) {
				if((Integer)map.get(value) >= len/2)
					return value;
				map.put(value, ((Integer)map.get(value))+1);
			}else {
				map.put(value, 1);
			}
		}
		Set<Integer> set = map.keySet();
		for (int v : set) {
			System.out.println("key =" + v + ", value = " + map.get(v));
		}

		Set<Map.Entry<Integer, Integer>> set2 = map.entrySet();
		for (Map.Entry<Integer, Integer> entry : set2) {
			entry.getValue();
		}

		return 1;

	}
}
