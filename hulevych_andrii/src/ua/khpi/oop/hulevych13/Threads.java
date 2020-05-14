package ua.khpi.oop.hulevych13;

public class Threads {
	public static void task_1() throws InterruptedException {
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
	public static void task_2() throws InterruptedException {
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