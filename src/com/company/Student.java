package com.company;

public class Student {

    private String firstName, lastName;
    private int studentNumber;

    Student(int studentNumber, String firstName, String lastName)   {
        makeFirstName(firstName);
        makeLastName(lastName);
        makeStudentNumber(studentNumber);
    }

    private void makeFirstName(String firstName)  {
        this.firstName = firstName;
        //I couldn't figure out why the line beneath this wasn't working.
        //The only visible error it showed me was at toUpperCase, which I know can't be used on chars.
        //I'll show you in class when I have the chance.
        //Nick
        //firstName=firstName.charAt(0).toUpperCase()+firstName.substring(1).toLowerCase();
    }

    private void makeLastName(String lastName)    {
        this.lastName = lastName;
        //I couldn't figure out why the line beneath this wasn't working.
        //The only visible error it showed me was at toUpperCase, which I know can't be used on chars.
        //I'll show you in class when I have the chance.
        //Nick
        //lastName=lastName.charAt(0).toUpperCase()+lastName.substring(1).toLowerCase();
    }

    private void makeStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String toString()    {
        return String.format("%s %s Student #: %d", firstName, lastName, studentNumber);
    }
}