package Controller;

import Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import static javafx.stage.Modality.APPLICATION_MODAL;

public class WinnerPageController{

    @FXML private Label endGame;
    @FXML private Label player1;
    @FXML private Label player2;
    @FXML private Label player3;
    @FXML private Label player4;
    @FXML private Label money1;
    @FXML private Label money2;
    @FXML private Label money3;
    @FXML private Label money4;
    @FXML private ImageView playerAvatar1;
    @FXML private ImageView playerAvatar2;
    @FXML private ImageView playerAvatar3;
    @FXML private ImageView playerAvatar4;

    private ArrayList<Player> players;
    private ArrayList<Player> ranked;
    private ArrayList<String> playerAvatars;
    private ArrayList<String> arrangedPlayerAvatars;
    private ArrayList<ImageView> avatars;
    private ArrayList<Label> playerNames;
    private ArrayList<Label> playerMoney;

    public void arrangeRankings(){
        ranked = new ArrayList<Player>();
        arrangedPlayerAvatars = new ArrayList<String>();

        while(players.size() > 0){
            int biggest = 0;
            for(int i = 0; i < players.size(); i++){
                    if(players.get(biggest).getMoney() < players.get(i).getMoney())
                        biggest = i;
            }

            ranked.add(players.get(biggest));
            players.remove(biggest);

            arrangedPlayerAvatars.add(playerAvatars.get(biggest));
            playerAvatars.remove(biggest);

        }
    }
/Chat me SEXY BOY once you get this update



    public void initialize(Player[] players, ArrayList<String> playerAvatars){
        this. players = new ArrayList<Player>();
        this.playerAvatars = new ArrayList<String>();
        avatars = new ArrayList<ImageView>();
        playerNames = new ArrayList<Label>();
        playerMoney = new ArrayList<Label>();
        for(int i = 0; i < players.length;i++)
            this.players.add(players[i]);

        for(int i = 0; i < playerAvatars.size(); i++){
            this.playerAvatars.add(playerAvatars.get(i));

        }

        playerMoney.add(money1);playerMoney.add(money2);playerMoney.add(money3);playerMoney.add(money4);
        playerNames.add(player1);playerNames.add(player2);playerNames.add(player3);playerNames.add(player4);
        avatars.add(playerAvatar1);avatars.add(playerAvatar2);avatars.add(playerAvatar3);avatars.add(playerAvatar4);

        arrangeRankings();


        for(int i = 0; i < ranked.size(); i++){
            playerNames.get(i).setText(ranked.get(i).getName());
            if(ranked.get(i).getMoney() > 0){
                playerMoney.get(i).setText(""+ranked.get(i).getMoney());
            }
            else{
                playerMoney.get(i).setText("BANKRUPT");
                playerMoney.get(i).setStyle("-fx-text-fill: red;");
            }
            Image ig = new Image(getClass().getResourceAsStream(arrangedPlayerAvatars.get(i)));
            avatars.get(i).setImage(ig);
        }
    }

    public void endGame(MouseEvent e){
        if(e.getSource() == endGame){
            Stage currStage = (Stage) endGame.getScene().getWindow();
            currStage.close();
        }
    }
}
