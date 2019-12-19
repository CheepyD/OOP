package ua.khpi.oop.hulevych04;
import java.util.Scanner;

public class Main {

	public static void main(final String args[]) {
		
		boolean flag = false;
		for(String one : args) {
			if(one.equals("-d")|| one.equals("-debug")) {
				flag = true;
			}
		}
		
		int choice = 0;
		Scanner temp = new Scanner(System.in);
		if(flag){
			String[] arr = new String[5];	
			do {
				Menu.print_main_menu();
				choice = temp.nextInt();
		switch(choice) {
		case 1:
			Helper.get_data(arr);
			break;
		case 2:
			Helper.print_arr(arr);
			break;
		case 3:
			Helper.sort_by_alphabet(arr,flag);
			break;
		case 4:
			Helper.sort_by_length(arr, flag);
			break;
		default:
			break;
		}
			}while(choice!=5);
		}
		else{
			Helper.info_about_author();
			do {
					Menu.print_main_menu();
					choice = temp.nextInt();
					switch(choice) {
					case 1:
						Helper.get_data(null);
						break;
					case 2:
						Helper.print_arr(null);
						break;
					case 3:
						Helper.sort_by_alphabet(null,flag);
						break;
					case 4:
						Helper.sort_by_length(null, flag);
						break;
					default:
						break;
					}
				}while(choice != 5);
			}
		}
	
}

	
	

	
	
