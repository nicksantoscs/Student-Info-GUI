import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.awt.image.ImageFilter;
import java.io.File;
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
    @FXML
    private ImageView imageView;

    @Override
    public void start(Stage primaryStage) {
    }

    /**
     * This method launches a FileChooser object so that the user selects a new image.
     * @param event
     */
    public void imageButtonPushed(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");

        //This filters the directory to search for .png and .jpg
        FileChooser.ExtensionFilter imgFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg","*.png");
        fileChooser.getExtensionFilters().addAll(imgFilter);

        //Set the start directory to the Pictures folder
        String userDirectoryString = System.getProperty("user.home") + "\\Pictures";
        File userDirectory = new File(userDirectoryString);

        //Confirm that the system can reach the Pictures directory
        if (!userDirectory.canRead())
            userDirectory = new File(System.getProperty("user.home"));

        //Sets file chooser to start with the user directory
        fileChooser.setInitialDirectory(userDirectory);

        File imageFile = fileChooser.showOpenDialog(stage);

        if (imageFile != null && imageFile.isFile()) {
            imageView.setImage(new Image(imageFile.toURI().toString()));
        }
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
        } else {
            int studentNum = Integer.parseInt(studentNumberTextField.getText());
            Student student1 = new Student(studentNum, firstNameTextField.getText(), lastNameTextField.getText(), activities);
            System.out.println(student1.toString());
        }
    }
}
