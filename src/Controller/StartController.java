package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartController {

    @FXML
        private AnchorPane anchorPane;
    @FXML
        private Label playLabel;


    public void labelClick(MouseEvent e){
       if(e.getSource() == playLabel){
            Stage stage = (Stage)anchorPane.getScene().getWindow();
            System.out.println("COWS");
       }
    }
}
