package factory;

public class TruckProductionLine extends ProductionLine {
	private int toDo;
	
	public void run() {
		while(isTruckToDo()) {
			try {
				Thread.sleep(Truck.productionTime*100);
				createVehicle();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private synchronized boolean isTruckToDo() {
		return toDo > 0;
	}	
	
	public synchronized IVehicle createVehicle() {
		Factory.totalCost += Truck.productionCost;
		toDo--;
		return new Truck();
	}
	
	public synchronized void addToProduce(int quantity) {
		toDo += quantity;
	}
	
}
