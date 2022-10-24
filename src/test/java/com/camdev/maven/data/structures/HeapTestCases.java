package com.camdev.maven.data.structures;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class HeapTestCases {
	
	public static Stream<Arguments> insertElementTestCase() {
		return Stream.of(
				Arguments.of(HeapTestCaseBuilder.HeapBuildAdd(Arrays.asList(),4), Arrays.asList(null,4)),
				Arguments.of(HeapTestCaseBuilder.HeapBuildAdd(Arrays.asList(1,2,3,4), 5), Arrays.asList(null,1,2,3,4,5)),
				Arguments.of(HeapTestCaseBuilder.HeapBuildAdd(Arrays.asList(3,7,13,9), 4), Arrays.asList(null,3,4,13,9,7)),
				Arguments.of(HeapTestCaseBuilder.HeapBuildAdd(Arrays.asList(5,-3,7,6,9), 6), Arrays.asList(null, -3,5,6,6,9,7))
			); 
	} 
    
    public static Stream<Arguments> insertElementsTestCase(){
        return Stream.of(
//        	Arguments.of(HeapTestCaseBuilder.HeapBuild(Arrays.asList()), List.of(null)),
            Arguments.of(HeapTestCaseBuilder.HeapBuild(Arrays.asList(1,2,3,4)), Arrays.asList(null,1,2,3,4)),
            Arguments.of(HeapTestCaseBuilder.HeapBuild(Arrays.asList(3,4,2,1)), Arrays.asList(null,1,2,3,4)),
            Arguments.of(HeapTestCaseBuilder.HeapBuild(Arrays.asList(7,3,6,2,88,5,33,4,19)), Arrays.asList(null,2,3,5,4,88,6,33,7,19))
        );
    }
    
}