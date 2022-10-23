package com.camdev.maven.data.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class HeapTest extends HeapTestCases {
    
	@ParameterizedTest
    @MethodSource("insertElementTestCase")
    public <T extends Comparable<T>> void insertElementTest(Heap<T> heap, List<T> list) {
        assertEquals(heap.toList().toString() , list.toString());
    }
	
    @ParameterizedTest
    @MethodSource("insertElementsTestCase")
    public <T extends Comparable<T>> void insertElementsTest(Heap<T> heap, List<T> list) {
        assertEquals(heap.toList().toString() , list.toString());
    }

}
