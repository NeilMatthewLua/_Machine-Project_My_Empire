package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;

import static javafx.stage.Modality.APPLICATION_MODAL;

public class StartController {

    @FXML
        private AnchorPane anchorPane;
    @FXML
        private Label playLabel;


//    public void labelClick(MouseEvent e) throws IOException {
//       if(e.getSource() == playLabel){
//           Stage stage = (Stage)anchorPane.getScene().getWindow();
//           FXMLLoader loader = new FXMLLoader();
//           loader.setLocation(getClass().getResource("/View/ViewInit.fxml"));
//           Scene scene = new Scene(loader.load());
//           stage.setScene(scene);
//       }
//    }

    public void labelClick(MouseEvent e) throws IOException {
        if(e.getSource() == playLabel){
            Stage stage = (Stage)anchorPane.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/View/EventLog.fxml"));


            Scene scene = new Scene(loader.load(),287,410);

            Stage x = new Stage();
            x.setScene(scene);
            EventLog eventLog = loader.getController();
            ArrayList<String> events = new ArrayList<>();

            events.add("Albert paid 10$ to Neil");
            events.add("Neil rolled a 5!");
            events.add("Neil bought Abad Santos");
            events.add("Albert paid 10$ to Neil");
            events.add("Neil rolled a 5!");
            events.add("Neil bought Abad Santos");
            events.add("Albert paid 10$ to Neil");
            events.add("Neil rolled a 5!");
            events.add("Neil bought Abad Santos");
            events.add("Albert paid 10$ to Neil");
            events.add("Neil rolled a 5!");
            events.add("Neil bought Abad Santos");
            events.add("Albert paid 10$ to Neil");
            events.add("Neil rolled a 5!");
            events.add("Neil bought Abad Santos");events.add("Albert paid 10$ to Neil");
            events.add("Neil rolled a 5!");
            events.add("Neil bought Abad Santos");
            events.add("Albert paid 10$ to Neil");
            events.add("Neil rolled a 5!");
            events.add("Neil bought Abad Santos");
            events.add("Albert paid 10$ to Neil");
            events.add("Neil rolled a 5!");
            events.add("Neil bought Abad Santos");
            events.add("Albert paid 10$ to Neil");
            events.add("Neil rolled a 5!");
            events.add("Neil bought Abad Santos");events.add("Albert paid 10$ to Neil");
            events.add("Neil rolled a 5!");
            events.add("Neil bought Abad Santos");




            eventLog.initialize(events);
            x.initModality(APPLICATION_MODAL);
            x.setResizable(false);
            x.setX(900);
            x.setY(30);
            x.show();
        }
    }
}
