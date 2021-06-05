package com.shipment.model;

public class ZipCodeRange {
	int upperBound;
	int lowerBound;
	public ZipCodeRange(int lowerBound, int upperBound) {
		this.upperBound = upperBound;
		this.lowerBound = lowerBound;
		// TODO Auto-generated constructor stub
	}
	public int getUpperBound() {
		return upperBound;
	}
	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}
	public int getLowerBound() {
		return lowerBound;
	}
	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lowerBound;
		result = prime * result + upperBound;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZipCodeRange other = (ZipCodeRange) obj;
		if (lowerBound != other.lowerBound)
			return false;
		if (upperBound != other.upperBound)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ZipCodeRange [upperBound=" + upperBound + ", lowerBound=" + lowerBound + "]";
	}

	
}
