package com.camdev.maven.data.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class HeapTest extends HeapTestCases {
	
//	@ParameterizedTest
//    @MethodSource("insertElementsTestCases")
//    public <T extends Comparable<T>> void insertElementsTest(Heap<T> heap, String arg) {
//        assertEquals(heap.toString() , arg);
//    }
//    
//	@ParameterizedTest
//    @MethodSource("insertElementTestCases")
//    public <T extends Comparable<T>> void insertElementTest(Heap<T> heap, String arg) {
//        assertEquals(heap.toString() , arg);
//    }
//	
//	@ParameterizedTest
//	@MethodSource("peekElementTestCases")
//	public <T extends Comparable<T>> void peekTest(Heap<T> heap, String arg) {
//		if(heap.peek() != null) assertEquals(heap.peek().toString(), arg);
//		else {
//			assertTrue(true);
//		}
//	}
    
//    @ParameterizedTest
//    @MethodSource("pollElementTestCases")
//    public <T extends Comparable<T>> void pollElementTest(Heap<T> heap, String arg) {
//    	heap.poll();
//    	assertEquals(heap.toString(), arg);
//    }
	
	@ParameterizedTest
	@MethodSource("heapifyTestCases")
	public <T extends Comparable<T>> void heapifyTest(List<T> list, String arg) {
		Heap<Integer> heap = new Heap<Integer>(list);
	}

}
