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


    public void labelClick(MouseEvent e) throws IOException {
       if(e.getSource() == playLabel){
           Stage stage = (Stage)anchorPane.getScene().getWindow();
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/View/ViewInit.fxml"));
           Scene scene = new Scene(loader.load());
           stage.setScene(scene);
       }
    }

}
