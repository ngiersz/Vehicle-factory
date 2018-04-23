package factory;

public class Car implements IVehicle {
	public static int productionTime = 10;
	public static int productionCost = 1000;
	
	public Car() {
		System.out.println("done: car		total cost: " + Factory.totalCost);
	}
}
