package factory;

public class MotorcycleProductionLine extends ProductionLine {
	private int toDo;

	public void run() {
		while(isMotorcycleToDo()) {
			try {
				Thread.sleep(Motorcycle.productionTime*100);
				createVehicle();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private synchronized boolean isMotorcycleToDo() {
		return toDo > 0;
	}	

	public synchronized factory.IVehicle createVehicle() {
		Factory.totalCost += Motorcycle.productionCost;
		toDo--;
		return new Motorcycle();
	}
	
	public synchronized void addToProduce(int quantity) {
		toDo += quantity;
	}
}
