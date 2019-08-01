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
    private AnchorPane playerPane1;
  @FXML
    private AnchorPane playerPane2;
  @FXML
    private AnchorPane playerPane3;
  @FXML
    private AnchorPane playerPane4;

  @FXML private Label empty1;
  @FXML private Label empty2;
  @FXML private Label empty3;
  @FXML private Label empty4;
  @FXML private Label empty5;
  @FXML private Label empty6;
  @FXML private Label empty7;
  @FXML private Label empty8;
  @FXML private Label empty9;
  @FXML private Label empty10;
  @FXML private Label empty11;
  @FXML private Label empty12;
  @FXML private Label empty13;
  @FXML private Label empty14;
  @FXML private Label empty15;
  @FXML private Label empty16;
  @FXML private Label empty17;
  @FXML private Label empty18;
  @FXML private Label empty19;
  @FXML private Label empty20;
  @FXML private Label empty21;
  @FXML private Label empty22;
  @FXML private Label empty23;
  @FXML private Label empty24;
  @FXML private Label empty25;
  @FXML private Label empty26;
  @FXML private Label empty27;
  @FXML private Label empty28;

  @FXML private ImageView Zoomed;
  @FXML private Label closeZoomed;
  @FXML private Label ownerZoom;
  @FXML private Label footTrafficZoom;
  @FXML private Label playersZoom;

  private ArrayList<Label> spaces;
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
  };

  private GameBoard gameBoard;
  private int nTurnCounter = 0;
  private int i = 0;

  public void setGameBoard(GameBoard gameBoard){
    this.gameBoard = gameBoard;
    initialize(gameBoard.getPlayers());
  }

  public void mouseClick(MouseEvent e) throws IOException {
    int nTotal = gameBoard.getPlayers().length;// Total number of players

    if (e.getSource() == rollButton) {
      rollPane.setVisible(false);

      String event = gameBoard.getPlayers()[nTurnCounter % nTotal].roll(gameBoard);
      eventLabel.setText(event);
      gameBoard.getEvents().add(event);
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
      else if(gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition()) instanceof Chance){
          Card temp = gameBoard.getPlayers()[nTurnCounter % nTotal].getCards().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getCards().size() - 1 );
          event = gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition()).triggerEvent(gameBoard, gameBoard.getPlayers()[nTurnCounter % nTotal]);
//TODO Add Card Desc FXML for Zoomed Card
          eventLabel.setText(event);

          if(temp instanceof CardSet_1){
            keepPane.setVisible(true);
          }
