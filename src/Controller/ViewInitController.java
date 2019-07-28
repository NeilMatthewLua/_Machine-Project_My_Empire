package Controller;


import Model.GameBoard;
import Controller.LandInitController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ViewInitController {

    @FXML private HBox background;
    @FXML private Label play;
    @FXML private Label ready1;
    @FXML private Label ready2;
    @FXML private Label ready3;
    @FXML private Label ready4;
    @FXML private Label add1;
    @FXML private Label add2;
    @FXML private Label delete1;
    @FXML private Label delete2;
    @FXML private TextField textField1;
    @FXML private TextField textField2;
    @FXML private TextField textField3;
    @FXML private TextField textField4;

    GameBoard gameBoard;

    @FXML
    public void play(MouseEvent e) throws IOException {
        ArrayList<String> players = new ArrayList<String>();
        players.add(textField1.getText());
        players.add(textField2.getText());
        if(textField3.isVisible()){
            players.add(textField3.getText());
            if(textField4.isVisible()){
                players.add(textField4.getText());
            }
        }
        gameBoard = new GameBoard();
        gameBoard.initializePlayers(players);
        if (e.getSource() == play) { //If user presses play then switch scene
            try {
                Stage stage = (Stage) background.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/View/LandInit.fxml"));
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
                ((LandInitController) loader.getController()).setGameBoard(gameBoard);
            } catch(IOException problem){
                System.out.println("Something happened");
            }
        }
    }

    @FXML
    public void ready(MouseEvent e){//Handles events for ready buttons
        if(e.getSource() == ready1){
            if(ready1.getText().equalsIgnoreCase("ready")){
            if(!(textField1.getText() == null || textField1.getText().trim().isEmpty())){
                textField1.setEditable(false);
                ready1.setText("UNREADY");
                textField1.setPromptText("Enter name..");
            }
            else{
                textField1.setPromptText("Error. Empty name.");
            }
            }
            else{
                ready1.setText("READY");
                textField1.setEditable(true);
            }
        }
        else if(e.getSource() == ready2){
            if(ready2.getText().equalsIgnoreCase("ready")){
                if(!(textField2.getText() == null || textField2.getText().trim().isEmpty())){
                    textField2.setEditable(false);
                    ready2.setText("UNREADY");
                    textField2.setPromptText("Enter name..");
                }
                else{
                    textField2.setPromptText("Error. Empty name.");
                }
            }
            else{
                ready2.setText("READY");
                textField2.setEditable(true);
            }
        }
        else if(e.getSource() == ready3){
            if(ready3.getText().equalsIgnoreCase("ready")){
                if(!(textField3.getText() == null || textField3.getText().trim().isEmpty())){
                    textField3.setEditable(false);
                    ready3.setText("UNREADY");
                    textField3.setPromptText("Enter name..");
                }
                else{
                    textField3.setPromptText("Error. Empty name.");
                }
            }
            else{
                ready3.setText("READY");
                textField3.setEditable(true);
            }
        }
        else if(e.getSource() == ready4){
            if(ready4.getText().equalsIgnoreCase("ready")){
                if(!(textField4.getText() == null || textField4.getText().trim().isEmpty())){
                    textField4.setEditable(false);
                    ready4.setText("UNREADY");
                    textField4.setPromptText("Enter name..");
                }
                else{
                    textField4.setPromptText("Error. Empty name.");
                }
            }
            else{
                ready4.setText("READY");
                textField4.setEditable(true);
            }
        }
        if(checkForReady()){
            play.setVisible(true);
        }
        else{
            play.setVisible(false);
        }
    }

    private boolean checkForReady(){
        boolean valid = false;
        if(!(textField1.getText() == null || textField1.getText().trim().isEmpty()) && ready1.getText().equalsIgnoreCase("UNREADY")){
            if(!(textField2.getText() == null || textField2.getText().trim().isEmpty()) && ready2.getText().equalsIgnoreCase("UNREADY")){
                if(ready3.isVisible()){
                    if(!(textField3.getText() == null || textField3.getText().trim().isEmpty()) && ready3.getText().equalsIgnoreCase("UNREADY")){
                        if(ready4.isVisible()){
                            if(!(textField4.getText() == null || textField4.getText().trim().isEmpty()) && ready4.getText().equalsIgnoreCase("UNREADY")){
                                valid = true;
                            }
                        }
                        else{
                            valid = true;
                        }
                    }
                }
                else{
                    valid = true;
                }
            }
        }
        return valid;
    }
    @FXML
    public void add(MouseEvent e){//Handles add button events
        if(e.getSource() == add1){
            add1.setVisible(false);
            delete1.setVisible(true);
            textField3.setVisible(true);
            ready3.setVisible(true);
            add2.setVisible(true);
            play.setVisible(false);
        }
        else if(e.getSource() == add2){
            delete1.setVisible(false);
            add2.setVisible(false);
            delete2.setVisible(true);
            textField4.setVisible(true);
            ready4.setVisible(true);
            play.setVisible(false);
        }
        if(checkForReady()){
            play.setVisible(true);
        }
        else{
            play.setVisible(false);
        }
    }

    @FXML
    public void delete(MouseEvent e){//Handles delete button events
        if(e.getSource() == delete1){
            add2.setVisible(false);
            delete1.setVisible(false);
            textField3.setVisible(false);
            ready3.setVisible(false);
            textField3.setText("");
            ready3.setText("READY");
            add1.setVisible(true);
        }
        else if(e.getSource() == delete2){
            delete2.setVisible(false);
            delete1.setVisible(true);
            textField4.setVisible(false);
            ready4.setVisible(false);
            textField4.setText("");
            ready4.setText("READY");
            add2.setVisible(true);
        }
        if(checkForReady()){
            play.setVisible(true);
        }
        else{
            play.setVisible(false);
        }
    }
}
