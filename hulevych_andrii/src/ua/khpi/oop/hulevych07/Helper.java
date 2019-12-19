package ua.khpi.oop.hulevych07;

import java.util.Scanner;

public class Helper {
    public static void lets_go() {
    	System.setProperty("console.encoding","Cp866");
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите размер массива:");
		int arraySize = sc.nextInt();
    	Agency[] agencies = new Agency[arraySize];
    	for(int i = 0; i < agencies.length; i++) {
    		System.out.println((i+1));
    		agencies[i] = new Agency(enterFirmName(), enterPosition(), enterCircs(), enterSalary(), enterKey());
    		if(agencies[i].getKey() == true)agencies[i].isNeedRequierments(enterExperience(), enterEducation());
    	}
    	showAccounts(agencies);
    }
	public static void showAccounts(Agency[] agencies) {
		for(int i = 0; i < agencies.length; i++) {
			agencies[i].print();
		}
	}

	public static String enterFirmName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Имя фирмы : ");
		String firmName = sc.nextLine();
		return firmName;
	}
	public static String enterPosition() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Должность : ");
		String position = sc.nextLine();
		return position;
	}
	public static String enterCircs() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Условия работы : ");
		String circs = sc.nextLine();
		return circs;
	}
	
	public static int enterSalary() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Зарплата : ");
		int salary = sc.nextInt();
		return salary;
	}
	
	public static boolean enterKey() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Есть ли дополнительные требования?");
		boolean choice = sc.nextBoolean();
		return choice;
	}
	
	public static int enterExperience() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Опыт работы : ");
		int exp = sc.nextInt();
		return exp;
	}
	
	public static String enterEducation() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Уровень образования : ");
		String educ = sc.nextLine();
		return educ;
	}
	
	
}
