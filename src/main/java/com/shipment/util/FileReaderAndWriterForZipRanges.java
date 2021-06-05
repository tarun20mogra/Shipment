package com.shipment.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;


import com.shipment.model.ZipCodeRange;
import com.sipment.validations.InvalidZipRangeInputException;

public class FileReaderAndWriterForZipRanges {

	public static List<ZipCodeRange> readInputFile(String inputFileLocation,String delimiter) throws IOException, InvalidZipRangeInputException {
		BufferedReader fileReader = new BufferedReader(new FileReader(inputFileLocation));
		String row;
		List<ZipCodeRange> resultInputZipRanges = new ArrayList<ZipCodeRange>();

		while ((row = fileReader.readLine()) != null) {
			
		    String[] data = row.split(delimiter);
		    	if(data.length != 2) {
			    	throw new InvalidZipRangeInputException("Invalid zip ranges in the input file. Require two '"+delimiter+"' seperated values");
			    }else if(StringUtils.isEmpty(data[0]) || StringUtils.isEmpty(data[1])) {
			    	throw new InvalidZipRangeInputException("Invalid zip ranges in the input file. Required '"+ delimiter +"' seperated non null zip values");
			    }else if(data[0].length() != 5 || data[1].length() != 5) {
			    	//This is because, as is mentioned in the problem the zip code ranges are for 5-digit zip code
			    	throw new InvalidZipRangeInputException("Invalid zip ranges in the input file. Required only 5 digit zip code");
			    }else if(!StringUtils.isNumeric(data[0]) || !StringUtils.isNumeric(data[1])) {
			    	throw new InvalidZipRangeInputException("Invalid zip ranges in the input file. Required only numeric values");
			    }
			    else {
			    	resultInputZipRanges.add(new ZipCodeRange(Integer.parseInt(data[0]),Integer.parseInt(data[1])));
			    }

		    
		    // do something with the data
		}
		fileReader.close();
		if(resultInputZipRanges.size() != 0)
			return resultInputZipRanges;
		else
			throw new InvalidZipRangeInputException("Input File is empty");
	}

	public static void writeOutputRanges(List<ZipCodeRange> outputZipRanges,String outputLocation,String delimiter) throws IOException {
		FileWriter csvWriter = new FileWriter(outputLocation);
		for(ZipCodeRange row: outputZipRanges) {
			csvWriter.append(String.valueOf(row.getLowerBound())+delimiter+String.valueOf(row.getUpperBound()));
			csvWriter.append("\n");
		}
		csvWriter.flush();
		csvWriter.close();	
		
	}

}
