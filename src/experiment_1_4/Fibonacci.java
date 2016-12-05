package experiment_1_4;

class Fibonacci {
	int Fib(int num){
		if(num<=2)
			return 1;
		else 
			return Fib(num-1)+Fib(num-2);
	}
}
