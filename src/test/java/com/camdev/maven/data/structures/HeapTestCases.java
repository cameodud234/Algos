package com.camdev.maven.data.structures;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class HeapTestCases {
    
    public static Stream<Arguments> insertElementTestCase(){
        return Stream.of(
            Arguments.of(HeapTestCaseBuilder.HeapBuild(Arrays.asList(1,2,3,4)), Arrays.asList(1,2,3,4)),
            Arguments.of(HeapTestCaseBuilder.HeapBuild(Arrays.asList(3,4,2,1)), Arrays.asList(1,2,3,4)),
            Arguments.of(HeapTestCaseBuilder.HeapBuild(Arrays.asList(7,3,6,2,88,5,33,4,19)), Arrays.asList())
        );
    }
    
}