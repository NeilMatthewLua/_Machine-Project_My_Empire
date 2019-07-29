package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Font.loadFont(Main.class.getResource("/CSS/Fascinate-Regular.ttf").toExternalForm(),20);
        Parent root = FXMLLoader.load(getClass().getResource("/View/StartPage.fxml"));
        primaryStage.setTitle("My Empire");
        primaryStage.setScene(new Scene(root, 1080, 620));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
