import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentCardController implements Initializable {

    public TextArea activityList;
    @FXML
    private Label firstName;
    @FXML
    private Label lastName;
    @FXML
    private Label studentNumber;
    @FXML
    private ImageView nickSantos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // Student santos = new Student(1117292, "Nicholas", "Santos");
//        firstName.setText(santos.getFirstName());
//        lastName.setText(santos.getLastName());
//        studentNumber.setText(String.format("%d", santos.getStudentNumber()));
//        nickSantos.setImage(santos.getImage());
//        favActivities(santos);
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
}

