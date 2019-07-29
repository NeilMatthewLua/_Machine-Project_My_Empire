package Controller;

import Model.GameBoard;
import Model.Player;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static javafx.stage.Modality.APPLICATION_MODAL;

public class GamePlayController  {

  @FXML
    private Label rollButton;
  @FXML
    private Label tradeButton;
  @FXML
    private Label endButton;
  @FXML
    private Label rentButton;
  @FXML
    private Label purchaseButton;
  @FXML
    private Label eventLabel;
  @FXML
    private Label turnLabel;
  @FXML
    private Label logButton;
  @FXML
    private Label money1;
  @FXML
    private Label money2;
  @FXML
    private Label money3;
  @FXML
    private Label money4;
  @FXML
    private Label player1;
  @FXML
    private Label player2;
  @FXML
    private Label player3;
  @FXML
    private Label player4;
  @FXML
    private StackPane tradePane;
  @FXML
    private StackPane purchasePane;
  @FXML
    private StackPane rollPane;
  @FXML
    private StackPane endPane;
  @FXML
    private StackPane rentPane;


  private GameBoard gameBoard;
  private int nTurnCounter = 0;

  public void setGameBoard(GameBoard gameBoard){
    this.gameBoard = gameBoard;
    initialize(gameBoard.getPlayers());
  }

  public void mouseClick(MouseEvent e) throws IOException {
    int nTotal = (gameBoard.getPlayers().length + 1); // Total number of players + 1

    if (e.getSource() == rollButton) {
      rollPane.setVisible(false);

      String event = gameBoard.getPlayers()[nTurnCounter % nTotal].roll(gameBoard);
      eventLabel.setText(event);
      gameBoard.getEvents().add(event);
      turnLabel.setText(gameBoard.getPlayers()[nTurnCounter % nTotal].getName() + "'s Turn!");

      //Checks if the tile is either Property, Utility, or Railroad
      if (gameBoard.getPlayers()[nTurnCounter % nTotal].isPropertyUtilityRailroad(gameBoard)) {

        //Checks if the spot is owned
        if (!gameBoard.getPlayers()[nTurnCounter % nTotal].isFree(gameBoard)) {

          //Checks if the player lands on an owned Utility / Railroad
          if (gameBoard.getPlayers()[nTurnCounter % nTotal].isOwnedUtilityRailroad(gameBoard)) {
            //There's nothing the player can do for that turn
            endPane.setVisible(true);
          }
          //Checks if player lands on an owned property
          else if (gameBoard.getPlayers()[nTurnCounter % nTotal].isOwnedProperty(gameBoard)) {

            //checks if that property is eligible for development
            if (gameBoard.getPlayers()[nTurnCounter % nTotal].eligibleDev(gameBoard)) {
              //Automatically develops the property if eligible
              event = gameBoard.getPlayers()[nTurnCounter % nTotal].develop(gameBoard);
              eventLabel.setText(event);
              gameBoard.getEvents().add(event);
              endPane.setVisible(true);
            }
            //else, player ends his/her turn
            else {
              endPane.setVisible(true);
            }
          }
          //Else, player will either pay rent or offer a trade
          else {

            //Checks if player has anything to offer in trade
            if (gameBoard.getPlayers()[nTurnCounter % nTotal].canTrade(gameBoard)) {
              tradePane.setVisible(true);
            }
            //else, he has no choice but to pay rent
            else {
              rentPane.setVisible(true);
            }
          }
        } else {

          //Checks if player can buy the tile
          if (gameBoard.getPlayers()[nTurnCounter % nTotal].eligiblePurchase(gameBoard)) {
            purchasePane.setVisible(true);
          }
          endPane.setVisible(true);
        }
      }
      //else, it's either Jail, Chance, Start, Tax, or Free Parking
      else {
        event = gameBoard.getPlayers()[nTurnCounter % nTotal].action(gameBoard);
        eventLabel.setText(event);
        gameBoard.getEvents().add(event);
        endPane.setVisible(true);
      }

    }
    else if (e.getSource() == purchaseButton) {
      String event = gameBoard.getPlayers()[nTurnCounter % nTotal].purchase(gameBoard);
      gameBoard.getEvents().add(event);
      eventLabel.setText(event);
      purchasePane.setVisible(false);
      updateMoney(nTotal);
    }
    //TODO: Trade show properties to choose from
//  else if(e.getSource() == tradeButton){
//    gameBoard.getPlayers()[nTurnCounter % nTotal].trade(gameBoard);
//    gameBoard.getEvents().add(event);
//    eventLabel.setText(event);
//  }
    else if(e.getSource() == rentButton){
      String event = gameBoard.getPlayers()[nTurnCounter % nTotal].payRent(gameBoard);
      endPane.setVisible(true);
      gameBoard.getEvents().add(event);
      eventLabel.setText(event);
    }
    else if(e.getSource() == endButton) {
      eventLabel.setText("");
      purchasePane.setVisible(false);
      tradePane.setVisible(false);
      rollPane.setVisible(true);
      endPane.setVisible(false);
      rentPane.setVisible(false);
      nTurnCounter++;
      turnLabel.setText(gameBoard.getPlayers()[nTurnCounter % nTotal].getName()+"'s Turn!");
    }
    else if(e.getSource() == logButton){
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource("/View/EventLog.fxml"));

          Scene scene = new Scene(loader.load(),287,410);

          Stage x = new Stage();
          x.setScene(scene);
          EventLogController eventLog = loader.getController();

          eventLog.initialize(gameBoard.getEvents());
          x.initModality(APPLICATION_MODAL);
          x.setResizable(false);
          x.setX(900);
          x.setY(30);
          x.show();
      }
  }


  public void updateMoney(int nTotal){
    //Updates Player Money on the board
    if((nTurnCounter % nTotal) == 0){
      money1.setText(String.valueOf(gameBoard.getPlayers()[nTurnCounter % nTotal].getMoney()));
    }
    else if((nTurnCounter % nTotal) == 1){
      money2.setText(String.valueOf(gameBoard.getPlayers()[nTurnCounter % nTotal].getMoney()));
    }
    else if((nTurnCounter % nTotal) == 1){
      money3.setText(String.valueOf(gameBoard.getPlayers()[nTurnCounter % nTotal].getMoney()));
    }
    else if((nTurnCounter % nTotal) == 1){
      money4.setText(String.valueOf(gameBoard.getPlayers()[nTurnCounter % nTotal].getMoney()));
    }
  }

  // Run everything in this function whenever this view has been initialized
  public void initialize(Player[] players) {

    player1.setText(players[0].getName());
    player2.setText(players[1].getName());

    if(gameBoard.getPlayers().length == 3){
      player3.setVisible(true);
      player3.setText(players[2].getName());
      if(gameBoard.getPlayers().length == 4) {
        player3.setVisible(true);
        player4.setText(players[3].getName());
      }
    }

    turnLabel.setText(gameBoard.getPlayers()[0].getName()+"'s Turn!");
  }
}
