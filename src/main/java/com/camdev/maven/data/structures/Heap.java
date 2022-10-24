package com.camdev.maven.data.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Heap<T extends Comparable<T>> {

    private List<T> elements;
    
    public Heap() {
        elements = new ArrayList<T>();
        elements.add(null);
    }
    
    public T insertElement(T element) {
        elements.add(element);
        if(elements.size() > 2) {
            int pos = elements.size() - 1;
            pos = pos / 2;
            int curr = elements.size() - 1;
            while((elements.get(pos) != null) && (elements.get(curr).compareTo(elements.get(pos)) < 0)) {
                Collections.swap(elements, pos, curr);
                curr = pos;
                pos = pos / 2;
            }
        }
        return element;
    } 
    
    public List<T> insertElements(List<T> list) {
        Iterator<T> itr = list.iterator();
        while(itr.hasNext()) {
            insertElement(itr.next());
        }
        return elements;
    }
    
    public List<T> toList() {
        return elements;
    }
   
    
    
}