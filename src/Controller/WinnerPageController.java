package Controller;

import Model.Player;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WinnerPageController implements Initializable {
    public ArrayList<Player> players;
    public ArrayList<Player> ranked;
    public ArrayList<Player> bankrupt;


    public void setPlayers(ArrayList<Player> players){
        for(int i = 0; i < players.size();i++)
            this.players.add(players.get(i));
    }

    public void arrangeRankings(){

    }


    @Override
    public void initialize(URL url, ResourceBundle rb){
        players = new ArrayList<Player>();
    }
}
