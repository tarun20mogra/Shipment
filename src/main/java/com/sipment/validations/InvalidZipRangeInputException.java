package com.sipment.validations;

/**
 * 
 * @author Tarun
 * Custom exception thrown when the input zip range is not valid
 *
 */
public class InvalidZipRangeInputException extends Exception{
	public InvalidZipRangeInputException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
