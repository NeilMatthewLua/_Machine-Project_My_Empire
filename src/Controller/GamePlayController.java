package Controller;

import Model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.event.EventHandler;
import java.io.IOException;
import java.util.ArrayList;


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
    private Label endGameButton;
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
  private StackPane endGamePane;
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
  @FXML
    private ArrayList<Label> playersMoney;
  @FXML
    private ArrayList<Label> playersName;
  @FXML
    private ArrayList<AnchorPane> playersPane;

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

    @FXML private ImageView currentDevelopment1;
    @FXML private ImageView currentDevelopment2;
    @FXML private ImageView currentDevelopment3;
    @FXML private ImageView currentDevelopment4;
    @FXML private ImageView currentDevelopment5;
    @FXML private ImageView currentDevelopment6;

    @FXML private ImageView increase10;
    @FXML private ImageView increase50;
    @FXML private ImageView decrease10;
    @FXML private ImageView doubleRent;

    @FXML private ImageView Zoomed;
    @FXML private ImageView zoomedChance;
    @FXML private Label zoomedCardApplicable;
    @FXML private Label closeZoomed;
    @FXML private Label ownerZoom;
    @FXML private Label footTrafficZoom;
    @FXML private Label playersZoom;

    @FXML private AnchorPane tradePanel;
    //Trade Panel components for tradee
    @FXML private ImageView tradeeZoom;
    @FXML private Label tradeeFootTraffic;
    @FXML private Label tradeeOwner;
    @FXML private ImageView tradeeDev1;
    @FXML private ImageView tradeeDev2;
    @FXML private ImageView tradeeDev3;
    @FXML private ImageView tradeeDev4;
    @FXML private ImageView tradeeDev5;
    @FXML private ImageView tradeeDev6;
    @FXML private ImageView tradeeDoubleRent;
    @FXML private ImageView tradeeIncrease10;
    @FXML private ImageView tradeeIncrease50;
    @FXML private ImageView tradeeDecrease10;
    @FXML private Label tradee;
    @FXML private Label tradeeOffer;
    private ArrayList<ImageView> tradeeDevelopment;

    //Trade Panel components for trader
    @FXML private AnchorPane traderPanel;
    @FXML private ImageView traderZoom;
    @FXML private Label traderFootTraffic;
    @FXML private Label traderOwner;
    @FXML private ImageView traderDev1;
    @FXML private ImageView traderDev2;
    @FXML private ImageView traderDev3;
    @FXML private ImageView traderDev4;
    @FXML private ImageView traderDev5;
    @FXML private ImageView traderDev6;
    @FXML private ImageView traderDoubleRent;
    @FXML private ImageView traderIncrease10;
    @FXML private ImageView traderIncrease50;
    @FXML private ImageView traderDecrease10;
    @FXML private Label trader;
    @FXML private Label traderOffer;
    private ArrayList<ImageView> traderDevelopment;


    private boolean isTrade;
    private boolean isCardSet5;
    private boolean isRenovate;
    @FXML private Label renovationLabel;
    @FXML private Label renovationPrice;


    @FXML private ImageView playerOneAvatar;
    @FXML private ImageView playerTwoAvatar;
    @FXML private ImageView playerThreeAvatar;
    @FXML private ImageView playerFourAvatar;

    private ArrayList<ImageView> playerAvatarIcons;
    private ArrayList<ImageView> player1Spaces;
    private ArrayList<ImageView> player2Spaces;
    private ArrayList<ImageView> player3Spaces;
    private ArrayList<ImageView> player4Spaces;
    private ArrayList<ImageView> developmentLevels;
    private ArrayList<ArrayList<ImageView>> playersSpaces;
    private ArrayList<ImageView> owners;
    private ArrayList<Label> spaces;
    private ArrayList<AnchorPane> anchors;
    private ArrayList<String> playerAvatars;
    private String[][] urls = {
      {"Almond Drive","../Images/SmallSpaces/Almond.png","../Images/BigSpaces/Almond.png"},
      {"Kasoy Street","../Images/SmallSpaces/Kasoy.png","../Images/BigSpaces/Kasoy.png"},
      {"Rodeo Drive","../Images/SmallSpaces/Rodeo.png","../Images/BigSpaces/Rodeo.png"},
      {"Orange Street","../Images/SmallSpaces/Orange.png","../Images/BigSpaces/Orange.png"},
      {"Ventura Street","../Images/SmallSpaces/Venture.png","../Images/BigSpaces/Ventura.png"},
      {"Juan Luna","../Images/SmallSpaces/Juan.png","../Images/BigSpaces/Juan.png"},
      {"Ylaya","../Images/SmallSpaces/Ylaya.png","../Images/BigSpaces/Ylaya.png"},
      {"J. Abad Santos","../Images/SmallSpaces/J.png","../Images/BigSpaces/Abad.png"},
      {"Madison","../Images/SmallSpaces/Madison.png","../Images/BigSpaces/Madison.png"},
      {"Annapolis","../Images/SmallSpaces/Annapolis.png","../Images/BigSpaces/Annapolis.png"},
      {"Connecticut","../Images/SmallSpaces/Connecticut.png","../Images/BigSpaces/Connecticut.png"},
      {"Bougainvilla","../Images/SmallSpaces/Bougainvilla.png","../Images/BigSpaces/Bougainvilla.png"},
      {"Dama de Noche","../Images/SmallSpaces/Dama.png","../Images/BigSpaces/Dama.png"},
      {"Acacia","../Images/SmallSpaces/Acacia.png","../Images/BigSpaces/Acacia.png"},
      {"Solar Street","../Images/SmallSpaces/Solar.png","../Images/BigSpaces/Solar.png"},
      {"Galaxy Street","../Images/SmallSpaces/Galaxy.png","../Images/BigSpaces/Galaxy.png"},
      {"9th Street","../Images/SmallSpaces/9th.png","../Images/BigSpaces/9th.png"},
      {"5th Avenue","../Images/SmallSpaces/5th.png","../Images/BigSpaces/5th.png"},
      {"North","../Images/SmallSpaces/North.png","../Images/BigSpaces/North.png"},
      {"South","../Images/SmallSpaces/South.png","../Images/BigSpaces/South.png"},
      {"Metro","../Images/SmallSpaces/Metro.png","../Images/BigSpaces/Metro.png"},
      {"Water","../Images/SmallSpaces/Water.png","../Images/BigSpaces/Water.png"},
      {"Electric","../Images/SmallSpaces/Electric.png","../Images/BigSpaces/Electric.png"},
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
    private String[][] chanceUrls = {
            {"../Images/ChanceCards/Group1/GetOutOfJail.png"},

            {"../Images/ChanceCards/Group2/ProceedToProperty.png","../Images/ChanceCards/Group2/ProceedToUtility.png","../Images/ChanceCards/Group2/ProceedToRailroad.png"},

            {"../Images/ChanceCards/Group3/BankDividend.png","../Images/ChanceCards/Group3/TaxRefund.png","../Images/ChanceCards/Group3/AdvanceToStart.png"
                    ,"../Images/ChanceCards/Group3/Birthday.png", "../Images/ChanceCards/Group3/Competition.png",},

            {"../Images/ChanceCards/Group4/GoToJail.png","../Images/ChanceCards/Group4/TakeTripProperty.png"},

            {"../Images/ChanceCards/Group5/DoubleRent.png","../Images/ChanceCards/Group5/Renovation.png","../Images/ChanceCards/Group5/DilapidatedHouse.png",
                    "../Images/ChanceCards/Group5/IncreaseUtilRail.png","../Images/ChanceCards/Group5/DecreaseUtilRail.png"},

            {"../Images/ChanceCards/Group6/CommunityDevelopment.png","../Images/ChanceCards/Group6/Taxes.png"}
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

      rollPane.setVisible(false);

      String event = gameBoard.getPlayers()[nTurnCounter % nTotal].roll(gameBoard);
      eventLabel.setText(event);
      gameBoard.getEvents().add(event);
      updatePlayerPositions();
      checkWin();
      updateMoney();

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
              event += gameBoard.getPlayers()[nTurnCounter % nTotal].develop(gameBoard);
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
            //Check if the player can afford to pay the rent
            Ownable tempOwnable = (Ownable) gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition());
            double dRent = 0;
            if (tempOwnable instanceof Property){
              dRent = ((Property) tempOwnable).getRent(tempOwnable.getOwner());
            }
            else if(tempOwnable instanceof Utility){
              dRent = ((Utility) tempOwnable).getRent(gameBoard.getPlayers()[nTurnCounter % nTotal]);
            }
            else if(tempOwnable instanceof Railroad){
              dRent = ((Railroad) tempOwnable).getRent(tempOwnable.getOwner());
            }
            if(gameBoard.getPlayers()[nTurnCounter % nTotal].getMoney() >= dRent){
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
        event += gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition()).triggerEvent(gameBoard, gameBoard.getPlayers()[nTurnCounter % nTotal]);
        Card tempCard = gameBoard.getPlayers()[nTurnCounter % nTotal].getCards().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getCards().size() - 1 );
        eventLabel.setText(event);
        gameBoard.getEvents().add(event);
        displayChanceCard(tempCard);
        if(tempCard instanceof CardSet_1){
          keepPane.setVisible(true);
        }
        else
          usePane.setVisible(true);
      }
      //else, it's either Jail, Start, Tax, Community Service or Free Parking
      else {
        if(!(gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition()) instanceof Start)){
          event += gameBoard.getPlayers()[nTurnCounter % nTotal].action(gameBoard) +"\n"; //performs the action
        }

        gameBoard.getEvents().add(event);
        eventLabel.setText(event);
        endPane.setVisible(true);
        updateMoney();
        checkWin();
      }

    }
    else if (e.getSource() == keepButton) {
        hideChanceCard();
        keepPane.setVisible(false);
        endPane.setVisible(true);
    }
    else if (e.getSource() == discardButton) {
        hideChanceCard();
        gameBoard.addCardDiscard(gameBoard.getPlayers()[nTurnCounter % nTotal].getCards().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getCards().size() - 1));
        gameBoard.getPlayers()[nTurnCounter % nTotal].getCards().remove(gameBoard.getPlayers()[nTurnCounter % nTotal].getCards().size() - 1);
        discardPane.setVisible(false);
        endPane.setVisible(true);
    }
    else if (e.getSource() == useButton){
      usePane.setVisible(false);

      String event = "";
      Card tempCard = gameBoard.getPlayers()[nTurnCounter % nTotal].getCards().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getCards().size() - 1 );
      if(!(tempCard instanceof CardSet_5)){
        hideChanceCard();
      }
      if(tempCard instanceof CardSet_2){
        event += tempCard.useCard(gameBoard.getPlayers()[nTurnCounter % nTotal], gameBoard);
        updatePlayerPositions();
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
              event += gameBoard.getPlayers()[nTurnCounter % nTotal].develop(gameBoard);
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
                int nRoll;
                nRoll = (int)((Math.random() * (6 - 1)) + 1 );
                double dPay = 10 * nRoll;
                event += gameBoard.getPlayers()[nTurnCounter % nTotal].getName() + " rolled the die and got " + nRoll + "\n";
                double dAmount = gameBoard.getPlayers()[nTurnCounter % nTotal].getMoney();
                if(gameBoard.getPlayers()[nTurnCounter % nTotal].giveMoney(((Utility) gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getOwner(), dPay)){
                  event += gameBoard.getPlayers()[nTurnCounter % nTotal].getName() + " paid $" + dPay + " to " +  ((Utility) gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getOwner().getName() + "\n";
                  endPane.setVisible(true);
                }
                else{
                  event += gameBoard.getPlayers()[nTurnCounter % nTotal].getName() + "paid " + dAmount + " to " + ((Utility) gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getOwner().getName() + ". \n";
                  event += gameBoard.getPlayers()[nTurnCounter % nTotal].getName() + "is now bankrupt.\n";
                  gameBoard.setIsWin(true);
                }
                eventLabel.setText(event);
                gameBoard.getEvents().add(event);
                checkWin();
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
        endPane.setVisible(true);
        updatePlayerPositions();
        checkWin();
      }
      else if(tempCard instanceof  CardSet_4){
        event += tempCard.useCard(gameBoard.getPlayers()[nTurnCounter % nTotal], gameBoard);
        updatePlayerPositions();
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
                event += gameBoard.getPlayers()[nTurnCounter % nTotal].develop(gameBoard);
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
          event += gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition()).triggerEvent(gameBoard, gameBoard.getPlayers()[nTurnCounter % nTotal]);
          eventLabel.setText(event);
          gameBoard.getEvents().add(event);
          endPane.setVisible(true);
        }
      }
      else if(tempCard instanceof CardSet_5) {//CARDSET5
        if (tempCard.getIndex() >= 0 && tempCard.getIndex() <= 2) {
          ArrayList<Property> tempArr = gameBoard.getPlayers()[nTurnCounter % nTotal].getOnlyProperty();
          if (tempArr.size() > 0 && (tempCard.getIndex() == 0 || tempCard.getIndex() == 2)) {
            isCardSet5 = true;
            setFalseVisible();
            chooseVisibleProperty(tempArr);
          }
          else if (tempCard.getIndex() == 1) {
            ArrayList<Property> tempArr1 = gameBoard.getPlayers()[nTurnCounter % nTotal].getOnlyPropertyRenovate();
            if (tempArr1.size() > 0) {
              isCardSet5 = true;
              isRenovate = true;
              setFalseVisible();
              chooseVisibleProperty(tempArr1);
            }
            else {
              zoomedCardApplicable.setVisible(true);
              event += "No owned properties that can be renovated";
              eventLabel.setText(event);
              discardPane.setVisible(true);
            }
          }
         else {
           zoomedCardApplicable.setVisible(true);
          event += "Not applicable. No owned properties.";
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
            isCardSet5 = true;
          }
          else{
            zoomedCardApplicable.setVisible(true);
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
        endPane.setVisible(true);
        checkWin();
      }
        updateMoney();
    }
    else if (e.getSource() == chooseButton) {//CLICKCHOOSE
      isRenovate = false;
      isCardSet5 = false;
      choosePane.setVisible(false);
      openZoomed(e);
      String event = "";
      event += (gameBoard.getPlayers()[nTurnCounter % nTotal].getCards().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getCards().size() - 1)).useCard(gameBoard.getPlayers()[nTurnCounter % nTotal],gameBoard);
      hideChanceCard();
      setAllVisible();
      updateMoney();
      eventLabel.setText(event);
      gameBoard.getEvents().add(event);
      endPane.setVisible(true);
    }

    else if (e.getSource() == noTradeButton) {
      isTrade = false;
      tradePanel.setVisible(false);
      tradeAnchorPane.setVisible(false);
      tradeButton.setVisible(true);
      setAllVisible();
      //Check if the player can afford to pay the rent
      Ownable tempOwnable = (Ownable) gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition());
      double dRent = 0;
      if (tempOwnable instanceof Property){
        dRent = ((Property) tempOwnable).getRent(tempOwnable.getOwner());
      }
      else if(tempOwnable instanceof Utility){
        dRent = ((Utility) tempOwnable).getRent(gameBoard.getPlayers()[nTurnCounter % nTotal]);
      }
      else if(tempOwnable instanceof Railroad){
        dRent = ((Railroad) tempOwnable).getRent(tempOwnable.getOwner());
      }
      if(gameBoard.getPlayers()[nTurnCounter % nTotal].getMoney() >= dRent){
        rentPane.setVisible(true);
        tradePane.setVisible(true);
      }
      else{
        tradePane.setVisible(true);
      }

      updateOwnerIcons();
      updatePlayerPositions();
    }
    else if (e.getSource() == yesTradeButton) {
      isTrade = false;
      tradePanel.setVisible(false);
      String event = "";
      event += gameBoard.getPlayers()[nTurnCounter % nTotal].trade(gameBoard,(Ownable) gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition()), gameBoard.getPlayers()[nTurnCounter % nTotal].getChosen());
      setAllVisible();
      updateOwnerIcons();
      gameBoard.getEvents().add(event);
      eventLabel.setText(event);
      tradeAnchorPane.setVisible(false);
      endPane.setVisible(true);
      checkWin();
    }

    else if (e.getSource() == purchaseButton) {
      String event = gameBoard.getPlayers()[nTurnCounter % nTotal].purchase(gameBoard);
      gameBoard.getEvents().add(event);
      eventLabel.setText(event);
      updateOwnerIcons();
      purchasePane.setVisible(false);
      updateMoney();
      checkWin();
    }
    else if(e.getSource() == tradeButton) {
      ArrayList<Property> tempArr = gameBoard.getPlayers()[nTurnCounter % nTotal].getOnlyProperty();
      setFalseVisible();
      chooseVisibleProperty(tempArr);
      rentPane.setVisible(false);
      tradePane.setVisible(false);
      tradeAnchorPane.setVisible(true);

      hideOwnerIcons();
      hidePlayers();

      isTrade = true;
      tradePanel.setVisible(true);
      //Various text setting for the tradee
      tradee.setText(((Ownable)gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getOwner().getName());
      tradeeOwner.setText(((Ownable)gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getOwner().getName());
      tradeeOffer.setText(gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition()).getName());
        int nDev = ((Property)gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getDevelopment();
       //Set the development level of the property of the tradee
        for(int i = 0; i < tradeeDevelopment.size();i++){
          if(nDev == i)
            tradeeDevelopment.get(i).setVisible(true);
          else
            tradeeDevelopment.get(i).setVisible(false);
        }
        tradeeFootTraffic.setText(""+((Property) gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getFootTraffic());

        //Set the image of the tradee
        for(int i = 0; i < urls.length; i++){
        if(urls[i][0].equalsIgnoreCase(gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition()).getName())){
          Image ig = new Image(getClass().getResourceAsStream(urls[i][2]));
          tradeeZoom.setImage(ig);
        }
      }
        //Set the icons of the tradee's property
      tradeeDoubleRent.setVisible(false);tradeeIncrease10.setVisible(false);tradeeDecrease10.setVisible(false);tradeeIncrease50.setVisible(false);

      for(int i = 0; i < ((Property)gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getCardMultipliers().size();i++){//Loops through the card multipliers
        int nIndex = ((Property)gameBoard.getLand().get(gameBoard.getPlayers()[nTurnCounter % nTotal].getPosition())).getCardMultipliers().get(i).getIndex();
        if(nIndex == 1){//Double Rent
          tradeeDoubleRent.setVisible(true);
        }
        else if(nIndex == 2){//Renovation
          tradeeIncrease50.setVisible(true);
        }
        else if(nIndex == 3 || nIndex == 5){//Decrease/Dilapidated
          tradeeDecrease10.setVisible(true);
        }
        else if(nIndex == 4){//Increase10
          tradeeIncrease10.setVisible(true);
        }
      }

      //Trader property setting
      gameBoard.getPlayers()[nTurnCounter % nTotal].setChosen(gameBoard.getPlayers()[nTurnCounter % nTotal].getOnlyProperty().get(0));
      Property temp = tempArr.get(0);

      for(int i = 0; i < urls.length; i++){
        if(urls[i][0].equalsIgnoreCase(temp.getName())){
          Image ig = new Image(getClass().getResourceAsStream(urls[i][2]));
          traderZoom.setImage(ig);
        }
      }
      traderFootTraffic.setText(""+ temp.getFootTraffic());
      traderOwner.setText(temp.getOwner().getName());
      traderOffer.setText(temp.getName());
      traderDoubleRent.setVisible(false);traderIncrease10.setVisible(false);traderIncrease50.setVisible(false);traderDecrease10.setVisible(false);

      for(int i = 0; i <traderDevelopment.size();i++){
          if(temp.getDevelopment() == i)
            traderDevelopment.get(i).setVisible(true);
          else
            traderDevelopment.get(i).setVisible(false);
      }

      for(int i = 0; i < temp.getCardMultipliers().size();i++){
        int nIndex = temp.getCardMultipliers().get(i).getIndex();
        if(nIndex == 1){//Double Rent
          traderDoubleRent.setVisible(true);
        }
        else if(nIndex == 2){//Renovation
          traderIncrease50.setVisible(true);
        }
        else if(nIndex == 3 || nIndex == 5){//Decrease/Dilapidated
          traderDecrease10.setVisible(true);
        }
        else if(nIndex == 4){//Increase10
          traderIncrease10.setVisible(true);
        }
      }
      trader.setText(gameBoard.getPlayers()[nTurnCounter % nTotal].getName());

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

      updateMoney();
      checkWin();
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
          else if(e.getSource() == endGameButton){
           try{
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/WinnerPage.fxml"));
        Scene scene = new Scene(loader.load(),575,575);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initModality(APPLICATION_MODAL);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          @Override
          public void handle(WindowEvent event) {
            event.consume();
          }
        });

        ((WinnerPageController) loader.getController()).initialize(gameBoard.getPlayers(),playerAvatars);
        stage.setX(350);
        stage.setY(30);
        stage.showAndWait();

        try{
          Stage currStage = (Stage) anchor1.getScene().getWindow();
          FXMLLoader loaderNewGame = new FXMLLoader();
          loaderNewGame.setLocation(getClass().getResource("/View/StartPage.fxml"));
          Scene sceneNewGame = new Scene(loaderNewGame.load());
          currStage.setScene(sceneNewGame);
          currStage.show();
        }
        catch(IOException event){
          System.out.println("Something happened");
        }
      }
      catch(IOException event){
        System.out.println("Something happened");
      }
    }
  }


  public void updateMoney(){
    for(int i = 0; i < gameBoard.getPlayers().length; i++)
      playersMoney.get(i).setText(Double.toString(gameBoard.getPlayers()[i].getMoney()));

    playersMoney.get(4).setText(Double.toString(gameBoard.getBank().getMoney()));

    checkWin();
  }

  public void setFalseVisible() {
    for(int i = 0; i < spaces.size(); i++){
        spaces.get(i).setVisible(false);
        anchors.get(i).setVisible(false);
    }
  }

  public void chooseVisibleProperty(ArrayList<Property> properties) {
    int counter = 0;
    for(int i = 0; i < spaces.size() && counter < properties.size(); i++){
      if (spaces.get(i).getText().equalsIgnoreCase(properties.get(counter).getName())){
        anchors.get(i).setVisible(true);
        spaces.get(i).setVisible(true);
        counter++;
      }
      else{
        anchors.get(i).setVisible(false);
      }
    }
  }

  public void chooseVisibleUtility(ArrayList<Utility> properties) {
    int counter = 0;
    for(int i = 0; i < spaces.size() && counter < properties.size(); i++){
      if (spaces.get(i).getText().equalsIgnoreCase(properties.get(counter).getName())){
        anchors.get(i).setVisible(true);
        spaces.get(i).setVisible(true);
        counter++;
      }
    }
  }

  public void chooseVisibleRailroad(ArrayList<Railroad> properties) {
    int counter = 0;
    for(int i = 0; i < spaces.size() && counter < properties.size(); i++){
      if (spaces.get(i).getText().equalsIgnoreCase(properties.get(counter).getName())){
        anchors.get(i).setVisible(true);
        spaces.get(i).setVisible(true);
        counter++;
      }
    }
  }

  public void setAllVisible(){
    for(int i = 0; i < spaces.size(); i++){
      spaces.get(i).setVisible(true);
      anchors.get(i).setVisible(true);
      if(i < 28)
      owners.get(i).setVisible(true);
    }
    updatePlayerPositions();
  }

  private void displayChanceCard(Card temp){
      Image ig = new Image(getClass().getResourceAsStream(chanceUrls[temp.getGroup()][temp.getIndex()]));
      zoomedChance.setImage(ig);
      zoomedChance.setVisible(true);
  }

  private void hideChanceCard(){
    zoomedCardApplicable.setVisible(false);
    zoomedChance.setVisible(false);
  }

  public void openZoomed(MouseEvent e){
    if(isTrade == false){
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
        if(gameBoard.getLand().get(index) instanceof Ownable){
          doubleRent.setVisible(false);increase10.setVisible(false);decrease10.setVisible(false);increase50.setVisible(false);
          for(int i = 0; i < ((Ownable)gameBoard.getLand().get(index)).getCardMultipliers().size();i++){//Loops through the card multipliers
            int nIndex = ((Ownable)gameBoard.getLand().get(index)).getCardMultipliers().get(i).getIndex();
            if(nIndex == 0){//Double Rent
              doubleRent.setVisible(true);
            }
            else if(nIndex == 1){//Renovation
              increase50.setVisible(true);
            }
            else if(nIndex == 2 || nIndex == 4){//Decrease/Dilapidated
              decrease10.setVisible(true);
            }
            else if(nIndex == 3){//Increase10
              increase10.setVisible(true);
            }
          }
          ownerZoom.setVisible(true);
        }
        if(gameBoard.getLand().get(index) instanceof Property){
          for(int i = 0; i < developmentLevels.size();i++){
            if(((Property) gameBoard.getLand().get(index)).getDevelopment() == i)
              developmentLevels.get(i).setVisible(true);
            else
              developmentLevels.get(i).setVisible(false);
          }
          playersZoom.setVisible(true);
          playersZoom.setText("" + gameBoard.getPlayers().length);
          footTrafficZoom.setVisible(true);
        }
        if(isRenovate == true){
          renovationLabel.setVisible(true);
          renovationPrice.setVisible(true);
        }
      }
      else {
        choosePane.setVisible(false);
        for(int i = 0; i < developmentLevels.size();i++){
          developmentLevels.get(i).setVisible(false);
        }
        closeZoomed.setVisible(false);
        Zoomed.setVisible(false);
        ownerZoom.setVisible(false);
        footTrafficZoom.setVisible(false);
        playersZoom.setVisible(false);
        increase10.setVisible(false);
        decrease10.setVisible(false);
        doubleRent.setVisible(false);
        increase50.setVisible(false);
        renovationLabel.setVisible(false);
        renovationPrice.setVisible(false);
      }
    }
  }


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
    if(isTrade == false){
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
      if(isCardSet5 == true){
        choosePane.setVisible(true);
        if(isRenovate == true){
          double dRenovation = 0; //Renovation price
          if (((Property)  gameBoard.getPlayers()[nTurnCounter % gameBoard.getPlayers().length].getChosen()).getDevelopment() >= 1) {//Calculates price of renovation
            if ((((Property)  gameBoard.getPlayers()[nTurnCounter % gameBoard.getPlayers().length].getChosen()).getDevelopment() )== 5) {
              dRenovation += 50;
              dRenovation += ((((Property)  gameBoard.getPlayers()[nTurnCounter % gameBoard.getPlayers().length].getChosen()).getDevelopment()) - 1) * 25;
            }
            else
              dRenovation += (((Property)  gameBoard.getPlayers()[nTurnCounter % gameBoard.getPlayers().length].getChosen()).getDevelopment()) * 25;
          }
          renovationPrice.setText(""+dRenovation);
        }
      }
    }
    else{

      Property temp = (Property) gameBoard.getLand().get(index);
      for(int i = 0; i < urls.length; i++){
        if(urls[i][0].equalsIgnoreCase(temp.getName())){
          Image ig = new Image(getClass().getResourceAsStream(urls[i][2]));
          traderZoom.setImage(ig);
        }
      }
      gameBoard.getPlayers()[nTurnCounter % gameBoard.getPlayers().length].setChosen((Ownable) gameBoard.getLand().get(index)); //Set ownable clicked to chosen ownable
      traderFootTraffic.setText(""+ temp.getFootTraffic());
      traderOffer.setText(temp.getName());
      traderDoubleRent.setVisible(false);traderIncrease10.setVisible(false);traderIncrease50.setVisible(false);traderDecrease10.setVisible(false);
      for(int i = 0; i <traderDevelopment.size();i++){
        if(temp.getDevelopment() == i)
          traderDevelopment.get(i).setVisible(true);
        else
          traderDevelopment.get(i).setVisible(false);
      }

      for(int i = 0; i < temp.getCardMultipliers().size();i++){
        int nIndex = temp.getCardMultipliers().get(i).getIndex();
        if(nIndex == 1){//Double Rent
          traderDoubleRent.setVisible(true);
        }
        else if(nIndex == 2){//Renovation
          traderIncrease50.setVisible(true);
        }
        else if(nIndex == 3 || nIndex == 5){//Decrease/Dilapidated
          traderDecrease10.setVisible(true);
        }
        else if(nIndex == 4){//Increase10
          traderIncrease10.setVisible(true);
        }
      }
    }
    }

  public void hideOwnerIcons(){//Hides owner icons
    for(int i = 0; i < owners.size();i++){
      owners.get(i).setVisible(false);
    }
  }

  public void hidePlayers(){
    for(int i = 0; i < playerAvatars.size();i++){
      for(int j = 0; j < playersSpaces.get(i).size();j++){
          playersSpaces.get(i).get(j).setImage(null);
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
          playersSpaces.get(i).get(j).toFront();
        }
        else //Set the images in empty spaces to null
          playersSpaces.get(i).get(j).setImage(null);
      }
    }
  }

  public void checkWin(){
    if(gameBoard.getIsWin() || (gameBoard.isCompleteSet())) {
      rentPane.setVisible(false);
      endPane.setVisible(false);
      tradePane.setVisible(false);
      purchasePane.setVisible(false);
      if(gameBoard.isCompleteSet()){
        eventLabel.setText("Congratulations! " + gameBoard.getPlayers()[nTurnCounter % gameBoard.getPlayers().length].getName() + " has two full sets.\n");
        gameBoard.getEvents().add(gameBoard.getPlayers()[nTurnCounter % gameBoard.getPlayers().length].getName() + " has gotten two full sets.\n");
      }
      gameBoard.getEvents().add("Game Over");
      endGamePane.setVisible(true);
    }
  }

 // Run everything in this function whenever this view has been initialized
  public void initialize(Player[] players) {

    player1Spaces = new ArrayList<ImageView>();
    player2Spaces = new ArrayList<ImageView>();
    player3Spaces = new ArrayList<ImageView>();
    player4Spaces = new ArrayList<ImageView>();
    playersMoney = new ArrayList<Label>();
    playersPane = new ArrayList<AnchorPane>();
    playersName = new ArrayList<Label>();
    playerAvatarIcons = new ArrayList<ImageView>();


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

    //Add in the owner icon imageviews into an arraylist
    owners = new ArrayList<ImageView>();
    owners.add(owner1);owners.add(owner2);owners.add(owner3);owners.add(owner4);owners.add(owner5);
    owners.add(owner6);owners.add(owner7);owners.add(owner8);owners.add(owner9);owners.add(owner10);
    owners.add(owner11);owners.add(owner12);owners.add(owner13);owners.add(owner14);owners.add(owner15);
    owners.add(owner16);owners.add(owner17);owners.add(owner18);owners.add(owner19);owners.add(owner20);
    owners.add(owner21);owners.add(owner22);owners.add(owner23);owners.add(owner24);owners.add(owner25);
    owners.add(owner26);owners.add(owner27);owners.add(owner28);

    //Add in the board spaces into an arraylist of labels
    spaces = new ArrayList<Label>();
    spaces.add(space1);spaces.add(space2);spaces.add(space3);spaces.add(space4);spaces.add(space5);
    spaces.add(space6);spaces.add(space7);spaces.add(space8);spaces.add(space9);spaces.add(space10);
    spaces.add(space11);spaces.add(space12);spaces.add(space13);spaces.add(space14);spaces.add(space15);
    spaces.add(space16);spaces.add(space17);spaces.add(space18);spaces.add(space19);spaces.add(space20);
    spaces.add(space21);spaces.add(space22);spaces.add(space23);spaces.add(space24);spaces.add(space25);
    spaces.add(space26);spaces.add(space27);spaces.add(space28);spaces.add(space29);spaces.add(space30);
    spaces.add(space31);spaces.add(space32);

    //Add in the anchors as an arraylist of anchorpanes
    anchors = new ArrayList<AnchorPane>();
    anchors.add(anchor1);anchors.add(anchor2);anchors.add(anchor3);anchors.add(anchor4);anchors.add(anchor5);
    anchors.add(anchor6);anchors.add(anchor7);anchors.add(anchor8);anchors.add(anchor9);anchors.add(anchor10);
    anchors.add(anchor11);anchors.add(anchor12);anchors.add(anchor13);anchors.add(anchor14);anchors.add(anchor15);
    anchors.add(anchor16);anchors.add(anchor17);anchors.add(anchor18);anchors.add(anchor19);anchors.add(anchor20);
    anchors.add(anchor21);anchors.add(anchor22);anchors.add(anchor23);anchors.add(anchor24);anchors.add(anchor25);
    anchors.add(anchor26);anchors.add(anchor27);anchors.add(anchor28);anchors.add(anchor29);anchors.add(anchor30);
    anchors.add(anchor31);anchors.add(anchor32);

    developmentLevels = new ArrayList<ImageView>();
    developmentLevels.add(currentDevelopment1);developmentLevels.add(currentDevelopment2);developmentLevels.add(currentDevelopment3);
    developmentLevels.add(currentDevelopment4);developmentLevels.add(currentDevelopment5);developmentLevels.add(currentDevelopment6);

    //Set the name of the spaces to that of the model's board
    for(int i = 0; i < gameBoard.getLand().size();i++){
      spaces.get(i).setText(gameBoard.getLand().get(i).getName());
    }

    //Set the appropriate images to the label spaces
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

    //Update the player positions on the board
    updatePlayerPositions();

    tradeeDevelopment = new ArrayList<ImageView>();
    tradeeDevelopment.add(tradeeDev1);tradeeDevelopment.add(tradeeDev2);tradeeDevelopment.add(tradeeDev3);
    tradeeDevelopment.add(tradeeDev4);tradeeDevelopment.add(tradeeDev5);tradeeDevelopment.add(tradeeDev6);

    traderDevelopment = new ArrayList<ImageView>();
    traderDevelopment.add(traderDev1);traderDevelopment.add(traderDev2);traderDevelopment.add(traderDev3);
    traderDevelopment.add(traderDev4);traderDevelopment.add(traderDev5);traderDevelopment.add(traderDev6);

    playersMoney.add(money1);playersMoney.add(money2);playersMoney.add(money3);playersMoney.add(money4);playersMoney.add(money5);
    playersPane.add(playerPane1);playersPane.add(playerPane2);playersPane.add(playerPane3);playersPane.add(playerPane4);
    playersName.add(player1);playersName.add(player2);playersName.add(player3);playersName.add(player4);
    playerAvatarIcons.add(playerOneAvatar);playerAvatarIcons.add(playerTwoAvatar);playerAvatarIcons.add(playerThreeAvatar);playerAvatarIcons.add(playerFourAvatar);
    //Set isTrade to false, only true during trading
    isTrade = false;

    for(int i = 0; i < players.length; i++){
        playersName.get(i).setText(players[i].getName());
        playersPane.get(i).setVisible(true);
        playersMoney.get(i).setText(Double.toString(players[i].getMoney()));
        Image ig = new Image(getClass().getResourceAsStream(playerAvatars.get(i)));
        playerAvatarIcons.get(i).setImage(ig);
    }

    playersMoney.get(4).setText(Double.toString(gameBoard.getBank().getMoney()));


    turnLabel.setText(gameBoard.getPlayers()[0].getName()+"'s Turn!");
    gameBoard.getBank().giveMoney(gameBoard.getPlayers()[0],200);
    checkWin();
  }
}
