import javafx.scene.image.Image;

import javax.swing.*;
import java.util.ArrayList;

public class Student {

    private String firstName, lastName;
    private int studentNumber;
    private Image image;
    private ArrayList<String>activities;


    Student(int studentNumber, String firstName, String lastName, ArrayList<String>activities) {
        setFirstName(firstName);
        setLastName(lastName);
        setStudentNumber(studentNumber);
        setActivities(activities);
        image = new Image("./image/nicksantos.jpg") {
        };
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public Image getImage() {
        return image;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;

    }

    public ArrayList<String> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<String> activities) {
        this.activities = activities;
    }

    public String toString() {
        return String.format("%s %s Student #: %d, favourite activities: %s", firstName, lastName, studentNumber, this.activities.toString());
    }

}