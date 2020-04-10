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

import static javafx.application.Application.launch;

public class Main extends Application {

    public static void main(String[] args) {

        //Student student = new Student(1117292, "Nicholas", "Santos");
        //System.out.printf("%s%n", student);
        launch(args);
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