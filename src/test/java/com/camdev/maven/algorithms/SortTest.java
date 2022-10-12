package com.camdev.maven.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


public class SortTest extends SortTestCases {
	
	@ParameterizedTest
	@MethodSource("sortListArgs")
	public <T extends Comparable<T>> void isSortedCheck(List<T> list, boolean expected){
		assertEquals(expected, Sort.isSorted(list));
	}
	
	@ParameterizedTest
	@MethodSource("sortListReverseArgs")
	public <T extends Comparable<T>> void isSortedReverseCheck(List<T> list, boolean expected){
		assertEquals(expected, Sort.isSortedReverse(list));
	}
	
	@ParameterizedTest
	@MethodSource("sortListArgs")
	public <T extends Comparable<T>> void selectionSortCheck(List<T> list) {
		Sort.selectionSort(list);
		assertTrue(Sort.isSorted(list));
	}
	
	@ParameterizedTest
	@MethodSource("listArgs")
	public <T extends Comparable<T>> void insertionSortCheck(List<T> list) {
		Sort.insertionSort(list);
		assertTrue(Sort.isSorted(list));
	}
	
	@ParameterizedTest
	@MethodSource("listArgs")
	public <T extends Comparable<T>> void mergeSortCheck(List<T> list) {
		Sort.mergeSort(list);
		assertTrue(Sort.isSorted(list));
	}
	
	@ParameterizedTest
	@MethodSource("listArgs")
	public <T extends Comparable<T>> void quickSortCheck(List<T> list) {
		Sort.quickSort(list);
		assertTrue(Sort.isSorted(list));
	}
	
}