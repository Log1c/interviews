package ua.logic.softserve;

import java.io.*;

/*
Create classes, which describe employees with hourly wage and fixed payment.
Give your suggestions about relations between classes. Implement method for calculating the average monthly salary.
For employees with hourly wage use next formula: “average monthly salary= 20.8*8* hourly rate”,
 for employees with fixed payment – “average monthly salary= fixed monthly payment”.
Write well commented code for solving next problems
*/
public class Employee implements Comparable<Employee>, SalaryCalculation, Serializable {
    private int id;
    private String name;
    private boolean fixedPrice;
    private double hourlyRate;
    private double monthlyRate;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(int id, String name, double hourlyRate) {
        this.id = id;
        this.name = name;
        this.hourlyRate = hourlyRate;
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

    @Override
    public double getSalary() {
        if(isFixedPrice()) {
            return getMonthlyRate();
        }

        return WORKDAYS_IN_MONTH * WORKING_HOURS_IN_DAY * getHourlyRate();
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

        return id == employee.id;
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
