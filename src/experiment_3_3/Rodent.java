package experiment_3_3;

class Rodent {
	void Eat(){}
	void Habitat(){}
}
class Mouse extends Rodent{
	void Eat(){
		System.out.println("Mouse eats food1");
	}
	void Habitat(){
		System.out.println("Mouse lives in habitat1");
	}
}
class Gerbil extends Rodent{
	void Eat(){
		System.out.println("Gerbil eats food2");
	}
	void Habitat(){
		System.out.println("Gerbil lives in habitat2");
	}
}
class Hamster extends Rodent{
	void Eat(){
		System.out.println("Hamster eats food3");
	}
	void Habitat(){
		System.out.println("Hamster lives in habitat3");
	}
}
