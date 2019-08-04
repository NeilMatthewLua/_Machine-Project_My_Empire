package Controller;

import Model.*;
import javafx.animation.PauseTransition;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
    private Label keepButton;
  @FXML
    private Label discardButton;
  @FXML
    private Label useButton;
  @FXML
    private Label yesTradeButton;
  @FXML
    private Label noTradeButton;
  @FXML
    private Label chooseButton;
  @FXML
    private Label money1;
  @FXML
    private Label money2;
  @FXML
    private Label money3;
  @FXML
    private Label money4;
  @FXML
    private Label money5;
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
  @FXML
    private StackPane keepPane;
  @FXML
    private StackPane usePane;
  @FXML
    private StackPane discardPane;
  @FXML
    private StackPane choosePane;
  @FXML
    private AnchorPane tradeAnchorPane;
  @FXML
    private AnchorPane playerPane1;
  @FXML
    private AnchorPane playerPane2;
  @FXML
    private AnchorPane playerPane3;
  @FXML
    private AnchorPane playerPane4;

    @FXML private Label space1;
    @FXML private Label space2;
    @FXML private Label space3;
    @FXML private Label space4;
    @FXML private Label space5;
    @FXML private Label space6;
    @FXML private Label space7;
    @FXML private Label space8;
    @FXML private Label space9;
    @FXML private Label space10;
    @FXML private Label space11;
    @FXML private Label space12;
    @FXML private Label space13;
    @FXML private Label space14;
    @FXML private Label space15;
    @FXML private Label space16;
    @FXML private Label space17;
    @FXML private Label space18;
    @FXML private Label space19;
    @FXML private Label space20;
    @FXML private Label space21;
    @FXML private Label space22;
    @FXML private Label space23;
    @FXML private Label space24;
    @FXML private Label space25;
    @FXML private Label space26;
    @FXML private Label space27;
    @FXML private Label space28;
    @FXML private Label space29;
    @FXML private Label space30;
    @FXML private Label space31;
    @FXML private Label space32;

    @FXML private ImageView owner1;
    @FXML private ImageView owner2;
    @FXML private ImageView owner3;
    @FXML private ImageView owner4;
    @FXML private ImageView owner5;
    @FXML private ImageView owner6;
    @FXML private ImageView owner7;
    @FXML private ImageView owner8;
    @FXML private ImageView owner9;
    @FXML private ImageView owner10;
    @FXML private ImageView owner11;
    @FXML private ImageView owner12;
    @FXML private ImageView owner13;
    @FXML private ImageView owner14;
    @FXML private ImageView owner15;
    @FXML private ImageView owner16;
    @FXML private ImageView owner17;
    @FXML private ImageView owner18;
    @FXML private ImageView owner19;
    @FXML private ImageView owner20;
    @FXML private ImageView owner21;
    @FXML private ImageView owner22;
    @FXML private ImageView owner23;
    @FXML private ImageView owner24;
    @FXML private ImageView owner25;
    @FXML private ImageView owner26;
    @FXML private ImageView owner27;
    @FXML private ImageView owner28;

    @FXML private ImageView playerOne1;
    @FXML private ImageView playerOne2;
    @FXML private ImageView playerOne3;
    @FXML private ImageView playerOne4;
    @FXML private ImageView playerOne5;
    @FXML private ImageView playerOne6;
    @FXML private ImageView playerOne7;
    @FXML private ImageView playerOne8;
    @FXML private ImageView playerOne9;
    @FXML private ImageView playerOne10;
    @FXML private ImageView playerOne11;
    @FXML private ImageView playerOne12;
    @FXML private ImageView playerOne13;
    @FXML private ImageView playerOne14;
    @FXML private ImageView playerOne15;
    @FXML private ImageView playerOne16;
    @FXML private ImageView playerOne17;
    @FXML private ImageView playerOne18;
    @FXML private ImageView playerOne19;
    @FXML private ImageView playerOne20;
    @FXML private ImageView playerOne21;
    @FXML private ImageView playerOne22;
    @FXML private ImageView playerOne23;
    @FXML private ImageView playerOne24;
    @FXML private ImageView playerOne25;
    @FXML private ImageView playerOne26;
    @FXML private ImageView playerOne27;
    @FXML private ImageView playerOne28;
    @FXML private ImageView playerOne29;
    @FXML private ImageView playerOne30;
    @FXML private ImageView playerOne31;
    @FXML private ImageView playerOne32;
  
    @FXML private ImageView playerTwo1;
    @FXML private ImageView playerTwo2;
    @FXML private ImageView playerTwo3;
    @FXML private ImageView playerTwo4;
    @FXML private ImageView playerTwo5;
    @FXML private ImageView playerTwo6;
    @FXML private ImageView playerTwo7;
    @FXML private ImageView playerTwo8;
    @FXML private ImageView playerTwo9;
    @FXML private ImageView playerTwo10;
    @FXML private ImageView playerTwo11;
    @FXML private ImageView playerTwo12;
    @FXML private ImageView playerTwo13;
    @FXML private ImageView playerTwo14;
    @FXML private ImageView playerTwo15;
    @FXML private ImageView playerTwo16;
    @FXML private ImageView playerTwo17;
    @FXML private ImageView playerTwo18;
    @FXML private ImageView playerTwo19;
    @FXML private ImageView playerTwo20;
    @FXML private ImageView playerTwo21;
    @FXML private ImageView playerTwo22;
    @FXML private ImageView playerTwo23;
    @FXML private ImageView playerTwo24;
    @FXML private ImageView playerTwo25;
    @FXML private ImageView playerTwo26;
    @FXML private ImageView playerTwo27;
    @FXML private ImageView playerTwo28;
    @FXML private ImageView playerTwo29;
    @FXML private ImageView playerTwo30;
    @FXML private ImageView playerTwo31;
    @FXML private ImageView playerTwo32;
  
    @FXML private ImageView playerThree1;
    @FXML private ImageView playerThree2;
    @FXML private ImageView playerThree3;
    @FXML private ImageView playerThree4;
    @FXML private ImageView playerThree5;
    @FXML private ImageView playerThree6;
    @FXML private ImageView playerThree7;
    @FXML private ImageView playerThree8;
    @FXML private ImageView playerThree9;
    @FXML private ImageView playerThree10;
    @FXML private ImageView playerThree11;
    @FXML private ImageView playerThree12;
    @FXML private ImageView playerThree13;
    @FXML private ImageView playerThree14;
    @FXML private ImageView playerThree15;
    @FXML private ImageView playerThree16;
    @FXML private ImageView playerThree17;
    @FXML private ImageView playerThree18;
    @FXML private ImageView playerThree19;
    @FXML private ImageView playerThree20;
    @FXML private ImageView playerThree21;
    @FXML private ImageView playerThree22;
    @FXML private ImageView playerThree23;
    @FXML private ImageView playerThree24;
    @FXML private ImageView playerThree25;
    @FXML private ImageView playerThree26;
    @FXML private ImageView playerThree27;
    @FXML private ImageView playerThree28;
    @FXML private ImageView playerThree29;
    @FXML private ImageView playerThree30;
    @FXML private ImageView playerThree31;
    @FXML private ImageView playerThree32;
  
    @FXML private ImageView playerFour1;
    @FXML private ImageView playerFour2;
    @FXML private ImageView playerFour3;
    @FXML private ImageView playerFour4;
    @FXML private ImageView playerFour5;
    @FXML private ImageView playerFour6;
    @FXML private ImageView playerFour7;
    @FXML private ImageView playerFour8;
    @FXML private ImageView playerFour9;
    @FXML private ImageView playerFour10;
    @FXML private ImageView playerFour11;
    @FXML private ImageView playerFour12;
    @FXML private ImageView playerFour13;
    @FXML private ImageView playerFour14;
    @FXML private ImageView playerFour15;
    @FXML private ImageView playerFour16;
    @FXML private ImageView playerFour17;
    @FXML private ImageView playerFour18;
    @FXML private ImageView playerFour19;
    @FXML private ImageView playerFour20;
    @FXML private ImageView playerFour21;
    @FXML private ImageView playerFour22;
    @FXML private ImageView playerFour23;
    @FXML private ImageView playerFour24;
    @FXML private ImageView playerFour25;
    @FXML private ImageView playerFour26;
    @FXML private ImageView playerFour27;
    @FXML private ImageView playerFour28;
    @FXML private ImageView playerFour29;
    @FXML private ImageView playerFour30;
    @FXML private ImageView playerFour31;
    @FXML private ImageView playerFour32;
  
    @FXML private AnchorPane anchor1;
    @FXML private AnchorPane anchor2;
    @FXML private AnchorPane anchor3;
    @FXML private AnchorPane anchor4;
    @FXML private AnchorPane anchor5;
    @FXML private AnchorPane anchor6;
    @FXML private AnchorPane anchor7;
    @FXML private AnchorPane anchor8;
    @FXML private AnchorPane anchor9;
    @FXML private AnchorPane anchor10;
    @FXML private AnchorPane anchor11;
    @FXML private AnchorPane anchor12;
    @FXML private AnchorPane anchor13;
    @FXML private AnchorPane anchor14;
    @FXML private AnchorPane anchor15;
    @FXML private AnchorPane anchor16;
    @FXML private AnchorPane anchor17;
    @FXML private AnchorPane anchor18;
    @FXML private AnchorPane anchor19;
    @FXML private AnchorPane anchor20;
    @FXML private AnchorPane anchor21;
    @FXML private AnchorPane anchor22;
    @FXML private AnchorPane anchor23;
    @FXML private AnchorPane anchor24;
    @FXML private AnchorPane anchor25;
    @FXML private AnchorPane anchor26;
    @FXML private AnchorPane anchor27;
    @FXML private AnchorPane anchor28;
    @FXML private AnchorPane anchor29;
    @FXML private AnchorPane anchor30;
    @FXML private AnchorPane anchor31;
    @FXML private AnchorPane anchor32;
    
    @FXML private ImageView Zoomed;
    //TODO Use this for implementing Card Zoomed
    @FXML private ImageView CardZoomed;
    @FXML private Label closeZoomed;
    @FXML private Label ownerZoom;
    @FXML private Label footTrafficZoom;
    @FXML private Label playersZoom;
    @FXML private ImageView playerOneAvatar;
    @FXML private ImageView playerTwoAvatar;
    @FXML private ImageView playerThreeAvatar;
    @FXML private ImageView playerFourAvatar;


  private ArrayList<ImageView> player1Spaces;
    private ArrayList<ImageView> player2Spaces;
    private ArrayList<ImageView> player3Spaces;
    private ArrayList<ImageView> player4Spaces;
    private ArrayList<ArrayList<ImageView>> playersSpaces;
    private ArrayList<ImageView> owners;
    private ArrayList<Label> spaces;
    private ArrayList<AnchorPane> anchors;
    private ArrayList<String> playerAvatars;
    private String[][] urls = {
      {"Almond Drive","../Images/SmallSpaces/Silver.png","../Images/BigSpaces/Almond.png"},
      {"Kasoy Street","../Images/SmallSpaces/Silver.png","../Images/BigSpaces/Kasoy.png"},
      {"Rodeo Drive","../Images/SmallSpaces/Purple.png","../Images/BigSpaces/Rodeo.png"},
      {"Orange Street","../Images/SmallSpaces/Purple.png","../Images/BigSpaces/Orange.png"},
      {"Ventura Street","../Images/SmallSpaces/Purple.png","../Images/BigSpaces/Ventura.png"},
      {"Juan Luna","../Images/SmallSpaces/Pink.png","../Images/BigSpaces/Juan.png"},
      {"Ylaya","../Images/SmallSpaces/Pink.png","../Images/BigSpaces/Ylaya.png"},
      {"J. Abad Santos","../Images/SmallSpaces/Pink.png","../Images/BigSpaces/Abad.png"},
      {"Madison","../Images/SmallSpaces/Green.png","../Images/BigSpaces/Madison.png"},
      {"Annapolis","../Images/SmallSpaces/Green.png","../Images/BigSpaces/Annapolis.png"},
      {"Connecticut","../Images/SmallSpaces/Green.png","../Images/BigSpaces/Connecticut.png"},
      {"Bougainvilla","../Images/SmallSpaces/Blue.png","../Images/BigSpaces/Bougainvilla.png"},
      {"Dama de Noche","../Images/SmallSpaces/Blue.png","../Images/BigSpaces/Dama.png"},
      {"Acacia","../Images/SmallSpaces/Blue.png","../Images/BigSpaces/Acacia.png"},
      {"Solar Street","../Images/SmallSpaces/Red.png","../Images/BigSpaces/Solar.png"},
      {"Galaxy Street","../Images/SmallSpaces/Red.png","../Images/BigSpaces/Galaxy.png"},
      {"9th Street","../Images/SmallSpaces/Yellow.png","../Images/BigSpaces/9th.png"},
      {"5th Avenue","../Images/SmallSpaces/Yellow.png","../Images/BigSpaces/5th.png"},
      {"North","../Images/SmallSpaces/Railroad.png","../Images/BigSpaces/North.png"},
      {"South","../Images/SmallSpaces/Railroad.png","../Images/BigSpaces/South.png"},
      {"Metro","../Images/SmallSpaces/Railroad.png","../Images/BigSpaces/Metro.png"},
      {"Water","../Images/SmallSpaces/Utility.png","../Images/BigSpaces/Water.png"},
      {"Electric","../Images/SmallSpaces/Utility.png","../Images/BigSpaces/Electric.png"},
      {"Luxury Tax","../Images/SmallSpaces/Tax.png","../Images/BigSpaces/Luxury.png"},
      {"Income Tax","../Images/SmallSpaces/Tax.png","../Images/BigSpaces/Income.png"},
      {"Chance","../Images/SmallSpaces/Chance.png","../Images/BigSpaces/Chance.png"},
      {"Chance","../Images/SmallSpaces/Chance.png","../Images/BigSpaces/Chance.png"},
      {"Chance","../Images/SmallSpaces/Chance.png","../Images/BigSpaces/Chance.png"},
            {"Start","../Images/SmallSpaces/placeholder.png","../Images/BigSpaces/Start.png"},
            {"Community Service","../Images/SmallSpaces/placeholder.png","../Images/BigSpaces/Community.png"},
            {"Jail","../Images/SmallSpaces/placeholder.png","../Images/BigSpaces/Jail.png"},
            {"Free Parking","../Images/SmallSpaces/placeholder.png","../Images/BigSpaces/FreeParking.png"},
};

  private GameBoard gameBoard;
  private int nTurnCounter = 0;
  private int i = 0;

  public void setGameBoard(GameBoard gameBoard){
    this.gameBoard = gameBoard;
    initialize(gameBoard.getPlayers());
  }

  public void setPlayerAvatars(ArrayList<String> playerAvatars){
    this.playerAvatars = new ArrayList<String>();
    for(int i = 0; i < playerAvatars.size();i++){
      this.playerAvatars.add(playerAvatars.get(i));
    }
  }

  public void mouseClick(MouseEvent e) throws IOException {
    int nTotal = gameBoard.getPlayers().length;// Total number of players

    if (e.getSource() == rollButton) {

      double[] temp = new double[nTotal + 1]; //temporary holder of everyone's(including bank's) money before the chance card takes action
      int[] nIndex = new int[2]; //holds the which players/bank's money has been changed
      int j = 0; //index of the players/bank whose money was changed
      int i;

      for( i = 0; i < nTotal; i ++){
        temp[i] = gameBoard.getPlayers()[i].getMoney(); //holds the money of everybody on a temp array
      }
      temp[i] = gameBoard.getBank().getMoney();


      rollPane.setVisible(false);
      String event = gameBoard.getPlayers()[nTurnCounter % nTotal].roll(gameBoard);
      eventLabel.setText(event);
      gameBoard.getEvents().add(event);
      updatePlayerPositions();
//      String[] strings = event.split("\n");
//        System.out.println(event);
//      if(strings.length > 1)
//           delayStart(strings);

      turnLabel.setText(gameBoard.getPlayers()[nTurnCounter % nTotal].getName() + "'s Turn!");

      //Checks if the tile is either Property, Utility, or Railroad
      if (gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition()) instanceof Ownable) {

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
              rentPane.setVisible(true);
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
//      else if(gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition()) instanceof Chance){
//          Card temp = gameBoard.getPlayers()[nTurnCounter % nTotal].getCards().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getCards().size() - 1 );
//          event = gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition()).triggerEvent(gameBoard, gameBoard.getPlayers()[nTurnCounter % nTotal]);
////TODO Add Card Desc FXML for Zoomed Card
//          usePane.setVisible(true);
//          eventLabel.setText(event);
//          gameBoard.getEvents().add(event);
//
//          if(temp instanceof CardSet_1){
//            keepPane.setVisible(true);
//          }
//          else
//            usePane.setVisible(true);
//      }
      //else, it's either Jail, Start, Tax, Community Service or Free Parking
      else {
        if(!(gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition()) instanceof Start)){
          event = gameBoard.getPlayers()[nTurnCounter % nTotal].action(gameBoard); //performs the action
        }
        gameBoard.getEvents().add(event);
        eventLabel.setText(event);
        endPane.setVisible(true);
      }

      j = 0;
      //goes through everybody's money to check whose were changed
      for( i = 0; i < nTotal; i ++){
        if(temp[i] != gameBoard.getPlayers()[i].getMoney()){
          nIndex[j] = i;    //holds their index in an array
          j++;
        }
      }
      if(temp[i] != gameBoard.getBank().getMoney()) //checks the bank's value changed
        nIndex[j] = 5;

      //updates the labels in the GUI if there are changes with their money
      if(j == 1)
        updateMoney(nIndex[0],nIndex[1]);
    }
    else if (e.getSource() == keepButton) {
        keepButton.setVisible(false);
    }
    else if (e.getSource() == discardButton) {
        gameBoard.getPlayers()[nTurnCounter % nTotal].getCards().remove(gameBoard.getPlayers()[nTurnCounter % nTotal].getCards().size() - 1);
        discardButton.setVisible(false);
    }
    else if (e.getSource() == useButton){
      double[] temp = new double[nTotal + 1]; //temporary holder of everyone's(including bank's) money before the chance card takes action
      int[] nIndex = new int[2]; //holds the which players/bank's money has been changed
      int j = 0; //index of the players/bank whose money was changed
      int i;

      for( i = 0; i < nTotal; i ++){
        temp[i] = gameBoard.getPlayers()[i].getMoney(); //holds the money of everybody on a temp array
      }
      temp[i] = gameBoard.getBank().getMoney();


      String event = "";
      Card tempCard = gameBoard.getPlayers()[nTurnCounter % nTotal].getCards().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getCards().size() - 1 );

      if(tempCard instanceof CardSet_2){
        event += tempCard.useCard(gameBoard.getPlayers()[nTurnCounter % nTotal], gameBoard);
        eventLabel.setText(event);
        gameBoard.getEvents().add(event);
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
              rentPane.setVisible(true);
            }
            //else, he has no choice but to pay rent
            else {
              if(gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition()) instanceof Utility){
                double dPay = 10 * gameBoard.getPlayers()[nTurnCounter % nTotal].getLastRoll();
                double dAmount = gameBoard.getPlayers()[nTurnCounter % nTotal].getMoney();
                if(gameBoard.getPlayers()[nTurnCounter % nTotal].giveMoney(((Utility) gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getOwner(), dPay)){
                  event += gameBoard.getPlayers()[nTurnCounter % nTotal].getName() + " paid $" + dPay + " to " +  ((Utility) gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getOwner().getName() + "\n";
                }
                else{
                  event += gameBoard.getPlayers()[nTurnCounter % nTotal].getName() + "paid " + dAmount + " to " + ((Utility) gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getOwner().getName() + ". \n";
                  event += gameBoard.getPlayers()[nTurnCounter % nTotal].getName() + "is now bankrupt.\n";
                  gameBoard.setIsWin(true);
                }
                eventLabel.setText(event);
                gameBoard.getEvents().add(event);
                //TODO CHECKFORWIN METHOD HERE
              }
              else{
                rentPane.setVisible(true);
              }
            }
          }
        }
        else {
          //Checks if player can buy the tile
          if (gameBoard.getPlayers()[nTurnCounter % nTotal].eligiblePurchase(gameBoard)) {
            purchasePane.setVisible(true);
          }
          endPane.setVisible(true);
        }
      }
      else if(tempCard instanceof CardSet_3){
        event += tempCard.useCard(gameBoard.getPlayers()[nTurnCounter % nTotal], gameBoard);
        eventLabel.setText(event);
        gameBoard.getEvents().add(event);
//TODO CHECKFORWIN METHOD HERE
      }
      else if(tempCard instanceof  CardSet_4){
        event += tempCard.useCard(gameBoard.getPlayers()[nTurnCounter % nTotal], gameBoard);
        eventLabel.setText(event);
        gameBoard.getEvents().add(event);

        if(gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition()) instanceof Ownable){

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
                rentPane.setVisible(true);
                //TODO CHECKFORWIN METHOD HERE
              }
              //else, he has no choice but to pay rent
              else {
                rentPane.setVisible(true);
                //TODO CHECKFORWIN METHOD HERE
              }
            }
          }
          else {
            //Checks if player can buy the tile
            if (gameBoard.getPlayers()[nTurnCounter % nTotal].eligiblePurchase(gameBoard)) {
              purchasePane.setVisible(true);
            }
            endPane.setVisible(true);
          }
        }
        else{
          event += gameBoard.getPlayers()[nTurnCounter % nTotal].getName() + " is now in Jail! \n";
          eventLabel.setText(event);
          gameBoard.getEvents().add(event);
        }
      }
      else if(tempCard instanceof CardSet_5){
        if(tempCard.getIndex() >= 0 && tempCard.getIndex() <= 2){
          ArrayList<Property> tempArr = gameBoard.getPlayers()[nTurnCounter % nTotal].getOnlyProperty();
          if(tempArr.size() > 0){
            setFalseVisible();
            chooseVisibleProperty(tempArr);
            if(tempCard.getIndex() == 0 || tempCard.getIndex() == 2){
              if(Zoomed.isVisible()){
                choosePane.setVisible(true);
              }
              else
              {
                choosePane.setVisible(false);
              }
            }
            else if(tempCard.getIndex() == 1){
              ArrayList<Property> tempArr1 = gameBoard.getPlayers()[nTurnCounter % nTotal].getOnlyPropertyRenovate();
              if(tempArr1.size() > 0){
                setFalseVisible();
                chooseVisibleProperty(tempArr1);
                if(Zoomed.isVisible()){
                  choosePane.setVisible(true);
                }
                else
                {
                  choosePane.setVisible(false);
                }
              }
              else{
                //TODO SET ADDITIONAL LABEL "Not Applicable" in Card Desc
                event +=  "No owned properties that can be renovated";
                eventLabel.setText(event);
                discardPane.setVisible(false);
              }
            }
//            else{
//              if(Zoomed.isVisible()){
//                choosePane.setVisible(true);
//              }
//              else
//              {
//                choosePane.setVisible(false);
//              }
//            }
          }
          else{
            //TODO SET ADDITIONAL LABEL "Not Applicable" in Card Desc
            event +=  "Not applicable. No owned properties.";
            eventLabel.setText(event);
            discardPane.setVisible(true);
          }
        }
        else if(tempCard.getIndex() == 3 || tempCard.getIndex() == 4){
          ArrayList<Utility> tempArr = gameBoard.getPlayers()[nTurnCounter % nTotal].getOnlyUtility();
          ArrayList<Railroad> tempArr2 = gameBoard.getPlayers()[nTurnCounter % nTotal].getOnlyRailroad();
          if(tempArr.size() + tempArr2.size() > 0){
            setFalseVisible();
            chooseVisibleUtility(tempArr);
            chooseVisibleRailroad(tempArr2);

            if(Zoomed.isVisible()){
              choosePane.setVisible(true);
            }
            else
            {
              choosePane.setVisible(false);
            }
//            if(tempCard.getIndex() == 3){
//              if(Zoomed.isVisible()){
//                choosePane.setVisible(true);
//              }
//              else
//              {
//                choosePane.setVisible(false);
//              }
//            }
//            else{
//              if(Zoomed.isVisible()){
//                choosePane.setVisible(true);
//              }
//              else
//              {
//                choosePane.setVisible(false);
//              }
//            }
          }
          else{
            event +=  "Not applicable. No owned utilities / railroad.";
            eventLabel.setText(event);
            discardPane.setVisible(true);
          }
        }
      }
      else if(tempCard instanceof CardSet_6){
        event += tempCard.useCard(gameBoard.getPlayers()[nTurnCounter % nTotal], gameBoard);
        eventLabel.setText(event);
        gameBoard.getEvents().add(event);
        //TODO Check isWin here
      }

      //goes through everybody's money to check whose were changed
      for( i = 0; i < nTotal; i ++){
        if(temp[i] != gameBoard.getPlayers()[i].getMoney()){
          nIndex[j] = i;    //holds their index in an array
          j++;
        }
      }
      if(temp[i] != gameBoard.getBank().getMoney()) //checks the bank's value changed
        nIndex[j] = 5;

      //updates the labels in the GUI if there are changes with their money
      if(j == 1)
        updateMoney(nIndex[0],nIndex[1]);
    }
