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
            while((elements.get(parent) != null) && (elements.get(current).compareTo(elements.get(parent)) < 0)) {
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
    	Collections.swap(elements, last, first);
    	
    	elements.remove(last);
    	
    	int current = first;
    	int childL = first;
    	int childR = first;
    	childL = 2 * first;
    	childR = childL + 1;
    	
    	while(current < elements.size()) {
    		if((childL < elements.size()) && (childR < elements.size())) {
    			int indexChild = (elements.get(childL).compareTo(elements.get(childR))) <= 0 ? childL : childR; 
         		if(elements.get(current).compareTo(elements.get(indexChild)) > 0) {
         			Collections.swap(elements, current, indexChild);
         			current = indexChild;
             		childL = 2 * current;
             		childR = childL + 1;
         		}
    		}
    		else if(childL < elements.size()) {
    			if(elements.get(current).compareTo(elements.get(childL)) > 0) {
         			Collections.swap(elements, current, childL);
         			return element;
         		}
    		}
    		else {
    			break;
    		}
     		
    	}
    	
    	return element;
    	
    }
    
    public String toString() {
    	return elements.toString();
    }
    
    
}