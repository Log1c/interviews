package ua.logic.softserve;

/*
Create classes, which describe employees with hourly wage and fixed payment. Give your suggestions about relations between classes. Implement method for calculating the average monthly salary. For employees with hourly wage use next formula: “average monthly salary= 20.8*8* hourly rate”, for employees with fixed payment – “average monthly salary= fixed monthly payment”. Write well commented code for solving next problems
a) Sort the collection of employees in descending order by the average monthly salary. In the case of equal salary – by the name. Write ID, name and monthly salary for all employees from collection.
b) Write information about first five employees from collection (problem a).
c) Write ID of three last employees from collection (problem b).
d) Write code for reading and writing collection of these objects from (into) file.
e) Write code for handling the incorrect format of incoming file.
 */

import java.util.*;

public class EmployeeTest {
    public static List<Employee> createCollectionOfEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee(1, "Eddy");

        employee1.setFixedPrice(true);
        employee1.setMonthlyRate(16640);

        Employee employee2 = new Employee(2, "Sonny");
        employee2.setHourlyRate(100);

        Employee employee3 = new Employee(3, "Sonn");
        employee3.setHourlyRate(700);

        Employee employee4 = new Employee(4, "Son");
        employee4.setHourlyRate(20000);

        Employee employee5 = new Employee(5, "Sy");
        employee5.setHourlyRate(8);

        Employee employee6 = new Employee(6, "Sy");
        employee6.setHourlyRate(8);

        employees.addAll(Arrays.asList(employee1
                , employee2
                , employee3
                , employee4
                , employee5
                , employee6));

        return employees;
    }

    public static void main(String[] args) {
        //TODO please refactor in test
        List<Employee> employees = createCollectionOfEmployees();
        problemA(employees);
        problemB(employees);
        problemC(employees);
        problemD(employees);
    }

    private static void problemA(List<Employee> employees) {
        System.out.println("Problem a");
        employees.stream()
                .sorted(new EmployeesSortBySalaryDesc())
                .forEach(System.out::println);
    }

    private static void problemB(List<Employee> employees) {
        System.out.println("Problem b");
        employees.stream()
                .sorted(new EmployeesSortBySalaryDesc())
                .limit(5)
                .forEach(System.out::println);
    }

    private static void problemC(List<Employee> employees) {
        System.out.println("Problem c");
        employees.stream()
                .sorted(new EmployeesSortById().reversed())
                .limit(3)
                .forEach(System.out::println);
    }

    private static void problemD(List<Employee> employees) {
        System.out.println("Problem d");
        EmployeesUtil.saveToFile("emp", employees);
        List<Employee> loadCollection = EmployeesUtil.loadFile("emp");

        loadCollection.forEach(System.out::println);
    }
}
