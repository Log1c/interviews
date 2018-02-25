package ua.logic.softserve;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class EmployeeTestTest {
    @Test
    //a) Sort the collection of employees in descending order by the average monthly salary.
    // In the case of equal salary – by the name. Write ID, name and monthly salary for all employees from collection.
    public void problemA() {
        //TODO replace for 6 employees
        Employee vik = new Employee(1, "Vik", 15);
        Employee will = new Employee(2, "Will", 16);
        Employee all = new Employee(3, "All", 16);
        List<Employee> sorted = new ArrayList<>(Arrays.asList(vik, will, all)).stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getName))
                .collect(toList());

        Assert.assertTrue(sorted.equals(new ArrayList<>(Arrays.asList(all, will, vik))));
    }

    @Test
    //b) Write information about first five employees from collection (problem a).
    public void problemB() {
        //TODO replace for 5 employees
        Employee vik = new Employee(1, "Vik", 15);
        Employee will = new Employee(2, "Will", 16);
        Employee all = new Employee(3, "All", 16);
        List<Employee> sorted = new ArrayList<>(Arrays.asList(vik, will, all)).stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getName))
                .limit(2)
                .collect(toList());

        Assert.assertTrue(sorted.equals(new ArrayList<>(Arrays.asList(all, will))));
    }

}