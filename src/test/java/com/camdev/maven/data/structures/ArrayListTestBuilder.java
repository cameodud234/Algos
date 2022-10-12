package com.camdev.maven.data.structures;

import java.util.Iterator;
import java.util.List;

public class ArrayListTestBuilder {
	
	public static <E extends Comparable<E>> String ArrayListIteratorStringBuild(List<E> list) {
		
		if(list.size() == 0) return "";
		
		StringBuilder sb = new StringBuilder();
		Iterator<E> itr = list.iterator();
		
		while(itr.hasNext()) {
			sb.append(itr.next());
			if(itr.hasNext()) sb.append(", ");
		}
		
		return sb.toString();
		
	}
	
}
