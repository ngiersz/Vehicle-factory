package factory;

public class CarProductionLine extends ProductionLine {
	int toDo;

	public void run() {
		while(isCarToDo()) {
			try {
				Thread.sleep(Car.productionTime*100);
				createVehicle();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private synchronized boolean isCarToDo() {
		return toDo > 0;
	}	

	public synchronized IVehicle createVehicle() {
		Factory.totalCost += Car.productionCost;
		toDo--;
		return new Car();
	}
	
	public synchronized void addToProduce(int quantity) {
		toDo += quantity;
	}
}
