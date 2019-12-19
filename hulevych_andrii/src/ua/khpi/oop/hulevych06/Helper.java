package ua.khpi.oop.hulevych06;

import java.io.FileInputStream;
import ua.khpi.oop.kotenko04.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Helper {

	static HandMade_String_Array list = new HandMade_String_Array();

	public static void start() throws IOException, ClassNotFoundException{	
		int choice = 0;
		Scanner temp = new Scanner(System.in);
		do {
			Helper.print_main_menu();
			choice = temp.nextInt();
			switch(choice) {
			case 1:
				Helper.get_data();
				break;
			case 2:
				Helper.print_arr();
				break;
			case 3:
				list.sortArray();
				break;
			case 4:
				Helper.addElement();
				break;
			case 5:
				Helper.removeElement();
				break;
			case 6:
				Scanner tempStr = new Scanner(System.in);
				System.out.println("Which string do you need?");
				String choiice = new String();
				choiice = tempStr.nextLine();
				System.out.println(list.indexOf(choiice));
				break;
			case 7:
				list.clear();
				break;
			case 8:
				Helper.saveContainer();
				break;
			case 9:
				Helper.recoverContainer();
				break;
			case 10:
				Function04 a = new Function04();
				Scanner tempScan = new Scanner(System.in);
				String tmp = new String();
				tmp = tempScan.nextLine();
				a.Operation(tmp);
				break;
			default:
				break;
			}
		}while(choice!=11);
	}
	
	public static void print_main_menu(){
		System.out.println("1.Enter data");
		System.out.println("2.Show current data");
		System.out.println("3.Sort by alphabet");
        System.out.println("4.Add data");
        System.out.println("5.Remove some element");
        System.out.println("6.Find index of element");
        System.out.println("7.Clear all");
		System.out.println("8.Save data");
        System.out.println("9.Recover data");
        System.out.println("10.Use foreign class");
        System.out.println("11.Exit");
	}
	
	public static void print_arr() {
		System.out.println("Your array is:");
		for(String str : list) {
			System.out.println("  " + str);
		}
	}

	
	public static void get_data() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the text:");
		String current = sc.nextLine();
		while(!current.equals("")) {
		    list.add(new String(current));
		    current = sc.nextLine();
		}
	}
	
	static public void addElement() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the text:");
		String current = sc.nextLine();
		list.add(current);
	}
	static public void removeElement() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the text:");
		String current = sc.nextLine();
		if(!list.contains(current)) System.out.println("Cannot find the string :(");
		else {list.remove(current);}
	}
	static public void saveContainer() throws IOException {
		FileOutputStream outputStream = new FileOutputStream("C:\\Users\\{Dean}\\Serialized\\savedContainer.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
	    objectOutputStream.writeObject(list);
	    objectOutputStream.close();
	}
	static public void recoverContainer() throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\{Dean}\\Serialized\\savedContainer.txt");
	    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	    list = (HandMade_String_Array) objectInputStream.readObject();
	}
	
	
	
}
