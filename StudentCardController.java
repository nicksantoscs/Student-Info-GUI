import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentCardController implements Initializable {
    private Student selectedStudent;

    public TextArea activityList;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label studentNumberLabel;
    @FXML
    private Label birthdayLabel;
    @FXML
    private ImageView imageView;
    @FXML
    private Label ageLabel;
    @FXML
    private ListView<Student> listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * This method allows the user to switch between the multiple
     * student cards that they saved.
     */
    public void changeStudentFromList() {
        selectedStudent = listView.getSelectionModel().getSelectedItem();
        initData();
    }

    /**
     * This method saves any student that was created by the user to the ListView.
     * @param student
     */
    public void selectStudent(Student student) {
        selectedStudent = student;
        listView.getItems().addAll(Main.getStudents());
        initData();
    }
    /**
     * This method accepts a student to initialize the view
     * @param
     */
    public void initData() {
        firstNameLabel.setText(selectedStudent.getFirstName());
        studentNumberLabel.setText(Integer.toString(selectedStudent.getStudentNumber()));
        lastNameLabel.setText(selectedStudent.getLastName());
        birthdayLabel.setText(selectedStudent.getBirthday().toString());
        ageLabel.setText(Integer.toString(selectedStudent.getAge()));
        imageView.setImage(selectedStudent.getImage());
        activityList.setText(String.valueOf(selectedStudent.getActivities()));
    }



    public void favActivities(Student santos) {
        ArrayList<String> activity = new ArrayList<>();
        activity.add("Coding");
        activity.add("Hockey");
        activity.add("Gaming");
        activity.add("Skiing");
        activity.add("Cooking");

        for (String a : activity) {
            activityList.appendText(a + "\n");
        }
    }

    /**
     * This method takes the user back to the CreateStudent interface where they can create
     * another student.
     * @param event
     * @throws IOException
     */
    public void backToStudent (ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("CreateStudent.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Student View");
        stage.setScene(scene);
        stage.show();
    }




}

