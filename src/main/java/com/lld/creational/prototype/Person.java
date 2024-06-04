package com.lld.creational.prototype;

public class Person implements Cloneable{
    private String name;
    private int age;
    private Address address ;

    public Person(String name, int age, Address address) {

        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        Person clonedPerson= (Person)super.clone();
        clonedPerson.address=  address.clone();
        return clonedPerson;

    }
}
