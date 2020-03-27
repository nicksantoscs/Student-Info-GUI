import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CreateStudentController extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    public TextField firstNameTextField;
    @FXML
    public TextField lastNameTextField;
    @FXML
    public TextField studentNumberTextField;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label studentNumberLabel;
    @FXML
    private Button submitButton;
    @FXML
    private CheckBox activityOne;
    @FXML
    private CheckBox activityTwo;
    @FXML
    private CheckBox activityThree;
    @FXML
    private CheckBox activityFour;
    @FXML
    private CheckBox activityFive;
    @FXML
    private CheckBox activitySix;
    @FXML
    private CheckBox activitySeven;
    @FXML
    private CheckBox activityEight;

    @Override
    public void start(Stage primaryStage) {

    }

    public void submitClick() {
        ArrayList<String> activities = new ArrayList<String>();
        if (activityOne.isSelected()) {
            activities.add(activityOne.getText());
        }
        if (activityTwo.isSelected()) {
            activities.add(activityTwo.getText());
        }
        if (activityThree.isSelected()) {
            activities.add(activityThree.getText());
        }
        if (activityFour.isSelected()) {
            activities.add(activityFour.getText());
        }
        if (activityFive.isSelected()) {
            activities.add(activityFive.getText());
        }
        if (activitySix.isSelected()) {
            activities.add(activitySix.getText());
        }
        if (activitySeven.isSelected()) {
            activities.add(activitySeven.getText());
        }
        if (activityEight.isSelected()) {
            activities.add(activityEight.getText());
        }

        if (activities.isEmpty()) {
            throw new IllegalArgumentException("Please select an activity");
        }
        else {
            int studentNum = Integer.parseInt(studentNumberTextField.getText());
            Student student1 = new Student(studentNum, firstNameTextField.getText(), lastNameTextField.getText(), activities);
            System.out.println(student1.toString());
        }
    }
}
