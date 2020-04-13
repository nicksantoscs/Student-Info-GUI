import javafx.scene.image.Image;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Student {

    private String firstName, lastName;
    private int studentNumber;
    private Image image;
    private ArrayList<String> activities;
    private LocalDate birthday;
    private int age;


    Student(int studentNumber, String firstName, String lastName, ArrayList<String> activities, LocalDate birthday, Image image) {
        setFirstName(firstName);
        setLastName(lastName);
        setStudentNumber(studentNumber);
        setBirthday(birthday);
        setActivities(activities);
        setImage(image);
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

    public void setImage(Image image) {
        this.image = image;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public ArrayList<String> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<String> activities) {
        this.activities = activities;
    }

    public String toString() {
        return String.format("%s %s with student #: %d has favourite activities: %s", firstName, lastName, studentNumber, this.activities.toString());
    }

}