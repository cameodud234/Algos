package com.camdev.maven.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class LeetTest {
	@ParameterizedTest
	@MethodSource("sortListArgs")
	public <T extends Comparable<T>> void maxSumTest(List<T> list, boolean expected){
	}
}
