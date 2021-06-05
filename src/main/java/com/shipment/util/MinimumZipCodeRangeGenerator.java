package com.shipment.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.shipment.model.ZipCodeRange;

public class MinimumZipCodeRangeGenerator {
	/**
	 * 
	 * @param allInputZipCodeRanges : Input of all the zip code ranges given by the user
	 * @return : list of all the merged ranges with the upper and the lower bounds.
	 */
	public List<ZipCodeRange> getMinimumRanges(List<ZipCodeRange> allInputZipCodeRanges) {
		//We need to Sort the list so that we can compare each range to find the merge between them 
		//Sorting the list on the range so that even if the ranges are at different position in the input file 
		//We will compare the two most nearest ranges
		List<ZipCodeRange> sortedZipCodeRanges = RangeCollectionSortUtil.getSortedList(allInputZipCodeRanges);
		System.out.println("Sorted :" + sortedZipCodeRanges);
		
		//Algorithm to merge the ranges
		ArrayList<ZipCodeRange> result = new ArrayList<ZipCodeRange>();
		ZipCodeRange first = sortedZipCodeRanges.get(0);
        int start = first.getLowerBound();
        int end = first.getUpperBound();

        for (int i = 1; i < sortedZipCodeRanges.size(); i++) {
            ZipCodeRange current = sortedZipCodeRanges.get(i);
            if (current.getLowerBound() <= end) {
                end = Math.max(current.getUpperBound(), end);
            } else {
                result.add(new ZipCodeRange(start, end));
                start = current.getLowerBound();
                end = current.getUpperBound();
            }
        }
        result.add(new ZipCodeRange(start, end));
        System.out.println("result :" + result);
		return result;
	}


}
