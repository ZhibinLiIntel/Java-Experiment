package experiment_4_1;

public class Duck {
	private FlyBehavior flybehavior;
	private QuackBehavior quackbehavior;
	void PerformFly(){
		flybehavior.fly();
	}
	void PerformQuack(){
		quackbehavior.quack();
	}
	void SetFlyBehavior(FlyBehavior flybehavior){
		this.flybehavior=flybehavior;
	}
	void SetQuackBehavior(QuackBehavior quackbehavior){
		this.quackbehavior=quackbehavior;
	}
	void Display(){
		System.out.println("This is a duck.");
	}
}
class MallardDuck extends Duck{
	void Display(){
		System.out.println("MallardDuck");
	}
}
class RubberDuck extends Duck{
	void Display(){
		System.out.println("RubberDuck");
	}
}
class RedheadDuck extends Duck	{
	void Display(){
		System.out.println("RedheadDuck");
	}
}

