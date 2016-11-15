/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework_5;

import java.util.Date;

/**
 *
 * @author NicKLz
 */
public class Employee extends Person {

    protected int office;
    protected double salary;
    protected myDate hired;

    public Employee(String nameString, String addressString,
            String numberString, String mailString,
            int officeNum, double sal,
            myDate hireDate) {
        super(nameString, addressString, numberString, mailString);
        this.office = officeNum;
        this.hired = hireDate;
        this.salary = sal;
    }

    public int getOffice() {
        return this.office;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getDateHired() {
        return this.hired.toString();
    }

    public void setDate(int month, int day, int year) {
        hired.setDate(month, day, year);
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
