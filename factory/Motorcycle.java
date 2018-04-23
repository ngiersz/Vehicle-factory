package factory;

public class Motorcycle implements IVehicle {
	public static int productionTime = 5;
	public static int productionCost = 600;
	
	public Motorcycle() {
		System.out.println("done: motorcycle	total cost: " + Factory.totalCost);
	}
}
