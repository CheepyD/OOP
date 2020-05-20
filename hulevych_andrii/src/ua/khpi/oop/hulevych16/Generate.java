package ua.khpi.oop.hulevych16;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Generate {
    private static String f_name = "\\C:\\Users\\{Dean}\\eclipse-workspace\\hulevych_andrii\\src\\ua\\khpi\\oop\\hulevych13\\file_name.txt";
    private static String f_circs = "\\C:\\Users\\{Dean}\\eclipse-workspace\\hulevych_andrii\\src\\ua\\khpi\\oop\\hulevych13\\file_circs.txt";
    private static String f_position = "\\C:\\Users\\{Dean}\\eclipse-workspace\\hulevych_andrii\\src\\ua\\khpi\\oop\\hulevych13\\file_position.txt";
    private static Random rand = new Random();

    public static ArrayList<Agency> agencyGeneration(int size) throws IOException {
        ArrayList<String> name = read_name();
        ArrayList<String> circs = read_circs();
        ArrayList<String> position = read_positions();
        ArrayList<Agency> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Agency agency = new Agency();
            Agency.Requierments reqs = new Agency.Requierments();
            agency.setFirmName(name.get(rand.nextInt(name.size())));
            agency.setCircs(circs.get(rand.nextInt(circs.size())));
            agency.setKey(true);
            agency.setPosition(position.get(rand.nextInt(position.size())));
            agency.setSalary(rand.nextInt(10000));
            if (agency.getKey()) {
                reqs.setEducation("Abscent");
                reqs.setYexp(rand.nextInt(10));
                agency.setReqs(reqs);
            }
            list.add(agency);
        }
        return list;
    }

    public static ArrayList<String> read_name() {
        ArrayList<String> name = new ArrayList<String>();
        FileReader filereader;
        try {
            filereader = new FileReader(f_name);
            BufferedReader reader = new BufferedReader(filereader);
            String line = reader.readLine();
            while (!line.equals("----")) {
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
            while (!line.equals("----")) {
                surname.add(new String(line));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return surname;
    }

    public static ArrayList<String> read_positions() {
        ArrayList<String> position = new ArrayList<String>();
        FileReader filereader;
        try {
            filereader = new FileReader(f_position);
            BufferedReader reader = new BufferedReader(filereader);
            String line = reader.readLine();
            while (!line.equals("----")) {
                position.add(new String(line));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return position;
    }
}
