import java.awt.*;

public class Student {

    private String firstName, lastName;
    private int studentNumber;
    private Image picture;

    Student(int studentNumber, String firstName, String lastName)   {
        makeFirstName(firstName);
        makeLastName(lastName);
        makeStudentNumber(studentNumber);
    }

    private void makeFirstName(String firstName)  {
        this.firstName = firstName;
        try {
        }
        catch(Exception e) {
            System.out.println("Only letters are allowed");
        }
    }

    private void makeLastName(String lastName)    {
        this.lastName = lastName;
        try {

        }
        catch(Exception e) {

        }
    }

    private void makeStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String toString()    {
        return String.format("%s %s Student #: %d", firstName, lastName, studentNumber);
    }
}