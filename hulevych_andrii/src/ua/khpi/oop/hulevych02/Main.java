package ua.khpi.oop.hulevych02;
import java.util.Random;

public class Main {
	public static void main(String arg[]) {
		int number_of_iterations = 10;
		System.out.println("------------------------------");
		System.out.println("|  Number  |   Sum of digits |");
		System.out.println("------------------------------");
		for (int i = 0; i <number_of_iterations; i++) {
			int number = generate(1000);
			System.out.print("|   " + number + "    |" );
			System.out.print("        " + find_summ(number)+ "       |\n");
			System.out.print("------------------------------\n");
		}
		
	}
	
	public static int generate(int border) {
		int res;
		Random random = new Random();
		res = random.nextInt(border+1);
		return res;
	}
	public static int find_summ(int number) {
		int temp = number;
		int sum = 0;
		while (temp!=0) 
		 {  sum += temp%10;     
		    temp /= 10;    
		 }
		
		return sum;
	}
}
