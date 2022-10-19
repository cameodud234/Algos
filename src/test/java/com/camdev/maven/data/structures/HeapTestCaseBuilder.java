package com.camdev.maven.data.structures;

import java.util.Iterator;
import java.util.List;

public class HeapTestCaseBuilder {
    public static <T extends Comparable<T>> Heap<T> HeapBuild(List<T> list) {
        Heap<T> heap = new Heap<T>();
        Iterator<T> itr = list.iterator();
        while(itr.hasNext()) {
            heap.insertElement(itr.next());
        }
        return heap;
    }
}

