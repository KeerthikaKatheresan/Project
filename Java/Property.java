package entities;

public class Property {
	private static int counter = 0;
	private int Id;
	private int baseValue;
	private int buildUpArea;
	private int landAge;
	private char landLocation;
	private int propertyTax;

	
	/**
	 * 
	 */
	public Property() {
		super();
	}

	/**
	 * @param baseValue
	 * @param buildUpArea
	 * @param landAge
	 * @param landLocation
	 */
	public Property(int baseValue, int buildUpArea, int landAge, char landLocation) {
		super();
		this.Id = ++counter;
		this.baseValue = baseValue;
		this.buildUpArea = buildUpArea;
		this.landAge = landAge;
		this.landLocation = landLocation;
		this.propertyTax = 0;
	}

	public int getId() {
		return Id;
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

	public int getPropertyTax() {
		return propertyTax;
	}

	public void setPropertyTax(int propertyTax) {
		this.propertyTax = propertyTax;
	}

	@Override
	public String toString() {
		return "Property [Id=" + Id + ", baseValue=" + baseValue + ", buildUpArea=" + buildUpArea + ", landAge="
				+ landAge + ", landLocation=" + landLocation + ", propertyTax=" + propertyTax + "]";
	}

}
