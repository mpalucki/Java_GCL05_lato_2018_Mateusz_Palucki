package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Clock");
        primaryStage.setScene(new Scene(root, 691, 325));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
