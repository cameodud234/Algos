package com.camdev.maven.data.structures;

import java.util.Iterator;
import java.util.List;

public class HeapTestCaseBuilder {
	
	public static <T extends Comparable<T>> Heap<T> HeapBuildAdd(List<T> list, T element) {
		Heap<T> heap = new Heap<T>();
		heap.insertElements(list);
		heap.insertElement(element);
		return heap;
	}
	
    public static <T extends Comparable<T>> Heap<T> HeapBuild(List<T> list) {
        Heap<T> heap = new Heap<T>();
        heap.insertElements(list);
        return heap;
    }
    
    public static <T extends Comparable<T>> Heap<T> HeapPoll(List<T> list) {
    	
    	Heap<T> heap = new Heap<T>();
    	heap.insertElements(list);
    	heap.poll();
    	return heap;
    
    }
    
}

