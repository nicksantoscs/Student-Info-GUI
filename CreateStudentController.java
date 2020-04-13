import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateStudentController implements Initializable {

    private Student student1;

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
    private Label ageLabel;
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
    @FXML
    private DatePicker datePicker;
    @FXML
    private ListView listView;
    static int studentNumber = 1111111;

    /**
     * This method launches a FileChooser object so that the user selects a new image.
     *
     * @param event
     */
    public void imageButtonPushed(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");

        //This filters the directory to search for .png and .jpg
        FileChooser.ExtensionFilter imgFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
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

    /**
     * This method takes the current date and calculates the user's age.
     *
     * @param event
     * @throws Exception
     */

    public void updateAge(ActionEvent event) throws Exception {
        //Gets the current date
        LocalDate currentDate = LocalDate.now();

        //Getting the date entered
        LocalDate enteredDate = datePicker.getValue();

        //Calculating the age
        int age = (int) ChronoUnit.YEARS.between(enteredDate, currentDate);

        //Updating the age label
        ageLabel.setText("Age: " + age);
    }

    /**
     * This method checks to make sure there are activities selected before submitting it to
     * the detailed student view
     * @param event
     * @throws IOException
     */
    public void submitClick(ActionEvent event) throws IOException {
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

            student1 = new Student(studentNumber, firstNameTextField.getText(), lastNameTextField.getText(), activities, datePicker.getValue(), imageView.getImage());
            studentNumber += 1;
            Main.getStudents().add(student1);
            System.out.println(student1.toString());
            changeSceneToDetailedStudentView(event);
        }
    }

    /**
     * When this method is called, it will pass the selected Student object to
     * a detailed view
     */
    public void changeSceneToDetailedStudentView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((getClass().getResource("StudentCard.fxml")));
        Parent listViewParent = loader.load();

        Scene listViewScene = new Scene(listViewParent);

        //Access the controller and call a method
        StudentCardController controller = loader.getController();
        controller.selectStudent(student1);

        //This line gets the stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(listViewScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentNumberTextField.setText(studentNumber + "");
    }
}

