package factory;

public class Truck implements IVehicle {
	public static int productionTime = 15;
	public static int productionCost = 2000;
	
	public Truck() {
		System.out.println("done: truck		total cost: " + Factory.totalCost);
		}
}
