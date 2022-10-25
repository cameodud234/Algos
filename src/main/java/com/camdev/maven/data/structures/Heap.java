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
            int parent = elements.size() - 1;
            parent = parent / 2;
            int current = elements.size() - 1;
            while((parent > 0) && (elements.get(current).compareTo(elements.get(parent)) < 0)) {
                Collections.swap(elements, parent, current);
                current = parent;
                parent = parent / 2;
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
    
    public boolean containsElements() {
    	if(elements.size() == 1) return false;
    	return true;
    }
    
    public T peek() {
    	if(!containsElements()) return null;
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