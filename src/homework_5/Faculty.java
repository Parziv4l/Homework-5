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
public class Faculty extends Employee {

    private String officeHours, rank;

    public Faculty(String nameString, String addressString,
            String numberString, String mailString,
            int officeNum, double sal,
            myDate hireDate, String officeHrs, String rankString) {
        super(nameString, addressString, numberString, mailString, officeNum, sal, hireDate);
        this.rank = rankString;
        this.officeHours = officeHrs;
    }

    public String getOfficeHours() {
        return this.officeHours;
    }

    public String getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        return "Faculty: " + this.name;
    }
}
