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
public class Staff extends Employee {

    private String title;

    public Staff(String nameString, String addressString,
            String numberString, String mailString,
            int officeNum, double sal,
            myDate hireDate, String titleString) {
        super(nameString, addressString, numberString, mailString, officeNum, sal, hireDate);
        this.title = titleString;

    }

    @Override
    public String toString() {
        return "Staff: " + this.name;
    }

    public String getTitle() {
        return this.title;
    }
}