//TODO Eligible Double Rent blah discardPane
          else
            usePane.setVisible(true);
      }
      //else, it's either Jail, Start, Tax, Community Service or Free Parking
      else {
        double[] temp = new double[nTotal + 1]; //temporary holder of everyone's(including bank's) money before the chance card takes action
        int[] nIndex = new int[2]; //holds the which players/bank's money has been changed
        int j = 0; //index of the players/bank whose money was changed
        int i;

        for( i = 0; i < nTotal; i ++){
            temp[i] = gameBoard.getPlayers()[i].getMoney(); //holds the money of everybody on a temp array
        }
        temp[i] = gameBoard.getBank().getMoney();

        event = gameBoard.getPlayers()[nTurnCounter % nTotal].action(gameBoard); //performs the action

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

        eventLabel.setText(event);
        gameBoard.getEvents().add(event);
        endPane.setVisible(true);
      }

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
                gameBoard.getPlayers()[nTurnCounter % nTotal].giveMoney(((Utility) gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getOwner(), dPay);
                event += gameBoard.getPlayers()[nTurnCounter % nTotal].getName() + " paid $" + dPay + " to " +  ((Utility) gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getOwner().getName();
                eventLabel.setText(event);
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
//TODO CHECKFORWIN METHOD HERE
      }
      else if(tempCard instanceof  CardSet_4){
        event += tempCard.useCard(gameBoard.getPlayers()[nTurnCounter % nTotal], gameBoard);
        eventLabel.setText(event);

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
                gameBoard.getPlayers()[nTurnCounter % nTotal].giveMoney(((Utility) gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getOwner(), dPay);
                event += gameBoard.getPlayers()[nTurnCounter % nTotal].getName() + " paid $" + dPay + " to " +  ((Utility) gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getOwner().getName();
                eventLabel.setText(event);
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
      else if(tempCard instanceof CardSet_5){
        if(tempCard.getIndex() == 0 || tempCard.getIndex() == 2){
          ArrayList<Property> tempArr = gameBoard.getPlayers()[nTurnCounter % nTotal].getOnlyProperty();
          if(tempArr.size() > 0){
            setFalseVisible();
            chooseVisible(tempArr);
            if(tempCard.getIndex() == 0){

            }
            else{

            }
          }
          else{
            discardPane.setVisible(true);
          }
        }
        else if(tempCard.getIndex() == 3 || tempCard.getIndex() == 4){
          if(tempCard.getIndex() == 3){

          }
          else{

          }
        }
      }
      else if(tempCard instanceof CardSet_6){
        event += tempCard.useCard(gameBoard.getPlayers()[nTurnCounter % nTotal], gameBoard);
        eventLabel.setText(event);
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
    else if (e.getSource() == purchaseButton) {

      String event = gameBoard.getPlayers()[nTurnCounter % nTotal].purchase(gameBoard);
      gameBoard.getEvents().add(event);
      eventLabel.setText(event);
      purchasePane.setVisible(false);
      updateMoney(nTurnCounter % nTotal, 5);
    }
    //TODO: Trade show properties to choose from
//  else if(e.getSource() == tradeButton){
//    gameBoard.getPlayers()[nTurnCounter % nTotal].trade(gameBoard);
//    gameBoard.getEvents().add(event);
//    eventLabel.setText(event);
//  }
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

    private void delayStart(String[] string) {
      for(String a: string)
          System.out.println("D" + a);
        eventLabel.setText(string[0]);
        for(int i = 0; i < string.length; i++){
          int nIndex = i;
          PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));
          pauseTransition.setOnFinished(e -> eventLabel.setText(string[nIndex]));
          pauseTransition.play();
      }

//        i = 0;
//        ScheduledExecutorService timer =
//             Executors.newScheduledThreadPool(1);
////        ScheduledExecutorService timer = Executors
////                .newSingleThreadScheduledExecutor();
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

  public void chooseVisible(ArrayList<Property> properties) {
    int counter = 0;
    for(int i = 0; i < spaces.size(); i++){
      if (spaces.get(i).getText().equalsIgnoreCase(properties.get(counter).getName())){
          spaces.get(i).setVisible(true);
          counter++;
      }
    }
  }

  @FXML
  public void closeZoomed(MouseEvent e){
    if(Zoomed.isVisible()){
      closeZoomed.setVisible(false);
      Zoomed.setVisible(false);
      ownerZoom.setVisible(false);
      footTrafficZoom.setVisible(false);
      playersZoom.setVisible(false);
    }
  }

  @FXML
  public void openZoomed(MouseEvent e){
    if(!Zoomed.isVisible()){
      closeZoomed.setVisible(true);
      Zoomed.setVisible(true);
      boolean isFound = true;
      for(int i = 0; (i < urls.length - 5) && isFound ;i++){
        if(((Label)e.getSource()).getText().equalsIgnoreCase(urls[i][0])){
          ownerZoom.setVisible(true);
          isFound = false;
          if(i <= 17){
            playersZoom.setVisible(true);
            playersZoom.setText("" + gameBoard.getPlayers().length);
            footTrafficZoom.setVisible(true);
          }
        }
      }
    }
  }

  @FXML
  public void displaySpaces(MouseEvent event){
    //Display land when clicked
    if(event.getButton() == MouseButton.SECONDARY){//Include Owner, Foot Traffic, and Multipliers
      if(!Zoomed.isVisible()){
        boolean isFound = true;
        if (!(((Label) event.getSource()).getText().equalsIgnoreCase("Start") || ((Label) event.getSource()).getText().equalsIgnoreCase("Community") ||
                ((Label) event.getSource()).getText().equalsIgnoreCase("Jail") || ((Label) event.getSource()).getText().equalsIgnoreCase("Free Parking"))) {
          for (int i = 0; i < urls.length && isFound; i++) {
            if (((Label) event.getSource()).getText().equalsIgnoreCase(urls[i][0])) {
              Image image = new Image(getClass().getResourceAsStream(urls[i][2]));
              Zoomed.setImage(image);
              isFound = false;
              if(gameBoard.getLand().get(i) instanceof Ownable){
                if(((Ownable) gameBoard.getLand().get(i)).getOwner() != null){
                  if(gameBoard.getLand().get(i) instanceof Property){
                    ownerZoom.setText(((Property) gameBoard.getLand().get(i)).getOwner().getName());
                    footTrafficZoom.setText(""+((Property) gameBoard.getLand().get(i)).getFootTraffic());
                  }
                  else {
                    ownerZoom.setText(((Ownable) gameBoard.getLand().get(i)).getOwner().getName());
                  }
                }
              }
            }
          }
        }
        else{
          if(((Label) event.getSource()).getText().equalsIgnoreCase("Start")){
            Image ig = new Image(getClass().getResourceAsStream("../Images/BigSpaces/Start.png"));
            Zoomed.setImage(ig);
          }
          else if(((Label) event.getSource()).getText().equalsIgnoreCase("Community Service")){
            Image ig = new Image(getClass().getResourceAsStream("../Images/BigSpaces/Community.png"));
            Zoomed.setImage(ig);
          }
          else if(((Label) event.getSource()).getText().equalsIgnoreCase("Jail")){
            Image ig = new Image(getClass().getResourceAsStream("../Images/BigSpaces/Jail.png"));
            Zoomed.setImage(ig);
          }
          else{
            Image ig = new Image(getClass().getResourceAsStream("../Images/BigSpaces/FreeParking.png"));
            Zoomed.setImage(ig);
          }
        }
        openZoomed(event);
      }
      else{
        closeZoomed(event);
      }
    }
  }

  // Run everything in this function whenever this view has been initialized
  public void initialize(Player[] players) {
    spaces = new ArrayList<Label>();
    spaces.add(empty1);spaces.add(empty2);spaces.add(empty3);spaces.add(empty4);spaces.add(empty5);
    spaces.add(empty6);spaces.add(empty7);spaces.add(empty8);spaces.add(empty9);spaces.add(empty10);
    spaces.add(empty11);spaces.add(empty12);spaces.add(empty13);spaces.add(empty14);spaces.add(empty15);
    spaces.add(empty16);spaces.add(empty17);spaces.add(empty18);spaces.add(empty19);spaces.add(empty20);
    spaces.add(empty21);spaces.add(empty22);spaces.add(empty23);spaces.add(empty24);spaces.add(empty25);
    spaces.add(empty26);spaces.add(empty27);spaces.add(empty28);

    int corners = 0;
    for(int i = 0; i < gameBoard.getLand().size();i++){
      if(i == 0 || i == 8 || i == 16 || i == 24){
        corners +=1;
      }
      else{
        spaces.get(i-corners).setText(gameBoard.getLand().get(i).getName());
      }
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


    player1.setText(players[0].getName());
    money1.setText(Double.toString(players[0].getMoney()));
    player2.setText(players[1].getName());
    money2.setText(Double.toString(players[1].getMoney()));

    money5.setText(Double.toString(gameBoard.getBank().getMoney()));
    if(gameBoard.getPlayers().length > 2){
      playerPane3.setVisible(true);
      player3.setText(players[2].getName());
      money3.setText(Double.toString(players[2].getMoney()));
      if(gameBoard.getPlayers().length == 4) {
        playerPane4.setVisible(true);
        player4.setText(players[3].getName());
        money4.setText(Double.toString(players[3].getMoney()));
      }
    }

    turnLabel.setText(gameBoard.getPlayers()[0].getName()+"'s Turn!");
  }
}