//    else if (e.getSource() == chooseButton) {
//        String event = "";
//        gameBoard.getPlayers()[nTurnCounter % nTotal].setChosen(); //TODO HOW TO GET Displayed Property/Utility/Railroad's Class?
//        event += ((CardSet_5)gameBoard.getPlayers()[nTurnCounter & nTotal].getCards().get(gameBoard.getPlayers()[nTurnCounter & nTotal].getCards().size() - 1)).useCard(gameBoard.getPlayers()[nTurnCounter & nTotal],gameBoard);
//        eventLabel.setText(event);
//        gameBoard.getEvents().add(event);
//    }
    else if (e.getSource() == yesTradeButton) {
      String event ="";
      //event += gameBoard.getPlayers()[nTurnCounter % nTotal].trade(gameBoard);
//TODO GET NAME OF DISPLAYSPACE

      eventLabel.setText(event);
      gameBoard.getEvents().add(event);

    }
    else if (e.getSource() == yesTradeButton) {
      String event = "";
      event += gameBoard.getPlayers()[nTurnCounter % nTotal].trade(gameBoard,((Ownable)gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())), gameBoard.getPlayers()[nTurnCounter % nTotal].getChosen());
      gameBoard.getEvents().add(event);
      eventLabel.setText(event);
      tradePane.setVisible(false);
      rentPane.setVisible(true);
    }
    else if (e.getSource() == purchaseButton) {

      String event = gameBoard.getPlayers()[nTurnCounter % nTotal].purchase(gameBoard);
      gameBoard.getEvents().add(event);
      eventLabel.setText(event);
      updateOwnerIcons();
      purchasePane.setVisible(false);
      updateMoney(nTurnCounter % nTotal, 5);
    }
    else if(e.getSource() == tradeButton) {
      ArrayList<Property> tempArr = gameBoard.getPlayers()[nTurnCounter % nTotal].getOnlyProperty();
      setFalseVisible();
      chooseVisibleProperty(tempArr);
      rentPane.setVisible(false);
      tradePane.setVisible(false);
      tradeAnchorPane.setVisible(true);
      if (Zoomed.isVisible()) {
        tradeAnchorPane.setVisible(true);
      }
    }
    else if(e.getSource() == rentButton){
      String event = gameBoard.getPlayers()[nTurnCounter % nTotal].payRent(gameBoard);
      Player tempPlayer = null;

      if(gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition()) instanceof Property)
        tempPlayer = ((Property)gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getOwner();
      if(gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition()) instanceof Utility)
        tempPlayer = ((Utility)gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getOwner();
      else if(gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition()) instanceof Railroad)
        tempPlayer = ((Railroad)gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getOwner();

      int nIndex = 0;
      for( int i = 0; i < gameBoard.getPlayers().length; i++)
        if(gameBoard.getPlayers()[i] == tempPlayer)
           nIndex = i;

      updateMoney(nTurnCounter % nTotal, nIndex);

      rentPane.setVisible(false);
      tradePane.setVisible(false);
      endPane.setVisible(true);
      eventLabel.setText(event);
      gameBoard.getEvents().add(event);
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

    private void delayStart(String[] string) {
//      for(String a: string)
//          System.out.println("D" + a);
//        eventLabel.setText(string[0]);
//        for(int i = 0; i < string.length; i++){
//          int nIndex = i;
//          PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));
//          pauseTransition.setOnFinished(e -> eventLabel.setText(string[nIndex]));
//          pauseTransition.play();
//      }

//        i = 0;
////        ScheduledExecutorService timer =
////             Executors.newScheduledThreadPool(1);
//        ScheduledExecutorService timer = Executors
//                .newSingleThreadScheduledExecutor();
//        timer.scheduleWithFixedDelay(new TimerTask() {
//            @Override
//            public void run() {
//                Platform.runLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (i < string.length) {
//                            eventLabel.setText(string[i]);
//                            System.out.println("D");
//                            i++;
//                        }
//                    }
//                });
//            }
//        }, 0, 3L , TimeUnit.SECONDS);
  }

  public void updateMoney(int nPlayer1, int nPlayer2){
     //Updates Player Money on the board
    if(nPlayer1 == 0){
      money1.setText(String.valueOf(gameBoard.getPlayers()[nPlayer1].getMoney()));
    }
    else if(nPlayer1 == 1){
      money2.setText(String.valueOf(gameBoard.getPlayers()[nPlayer1].getMoney()));
    }
    else if(nPlayer1 == 2){
      money3.setText(String.valueOf(gameBoard.getPlayers()[nPlayer1].getMoney()));
    }
    else if(nPlayer1 == 3){
      money4.setText(String.valueOf(gameBoard.getPlayers()[nPlayer1].getMoney()));
    }
    else if(nPlayer1 == 5){
      money5.setText(String.valueOf(gameBoard.getBank().getMoney()));
    }

    if(nPlayer2 == 0){
      money1.setText(String.valueOf(gameBoard.getPlayers()[nPlayer2].getMoney()));
    }
    else if(nPlayer2 == 1){
      money2.setText(String.valueOf(gameBoard.getPlayers()[nPlayer2].getMoney()));
    }
    else if(nPlayer2 == 2){
      money3.setText(String.valueOf(gameBoard.getPlayers()[nPlayer2].getMoney()));
    }
    else if(nPlayer1 == 3){
        money4.setText(String.valueOf(gameBoard.getPlayers()[nPlayer2].getMoney()));
    }
    else if(nPlayer2 == 5){
      money5.setText(String.valueOf(gameBoard.getBank().getMoney()));
    }
  }

  public void setFalseVisible() {
    for(int i = 0; i < spaces.size(); i++){
        spaces.get(i).setVisible(false);
    }
  }

  public void chooseVisibleProperty(ArrayList<Property> properties) {
    int counter = 0;
    for(int i = 0; i < spaces.size(); i++){
      if (spaces.get(i).getText().equalsIgnoreCase(properties.get(counter).getName())){
          spaces.get(i).setVisible(true);
          counter++;
      }
    }
  }

  public void chooseVisibleUtility(ArrayList<Utility> properties) {
    int counter = 0;
    for(int i = 0; i < spaces.size(); i++){
      if (spaces.get(i).getText().equalsIgnoreCase(properties.get(counter).getName())){
        spaces.get(i).setVisible(true);
        counter++;
      }
    }
  }

  public void chooseVisibleRailroad(ArrayList<Railroad> properties) {
    int counter = 0;
    for(int i = 0; i < spaces.size(); i++){
      if (spaces.get(i).getText().equalsIgnoreCase(properties.get(counter).getName())){
        spaces.get(i).setVisible(true);
        counter++;
      }
    }
  }



  public void openZoomed(MouseEvent e){
    if(Zoomed.isVisible() == false){
      closeZoomed.setVisible(true);
      Zoomed.setVisible(true);
      boolean isFound = true;
      int index;
      if(e.getSource() instanceof Label){
        index = spaces.indexOf(e.getSource());
      }
      else {
        index = anchors.indexOf(e.getSource());
      }
      if(gameBoard.getLand().get(index) instanceof Ownable)
        ownerZoom.setVisible(true);
      if(gameBoard.getLand().get(index) instanceof Property){
        playersZoom.setVisible(true);
        playersZoom.setText("" + gameBoard.getPlayers().length);
        footTrafficZoom.setVisible(true);
      }
    }
    else{
      closeZoomed.setVisible(false);
      Zoomed.setVisible(false);
      ownerZoom.setVisible(false);
      footTrafficZoom.setVisible(false);
      playersZoom.setVisible(false);
    }}


  @FXML
  public void displaySpaces(MouseEvent event) {
    //Display land when clicked
    int index;
    if(event.getSource() instanceof Label){
      index = spaces.indexOf(event.getSource());
    }
    else{
      index = anchors.indexOf(event.getSource());
    }
    boolean isFound = false;
    Image img;
    for(int i = 0; i < urls.length && !isFound; i++){//Loop through to get the corresponding url for the space that was clicked
      if(spaces.get(index).getText().equalsIgnoreCase(urls[i][0])){
        isFound = true;
        img = new Image(getClass().getResourceAsStream(urls[i][2]));
        Zoomed.setImage(img);
        openZoomed(event);
            if (gameBoard.getLand().get(index) instanceof Ownable) {
              gameBoard.getPlayers()[nTurnCounter % gameBoard.getPlayers().length].setChosen((Ownable) gameBoard.getLand().get(index)); //Set ownable clicked to chosen ownable
              System.out.println(gameBoard.getPlayers()[nTurnCounter % gameBoard.getPlayers().length].getChosen().getName());
              if (((Ownable) gameBoard.getLand().get(index)).getOwner() != null) {//If the Ownable is owned then display the following
                if (gameBoard.getLand().get(index) instanceof Property) {//If the space is a property, also show the foot traffic
                  ownerZoom.setText(((Property) gameBoard.getLand().get(index)).getOwner().getName());
                  footTrafficZoom.setText("" + ((Property) gameBoard.getLand().get(index)).getFootTraffic());
                } else {//Just display the owner
                  ownerZoom.setText(((Ownable) gameBoard.getLand().get(index)).getOwner().getName());
                }
              } else {//If not owned, then show the following
                footTrafficZoom.setText("0.0");
                ownerZoom.setText("None");
              }
            }
        }
      }
    }

  public void updateOwnerIcons(){ //Updates icons of owners of properties
      for(int i = 0; i < gameBoard.getLand().size();i++){
        if(gameBoard.getLand().get(i) instanceof Ownable){
          for(int j = 0; j < gameBoard.getPlayers().length;j++){
            if(((Ownable) gameBoard.getLand().get(i)).getOwner() != null){
              if(((Ownable) gameBoard.getLand().get(i)).getOwner().equals(gameBoard.getPlayers()[j])){
                Image ig = new Image(getClass().getResourceAsStream(playerAvatars.get(j)));
                owners.get(i - (i / 8 + 1)).setImage(ig);
              }
            }
          }
//          if(((Ownable) gameBoard.getLand().get(i)).getOwner() != null){
//            boolean isFound = false;
//            for(int j = 0; i < gameBoard.getPlayers().length && !isFound;j++){
//              System.out.println(((Ownable) gameBoard.getLand().get(i)).getOwner() + " " + gameBoard.getPlayers()[j]);
//              if(((Ownable) gameBoard.getLand().get(i)).getOwner().getName().equalsIgnoreCase(gameBoard.getPlayers()[j].getName())){
//                System.out.println(gameBoard.getPlayers()[j].getName());
//                isFound = true;
//                Image ig = new Image(getClass().getResourceAsStream(playerAvatars.get(j)));
//                owners.get(i-(i / 8 + 1)).setImage(ig);
//              }
//            }
//          }
          }
      }
  }

  @FXML
  public void updatePlayerPositions(){//Updates the positions of all players
    for(int i = 0; i < playerAvatars.size();i++){
      for(int j = 0; j < playersSpaces.get(i).size();j++){
        if(j == gameBoard.getPlayers()[i].getPosition()){
          Image img = new Image(getClass().getResourceAsStream(playerAvatars.get(i)));
          playersSpaces.get(i).get(j).setImage(img);
        }
        else //Set the images in empty spaces to null
          playersSpaces.get(i).get(j).setImage(null);
      }
    }
  }

//TODO CHECKISWIN
//  public void checkWin(){
//    if(gameBoard.getIsWin())
//
//  }
 // Run everything in this function whenever this view has been initialized
  public void initialize(Player[] players) {
    player1Spaces = new ArrayList<ImageView>();
    player2Spaces = new ArrayList<ImageView>();
    player3Spaces = new ArrayList<ImageView>();
    player4Spaces = new ArrayList<ImageView>();


    //Add in the imageviews of the player positions into their corresponding arraylists
    player1Spaces.add(playerOne1); player1Spaces.add(playerOne2);player1Spaces.add(playerOne3);player1Spaces.add(playerOne4);player1Spaces.add(playerOne5);player1Spaces.add(playerOne6);player1Spaces.add(playerOne7);player1Spaces.add(playerOne8);player1Spaces.add(playerOne9);player1Spaces.add(playerOne10);player1Spaces.add(playerOne11);player1Spaces.add(playerOne12);player1Spaces.add(playerOne13);player1Spaces.add(playerOne14);player1Spaces.add(playerOne15);player1Spaces.add(playerOne16);player1Spaces.add(playerOne17);player1Spaces.add(playerOne18);player1Spaces.add(playerOne19);player1Spaces.add(playerOne20);player1Spaces.add(playerOne21);player1Spaces.add(playerOne22);player1Spaces.add(playerOne23);player1Spaces.add(playerOne24);player1Spaces.add(playerOne25);player1Spaces.add(playerOne26);player1Spaces.add(playerOne27);player1Spaces.add(playerOne28);player1Spaces.add(playerOne29);player1Spaces.add(playerOne30);player1Spaces.add(playerOne31);player1Spaces.add(playerOne32);
    player2Spaces.add(playerTwo1);player2Spaces.add(playerTwo2);player2Spaces.add(playerTwo3);player2Spaces.add(playerTwo4);player2Spaces.add(playerTwo5);player2Spaces.add(playerTwo6);player2Spaces.add(playerTwo7);player2Spaces.add(playerTwo8);player2Spaces.add(playerTwo9);player2Spaces.add(playerTwo10);player2Spaces.add(playerTwo11);player2Spaces.add(playerTwo12);player2Spaces.add(playerTwo13);player2Spaces.add(playerTwo14);player2Spaces.add(playerTwo15);player2Spaces.add(playerTwo16);player2Spaces.add(playerTwo17);player2Spaces.add(playerTwo18);player2Spaces.add(playerTwo19);player2Spaces.add(playerTwo20);player2Spaces.add(playerTwo21);player2Spaces.add(playerTwo22);player2Spaces.add(playerTwo23);player2Spaces.add(playerTwo24);player2Spaces.add(playerTwo25);player2Spaces.add(playerTwo26);player2Spaces.add(playerTwo27);player2Spaces.add(playerTwo28);player2Spaces.add(playerTwo29);player2Spaces.add(playerTwo30);player2Spaces.add(playerTwo31);player2Spaces.add(playerTwo32);
    player3Spaces.add(playerThree1);player3Spaces.add(playerThree2);player3Spaces.add(playerThree3);player3Spaces.add(playerThree4);player3Spaces.add(playerThree5);player3Spaces.add(playerThree6);player3Spaces.add(playerThree7);player3Spaces.add(playerThree8);player3Spaces.add(playerThree9);player3Spaces.add(playerThree10);player3Spaces.add(playerThree11);player3Spaces.add(playerThree12);player3Spaces.add(playerThree13);player3Spaces.add(playerThree14);player3Spaces.add(playerThree15);player3Spaces.add(playerThree16);player3Spaces.add(playerThree17);player3Spaces.add(playerThree18);player3Spaces.add(playerThree19);player3Spaces.add(playerThree20);player3Spaces.add(playerThree21);player3Spaces.add(playerThree22);player3Spaces.add(playerThree23);player3Spaces.add(playerThree24);player3Spaces.add(playerThree25);player3Spaces.add(playerThree26);player3Spaces.add(playerThree27);player3Spaces.add(playerThree28);player3Spaces.add(playerThree29);player3Spaces.add(playerThree30);player3Spaces.add(playerThree31);player3Spaces.add(playerThree32);
    player4Spaces.add(playerFour1);player4Spaces.add(playerFour2);player4Spaces.add(playerFour3);player4Spaces.add(playerFour4);player4Spaces.add(playerFour5);player4Spaces.add(playerFour6);player4Spaces.add(playerFour7);player4Spaces.add(playerFour8);player4Spaces.add(playerFour9);player4Spaces.add(playerFour10);player4Spaces.add(playerFour11);player4Spaces.add(playerFour12);player4Spaces.add(playerFour13);player4Spaces.add(playerFour14);player4Spaces.add(playerFour15);player4Spaces.add(playerFour16);player4Spaces.add(playerFour17);player4Spaces.add(playerFour18);player4Spaces.add(playerFour19);player4Spaces.add(playerFour20);player4Spaces.add(playerFour21);player4Spaces.add(playerFour22);player4Spaces.add(playerFour23);player4Spaces.add(playerFour24);player4Spaces.add(playerFour25);player4Spaces.add(playerFour26);player4Spaces.add(playerFour27);player4Spaces.add(playerFour28);player4Spaces.add(playerFour29);player4Spaces.add(playerFour30);player4Spaces.add(playerFour31);player4Spaces.add(playerFour32);

    playersSpaces = new ArrayList<ArrayList<ImageView>>();

    playersSpaces.add(player1Spaces);playersSpaces.add(player2Spaces);
    if(players.length >= 3){
      playersSpaces.add(player3Spaces);

      if(players.length == 4){
        playersSpaces.add(player4Spaces);
      }
    }

    owners = new ArrayList<ImageView>();
    owners.add(owner1);owners.add(owner2);owners.add(owner3);owners.add(owner4);owners.add(owner5);
    owners.add(owner6);owners.add(owner7);owners.add(owner8);owners.add(owner9);owners.add(owner10);
    owners.add(owner11);owners.add(owner12);owners.add(owner13);owners.add(owner14);owners.add(owner15);
    owners.add(owner16);owners.add(owner17);owners.add(owner18);owners.add(owner19);owners.add(owner20);
    owners.add(owner21);owners.add(owner22);owners.add(owner23);owners.add(owner24);owners.add(owner25);
    owners.add(owner26);owners.add(owner27);owners.add(owner28);

    spaces = new ArrayList<Label>();
    spaces.add(space1);spaces.add(space2);spaces.add(space3);spaces.add(space4);spaces.add(space5);
    spaces.add(space6);spaces.add(space7);spaces.add(space8);spaces.add(space9);spaces.add(space10);
    spaces.add(space11);spaces.add(space12);spaces.add(space13);spaces.add(space14);spaces.add(space15);
    spaces.add(space16);spaces.add(space17);spaces.add(space18);spaces.add(space19);spaces.add(space20);
    spaces.add(space21);spaces.add(space22);spaces.add(space23);spaces.add(space24);spaces.add(space25);
    spaces.add(space26);spaces.add(space27);spaces.add(space28);spaces.add(space29);spaces.add(space30);
    spaces.add(space31);spaces.add(space32);

    anchors = new ArrayList<AnchorPane>();
    anchors.add(anchor1);anchors.add(anchor2);anchors.add(anchor3);anchors.add(anchor4);anchors.add(anchor5);
    anchors.add(anchor6);anchors.add(anchor7);anchors.add(anchor8);anchors.add(anchor9);anchors.add(anchor10);
    anchors.add(anchor11);anchors.add(anchor12);anchors.add(anchor13);anchors.add(anchor14);anchors.add(anchor15);
    anchors.add(anchor16);anchors.add(anchor17);anchors.add(anchor18);anchors.add(anchor19);anchors.add(anchor20);
    anchors.add(anchor21);anchors.add(anchor22);anchors.add(anchor23);anchors.add(anchor24);anchors.add(anchor25);
    anchors.add(anchor26);anchors.add(anchor27);anchors.add(anchor28);anchors.add(anchor29);anchors.add(anchor30);
    anchors.add(anchor31);anchors.add(anchor32);


    for(int i = 0; i < gameBoard.getLand().size();i++){
      spaces.get(i).setText(gameBoard.getLand().get(i).getName());
    }

    for(int i = 0; i < spaces.size();i++){
      boolean isFound = true;
      for(int j = 0; j < urls.length && isFound; j++){
        if(spaces.get(i).getText().equalsIgnoreCase(urls[j][0])){
          Image image = new Image(getClass().getResourceAsStream(urls[j][1]));
          spaces.get(i).setGraphic(new ImageView(image));
          isFound = false;
        }
      }
    }

    for(int i = 0; i < players.length;i++){
      System.out.println(gameBoard.getPlayers()[i]);
    }

    updatePlayerPositions();

    player1.setText(players[0].getName());
    Image ig = new Image(getClass().getResourceAsStream(playerAvatars.get(0)));
    playerOneAvatar.setImage(ig);
    money1.setText(Double.toString(players[0].getMoney()));
    ig = new Image(getClass().getResourceAsStream(playerAvatars.get(1)));
    playerTwoAvatar.setImage(ig);
    player2.setText(players[1].getName());
    money2.setText(Double.toString(players[1].getMoney()));

    money5.setText(Double.toString(gameBoard.getBank().getMoney()));
    if(gameBoard.getPlayers().length > 2){
      playerPane3.setVisible(true);
      ig = new Image(getClass().getResourceAsStream(playerAvatars.get(2)));
      playerThreeAvatar.setImage(ig);
      player3.setText(players[2].getName());
      money3.setText(Double.toString(players[2].getMoney()));
      if(gameBoard.getPlayers().length == 4) {
        playerPane4.setVisible(true);
        ig = new Image(getClass().getResourceAsStream(playerAvatars.get(3)));
        playerFourAvatar.setImage(ig);
        player4.setText(players[3].getName());
        money4.setText(Double.toString(players[3].getMoney()));
      }
    }

    turnLabel.setText(gameBoard.getPlayers()[0].getName()+"'s Turn!");
  }
}
