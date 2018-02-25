package ua.logic.softserve;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/*
c) Write ID of three last employees from collection (problem b).
d) Write code for reading and writing collection of these objects from (into) file.
e) Write code for handling the incorrect format of incoming file.
 */
public class EmployeeTestTest {
    @Test
    //a) Sort the collection of employees in descending order by the average monthly salary.
    // In the case of equal salary – by the name. Write ID, name and monthly salary for all employees from collection.
    public void problemA() {
        Employee vik = new Employee(1, "Vik", 15);
        Employee will = new Employee(2, "Will", 16);
        Employee all = new Employee(3, "All", 14);
        Employee nick = new Employee(4, "Nick", 13);
        Employee jin = new Employee(5, "Jin", 17);
        Employee jin6 = new Employee(6, "Jin", 16);
        List<Employee> sorted = new ArrayList<>(Arrays.asList(vik, will, all, nick, jin, jin6)).stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getName))
                .collect(toList());

        Assert.assertTrue(sorted.equals(new ArrayList<>(Arrays.asList(jin, jin6, will, vik, all, nick))));
    }

    @Test
    //b) Write information about first five employees from collection (problem a).
    public void problemB() {
        Employee vik = new Employee(1, "Vik", 15);
        Employee will = new Employee(2, "Will", 16);
        Employee all = new Employee(3, "All", 14);
        Employee nick = new Employee(4, "Nick", 13);
        Employee jin = new Employee(5, "Jin", 17);
        Employee jin6 = new Employee(6, "Jin", 16);
        List<Employee> sorted = new ArrayList<>(Arrays.asList(vik, will, all, nick, jin, jin6)).stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getName))
                .limit(5)
                .collect(toList());

        Assert.assertTrue(sorted.equals(new ArrayList<>(Arrays.asList(jin, jin6, will, vik, all))));
    }

}