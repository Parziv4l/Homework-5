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
public class Student extends Person {

    private final Class_Status status;

    public Student(String n, String add, String num, String mail, Class_Status stat) {
        super(n, add, num, mail);
        this.status = stat;
    }

    public Class_Status getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return "Student: " + this.name;
    }
}
