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
import javafx.scene.image.ImageView;
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
    @FXML private ImageView player3Avatar;
    @FXML private ImageView player4Avatar;
    GameBoard gameBoard;
    String [][] avatarUrls = {
        {"../Images/Players/player1.png"},{"../Images/Players/player2.png"},{"../Images/Players/player3.png"},{"../Images/Players/player4.png"}
    };

    @FXML
    public void play(MouseEvent e) throws IOException {
        //Retrieve the Text found in the textfields and register as player names
        ArrayList<String> players = new ArrayList<String>();
        players.add(textField1.getText());
        players.add(textField2.getText());
        if(textField3.isVisible()){ //If player 3 exists
            players.add(textField3.getText());
            if(textField4.isVisible()){ //If player 4 exists
                players.add(textField4.getText());
            }
        }
        ArrayList<String> playerAvatars = new ArrayList<String>();
        gameBoard = new GameBoard();
        gameBoard.initializePlayers(players); //Initialize the players in the model based off their names

        for(int i = 0; i < gameBoard.getPlayers().length;i++){
            boolean isFound = false;
            for(int j = 0; j < gameBoard.getPlayers().length && !isFound;j++){
                if(gameBoard.getPlayers()[i].getName().equalsIgnoreCase(textFields.get(j).getText())){//The proper avatars to the players
                    playerAvatars.add(avatarUrls[j][0]);
                    isFound = true;
                }
            }
        }

        if (e.getSource() == play) { //If user presses play then switch scene
            try {
                Stage stage = (Stage) background.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/View/LandInit.fxml"));
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
                ((LandInitController) loader.getController()).setGameBoard(gameBoard);
                ((LandInitController) loader.getController()).setPlayerAvatars(playerAvatars);
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
                if(readyButtons.get(i).getText().equalsIgnoreCase("READY")){ //If player wishes to click ready
                    boolean isDuplicate = false;
                    for(int j = 0; j < tempNames.size();j++){ //Checks if name has been taken
                        if(textFields.get(i).getText().trim().equals(textFields.get(j).getText().trim()) && i != j)
                            isDuplicate = true;
                    }
                    if (isDuplicate){ //If duplicate
                        errorLabels.get(i).setVisible(true);
                        errorLabels.get(i).setText("Error. Duplicate name.");
                    }

                    else if(textFields.get(i).getText().trim().length() == 0 || textFields.get(i).getText() == null){//If empty name
                        errorLabels.get(i).setVisible(true);
                        errorLabels.get(i).setText("Error. Empty name.");
                    }
                    else if(textFields.get(i).getText().trim().length() > 6){//If name is too long
                        errorLabels.get(i).setVisible(true);
                        errorLabels.get(i).setText("Error. Name is too long.");
                    }
                    else{//If name is valid then continue
                            textFields.get(i).setEditable(false);
                            readyButtons.get(i).setText("UNREADY");
                            textFields.get(i).setPromptText("Enter name..");
                    }
                }
                else{ //If the player wants to unready
                    errorLabels.get(i).setVisible(false);
                    readyButtons.get(i).setText("READY");
                    textFields.get(i).setEditable(true);
                }
            }
        }
        if(checkForReady()){ //If the game is valid for playing
            play.setVisible(true);
        }
        else{
            play.setVisible(false);
        }
    }

    private boolean checkForReady(){
        boolean valid = false;
        boolean stop = true;
        for(int i = 0; i < textFields.size() && stop;i++){//Loops through the visible players and checks if they are all ready
            if(textFields.get(i).isVisible()){//If player is visible then check
                if(!(textFields.get(i).getText() == null || textFields.get(i).getText().trim().isEmpty()) && readyButtons.get(i).getText().equalsIgnoreCase("UNREADY")){
                    valid = true;
                }
                else{//If player is visible and does not comply to requirements
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
            player3Avatar.setVisible(true);
        }
        else if(e.getSource() == add2){
            delete1.setVisible(false);
            add2.setVisible(false);
            delete2.setVisible(true);
            textField4.setVisible(true);
            ready4.setVisible(true);
            play.setVisible(false);
            player4Avatar.setVisible(true);
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
            player3Avatar.setVisible(false);
        }
        else if(e.getSource() == delete2){
            delete2.setVisible(false);
            delete1.setVisible(true);
            textField4.setVisible(false);
            ready4.setVisible(false);
            textField4.setText("");
            ready4.setText("READY");
            add2.setVisible(true);
            player4Avatar.setVisible(false);
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
