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
public abstract class Person {

    protected String name, address, number, email;

    protected Person(String nameString, String addressString, String numberString, String emailString) {
        this.name = nameString;
        this.address = addressString;
        this.number = numberString;
        this.email = emailString;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setNumber(String n) {
        this.number = n;
    }

    public void setAddress(String n) {
        this.address = n;
    }

    public void setEmail(String n) {
        this.email = n;
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

    @Override
    abstract public String toString();
}
