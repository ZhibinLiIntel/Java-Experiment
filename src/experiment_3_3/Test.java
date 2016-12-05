package experiment_3_3;

public class Test {
	public static void main(String args[]){
		Rodent[] rodent=new Rodent[3];
		rodent[0]=new Mouse();
		rodent[1]=new Gerbil();
		rodent[2]=new Hamster();
		rodent[0].Eat();
		rodent[0].Habitat();
		rodent[1].Eat();
		rodent[1].Habitat();
		rodent[2].Eat();
		rodent[2].Habitat();
	}
}
