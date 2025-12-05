package entities;

public class TotalTax {

	private int propertyQuantity;
	private int vehicleQuantity;
	private int totalPropertyTax;
	private int totalVehicleTax;
	private int totalTax;
	/**
	 * 
	 */
	public TotalTax() {
		super();
	}
	/**
	 * @param propertyQuantity
	 * @param vehicleQuantity
	 * @param totalPropertyTax
	 * @param totalVehicleTax
	 * @param totalTax
	 */
	public TotalTax(int propertyQuantity, int vehicleQuantity, int totalPropertyTax, int totalVehicleTax,
			int totalTax) {
		super();
		this.propertyQuantity = propertyQuantity;
		this.vehicleQuantity = vehicleQuantity;
		this.totalPropertyTax = totalPropertyTax;
		this.totalVehicleTax = totalVehicleTax;
		this.totalTax = totalTax;
	}
	public int getPropertyQuantity() {
		return propertyQuantity;
	}
	public void setPropertyQuantity(int propertyQuantity) {
		this.propertyQuantity = propertyQuantity;
	}
	public int getVehicleQuantity() {
		return vehicleQuantity;
	}
	public void setVehicleQuantity(int vehicleQuantity) {
		this.vehicleQuantity = vehicleQuantity;
	}
	public int getTotalPropertyTax() {
		return totalPropertyTax;
	}
	public void setTotalPropertyTax(int totalPropertyTax) {
		this.totalPropertyTax = totalPropertyTax;
	}
	public int getTotalVehicleTax() {
		return totalVehicleTax;
	}
	public void setTotalVehicleTax(int totalVehicleTax) {
		this.totalVehicleTax = totalVehicleTax;
	}
	public int getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(int totalTax) {
		this.totalTax = totalTax;
	}
	@Override
	public String toString() {
		return "TotalTax [propertyQuantity=" + propertyQuantity + ", vehicleQuantity=" + vehicleQuantity
				+ ", totalPropertyTax=" + totalPropertyTax + ", totalVehicleTax=" + totalVehicleTax + ", totalTax="
				+ totalTax + "]";
	}
	
	
}
