package com.camdev.maven.data.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heap<T extends Comparable<T>> {

    private List<T> elements;
    
    private static final int DEFAULT_CAPACITY = 10;
    private final List<T> EMPTY_ELEMENTSDATA = List.of();
    
    public Heap() {
        elements = Arrays.asList(EMPTY_ELEMENTSDATA);
    }
    
}