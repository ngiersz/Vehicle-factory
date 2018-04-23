package factory;

public class Factory {
	private Thread carProductionLineThread, motorcycleProductionLineThread, truckProductionLineThread;
	static int totalCost;		
	
	ProductionLine carFactory = new CarProductionLine();
	ProductionLine motorcycleFactory = new MotorcycleProductionLine();
	ProductionLine truckFactory = new TruckProductionLine();
	
	public Factory() {
		carProductionLineThread = new Thread(carFactory);
		motorcycleProductionLineThread = new Thread(motorcycleFactory);
		truckProductionLineThread = new Thread(truckFactory);		
	}
	
	public void takeOrder(String path) {
		XMLParser orderParser = new XMLParser(path);
				
		carFactory.addToProduce(orderParser.getNumberOf("car"));
		motorcycleFactory.addToProduce(orderParser.getNumberOf("motorcycle"));
		truckFactory.addToProduce(orderParser.getNumberOf("truck"));
	}
	
	public void run() {
		carProductionLineThread.start();
		motorcycleProductionLineThread.start();
		truckProductionLineThread.start();

		try {
			carProductionLineThread.join();
			motorcycleProductionLineThread.join();
			truckProductionLineThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
		System.out.println("total cost = " + totalCost);
	}
}
