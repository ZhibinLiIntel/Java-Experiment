package experiment_4_1;

interface FlyBehavior{
	void fly();
}
class FlyWithWings implements FlyBehavior{
	public void fly(){
		System.out.println("Fly with wings");
	}
}
class FlyNoWay implements FlyBehavior{
	public void fly(){
		System.out.println("Fly no way");
	}
}