package factory;

public abstract class ProductionLine implements Runnable {
	public abstract IVehicle createVehicle();
	public abstract void addToProduce(int quantity);
}
