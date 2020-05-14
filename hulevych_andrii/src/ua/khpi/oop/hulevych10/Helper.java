package ua.khpi.oop.hulevych10;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Helper {
	
    @SuppressWarnings("unchecked")
	public static void lets_go(int flag) throws ClassNotFoundException, IOException {
    	List<Agency> agencies = new List<Agency>();
    	System.setProperty("console.encoding","Cp866");
    	int choice = 0;
		Scanner temp = new Scanner(System.in);
		do {
			Helper.print_main_menu();
			choice = temp.nextInt();
			switch(choice) {
			case 1:
				if(flag > 0) {
					get_data(agencies);
				}
				else {
					int listSize = 0;
					try (BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\{Dean}\\eclipse-workspace\\hulevych_andrii\\notes3.txt")))
				    {
					 listSize = in.read();
				    }
				 catch(Exception FileNotFoundException) {
					 
				 };
				agencies = Serialization.LongTermPersistenceRead(listSize,flag);
				}
				break;
			case 2:
				if(agencies.getSize() == 0) {System.out.println("Enter data first"); break;} 
				Helper.showAgencies(agencies);
				break;
			case 3:
				if(agencies.getSize() == 0) {System.out.println("Enter data first"); break;} 
				agencies.remove(agencies.getTail().getData());
				break;
			case 4:
				if(agencies.getSize() == 0) {System.out.println("Enter data first"); break;}
				 Serialization.LongTermPersistenceWrite(agencies, agencies.getSize());
				break;
			case 5:
				int listSize = 0;
				 try (BufferedReader in = new BufferedReader(new FileReader(directory())))
				    {
					 listSize = in.read();
				    }
				 catch(Exception FileNotFoundException) {
					 
				 };
				agencies = Serialization.LongTermPersistenceRead(listSize, flag);
				break;
			case 6:
				System.out.println(agencies.toString(agencies));
			case 7:
				Agency[] tempp = new Agency[agencies.getSize()];
				tempp = agencies.toArray();
				for(int i = 0; i < tempp.length; i++) {
					System.out.println(tempp[i].getFirmName());
				}
			case 8:
				agencies.sortList();
			default:
				break;
			}
		}while(choice!=9);
    }
    
    public static void print_main_menu(){
		System.out.println("1.Enter data");
		System.out.println("2.Show current data");
        System.out.println("3.Remove tail");
		System.out.println("4.Save data");
        System.out.println("5.Recover data");
        System.out.println("6.To string");
        System.out.println("7.To Array");
        System.out.println("8.Sort list");
        System.out.println("9.Exit");
	}
	public static void showAgencies(List<Agency> agencies) {
		for(Agency temp : agencies) {
			temp.print();
		}
	}

	public static String enterFirmName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Назвиние фирмы : ");
		String firmName = sc.nextLine();
		return firmName;
	}
	public static String enterPosition() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Должность: ");
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
		System.out.println("Есть ли какие-то дополнительные требования?");
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
		System.out.print("Введите образование : ");
		String educ = sc.nextLine();
		return educ;
	}
	
	public static void get_data(List<Agency> list) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = sc.nextInt();
		Agency tempp = new Agency();
		for (int i = 0; i < size; i++) {
			tempp = new Agency();
			System.out.println((i+1));
			tempp.setFirmName(enterFirmName());
			tempp.setPosition(enterPosition());
			tempp.setCircs(enterCircs());
			tempp.setSalary(enterSalary());
			tempp.setKey(enterKey());
			if(tempp.getKey() == true) tempp.isNeedRequierments(enterExperience(), enterEducation());
			list.add(tempp);
			tempp = null;
		}
	}
static String directory() {
		int index_const = 3, index2, index3, choice;
		String fileName = writeFileName();
		File file = new File(fileName);
		File file2 = new File(file.getAbsolutePath());
		String currPos = file2.getParent();
		while(true) {
			index2 = 0;
			index3 = 0;
			File currFolder = new File(currPos);
			File[] folders = currFolder.listFiles();
			int[] indexes = new int[folders.length];

			System.out.printf("%-30s","1) .");
			System.out.printf("%-30s","2) ..");
			for(int i = 0; i < folders.length; i++) {
				if(folders[i].isDirectory() && !folders[i].isHidden())   {
					indexes[index2] = i;
					if(index2%4 == 3) System.out.printf("%-30s", (index_const + index3++) + ") " + folders[i].getName());
					else if(index2%4 == 2) System.out.printf("%-30s", (index_const + index3++) + ") " + folders[i].getName());
					else if(index2%4 == 1) System.out.printf("%-30s\n", (index_const + index3++) + ") " + folders[i].getName());
					else System.out.printf("%-30s", (index_const + index3++) + ") " + folders[i].getName());
					index2++;
				}
			}
			Scanner sc = new Scanner(System.in);
			System.out.print("\n" + currPos + "> ");
			choice = sc.nextInt();
			if(choice == 1) 
				break;
			else if(choice == 2 && currFolder.getParent() != null) {
				currPos = currFolder.getParent();
			}
			else if((choice-index_const) < index2 && (choice-index_const) >= 0) {
				currPos = folders[indexes[choice-index_const]].getAbsolutePath();
			}
			else {
				System.out.println("Try again.");
			}
		}
		
		return currPos + "\\" + fileName;
	}
	private static String writeFileName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = sc.nextLine();
		return fileName;
	}
	
	
}
