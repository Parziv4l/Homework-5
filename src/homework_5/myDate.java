/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework_5;

import java.text.DateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author NicKLz
 */
public class myDate {

    GregorianCalendar hiredDate;
    String month,day,year;

    public void setDate(int m, int d, int y) {
        this.hiredDate.set(y, m, d);
    }
    public String dateString(){return hiredDate.toString();}

}
