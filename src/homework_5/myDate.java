/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework_5;

/**
 *
 * @author NicKLz
 */
public class myDate {

    int month, day, year;
    String dateString;

    public myDate(int m, int d, int y) {
        this.setDate(m, d, y);
    }

    public void setDate(int m, int d, int y) {
        this.setDay(d);
        this.setMonth(m);
        this.setYear(y);
        this.setDateString();
    }

    private void setDay(int d) {
        if (d > 0 && d <= 31) {
            this.day = d;
        }
    }

    private void setMonth(int m) {
        if (m > 0 && m <= 12) {
            this.month = m;
        }
    }

    private void setYear(int y) {
        this.year = y;
    }

    private void setDateString() {
        this.dateString = month + "/" + day + "/" + year;
    }

    public String toString() {
        return this.dateString;
    }

}
