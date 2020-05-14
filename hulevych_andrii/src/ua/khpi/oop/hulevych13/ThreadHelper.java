package ua.khpi.oop.hulevych13;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

public class ThreadHelper {
	private static String f_name = "\\C:\\Users\\{Dean}\\eclipse-workspace\\hulevych_andrii\\src\\ua\\khpi\\oop\\hulevych13\\file_name.txt";
	private static String f_circs = "\\C:\\Users\\{Dean}\\eclipse-workspace\\hulevych_andrii\\src\\ua\\khpi\\oop\\hulevych13\\file_circs.txt";
	private static String f_position = "\\C:\\Users\\{Dean}\\eclipse-workspace\\hulevych_andrii\\src\\ua\\khpi\\oop\\hulevych13\\file_position.txt";
	private static int size;
	private static Random rand = new Random();
	public static void starter_accountGenerator() {
		System.out.println("Enter the amount of accounts to be generated [0 - 100 000 000]");
		size = Helper.numberEnterer(100000000);
		System.out.println("Starting generation...");
		try {
			_gen_add();
		} catch (IOException e) {
			System.out.println("Error" + e);
		}
		System.out.println("\nFinished");
	}
	public static void _gen_add() throws IOException {
		ArrayList<String> name = read_name();
		ArrayList<String> circs = read_circs();
		ArrayList<String> position = read_positions();
		for(int i = 0; i < size; i++) {
			Agency agency = new Agency();
			Agency.Requierments reqs = new Agency.Requierments();
			agency.setFirmName(name.get(rand.nextInt(name.size())));
			agency.setCircs(circs.get(rand.nextInt(circs.size())));
			agency.setKey(rand.nextBoolean());
			agency.setPosition(position.get(rand.nextInt(position.size())));
			agency.setSalary(rand.nextInt(10000));
			if(agency.getKey()) {
				reqs.setEducation("Abscent");
				reqs.setYexp(rand.nextInt(10));
				agency.setReqs(reqs);
			}
			Helper.agencies.add(agency);
		}
	}
	public static ArrayList<String> read_name() {
		ArrayList<String> name = new ArrayList<String>();
		FileReader filereader;
		try {
			filereader = new FileReader(f_name);
			BufferedReader reader = new BufferedReader(filereader);
			String line = reader.readLine();
			while(!line.equals("----")) {
			    name.add(new String(line));
			    line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return name;	
	}
	public static ArrayList<String> read_circs() {
		ArrayList<String> surname = new ArrayList<String>();
		FileReader filereader;
		try {
			filereader = new FileReader(f_circs);
			BufferedReader reader = new BufferedReader(filereader);
			String line = reader.readLine();
			while(!line.equals("----")) {
			    surname.add(new String(line));
			    line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return surname;	
	}
	
	public static ArrayList<String> read_positions(){
		ArrayList<String> position = new ArrayList<String>();
		FileReader filereader;
		try {
			filereader = new FileReader(f_position);
			BufferedReader reader = new BufferedReader(filereader);
			String line = reader.readLine();
			while(!line.equals("----")) {
			    position.add(new String(line));
			    line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return position;	
	}
	public static void start_all_threads() {
		System.out.println("Set the timer [0 - 100 000 ms]: ");
		int timer_num = Helper.numberEnterer(100000);
		System.out.println("Starting all threads...");
		
		FirstThread first = new FirstThread();
        Thread t1 = new Thread(first,"FirstThread"); 
        
		SecondThread second = new SecondThread();
        Thread t2 = new Thread(second,"SecondThread"); 
       

		t1.start();
		t2.start();
        Timer timer = new Timer(timer_num, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Interrupting thread...");
    			t1.interrupt();
    			t2.interrupt();
            }
        });
        timer.setRepeats(false);
        timer.start();
		try {
			t1.join();
			t2.join();
			timer.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finishing all threads...");
	}
	
	public static long comparison_parallel() {
		long time_start = System.currentTimeMillis();
		System.out.println("Starting all threads...");
		FirstThread first = new FirstThread();
        Thread t1 = new Thread(first,"FirstThread"); 
        
		SecondThread second = new SecondThread();
        Thread t2 = new Thread(second,"SecondThread"); 

		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finishing all threads...");
		return System.currentTimeMillis() - time_start;
	}
	public static long comparison_sequential() {
		long time_start = System.currentTimeMillis();
		System.out.println("Starting sequence...");
		try {
			Threads.task_1();
			Threads.task_2();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finishing sequence...");
		return System.currentTimeMillis() - time_start;
	}

}

class FirstThread implements Runnable {
	public void run() {
		int count = 0;
        System.out.println("First Thread started");
        try {
            for (Agency a : Helper.agencies) {
            	Thread.sleep(100);
                if (!Thread.currentThread().isInterrupted()) {
                    if(a.getFirmName().indexOf("Daxx") >= 0) { 
                    	count++;
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("First Thread finished. Firms with name Daxx : " + count);
        } catch (InterruptedException e) {
            System.out.println("First Thread is interrupted");
        }
    }
} 
class SecondThread implements Runnable {
	public void run() {
		int count = 0;
        System.out.println("Second Thread started");
        try {
            for (Agency a : Helper.agencies) {
            	Thread.sleep(100);
                if (!Thread.currentThread().isInterrupted()) {
                    if(a.getKey()) { 
                    	count++;
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("Second Thread finished. Vacanties with add conditions : " + count);
        } catch (InterruptedException e) {
            System.out.println("Second Thread is interrupted");
        }

    }
} 


