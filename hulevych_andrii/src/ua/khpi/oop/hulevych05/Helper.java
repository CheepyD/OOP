package ua.khpi.oop.hulevych05;

import java.util.Arrays;
import java.util.Scanner;

public class Helper {

	public static void sort_by_alphabet(String[] array, boolean flagg ) {
		if(flagg)	Arrays.sort(array);
		else {
			System.out.println("This function sorts array of strings by alphabet");
		}
	}
	
	public static void sort_by_length(String[] array, boolean flagg) {
		if(flagg) {
		String temp = new String();
		
		int i, j, nMin;
		  for( i=0; i < array.length; i++)
		  { nMin=i;
		    temp=array[i];
		    for( j=i+1; j < array.length; j++)	// цикл выбора наименьшего элемента
		      if (array[j].length() < temp.length())
		      {	 nMin=j;			// индекс наименьшего элемента
			     temp=array[j];			//  значение наименьшего элемента
		      }
		    array[nMin] = array[i];
		    array[i] = temp;			// меняем местами наименьший с a[i]
		  }
		  temp = null;
		}
		else {
			System.out.println("This function sorts array by length");
		}
	}
	public static void print_arr(String[] arr) {
		if(arr == null) {
			System.out.println("This function prints array in console");
			return;
		}
		System.out.println("Your array is:");
		for(int i = 0; i < 5; i++) {
			System.out.println(i + "." + arr[i]);
		}
		System.out.println("");
	}

	
	public static void get_data(String[] arr) {
		if(arr == null) {
			System.out.println("The function get_gata scans the data from input");
			return;
		}
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a couple of strings(5)");
		for(int i = 0; i < 5; i++) {
			arr[i] = scan.nextLine();
		}
	}
	
	public static void info_about_author() {
		System.out.println("@Author: Andrii Hulevych 1.KIT 102.8a");
		System.out.println("@Date: 01.11.2019");
		System.out.println("@Version 1.1");
	}
	
	
}
