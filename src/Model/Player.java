package Model;
/**
 * Player Class which is a subclass of people is used for the players within the game
 *
 *      New Changes: Updated Trade()

        Last Changes Made: public ArrayList<Property> getOnlyProperty()
                         public ArrayList<Property> getOnlyPropertyRenovate()
                         public ArrayList<Utility> getOnlyUtility()
                         public ArrayList<Railroad> getOnlyRailroad()

 *
 *   @author  Lua and Tanting
 *   @version 1.7
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Player extends People{

    private ArrayList<Ownable> properties;
    private ArrayList<Card> cards;
    private int nPosition;
    private int nDiceRoll;
    private boolean inJail;
    private Ownable chosen;

    /**
     * This constructor creats a new Player
     * @param strName is the name to be assigned to the player
     */
    public Player(String strName) {
        super(strName);
        this.properties = new ArrayList<Ownable>();
        this.cards = new ArrayList<Card>();
        nPosition = 0;
        this.nDiceRoll = 0;
    }


    /**
     * Getter for the properties
     * @return properties arrayList owned by the player
     */
    public ArrayList<Ownable> getProperties() {
        return this.properties;
    }

    /**
     * Getter for the cards on hand (One card at a time, first card always)
     * @return cards the player has
     */
    public ArrayList<Card> getCards() {
            return cards;
    }

    /**
     * Getter for Current Position
     * @return current position of the player
     */
    public int getPosition() {
        return nPosition;
    }

    /**
     * Getter for the last roll value
     * @return last number rolled
     */
    public int getLastRoll() {
        return this.nDiceRoll;
    }

    /**
     * Getter for the is in jail checker
     * @return true or false if the player is in jail
     */
    public boolean getJail() {
        return this.inJail;
    }

    /**
     * Getter for player's chosen owned Property / Utility / Railroad
     * @return chosen Property / Utility / Railroad from Player
     */
    public Ownable getChosen() { return this.chosen; }

    /**
     * Gets the player's properties that the player has
     * @return the arrayList of Property
     */
    public ArrayList<Property> getOnlyProperty(){

        //Loops through properties to check if player has property of applicable type
        ArrayList<Property> tempArr = new ArrayList<Property>();

        for(int i = 0; i < getProperties().size();i++)
            if(getProperties().get(i) instanceof Property){
                tempArr.add(((Property)getProperties().get(i)));
            }
        return tempArr;
    }

    /**
     * Gets the player's properties that the player can renovate
     * @return the arrayList of Properties
     */
    public ArrayList<Property> getOnlyPropertyRenovate(){

        //Loops through properties to check if player has property of applicable type
        ArrayList<Property> tempArr = new ArrayList<Property>();
        double dRenovation = 0; //Renovation price

        for(int i = 0; i < getProperties().size();i++){
            dRenovation = 0;
            if(getProperties().get(i) instanceof Property){
                if (((Property) getProperties().get(i)).getDevelopment() >= 1) {//Calculates price of renovation
                    if (((Property) getProperties().get(i)).getDevelopment() == 5) {
                        dRenovation += 50;
                        dRenovation += (((Property) getProperties().get(i)).getDevelopment() - 1) * 25;
                    }
                    else {
                        dRenovation += ((Property) getProperties().get(i)).getDevelopment() * 25;
                    }
                }

                if (getMoney() - dRenovation >= 0) {//If funds for renovation is applicable
                    tempArr.add(((Property)getProperties().get(i)));
                }
            }
        }

        return tempArr;
    }

    /**
     * Gets the player's utilities that the player has
     * @return the arrayList of Utility
     */
    public ArrayList<Utility> getOnlyUtility(){

        //Loops through properties to check if player has property of applicable type
        ArrayList<Utility> tempArr = new ArrayList<Utility>();

        for(int i = 0; i < getProperties().size();i++)
            if(getProperties().get(i) instanceof Utility){
                tempArr.add(((Utility)getProperties().get(i)));
            }
        return tempArr;
    }

    /**
     * Gets the player's railroad that the player has
     * @return the arrayList of Railroad
     */
    public ArrayList<Railroad> getOnlyRailroad(){

        //Loops through properties to check if player has property of applicable type
        ArrayList<Railroad> tempArr = new ArrayList<Railroad>();

        for(int i = 0; i < getProperties().size();i++)
            if(getProperties().get(i) instanceof Railroad){
                tempArr.add(((Railroad)getProperties().get(i)));
            }
        return tempArr;
    }
    /**
     * Adds a card on hand
     * @param card a card that can be kept on hand
     */
    public void addCard(Card card) {
         this.cards.add(card);
    }

    /**
     * Setter for the Player's position
     * @param nRoll number of spaces the token moves
     */
    public void setPosition(int nRoll) {
        if(nPosition == 31 && nRoll == 1){
            nPosition = -1;
        }
        else if(nPosition + nRoll > 31) { //checks if the token went through the whole board already
            nPosition = nRoll - (31 - nPosition) - 1;
        }
        nPosition += nRoll;
    }
      
    /**
     * Setter for the Player's jail status. Changes status of player's jail status based on parameter
     */
    public void setJail(boolean value) {
        this.inJail = value;
    }

    /**
     * Setter for player's chosen owned Property / Utility / Railroad
     */
    public void setChosen(Ownable chosen) { this.chosen = chosen; }


    /**
     * This checks if the tile the player is on is that player's owned Property
     * @param gameBoard  Gameboard where the players are playing on
     * @return boolean value to confirm
     */
    public boolean isOwnedProperty(GameBoard gameBoard){
        //Checks if the tile is a Property subclass first
        if((gameBoard.getLand().get(nPosition) instanceof Property))
            //Calls isMine to check if the player owns it
            if(isMine(gameBoard)) {
                return true;
            }

        return false;
    }

    /**
     * This checks if the tile the player is on is free for purchase
     * @param gameBoard Gameboard where the players are playing on
     * @return boolean value to confirm
     */
    public boolean isFree(GameBoard gameBoard){
        if(gameBoard.getLand().get(nPosition) instanceof Property )
            if(((Property)gameBoard.getLand().get(nPosition)).getOwner() == null)
                return true;
        if(gameBoard.getLand().get(nPosition) instanceof Utility )
            if(((Utility)gameBoard.getLand().get(nPosition)).getOwner() == null)
                return true;
        if(gameBoard.getLand().get(nPosition) instanceof Railroad )
            if(((Railroad)gameBoard.getLand().get(nPosition)).getOwner() == null)
                return true;

        return false;
    }

    /**
     * This checks if the tile the player is on is that player's owned Utility / Railroad
     * @param gameBoard  Gameboard where the players are playing on
     * @return boolean value to confirm
     */
    public boolean isOwnedUtilityRailroad(GameBoard gameBoard){
        //Checks if the tile is a Utility / Railroad subclass first
        if( (gameBoard.getLand().get(nPosition) instanceof Utility) || (gameBoard.getLand().get(nPosition) instanceof Railroad ))
            //Calls isMine to check if the player owns it
            if(isMine(gameBoard)) {
                return true;
            }
        return false;
    }

    /**
     * Checks if the current Player owns that piece of land
     * @param gameBoard Gameboard where the players are playing on
     * @return if current Player owns that land
     */
    public boolean isMine(GameBoard gameBoard) {
        return this.properties.contains(gameBoard.getLand().get(nPosition));
    }

    /**
     * Method that performs the rolling of die and the calculation of steps of the Player's token
     * @param gameBoard Gameboard where the players are playing on
     * @return string which contains the details of the event
     */
    public String roll(GameBoard gameBoard) {//
        int nRoll;
        int start = nPosition; //Initializes the starting position of the token
        Land temp;
        nRoll = (int)((Math.random() * (6 - 1)) + 1 ); //generates a random number form 1 - 6


        this.nDiceRoll = nRoll;
        String event = "";
        if(inJail){//If player is in jail then exact fine
            if(this.getCards().size() > 0){
                if(this.getCards().get(0) instanceof CardSet_1){
                    event += this.getCards().get(0).useCard(this,gameBoard)+"\n";
                    gameBoard.getEvents().add(event);
                }
            }
            if(this.giveMoney(gameBoard.getBank(),50)){
                event += "Bank was given 50$ for Jail fine.\n";
                inJail = false;
                gameBoard.getEvents().add(event);
            }
            else{//If player can't pay
                event += getName() +" was not able to pay Jail Fine.\n";
                gameBoard.getEvents().add(event);
                gameBoard.setIsWin(true);
            }
        }
        event += getName() + " rolled a " + nRoll + "\n";
        if(!gameBoard.getIsWin()){
            for( int i = start + 1 ; i <= start + nRoll; i++ ) {
                if( i > 31 ) { //Checks if the token has reached the end of the board
                    nRoll = nRoll + start -i;
                    i = 0;
                    nPosition = 0; //this sets the token at start (index 0)
                    start = 0;
                    event += gameBoard.getLand().get(0).triggerEvent(gameBoard,this);
                    gameBoard.getEvents().add(event);
                }
                else {
                    nPosition += 1;
                }
                if (gameBoard.getLand().get(i) instanceof Property)
                    if(((Property) gameBoard.getLand().get(i)).getOwner() != null) {
                        //If land is owned and is property type
                        ((Property) gameBoard.getLand().get(this.getPosition())).addFootTraffic();
                    }
            }
            event += getName() + " landed on " + gameBoard.getLand().get(getPosition()).getName() + "\n";

        }
        return event;
    }

    /**
     * This triggers the Jail / Chance / Tax / Free Parking / Start events
     * @param gameBoard Gameboard where the players are playing on
     * @return string which contains the details of the event
     */
    public String action(GameBoard gameBoard) {
        String event = gameBoard.getLand().get(nPosition).triggerEvent(gameBoard, this);
        return event;
    }
    
    /**
     * This checks if the player owns any property that can be traded
     * @param gameBoard  Gameboard where the players are playing on
     * @return boolean value to confirm
     */
    public boolean canTrade(GameBoard gameBoard){
        //goes through player's assets
        if(gameBoard.getLand().get(nPosition) instanceof Property){
            for(int i = 0; i < this.getProperties().size(); i++ ){
                //Checks if there is at least one Property subclass in the player's assets
                if(this.getProperties().get(i) instanceof Property)
                    return true;
            }
        }
        return false;
    }

    /**
     * This charges rent to the player
     * @param gameBoard  Gameboard where the players are playing on
     * @return string event to be displayed on the window
     */
    public String payRent(GameBoard gameBoard) {
         String event = gameBoard.getLand().get(nPosition).triggerEvent(gameBoard, this);
         return event;
    }

    /**
     * Purchasing a Land Tile
     * @param gameBoard Gameboard where the players are playing on
     * @return string which contains the details of the event
     */
    public String purchase (GameBoard gameBoard) {
        String event = "";
        if(gameBoard.getLand().get(nPosition) instanceof Property){
            ((Property)gameBoard.getLand().get(nPosition)).setOwner(this); //sets the current player as the owner of the Property
            properties.add(((Ownable)gameBoard.getLand().get(nPosition))); //adds the land to the current Player's list of Property owned
            dMoney -= ((Property)gameBoard.getLand().get(nPosition)).getPrice(); //subtracts the money from the current Player
            gameBoard.getBank().receiveMoney(((Property)gameBoard.getLand().get(nPosition)).getPrice()); //gives the money to the bank
            event += gameBoard.getLand().get(nPosition).getName() + " was purchased by " + getName() + " for $" + ((Property)gameBoard.getLand().get(nPosition)).getPrice();
        }
        else if(gameBoard.getLand().get(nPosition) instanceof Utility){
            ((Utility)gameBoard.getLand().get(nPosition)).setOwner(this); //sets the current player as the owner of the Utility
            properties.add(((Ownable)gameBoard.getLand().get(nPosition))); //adds the land to the current Player's list of Utility owned
            dMoney -= ((Utility)gameBoard.getLand().get(nPosition)).getPrice(); //subtracts the money from the current Player
            gameBoard.getBank().receiveMoney(((Utility)gameBoard.getLand().get(nPosition)).getPrice()); //gives the money to the bank
            event += gameBoard.getLand().get(nPosition).getName() + " was purchased by " + getName() + " for $" + ((Utility)gameBoard.getLand().get(nPosition)).getPrice();
        }
        else if(gameBoard.getLand().get(nPosition) instanceof Railroad){
            ((Railroad)gameBoard.getLand().get(nPosition)).setOwner(this); //sets the current player as the owner of the Railroad
            properties.add(((Ownable)gameBoard.getLand().get(nPosition))); //adds the land to the current Player's list of Railroad owned
            dMoney -= ((Railroad)gameBoard.getLand().get(nPosition)).getPrice(); //subtracts the money from the current Player
            gameBoard.getBank().receiveMoney(((Railroad)gameBoard.getLand().get(nPosition)).getPrice()); //gives the money to the bank
            event += gameBoard.getLand().get(nPosition).getName() + " was purchased by " + getName() + " for $" + ((Railroad)gameBoard.getLand().get(nPosition)).getPrice();
        }
        return event;
    }


    /**
     * Conducts the trading of property
     * @param gameBoard main board of the game
     * @param landedOwnable landed Ownable
     * @param chosenOwnable Ownable to be given
     * @return the summary of the trade event
     */
    public String trade(GameBoard gameBoard, Ownable landedOwnable, Ownable chosenOwnable) {

        Player temp = chosenOwnable.getOwner();
        Player temp2 = landedOwnable.getOwner();

        //Sets owner to player and removes property traded from owned properties
        this.properties.remove(chosenOwnable);
        chosenOwnable.setOwner(landedOwnable.getOwner());
        landedOwnable.getOwner().getProperties().add(chosenOwnable);

        //Sets your chosen property to be owned by you
        landedOwnable.setOwner(temp);
        temp.getProperties().add(landedOwnable);
        temp2.getProperties().remove(landedOwnable);


        String event = "";
        event += landedOwnable.getOwner().getName() + " now owns " + landedOwnable.getName() + "\n";
        event += chosenOwnable.getOwner().getName() +" now owns " +
                chosenOwnable.getName() + "\n";

        return event;
    }

    /**
     * Develops land of the owner
     *  @param gameBoard Gameboard where the players are playing on
     * @return string which contains the details of the event
     */
    public String develop(GameBoard gameBoard) {
        String event = "";
        dMoney -=  ((Property)gameBoard.getLand().get(nPosition)).getDetails()[1];
        ((Property)gameBoard.getLand().get(nPosition)).setDevelopment(1);
       return gameBoard.getLand().get(nPosition).getName() + " was developed. " +
               "Now at Development Level: " + ((Property)gameBoard.getLand().get(nPosition)).getDevelopment();
    }

    /**
     * Checks if the land can be purchased or not
     * @param gameBoard Gameboard where the players are playing on
     * @return boolean if land can be purchased
     */
    public boolean eligiblePurchase(GameBoard gameBoard){
        if (gameBoard.getLand().get(nPosition) instanceof Property){
            if(dMoney >= ((Property) gameBoard.getLand().get(nPosition)).getPrice()){
                return true;
            }
        }
        else if (gameBoard.getLand().get(nPosition) instanceof Utility){
            if(dMoney >= ((Utility) gameBoard.getLand().get(nPosition)).getPrice()){
                return true;
            }
        }
        else if (gameBoard.getLand().get(nPosition) instanceof Railroad){
            if(dMoney >= ((Railroad) gameBoard.getLand().get(nPosition)).getPrice()){
                return true;
            }
        }

        return false;
    }

    /**
     * Checker whether or not this land is eligible for development
     * @param gameBoard Gameboard where the players are playing on
     * @return boolean if the land is eligible
     */
    public boolean eligibleDev (GameBoard gameBoard) { //NOTE: FootTraffic does not reset for every development made
        if(gameBoard.getLand().get(nPosition) instanceof Property){ //checks if the landed spot is indeed a proprty, therefore eligible for a development
            if(dMoney >= ((Property)gameBoard.getLand().get(nPosition)).getDetails()[1]) { //checks if the player has enough cash to develop
                if( (((Property)gameBoard.getLand().get(nPosition)).getRentCollected() >=((Property)gameBoard.getLand().get(nPosition)).getDetails()[1]) || (((Property)gameBoard.getLand().get(nPosition)).getFootTraffic() >=  ((Property)gameBoard.getLand().get(nPosition)).getDetails()[8] * gameBoard.getPlayers().length) ) { //checks if either the property has accumulated enough rent or foottraffic on that spot is more than the multiplier * # of players requirement
                    if(((Property)gameBoard.getLand().get(nPosition)).getDevelopment() <= 4) { //checks if the property has not yet reached max development
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        else
            return false;
    }
}