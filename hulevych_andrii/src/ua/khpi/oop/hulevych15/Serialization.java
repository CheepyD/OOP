package ua.khpi.oop.hulevych15;

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import org.xml.sax.SAXException;

public class Serialization {
	public static int LongTermPersistenceWrite(LinkedList<Agency> object,int size) throws FileNotFoundException {
		
		XMLEncoder encoder = new XMLEncoder(
		           new BufferedOutputStream(
		           new FileOutputStream(Helper.directory())));

		for (Agency agency: object) {
			encoder.writeObject(agency);
		}
		
		 try(FileWriter writer = new FileWriter("notes3.txt", false))
	        {
	            writer.write(size);
				writer.flush();
	        }
	        catch(IOException ex){
	            
	            System.out.println(ex.getMessage());
	        } 
		size = object.size();
		encoder.close();
		return size; 
	}

	
	
	public static LinkedList<Agency> LongTermPersistenceRead(int size,int flag) throws FileNotFoundException {
		
		XMLDecoder decoder = null;
		if(flag > 0) {
			decoder = new XMLDecoder(
			    new BufferedInputStream(
			    new FileInputStream(Helper.directory())));	
		}
		else {
			decoder = new XMLDecoder(
				    new BufferedInputStream(
				    new FileInputStream("C:\\Users\\{Dean}\\eclipse-workspace\\hulevych_andrii\\4Firms11.xml")));	
			}
		LinkedList<Agency> object = new LinkedList<Agency>();
			System.out.println(size);
			for(int i = 0; i < size; i++) {
				object.add((Agency)decoder.readObject());
			}
			 
			decoder.close();
			return object;
	}

	
	public static void SerializationA(LinkedList<Agency> object,String path) throws IOException {
		
		FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(object);
        objectOutputStream.close();
	}

	
	
	@SuppressWarnings("unchecked")
	public static LinkedList<Agency> DeserializationA(String path) throws IOException, ClassNotFoundException {

			
			FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            LinkedList<Agency> object = (LinkedList<Agency>) objectInputStream.readObject();
            
            objectInputStream.close();
            return object;
	}

}
