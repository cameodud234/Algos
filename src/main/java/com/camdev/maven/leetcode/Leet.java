package com.camdev.maven.leetcode;

import java.util.List;

public class Leet {
	
	final static String zeroElementMsg = "No elements in list.";
	
	public static long maxSum(List<Integer> list) throws Exception {
		
		if(list.size() <= 0) throw new Exception(zeroElementMsg);
		
		long maxSum = 0;
		
		int i = 0; 
		int j = 0;
		long sum = 0;
		sum += list.get(i);
		
		while(i < list.size() && j < list.size()) {
			if(list.get(j).compareTo(0) > 0) {
				sum += list.get(j);
				j++;
			}
			else {
				i = j;
				i++;
				j++;
				sum = 0;
				sum += list.get(i);
			}
			maxSum = Math.max(maxSum, sum);
		}
		
		return maxSum;
		
	}

}
