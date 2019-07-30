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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GamePlay  {

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

  private GameBoard gameBoard;
  private int nTurnCounter = 0;

  public void mouseClick(MouseEvent e) {
    int nTotal = (gameBoard.getPlayers().length + 1); // Total number of players + 1

    if (e.getSource() == rollButton) {
      rollButton.setVisible(false);

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
            endButton.setVisible(true);
          }
          //Checks if player lands on an owned property
          else if (gameBoard.getPlayers()[nTurnCounter % nTotal].isOwnedProperty(gameBoard)) {

            //checks if that property is eligible for development
            if (gameBoard.getPlayers()[nTurnCounter % nTotal].eligibleDev(gameBoard)) {
              //Automatically develops the property if eligible
              event = gameBoard.getPlayers()[nTurnCounter % nTotal].develop(gameBoard);
              eventLabel.setText(event);
              gameBoard.getEvents().add(event);
              endButton.setVisible(true);
            }
            //else, player ends his/her turn
            else {
              endButton.setVisible(true);
            }
          }
          //Else, player will either pay rent or offer a trade
          else {

            //Checks if player has anything to offer in trade
            if (gameBoard.getPlayers()[nTurnCounter % nTotal].canTrade(gameBoard)) {
              tradeButton.setVisible(true);
            }
            //else, he has no choice but to pay rent
            else {
              rentButton.setVisible(true);
            }
          }
        } else {

          //Checks if player can buy the tile
          if (gameBoard.getPlayers()[nTurnCounter % nTotal].eligiblePurchase(gameBoard)) {
            purchaseButton.setVisible(true);
          }
          endButton.setVisible(true);
        }
      }
      //else, it's either Jail, Chance, Start, Tax, or Free Parking
      else {
        event = gameBoard.getPlayers()[nTurnCounter % nTotal].action(gameBoard);
        eventLabel.setText(event);
        gameBoard.getEvents().add(event);
        endButton.setVisible(true);
      }

      nTurnCounter++;
    } else if (e.getSource() == purchaseButton) {
      String event = gameBoard.getPlayers()[nTurnCounter % nTotal].purchase(gameBoard);
      gameBoard.getEvents().add(event);
      eventLabel.setText(event);
    }
    //TODO: Trade show properties to choose from
//  else if(e.getSource() == tradeButton){
//    gameBoard.getPlayers()[nTurnCounter % nTotal].trade(gameBoard);
//    gameBoard.getEvents().add(event);
//    eventLabel.setText(event);
//  }
    else if(e.getSource() == rentButton){
      String event = gameBoard.getPlayers()[nTurnCounter % nTotal].payRent(gameBoard);
      gameBoard.getEvents().add(event);
      eventLabel.setText(event);
    }
    else if(e.getSource() == endButton) {
    }
    else if(e.getSource() == logButton){
      //TODO: Log Window
    }


  }



  //TODO: Show properties to choose from
//  public void trade(MouseEvent e){
//    if(e.getSource() == tradeButton)
//      gameBoard.getPlayers()[nTurnCounter % nTotal].trade(gameBoard);
//
//  }

  // Run everything in this function whenever this view has been initialized
  public void initialize(ArrayList<String> players) {
    gameBoard = new GameBoard();
    gameBoard.initializePlayers(players);

    turnLabel.setText(gameBoard.getPlayers()[0].getName()+"'s Turn!");
  }
}
