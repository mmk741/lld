package com.lld.creational.builder;

public class Client {
    //builder pattern is used when validation is required while creating object and when there are
    //lot of parameter to create object and most of parameter are default or optional
    public static void main(String[] args) {
        Director directorObj1 = new Director(new EngineeringStudentBuilder());
        Director directorObj2 = new Director(new MBAStudentBuilder());

        Student engineerStudent = directorObj1.createStudent();
        Student mbaStudent =directorObj2.createStudent();

        System.out.println(engineerStudent.toString());
        System.out.println(mbaStudent.toString());

    }
}
