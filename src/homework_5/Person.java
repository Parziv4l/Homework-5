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
public class Person {

    String name;
    String address;
    String number;
    String email;

    public Person(String n, String add, String num, String mail) {
        name = n;
        address = add;
        number = num;
        email = mail;
    }
    
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

}
