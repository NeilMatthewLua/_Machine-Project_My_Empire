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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
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
