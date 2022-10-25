package com.camdev.maven.data.structures;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class HeapTestCases {
	
	public static Stream<Arguments> insertElementsTestCases(){
        return Stream.of(
        		Arguments.of(HeapTestCaseBuilder.HeapBuild(Arrays.asList()), "[null]"),
        		Arguments.of(HeapTestCaseBuilder.HeapBuild(Arrays.asList(1,2,3,4)), "[null, 1, 2, 3, 4]"),
        		Arguments.of(HeapTestCaseBuilder.HeapBuild(Arrays.asList(3,4,2,1)), "[null, 1, 2, 3, 4]"),
	            Arguments.of(HeapTestCaseBuilder.HeapBuild(Arrays.asList(7,3,6,2,88,5,33,4,19)), "[null, 2, 3, 5, 4, 88, 6, 33, 7, 19]"),
	            Arguments.of(HeapTestCaseBuilder.HeapBuild(Arrays.asList(5,3,4,4,6)), "[null, 3, 4, 4, 5, 6]")
        );
    }
	
	public static Stream<Arguments> insertElementTestCases() {
		return Stream.of(
				Arguments.of(HeapTestCaseBuilder.HeapBuildAdd(Arrays.asList(),4), "[null, 4]"),
				Arguments.of(HeapTestCaseBuilder.HeapBuildAdd(Arrays.asList(1,2,3,4), 5), "[null, 1, 2, 3, 4, 5]"),
				Arguments.of(HeapTestCaseBuilder.HeapBuildAdd(Arrays.asList(3,7,13,9), 4), "[null, 3, 4, 13, 9, 7]"),
				Arguments.of(HeapTestCaseBuilder.HeapBuildAdd(Arrays.asList(5,-3,7,6,9), 6), "[null, -3, 5, 6, 6, 9, 7]")
			); 
	}
	
	public static Stream<Arguments> peekElementTestCases() {
		return Stream.of(
				Arguments.of(HeapTestCaseBuilder.HeapBuild(Arrays.asList()), "null"),
        		Arguments.of(HeapTestCaseBuilder.HeapBuild(Arrays.asList(1,2,3,4)), "1"),
        		Arguments.of(HeapTestCaseBuilder.HeapBuild(Arrays.asList(3,4,2,1)), "1"),
	            Arguments.of(HeapTestCaseBuilder.HeapBuild(Arrays.asList(7,3,6,2,88,5,33,4,19)), "2"),
	            Arguments.of(HeapTestCaseBuilder.HeapBuild(Arrays.asList(5,3,4,4,6)), "3")
		);
	}
	
//	public static Stream<Arguments> deleteElementTestCases() {
//		return Stream.of(
//				Arguments.of(HeapTestCaseBuilder.HeapBuild(Arrays.asList()).delete(), "")
//		);
//	}
    
}