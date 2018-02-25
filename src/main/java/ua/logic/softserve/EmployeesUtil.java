package ua.logic.softserve;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesUtil {
    public static void saveToFile(String scr, List collection) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(scr)))) {
            out.writeObject(collection);
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }
    }

    public static List<Employee> loadFile(String out) {
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(out)))) {
            return (List<Employee>)in.readObject();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void print(List<Employee> employees) {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
