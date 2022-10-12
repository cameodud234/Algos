package com.camdev.maven.data.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class ArrayListTest extends ArrayListTestCases {
	
	@ParameterizedTest
	@MethodSource("arraySizeArgs")
	public <T extends Comparable<T>> void arrayListSize(List<T> list, int expected) {
		assertEquals( list.size(), expected );
	}
	
	@ParameterizedTest
	@MethodSource("isEmptyArgs")
	public <T extends Comparable<T>> void isEmpty(List<T> list, boolean expected) {
		assertEquals(list.isEmpty(), expected);
	}
	
	@ParameterizedTest
	@MethodSource("addCollectionArgs")
	public <T extends Comparable<T>> void addCollection(List<T> list, String out) {
		assertEquals(list.toString(), out);
	}
	
	@ParameterizedTest
	@MethodSource("arrayListIteratorArgs")
	public <T extends Comparable<T>> void arrayListIterator(List<T> list, String out) {
		assertEquals(ArrayListTestBuilder.ArrayListIteratorStringBuild(list), out);
	}
	
}
