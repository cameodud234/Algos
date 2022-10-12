package com.camdev.maven.Algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class App {
    public static void main( String[] args ) {
    	try {
    		Objects.checkIndex(0, 1);
        	List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));
		} 
    	catch (Exception e) {
    		System.out.println(e.getMessage());
		}
    }
}