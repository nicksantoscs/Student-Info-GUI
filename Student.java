import javafx.scene.image.Image;


public class Student {

    private String firstName, lastName;
    private int studentNumber;
    private Image image;


    Student(int studentNumber, String firstName, String lastName)   {
        setFirstName(firstName);
        setLastName(lastName);
        setStudentNumber(studentNumber);
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

    private void setFirstName(String firstName)  {
        this.firstName = firstName;
    }

    private void setLastName(String lastName)    {
        this.lastName = lastName;
    }

    private void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String toString()    {
        return String.format("%s %s Student #: %d", firstName, lastName, studentNumber);
    }

}