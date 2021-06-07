package com.shipment.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.shipment.model.ZipCodeRange;
import com.shipment.util.MinimumZipCodeRangeGenerator;

public class MinimumZipCodeRangeGeneratorTest {
	
	@Test
	public void testZipCodeRangeSample1() {
		List<ZipCodeRange> allCodes = new ArrayList<ZipCodeRange>();
		allCodes.add(new ZipCodeRange(94133,94133));
		allCodes.add(new ZipCodeRange(94200,94299));
		allCodes.add(new ZipCodeRange(94226,94399));

		List<ZipCodeRange> expectedOutputRange = new ArrayList<ZipCodeRange>();
		expectedOutputRange.add(new ZipCodeRange(94133,94133));	
		expectedOutputRange.add(new ZipCodeRange(94200,94299));	
		expectedOutputRange.add(new ZipCodeRange(94600,94699));	
	
		MinimumZipCodeRangeGenerator minimumZipCodeRangeGenerator = new MinimumZipCodeRangeGenerator();
		List<ZipCodeRange> actualOutputRange = minimumZipCodeRangeGenerator.getMinimumRanges(expectedOutputRange);
		
		assertEquals(actualOutputRange,expectedOutputRange);
		
		
	}
	
	public void testZipCodeRangeSample2() {
		List<ZipCodeRange> allCodes = new ArrayList<ZipCodeRange>();
		allCodes.add(new ZipCodeRange(94133,94133));
		allCodes.add(new ZipCodeRange(94200,94400));
		allCodes.add(new ZipCodeRange(94300,94500));

		List<ZipCodeRange> expectedOutputRange = new ArrayList<ZipCodeRange>();
		expectedOutputRange.add(new ZipCodeRange(94133,94133));	
		expectedOutputRange.add(new ZipCodeRange(94200,94500));	
	
		MinimumZipCodeRangeGenerator minimumZipCodeRangeGenerator = new MinimumZipCodeRangeGenerator();
		List<ZipCodeRange> actualOutputRange = minimumZipCodeRangeGenerator.getMinimumRanges(expectedOutputRange);
		
		assertEquals(actualOutputRange,expectedOutputRange);
		
		
	}


}
