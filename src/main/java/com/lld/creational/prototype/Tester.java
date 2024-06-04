package com.lld.creational.prototype;

public class Tester {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address1=new Address("haroon colnty","patna",800002,"payna","bihar");
        Person person1=new Person("Moshahid",25,address1);


        Person person2=person1.clone();
        person2.getAddress().setCity("Delhi");
        System.out.println(person1);
        System.out.println(person2);
    }
}
