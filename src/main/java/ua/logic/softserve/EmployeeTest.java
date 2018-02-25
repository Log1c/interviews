package ua.logic.softserve;

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
        problemC(employees);
        problemD(employees);
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
