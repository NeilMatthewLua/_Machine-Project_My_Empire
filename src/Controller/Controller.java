
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Controller implements Initializable {

    @FXML
    private VBox box1;
    @FXML
    private VBox box2;
    @FXML
    private VBox box3;
    @FXML
    private Button add1;
    @FXML
    private Button add2;
    @FXML
    private Button add3;
    @FXML
    private Button play;
    @FXML
    private TextField text1;
    @FXML
    private TextField text2;
    @FXML
    private TextField text3;
    @FXML
    private Button readyFour;

    private int nPlayers;

    @FXML
    private void changeButton(ActionEvent event) {
            if(((Button) event.getSource()).getText().equalsIgnoreCase("Ready")){
                ((Button) event.getSource()).setText("Unready");
            }
            else{
                ((Button) event.getSource()).setText("Ready");
            }
    }
    @FXML
    private void readyPlayer(ActionEvent event){
        if(readyFour.getText().equalsIgnoreCase("Unready"))
            play.setVisible(true);
        if(((Button) event.getSource()).getText().equalsIgnoreCase("Add")){
            ((Button) event.getSource()).setText("Remove");
            String btnID = ((Button) event.getSource()).getId();
            if(btnID.charAt(btnID.length()-1) == '1'){
                box1.setVisible(true);
                add2.setVisible(true);
            }
            else if(btnID.charAt(btnID.length()-1) == '2'){
                add1.setVisible(false);
                box2.setVisible(true);
                add3.setVisible(true);
            }
            else if(btnID.charAt(btnID.length()-1) == '3'){
                add2.setVisible(false);
                box3.setVisible(true);
            }
        }
        else{
            ((Button) event.getSource()).setText("Add");
            String btnID = ((Button) event.getSource()).getId();
            if(btnID.charAt(btnID.length()-1) == '1'){
                box1.setVisible(false);
                text1.setPromptText("Enter Name....");
                add1.setVisible(true);
                add2.setVisible(false);
            }
            else if(btnID.charAt(btnID.length()-1) == '2'){
                box2.setVisible(false);
                text2.setPromptText("Enter Name....");
                add1.setVisible(true);
                add2.setVisible(true);
                add3.setVisible(false);
            }
            else if(btnID.charAt(btnID.length()-1) == '3'){
                box3.setVisible(false);
                text3.setPromptText("Enter Name....");
                add2.setVisible(true);
                add3.setVisible(true);
            }
        }
    }

    @FXML
    private void switchScene(ActionEvent event){
        if(((Button) event.getSource()).getText().equalsIgnoreCase("YOUR MOM GAY")){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(
                        "/MainBoard.fxml"));
                Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
            }
            catch(IOException io){
                System.out.println("Welp");
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
