package com.shipment.job;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.shipment.model.ZipCodeRange;
import com.shipment.util.FileReaderAndWriterForZipRanges;
import com.shipment.util.MinimumZipCodeRangeGenerator;
import com.sipment.validations.InvalidZipRangeInputException;

public class ShipmentJob {
	
	//This job might have multiple business logic.
	//One of the business logic is to merge the postal code ranges 
   static Logger log = Logger.getLogger(ShipmentJob.class.getName());

	public static void main(String[] args) {
		
		if(args.length != 3) {
			log.error("Require three arguments. \n 1. Input File location. \n 2. Delimiter for the input and output file. \n 3. Output file Location");
			System.exit(0);
		}
		
		/* Since the zip code merger is more of a modular design there can be multiple ways to send the input to the 
		 * MinimumZipCodeRangeGenerator class. 
		 * I am choosing to develop input and output in the file form where any comma separated zip ranges and with new line character to 
		 * separate different ranges will work 
		 * */	
		String inputFileLocation = args[0];
		String delimiter = args[1];
		String outputFileLocation = args[2];
		List<ZipCodeRange> inputZipRanges = new ArrayList<ZipCodeRange>();
		List<ZipCodeRange> outputZipRanges = new ArrayList<ZipCodeRange>();
		MinimumZipCodeRangeGenerator minimumZipCodeRangeGenerator = new MinimumZipCodeRangeGenerator();

		try {
			inputZipRanges = FileReaderAndWriterForZipRanges.readInputFile(inputFileLocation,delimiter);
			outputZipRanges = minimumZipCodeRangeGenerator.getMinimumRanges(inputZipRanges);
			
			FileReaderAndWriterForZipRanges.writeOutputRanges(outputZipRanges,outputFileLocation,delimiter);
		}catch(IOException e) {
			log.error("File reading/Writing Exception");
			e.printStackTrace();
		}catch(InvalidZipRangeInputException e1) {
			log.error("Zip Validation eroor Occured");
			e1.printStackTrace();
		}
		
		
		

		
		
			
		
		
	}

}
