package com.camdev.maven.data.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Heap<T extends Comparable<T>> {
    
    // min heap

    private List<T> elements;
    
    public Heap() {
        elements = new ArrayList<T>();
    }
    
    public T insertElement(T element) {
        elements.add(element);
        if(elements.size() > 1) {
            int pos = elements.size() - 1;
            pos = (pos + 1 / 2) - 1;
            int curr = elements.size() - 1;
            while(pos >= 0 && elements.get(curr).compareTo(elements.get(pos)) < 0) {
                Collections.swap(elements, pos, curr);
                curr = pos;
                pos = pos / 2;
            }
        }
        return element;
    }
    
    public List<T> getList() {
        return elements;
    }
    
//    private void heapify(T element) {
//        
//    }
    
}