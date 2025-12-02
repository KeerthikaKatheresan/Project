package com.mphasis.TAX_CALULATION;

public class TotalTaxCalculation {
//	Property property=new Property();
//	Vehicle vehicle=new Vehicle();
	double propertyTax=0;
	double vehicleTax=0;
	
	PropertyTaxCalculation propertyCalc = new PropertyTaxCalculation();
    VehicleTaxCalculation vehicleCalc = new VehicleTaxCalculation();
	public void calculateTotalTax()
	{
		for(Property p:propertyCalc.getProperties())
		{
			propertyTax+=p.getPropertyTax();
		}
		for(Vehicle v:vehicleCalc.getVehicles())
		{
			vehicleTax+=v.getVehicleTax();
		}
	}
	
	public void display()
	{
		System.out.println("Total property tax:"+propertyTax);
		System.out.println("Total vehicle tax:"+vehicleTax);
		System.out.println("Total tax:"+(propertyTax+vehicleTax));
	}
	

}
