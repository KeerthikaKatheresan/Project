package com.mphasis.TAX_CALULATION;

public class Property {
	private int baseValue;
	private int buildUpArea;
	private int landAge;
	private char landLocation;
	/**
	 * @param baseValue
	 * @param buildUpArea
	 * @param landAge
	 * @param landLocation
	 */
	public Property(int baseValue, int buildUpArea, int landAge, char landLocation) {
		super();
		this.baseValue = baseValue;
		this.buildUpArea = buildUpArea;
		this.landAge = landAge;
		this.landLocation = landLocation;
	}
	public int getBaseValue() {
		return baseValue;
	}
	public int getBuildUpArea() {
		return buildUpArea;
	}
	public int getLandAge() {
		return landAge;
	}
	public char getLandLocation() {
		return landLocation;
	}
	@Override
	public String toString() {
		return "Property [baseValue=" + baseValue + ", buildUpArea=" + buildUpArea + ", landAge=" + landAge
				+ ", landLocation=" + landLocation + "]";
	}
	

}
