import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

import static javafx.application.Application.launch;

public class Main extends Application {

    private static ArrayList<Student> students;

    public static void main(String[] args) {
        students = new ArrayList<>();
        launch(args);
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    @Override

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CreateStudent.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Student Card");
        stage.setScene(scene);
        stage.show();
    }
}