package com.camdev.maven.data.structures;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class ArrayListTestCases {
	public static Stream<Arguments> arraySizeArgs() {
		return Stream.of(
			Arguments.of(new ArrayList<Integer>(0), 0 ),
			Arguments.of(new ArrayList<Integer>(1), 1 ),
			Arguments.of(new ArrayList<Integer>(), 10 ),
			Arguments.of(new ArrayList<Integer>(20), 20 ),
			Arguments.of(new ArrayList<Integer>(100), 100 )
			
		);
	}
	
//	public static Stream<Arguments> arrayCurrSizeArgs() {
//		return Stream.of(
//				
//			Arguments.of(new ArrayList<Integer>(10), 0 ),
//			Arguments.of(new ArrayList<Integer>(Arrays.asList(1,2,3)), 3),
//			Arguments.of(new ArrayList<Integer>(Arrays.asList(4,5,6,7,3,343,64,2,32,64,75,54)), 12),
//			Arguments.of(new ArrayList<String>(Arrays.asList("Cameron")), 1)
//				
//		); 
//	}
	
	public static Stream<Arguments> isEmptyArgs() {
		return Stream.of(
				
			Arguments.of(new ArrayList<Integer>(20), true),
			Arguments.of(new ArrayList<Integer>(Arrays.asList(5,6,7,34,64,332,6)), false),
			Arguments.of(new ArrayList<String>(), true)
			
		);
	}
	
	public static Stream<Arguments> addCollectionArgs() {
		return Stream.of(
			
			Arguments.of(new ArrayList<Integer>(), ""),
			Arguments.of(new ArrayList<Integer>(Arrays.asList(1,2,3)), "1, 2, 3"),
			Arguments.of(new ArrayList<Integer>(Arrays.asList(23,43,56,664,545,54)), "23, 43, 56, 664, 545, 54"),
			Arguments.of(new ArrayList<String>(Arrays.asList("Cameron", "Chanelle", "Paul")), "Cameron, Chanelle, Paul"),
			Arguments.of(new ArrayList<Integer>(Arrays.asList(1)), "1"),
			Arguments.of(new ArrayList<Character>(Arrays.asList('C', 'a', 'm')), "C, a, m"),
			Arguments.of(new ArrayList<Double>(Arrays.asList(2.34, 6.87, 3.3333)), "2.34, 6.87, 3.3333")
			
		);
	}
	
	public static Stream<Arguments> arrayListIteratorArgs() {
		
		return Stream.of(
				
				Arguments.of(new ArrayList<Integer>(Arrays.asList(1,2,3)), "1, 2, 3"),
				Arguments.of(new ArrayList<Integer>(Arrays.asList(23,43,56,664,545,54)), "23, 43, 56, 664, 545, 54"),
				Arguments.of(new ArrayList<String>(Arrays.asList("Cameron", "Chanelle", "Paul")), "Cameron, Chanelle, Paul"),
				Arguments.of(new ArrayList<Integer>(), ""),
				Arguments.of(new ArrayList<Integer>(Arrays.asList(1)), "1"),
				Arguments.of(new ArrayList<Character>(Arrays.asList('C', 'a', 'm')), "C, a, m"),
				Arguments.of(new ArrayList<Double>(Arrays.asList(2.34, 6.87, 3.3333)), "2.34, 6.87, 3.3333")
				
			);
		
	}
	
}