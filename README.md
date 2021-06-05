# Shipment
Business logic for the zip code merging to get the proper zip code ranges from the given inputs

1. Created a simple maven project to include complete business logic
2. Actual business logic to achive the zip code mergin is written in MinimumZipCodeRangeGenerator package com.shipment.util. Complexity = O(n log n)

Assumption 
1. There can be multiple ways to read the input for the zip file. I have writted the code to read any file with user given delimiter and write the output to the file with user specified delimiter
2. File should not be empty otherwise code will through fill empty custom exception 
3. As per the problem, if zip code is more or less than 5 digits program will throw a custom exception 
4. If the input doesnt have the delimiter that user specified, program will throw a custom exception 
5. If the input have more than two numeric digits, program will throw a custom exception 
6. If input is not numeric program will throw a custom exception.
