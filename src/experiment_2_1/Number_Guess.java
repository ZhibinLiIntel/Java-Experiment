package experiment_2_1;
import java.util.*;
public class Number_Guess {   //Assume that the scale of the number is 0 to 100
	int number=24;            //Set the original number as 24
	void Guess(){
		System.out.print("Please input the number(Scale 1 to 100): ");
		Scanner input=new Scanner(System.in);
		int guess_num=input.nextInt();
		for(;guess_num!=number;){
			if(guess_num>number)
				System.out.println("It's too large");
			else 
				System.out.println("It's too small");
			System.out.print("Please re-enter the number: ");
			input=new Scanner(System.in);
			guess_num=input.nextInt();
		}
		System.out.println("Gracious!");
	}
	
}
