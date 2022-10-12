package com.camdev.maven.algorithms;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Sort {
	
	private static Logger log = LogManager.getLogger(Sort.class);
	
	public static <T extends Comparable<T>> boolean isSorted(List<T> list) {
		for(int i = 1; i < list.size(); i++) {
			if(list.get(i-1).compareTo(list.get(i)) > 0) {
				return false;
			}
		}
		return true;
	}
	
	public static <T extends Comparable<T>> boolean isSortedReverse(List<T> list) {
		for(int i = 1; i < list.size(); i++) {
			if(list.get(i-1).compareTo(list.get(i)) < 0) {
				return false;
			}
		}
		return true;
	}
	
	public static <T extends Comparable<T>> void insertionSort(List<T> list) {
		for(int i = 1; i < list.size(); i++) {
			
			T mem = list.get(i);
			int j = i - 1;
			
			while(j > 0 && (list.get(j).compareTo(mem) > 0)) {
				list.set(j+1, list.get(j));
				j--;
			}
			
			list.set(j, mem);
			
		}
	}

	public static <T extends Comparable<T>> void selectionSort(List<T> list) {
		for(int i = 0; i < list.size(); i++) {
			int min = Sort.minimumIndex(list, i, list.size());
			Collections.swap(list, i, min);
		}
	}
	
	private static <T extends Comparable<T>> int minimumIndex(List<T> list, int startIndex, int endIndex) {
		T curr = list.get(startIndex);
		int pos = startIndex;
		for(int i = startIndex + 1; i < endIndex; i++) {
			if(curr.compareTo(list.get(i)) > 0){
				curr = list.get(i);
				pos = i;
			}
		}
		return pos;
	}
	
	public static <T extends Comparable<T>> void mergeSort(List<T> list) {
		assert(list.size() > 0);
		Sort.mergeSort(list, 0, list.size()-1);
	}

	private static <T extends Comparable<T>> void mergeSort(List<T> list, int left, int right) {
		if(left >= right) return;
		int mid = left + ((right - left) / 2);
		mergeSort(list, left, mid);
		mergeSort(list, mid + 1, right);
		Sort.merge(list, left, mid, right);
	}

	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> void merge(List<T> list, int left, int mid, int right){
		
		final int sizeL = mid - left;
		final int sizeR = right - mid + 1;
	
		Object[] L = list.subList(left, mid + 1).toArray();
		Object[] R = list.subList(mid + 1, right + 1).toArray();
		
		int indexL = 0;
		int indexR = 0;
		int indexList = left;
		
		while((indexL < L.length) && (indexR < R.length)) {
			
			T currL = (T) L[indexL];
			T currR = (T) R[indexR];
			
			if(currL.compareTo(currR) < 0) {
				list.set(indexList, currL);
				indexL++;
			}
			else {
				list.set(indexList, currR);
				indexR++;
			}
			
			indexList++;
			
		}
		
		// Probably a more clever way to do this...
		while(indexL < L.length) {
			T currL = (T) L[indexL];
			list.set(indexList, currL);
			indexL++;
			indexList++;
		}
		
		while(indexR < R.length) {
			T currR = (T) R[indexR];
			list.set(indexList, currR);
			indexR++;
			indexList++;
		}
		
		
	}
	
	public static <T extends Comparable<T>> void quickSort(List<T> list) {
		assert(list.size() > 0);
		Sort.quickSort(list, 0, list.size() - 1);
	}
	
	private static <T extends Comparable<T>> void quickSort(List<T> list, int left, int right) {
		if(left >= right) return;
		int pivot = Sort.partition(list, left, right);
		quickSort(list, left, pivot - 1);
		quickSort(list, pivot + 1, right);
	}
	
	// This is one type of partition...
	private static <T extends Comparable<T>> int partition(List<T> list, int left, int right) {
		int x = right;
		int i = left - 1;
		for(int j = left; j < right; j++) {
			if(list.get(j).compareTo(list.get(x)) <= 0) {
				++i;
				Collections.swap(list, i, j);
			}
		}
		++i;
		Collections.swap(list, i, x);
		
		return i;
	}
	
}