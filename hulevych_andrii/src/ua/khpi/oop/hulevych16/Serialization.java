package ua.khpi.oop.hulevych16;

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
import java.util.ArrayList;
import java.util.LinkedList;

import org.xml.sax.SAXException;

public class Serialization {
    public static void LongTermPersistenceWrite(ArrayList<Agency> object, String path) throws FileNotFoundException {

        XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(
                        new FileOutputStream(path)));

        encoder.writeObject(object);

        encoder.close();
    }


    public static ArrayList<Agency> LongTermPersistenceRead(String path) throws FileNotFoundException {
        ArrayList<Agency> list = new ArrayList<>();
        try {
            XMLDecoder decoder = new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream(path)));

            list = (ArrayList<Agency>) decoder.readObject();
        } catch (FileNotFoundException e) {
            System.out.println(e.getStackTrace());
        }
        return list;
    }
}

