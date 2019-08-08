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
    //Play button
    @FXML private Label play;
    //Ready buttons
    @FXML private Label ready1;
    @FXML private Label ready2;
    @FXML private Label ready3;
    @FXML private Label ready4;
    //Add buttons
    @FXML private Label add1;
    @FXML private Label add2;
    //Delete buttons
    @FXML private Label delete1;
    @FXML private Label delete2;
    //The four textfields
    @FXML private TextField textField1;
    @FXML private TextField textField2;
    @FXML private TextField textField3;
    @FXML private TextField textField4;
    //Error messages on top of each player
    @FXML private Label error1;
    @FXML private Label error2;
    @FXML private Label error3;
    @FXML private Label error4;
    //Their respective arraylists
    ArrayList<Label> errorLabels;
    ArrayList<Label> readyButtons;
    ArrayList<TextField> textFields;
    //Player avatar for player 3 and player 4
    @FXML private ImageView player3Avatar;
    @FXML private ImageView player4Avatar;
    GameBoard gameBoard;
    String [][] avatarUrls = {
        {"../Images/Players/player1.png"},{"../Images/Players/player2.png"},{"../Images/Players/player3.png"},{"../Images/Players/player4.png"}
    };

    //If play button is pressed
    @FXML
    public void play(MouseEvent e) throws IOException {
        //Retrieve the Text found in the textfields and register as player names
        ArrayList<String> players = new ArrayList<String>();
        players.add(textField1.getText());
        players.add(textField2.getText());
        //If player 3 was added
        if(textField3.isVisible()){
            players.add(textField3.getText());
            //If player 4 was added
            if(textField4.isVisible()){
                players.add(textField4.getText());
            }
        }
        ArrayList<String> playerAvatars = new ArrayList<String>();
        gameBoard = new GameBoard();
        //Initialize the players in the model based off their names
        gameBoard.initializePlayers(players);
        //Arrange the player avatars in the same sequence of the players inside the gameboard
        for(int i = 0; i < gameBoard.getPlayers().length;i++){
            boolean isFound = false;
            //Match their corresponding images
            for(int j = 0; j < gameBoard.getPlayers().length && !isFound;j++){
                if(gameBoard.getPlayers()[i].getName().equalsIgnoreCase(textFields.get(j).getText())){//The proper avatars to the players
                    playerAvatars.add(avatarUrls[j][0]);
                    isFound = true;
                }
            }
        }
        //If user presses play then switch scene
        if (e.getSource() == play) {
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

    //Handles events for ready buttons
    @FXML
    public void ready(MouseEvent e){
        //Store the names in a temp arraylist to check for duplicates
        ArrayList<String> tempNames = new ArrayList<String>();
        for(int i = 0; i <readyButtons.size(); i++){
            tempNames.add(textField1.getText());
            if(e.getSource().equals(readyButtons.get(i))){
                errorLabels.get(i).setVisible(false);
                //If player wishes to click ready
                if(readyButtons.get(i).getText().equalsIgnoreCase("READY")){
                    boolean isDuplicate = false;
                    //Checks if name has been taken
                    for(int j = 0; j < tempNames.size();j++){
                        if(textFields.get(i).getText().trim().equals(textFields.get(j).getText().trim()) && i != j)
                            isDuplicate = true;
                    }
                    //If duplicate
                    if (isDuplicate){
                        errorLabels.get(i).setVisible(true);
                        errorLabels.get(i).setText("Error. Duplicate name.");
                    }
                    //If empty name
                    else if(textFields.get(i).getText().trim().length() == 0 || textFields.get(i).getText() == null){
                        errorLabels.get(i).setVisible(true);
                        errorLabels.get(i).setText("Error. Empty name.");
                    }
                    //If name is too long
                    else if(textFields.get(i).getText().trim().length() > 6){
                        errorLabels.get(i).setVisible(true);
                        errorLabels.get(i).setText("Error. Name is too long.");
                    }
                    //If name is valid then continue
                    else{
                            textFields.get(i).setEditable(false);
                            readyButtons.get(i).setText("UNREADY");
                            textFields.get(i).setPromptText("Enter name..");
                    }
                }
                //If the player wants to unready
                else{
                    errorLabels.get(i).setVisible(false);
                    readyButtons.get(i).setText("READY");
                    textFields.get(i).setEditable(true);
                }
            }
        }
        //If the game is valid for playing
        if(checkForReady()){
            play.setVisible(true);
        }
        //If not then do not show play button
        else{
            play.setVisible(false);
        }
    }

    private boolean checkForReady(){
        boolean valid = false;
        boolean stop = true;
        //Loops through the visible players and checks if they are all ready
        for(int i = 0; i < textFields.size() && stop;i++){
            //If player is visible then check
            if(textFields.get(i).isVisible()){
                //Is player textfield is visible and not empty
                if(!(textFields.get(i).getText() == null || textFields.get(i).getText().trim().isEmpty()) && readyButtons.get(i).getText().equalsIgnoreCase("UNREADY")){
                    valid = true;
                }
                //Otherwise visible player has empty texfield and is not valid for play
                else{
                    stop = false;
                    valid = false;
                }
            }
        }
        return valid;
    }
    //Handles add button events
    @FXML
    public void add(MouseEvent e){

        if(e.getSource() == add1){
            add1.setVisible(false);
            delete1.setVisible(true);
            textField3.setVisible(true);
            ready3.setVisible(true);
            add2.setVisible(true);
            play.setVisible(false);
            player3Avatar.setVisible(true);
        }
        //Show the corresponding components when adding player 3
        else if(e.getSource() == add2){
            delete1.setVisible(false);
            add2.setVisible(false);
            delete2.setVisible(true);
            textField4.setVisible(true);
            ready4.setVisible(true);
            play.setVisible(false);
            player4Avatar.setVisible(true);
        }
        //Checks for game validity
        if(checkForReady()){
            play.setVisible(true);
        }
        else{
            play.setVisible(false);
        }
    }

    //Handles delete button events
    @FXML
    public void delete(MouseEvent e){
        //Show the corresponding components when deleting player 4
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
        //Show the corresponding components when deleting player 4
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
        //add in the corresponding labels/textfields to their corresponding arraylists
        errorLabels.add(error1);errorLabels.add(error2);errorLabels.add(error3);errorLabels.add(error4);
        readyButtons.add(ready1);readyButtons.add(ready2);readyButtons.add(ready3);readyButtons.add(ready4);
        textFields.add(textField1);textFields.add(textField2);textFields.add(textField3);textFields.add(textField4);
    }
}
