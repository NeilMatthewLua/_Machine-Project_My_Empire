package Controller;


import Model.GameBoard;
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

public class ViewInitController implements Initializable{

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
    @FXML private Label error1;
    @FXML private Label error2;
    @FXML private Label error3;
    @FXML private Label error4;
    ArrayList<Label> errorLabels;
    ArrayList<Label> readyButtons;
    ArrayList<TextField> textFields;
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
        ArrayList<String> tempNames = new ArrayList<String>();
        for(int i = 0; i <readyButtons.size(); i++){
            tempNames.add(textField1.getText());
            if(e.getSource().equals(readyButtons.get(i))){
                errorLabels.get(i).setVisible(false);
                if(readyButtons.get(i).getText().equalsIgnoreCase("READY")){
                    boolean isDuplicate = false;
                    for(int j = 0; j < tempNames.size();j++){
                        if(textFields.get(i).getText().trim().equals(textFields.get(j).getText().trim()) && i != j)
                            isDuplicate = true;
                    }
                    if (isDuplicate){
                        errorLabels.get(i).setVisible(true);
                        errorLabels.get(i).setText("Error. Duplicate name. :(");
                    }

                    else if(textFields.get(i).getText().trim().length() == 0 || textFields.get(i).getText() == null){
                        errorLabels.get(i).setVisible(true);
                        errorLabels.get(i).setText("Error. Empty name. :O");
                    }
                    else if(textFields.get(i).getText().trim().length() >= 6){
                        errorLabels.get(i).setVisible(true);
                        errorLabels.get(i).setText("Error. Name too long. :>");
                    }
                    else{
                            textFields.get(i).setEditable(false);
                            readyButtons.get(i).setText("UNREADY");
                            textFields.get(i).setPromptText("Enter name..");
                    }
                }
                else{
                    errorLabels.get(i).setVisible(false);
                    readyButtons.get(i).setText("READY");
                    textFields.get(i).setEditable(true);
                }
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
        boolean stop = true;
        for(int i = 0; i < textFields.size() && stop;i++){
            if(textFields.get(i).isVisible()){
                if(!(textFields.get(i).getText() == null || textFields.get(i).getText().trim().isEmpty()) && readyButtons.get(i).getText().equalsIgnoreCase("UNREADY")){
                    valid = true;
                }
                else{
                    stop = false;
                    valid = false;
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

    @Override
    public void initialize(URL url, ResourceBundle rb){
        readyButtons = new ArrayList<Label>();
        textFields = new ArrayList<TextField>();
        errorLabels = new ArrayList<Label>();
        errorLabels.add(error1);errorLabels.add(error2);errorLabels.add(error3);errorLabels.add(error4);
        readyButtons.add(ready1);readyButtons.add(ready2);readyButtons.add(ready3);readyButtons.add(ready4);
        textFields.add(textField1);textFields.add(textField2);textFields.add(textField3);textFields.add(textField4);
    }
}
