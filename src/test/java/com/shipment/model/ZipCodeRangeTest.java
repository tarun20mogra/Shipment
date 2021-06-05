package com.shipment.model;

import org.junit.Test;


import com.jparams.verifier.tostring.ToStringVerifier;
import com.jparams.verifier.tostring.NameStyle;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class ZipCodeRangeTest {
	@Test
	public void testEqualsVerifier() {
		EqualsVerifier.forClass(ZipCodeRange.class).usingGetClass().suppress(Warning.NONFINAL_FIELDS).verify();
	}
	
	@Test
	public void testToString() {
	ToStringVerifier.forClass(ZipCodeRange.class).withClassName(NameStyle.SIMPLE_NAME).verify();
	}

}
