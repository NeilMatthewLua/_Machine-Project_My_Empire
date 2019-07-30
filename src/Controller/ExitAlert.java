package Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ExitAlert {

    @FXML
        private Label yesButton;
    @FXML
        private Label noButton;

    @FXML
        private Button yesButton1;

     private boolean bAns;

    public boolean display(){



            System.out.println("DXDXX");
            yesButton1.setOnAction(e -> {
                bAns = true;
                System.out.println("DD");

            });

        return bAns;
    }

//    public boolean getAns(){
//
//
//    }
}
