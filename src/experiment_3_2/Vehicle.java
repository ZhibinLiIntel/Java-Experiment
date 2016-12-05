package experiment_3_2;

public abstract class Vehicle {
	abstract String NoOfWheels();
}
class Car extends Vehicle{
	String NoOfWheels(){
		return "Car: Four wheels";
	}
}
class Motorbike extends Vehicle{
	String NoOfWheels(){
		return "Motorbike: Two wheels";
	}
}
