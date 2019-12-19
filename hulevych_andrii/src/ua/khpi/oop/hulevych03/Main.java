package ua.khpi.oop.hulevych03;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String arg[]) {
		String[] arr = new String[5];
		Scanner temp = new Scanner(System.in);
		
		System.out.println("Enter a couple of strings(5)");
		for(int i = 0; i < 5; i++) {
			arr[i] = temp.nextLine();
		}
		temp.close();
		sort_by_alphabet(arr);
		
		System.out.println("Sorted array is:");
		for(int i = 0; i < 5; i++) {
			System.out.println(i + "." + arr[i]);
		}
		sort_by_length(arr);
		
		System.out.println("");
		
		System.out.println("Sorted array is:");
		for(int i = 0; i < 5; i++) {
			System.out.println(i + "." + arr[i]);
		}
		
	}
	public static void sort_by_alphabet(String[] array ) {
		Arrays.sort(array);
	}
	
	public static void sort_by_length(String[] array) {
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
	
	
}
