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
public abstract class Employee extends Person {

    protected int office;
    protected double salary;
    protected myDate hired;

    public int getOffice() {
        return this.office;
    }

    public double getSalary() {
        return this.salary;
    }

    public myDate getDateHired() {
        return this.hired;
    }

    @Override
    abstract public String toString();

    

    

}
