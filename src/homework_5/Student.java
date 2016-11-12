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
enum Class_Status {
    FRESHMAN, SOPHOMORE, JUNIOR, SENIOR
}

public class Student extends Person {

    private final Class_Status status;

    public Student(String n, String add, String num, String mail, Class_Status stat) {
        this.name = n;
        this.address = add;
        this.number = num;
        this.email = mail;
        this.status = stat;
    }

    public Class_Status getStatus() {
        return this.status;
    }
    
    public String toString(){
    return super.toString() + "\n" + this.status;}
}
