package experiment_4_1;

public class Test {

	public static void main(String[] args) {
		Duck mallardduck=new MallardDuck();
		mallardduck.SetFlyBehavior(new FlyWithWings());
		mallardduck.SetQuackBehavior(new Quack1());
		mallardduck.Display();
		mallardduck.PerformFly();
		mallardduck.PerformQuack();
	}

}
