package ua.khpi.oop.hulevych08;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Helper {
	
    @SuppressWarnings("unchecked")
	public static void lets_go() throws ClassNotFoundException, IOException {
    	ArrayList<Agency> agencies = null;
    	int curSize;
    	curSize = 0;
    	System.setProperty("console.encoding","Cp866");
    	int choice = 0;
		Scanner temp = new Scanner(System.in);
		
		
		do {
			Helper.print_main_menu();
			choice = temp.nextInt();
			switch(choice) {
			case 1:
				agencies = get_data();
				curSize = agencies.size();
				break;
			case 2:
				if(curSize == 0) {System.out.println("Enter data first"); break;} 
				Helper.showAgencies(agencies);
				break;
			case 3:
				if(curSize == 0) {System.out.println("Enter data first"); break;} 
				agencies.clear();
				curSize = 0;
				break;
			case 4:
				if(curSize == 0) {System.out.println("Enter data first"); break;} 
				FileOutputStream fileOutputStream = new FileOutputStream(directory());
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
				objectOutputStream.writeObject(agencies);
				break;
			case 5:
				FileInputStream fileInputStream = new FileInputStream(directory());
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
				agencies =  (ArrayList<Agency>) objectInputStream.readObject();
				curSize = agencies.size();
				break;
			default:
				break;
			}
		}while(choice!=6);
    }
    
    public static void print_main_menu(){
		System.out.println("1.Enter data");
		System.out.println("2.Show current data");
        System.out.println("3.Clear all");
		System.out.println("4.Save data");
        System.out.println("5.Recover data");
        System.out.println("6.Exit");
	}
	public static void showAgencies(ArrayList<Agency> agencies2) {
		for(int i = 0; i < agencies2.size(); i++) {
			agencies2.get(i).print();
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
	
	public static ArrayList<Agency> get_data() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = sc.nextInt();
		ArrayList<Agency> temp = new ArrayList<>();
		Agency tempp = new Agency();
		for (int i = 0; i < size; i++) {
			System.out.println((i+1));
			tempp.setFirmName(enterFirmName());
			tempp.setPosition(enterPosition());
			tempp.setCircs(enterCircs());
			tempp.setSalary(enterSalary());
			tempp.setKey(enterKey());
			if(tempp.getKey() == true) tempp.isNeedRequierments(enterExperience(), enterEducation());
			temp.add(tempp);
		}
		return temp;
	}
	
	static void encoder(ArrayList<Agency> agencies) throws FileNotFoundException {
		XMLEncoder encoder = new XMLEncoder(
				new BufferedOutputStream(
						new FileOutputStream(directory())));
			encoder.writeObject(agencies);
			encoder.writeObject(agencies.get(0).getReqs());
		encoder.close(); 
	}
	static ArrayList<Agency> decoder() throws FileNotFoundException {
		XMLDecoder decoder = new XMLDecoder(
				new BufferedInputStream(
						new FileInputStream(directory())));
		@SuppressWarnings("unchecked")
		ArrayList<Agency> agency =  (ArrayList<Agency>) decoder.readObject();
		decoder.close();
		return agency; 
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
