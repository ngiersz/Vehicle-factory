package factory;

public class Main {

	public static void main(String[] args) {

		Factory.totalCost = 0;
		Factory factory = new Factory();
		factory.takeOrder("/orders.xml");
		factory.run();
	}

}
