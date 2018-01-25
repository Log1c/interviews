package ua.logic.softserve;

import java.io.*;

public class Employee implements Comparable<Employee>, Serializable {
    private int id;
    private String name;
    private boolean fixedPrice;
    private double hourlyRate;
    private double monthlyRate;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(double monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    @Override
    public int compareTo(Employee employee) {
        return getName().compareTo(employee.getName());
    }

    public double getSalary() {
        if(isFixedPrice()) {
            return getMonthlyRate();
        }

        return 20.8 * 8 * getHourlyRate();
    }

    public boolean isFixedPrice() {
        return fixedPrice;
    }

    public void setFixedPrice(boolean fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        return id != employee.id;
    }

    @Override
    public int hashCode() {
        return getName().length();
    }

    @Override
    public String toString() {
        return getId() + "; " + getName() + "; " + getSalary();
    }


}
