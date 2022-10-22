package com.camdev.maven.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class LeetTestCases {
	public static Stream<Arguments> insertElementTestCase(){
        return Stream.of(
            Arguments.of(Arrays.asList(7,3,2,-1,1,8), 12),
            Arguments.of(Arrays.asList(7,3,2,0,0,0,0,-1,1,8), 12),
            Arguments.of(Arrays.asList(-7,-73,-3,0,0,-5,-2), 5),
            Arguments.of(Arrays.asList(2,2,2,2,2,2), 12)
        );
    }
}
