package ua.logic.softserve;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesUtil {
    //TODO refactor to try with resources
    public static void saveToFile(String scr, List collection) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream(scr)));
            out.writeObject(collection);
        } catch ( IOException ex ) {
            ex.printStackTrace();
        } finally {
            if ( out != null )
                try {
                    out.close();
                } catch ( IOException ex ) {
                    ex.printStackTrace();
                }
        }
    }

    //TODO refactor to try with resources
    public static List<Employee> loadFile(String out) {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(
                    new FileInputStream(out)));
            return (List<Employee>)in.readObject();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        } catch ( Exception ex ) {
            ex.printStackTrace();
        } finally {
            if ( in != null )
                try {
                    in.close();
                } catch ( IOException ex ) {
                    ex.printStackTrace();
                }
        }
        return new ArrayList<>();
    }

    public static void print(List<Employee> employees) {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
