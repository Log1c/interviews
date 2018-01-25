package ua.logic.softserve;

import java.util.Comparator;

public class EmployeesSortBySalaryDesc implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getSalary() != o2.getSalary()) {
            if (o1.getSalary() < o2.getSalary()) {
                return 1;
            } else {
                return -1;
            }
        }

        if (o1.getName().compareTo(o2.getName()) != 0) {
            return o1.getName().compareTo(o2.getName());
        }

        return o1.getId() - o2.getId();
    }
}
