package com.camdev.maven.data.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Heap<T extends Comparable<T>> {

    private List<T> elements = new ArrayList<T>();
    
    public Heap(List<T> list) {
        elements.add(null);
        for(T element: list) {
        	elements.add(element);
        }
        heapify();
    }
    
    private int parent(int i) {
    	return (int) Math.floor(i/2);
    }
    
    private int left(int i) {
    	return 2 * i;
    }
    
    private int right(int i) {
    	return (2 * i) + 1;
    }
    
    public void heapify() {
    	for(int i = elements.size() - 1; i >= 1; i++) {
    		heapify(i);
    	}
    }
    
    private void heapify(int i) {
    	int L = left(i);
    	int R = right(i);
    	int largest = Integer.MIN_VALUE;
    	if((L < elements.size()) && (elements.get(L).compareTo(elements.get(i)) > 0)) {
    		largest = L;
    	}
    	else {
    		largest = i;
    	}
    	if((R < elements.size()) && ( elements.get(R).compareTo(elements.get(largest)) > 0) ) {
    		largest = R;
    	}
    	if(largest != i) {
    		Collections.swap(elements, i, largest);
    		heapify(largest);
    	}
    }
    
    public List<T> toList() {
        return elements;
    }
    
    public T peek() {
    	if(elements.size() == 1) return null;
    	return elements.get(1);
    }
   
    public T poll() {
    	T element = peek();
    	if(element == null) return null;
    	int first = 1;
    	int last = elements.size() - 1;
    	
    	elements.set(first, elements.get(last));
    	
    	elements.remove(last);
    	
    	int current = first;
    	
    	while(current < elements.size()) {
    		passDown(current);
    	}
    	
    	return element;
    	
    }
    
    private void passDown(int current) {
    	
    	int childL = 2 * current;
    	int childR = childL + 1;
    	
    	if(childL < elements.size() && childR < elements.size()) {
    		int indexChild = (elements.get(childL).compareTo(elements.get(childR)) <= 0) ? childL : childR;
    		if(elements.get(current).compareTo(elements.get(indexChild)) > 0) {
    			Collections.swap(elements, current, indexChild);
    			current = indexChild;
    		}
    	}
    	else if(childR > elements.size()) {
    		if(elements.get(current).compareTo(elements.get(childL)) > 0) {
    			Collections.swap(elements, current, childL);
    			current = childL;
    		}
    	}
    	else {
    		current++;
    		return;
    	}
    	
    }
    
    public String toString() {
    	return elements.toString();
    }
    
    
}