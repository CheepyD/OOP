package ua.khpi.oop.hulevych05;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		String[] animals = new String[5];
		Helper.get_data(animals);
		HandMade_String_Array test = new HandMade_String_Array(animals);	
		System.out.println(test.contains("vombat"));
		System.out.println(test.toString());
		
		System.out.println(test.indexOf("vombat"));
		
		Iterator<String> iter = test.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		for(String iterr : test) {
			System.out.println(iterr);
		}
	}
		
	
	}

