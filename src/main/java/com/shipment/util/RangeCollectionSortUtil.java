package com.shipment.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.shipment.model.ZipCodeRange;

public class RangeCollectionSortUtil {
	
	public static List<ZipCodeRange> getSortedList(List<ZipCodeRange> inputRanges) {
	    //The main sorting algorithm which is used in standard stream API implementation for sequential sorting is TimSort. 
		//Its worst case complexity is O(n log n)		
		return inputRanges.stream().
		sorted(Comparator.comparing(ZipCodeRange::getLowerBound).thenComparing(ZipCodeRange::getUpperBound)).
		collect(Collectors.toList());
		
		//Reason to use Collection sort is because as per the standards its more clean code. And already tested.
	
	}

}
