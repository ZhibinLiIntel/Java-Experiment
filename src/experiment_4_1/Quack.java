package experiment_4_1;

interface QuackBehavior{
	void quack();
}
class Quack1 implements QuackBehavior{
	public void quack(){
		System.out.println("Quack 1");
	}
}
class Quack2 implements QuackBehavior{
	public void quack(){
		System.out.println("Quack 2");
	}
}
class Quack3 implements QuackBehavior{
	public void quack(){
		System.out.println("Quack 3");
	}
}