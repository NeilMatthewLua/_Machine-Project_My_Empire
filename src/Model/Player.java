package Model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Player Class which is a subclass of people is used for the Players within the game
 */


public class Player extends People{

    //ArrayList of Ownable tiles the Player can have
    private ArrayList<Ownable> properties;
    //ArrayList of Cards the Player can hold and use
    private ArrayList<Card> cards;
    //Current position of the Player in the gameboard
    private int nPosition;
    //The value of the Player's last rolled dice
    private int nDiceRoll;
    private boolean inJail;
    private Ownable chosen;

    /**
     * This constructor creats a new Player
     * @param strName is the name to be assigned to the Player
     */
    public Player(String strName) {
        super(strName);
        this.properties = new ArrayList<Ownable>();
        this.cards = new ArrayList<Card>();
        nPosition = 0;
        this.nDiceRoll = 0;
    }


    /**
     * Getter for the Player's properties
     * @return properties arrayList owned by the Player
     */
    public ArrayList<Ownable> getProperties() {
        return this.properties;
    }

    /**
     * Getter for the cards on hand (One card at a time, first card always)
     * @return cards the Player has
     */
    public ArrayList<Card> getCards() {
            return cards;
    }

    /**
     * Getter for Current Position
     * @return current position of the Player
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
     * @return true or false if the Player is in jail
     */
    public boolean getJail() {
        return this.inJail;
    }

    /**
     * Getter for Player's chosen owned Property / Utility / Railroad
     * @return chosen Property / Utility / Railroad from Player
     */
    public Ownable getChosen() { 
        return this.chosen; 
    }

    /**
     * Getter for the Player's properties that the Player has
     * @return the arrayList of Property
     */
    public ArrayList<Property> getOnlyProperty(){
        //Holds the ArrayList of Properties to be returned
        ArrayList<Property> tempArr = new ArrayList<Property>();
        
        //Loops through properties to check if Player has property of applicable type
        for(int i = 0; i < getProperties().size();i++)
            if(getProperties().get(i) instanceof Property){
                tempArr.add(((Property)getProperties().get(i)));
            }
        return tempArr;
    }

    /**
     * Getter for the Player's properties that the Player can renovate
     * @return the arrayList of Properties
     */
    public ArrayList<Property> getOnlyPropertyRenovate(){
        //Holds the ArrayList of Properties that are eligible for renovation
        ArrayList<Property> tempArr = new ArrayList<Property>();
        //Renovation price
        double dRenovation = 0; 
        
        
        //Loops through properties to check if Player has property of applicable type
        for(int i = 0; i < getProperties().size();i++){
            //Renovation price is reset here
            dRenovation = 0;
            //Checks if that ownable is a Property
            if(getProperties().get(i) instanceof Property){
                //if yes, checks if that Property's Development status
                if (((Property) getProperties().get(i)).getDevelopment() >= 1) {
                    //Calculates price of renovation
                    //Checks if the Proeprty has a hotel
                    if (((Property) getProperties().get(i)).getDevelopment() == 5) {
                        //If so, add's 50 on renovation price
                        dRenovation += 50;
                        //Adds 25 for each house 
                        dRenovation += (((Property) getProperties().get(i)).getDevelopment() - 1) * 25;
                    }
                    //If no Hotel, jsut adds 25$ per house owned
                    else {
                        dRenovation += ((Property) getProperties().get(i)).getDevelopment() * 25;
                    }
                }
                
                //If funds for renovation is applicable
                if (getMoney() - dRenovation >= 0) {
                    tempArr.add(((Property)getProperties().get(i)));
                }
            }
        }

        return tempArr;
    }

    /**
     * Getter for the Player's utilities that the Player has
     * @return the arrayList of Utility
     */
    public ArrayList<Utility> getOnlyUtility(){
        //Holds the Player's owned Utilities
        ArrayList<Utility> tempArr = new ArrayList<Utility>();
        
        //Loops through properties to check if Player has property of applicable type
        for(int i = 0; i < getProperties().size();i++)
            if(getProperties().get(i) instanceof Utility){
                tempArr.add(((Utility)getProperties().get(i)));
            }
        return tempArr;
    }

    /**
     * Getter for the Player's railroad that the Player has
     * @return the arrayList of Railroad
     */
    public ArrayList<Railroad> getOnlyRailroad(){
        //Holds the Player's Railroads
        ArrayList<Railroad> tempArr = new ArrayList<Railroad>();
        
        //Loops through properties to check if Player has property of applicable type
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
        //Checks if the Player is one move away from Start tile
        if(nPosition == 31 && nRoll == 1){
            nPosition = -1;
        }
        //checks if the token went through the whole board already
        else if(nPosition + nRoll > 31) { 
            nPosition = nRoll - (31 - nPosition) - 1;
        }

        nPosition += nRoll;
    }
      
    /**
     * Setter for the Player's jail status. Changes status of Player's jail status based on parameter
     * @param value Jail status of the Player
     */
    public void setJail(boolean value) {
        this.inJail = value;
    }

    /**
     * Setter for Player's chosen owned Property / Utility / Railroad
     * @param chosen Player's chosen Ownable
     */
    public void setChosen(Ownable chosen) { this.chosen = chosen; }


    /**
     * Checks if the tile the Player is on is that Player's owned Property
     * @param gameBoard  Gameboard where the Players are playing on
     * @return boolean value to confirm
     */
    public boolean isOwnedProperty(GameBoard gameBoard){
        //Checks if the tile is a Property subclass first
        if((gameBoard.getLand().get(nPosition) instanceof Property))
            //Calls isMine to check if the Player owns it
            if(isMine(gameBoard)) {
                return true;
            }

        return false;
    }

    /**
     * This checks if the tile the Player is on is free for purchase
     * @param gameBoard Gameboard where the Players are playing on
     * @return boolean value to confirm
     */
    public boolean isFree(GameBoard gameBoard){
        //Checks the instnace of Ownable in general
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
     * This checks if the tile the Player is on is that Player's owned Utility / Railroad
     * @param gameBoard  Gameboard where the Players are playing on
     * @return boolean value to confirm
     */
    public boolean isOwnedUtilityRailroad(GameBoard gameBoard){
        //Checks if the tile is a Utility / Railroad subclass first
        if( (gameBoard.getLand().get(nPosition) instanceof Utility) || (gameBoard.getLand().get(nPosition) instanceof Railroad ))
            //Calls isMine to check if the Player owns it
            if(isMine(gameBoard)) {
                return true;
            }
        return false;
    }

    /**
     * Checks if the current Player owns that piece of land
     * @param gameBoard Gameboard where the Players are playing on
     * @return if current Player owns that land
     */
    public boolean isMine(GameBoard gameBoard) {
        return this.properties.contains(gameBoard.getLand().get(nPosition));
    }

    /**
     * Method that performs the rolling of die and the calculation of steps of the Player's token
     * @param gameBoard Gameboard where the Players are playing on
     * @return string which contains the details of the event
     */
    public String roll(GameBoard gameBoard) {//
        int nRoll;
        //Initializes the starting position of the token
        int start = nPosition; 
        Land temp;
        //generates a random number form 1 - 6
        nRoll = (int)((Math.random() * (6 - 1)) + 1 );
        //Holds the last roll value
        this.nDiceRoll = nRoll;
        String event = "";
        //If Player is in jail then charge fine
        if(inJail){
            //Checks if the Player has at least one card on hand (might be a get out of jail free)
            if(this.getCards().size() > 0){
                //Checks if the Player owns a get-out-of-Jail free Card
                if(this.getCards().get(0) instanceof CardSet_1){
                    //Uses the card it Player has
                    event += this.getCards().get(0).useCard(this,gameBoard) + "\n";
                    //gameboard records the event
                    gameBoard.getEvents().add(event);
                }
                //If Player does not have that card
                else{
                    //Player pays 50$
                    if(this.giveMoney(gameBoard.getBank(),50)){
                        event += "Bank was given 50$ for Jail fine.\n";
                        //sets the Player free
                        inJail = false;
                        gameBoard.getEvents().add(event);
                    }
                    //If Player can't pay
                    else{
                        event += getName() +" was not able to pay Jail Fine.\n";
                        gameBoard.getEvents().add(event);
                        gameBoard.setIsWin(true);
                    }
                }
            }
            //If Player can pay Jail Fine
            else if(this.giveMoney(gameBoard.getBank(),50)){
                event += "Bank was given 50$ for Jail fine.\n";
                inJail = false;
                gameBoard.getEvents().add(event);
            }
            //If Player can't pay
            else{
                event += getName() +" was not able to pay Jail Fine.\n";
                gameBoard.getEvents().add(event);
                gameBoard.setIsWin(true);
            }
        }
        event += getName() + " rolled a " + nRoll + "\n";
        //Checks if there is already a winner
        if(!gameBoard.getIsWin()){
            for( int i = start + 1 ; i <= start + nRoll; i++ ) {
                //Checks if the token has reached the end of the board
                if( i > 31 ) { 
                    nRoll = nRoll + start -i;
                    i = 0;
                    //this sets the token at start (index 0)
                    nPosition = 0; 
                    start = 0;
                    event += gameBoard.getLand().get(0).triggerEvent(gameBoard,this);
                    gameBoard.getEvents().add(event);
                }
                else {
                    nPosition += 1;
                }
                //Adds footTraffic for every Property passed by
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
     * @param gameBoard Gameboard where the Players are playing on
     * @return string which contains the details of the event
     */
    public String action(GameBoard gameBoard) {
        String event = gameBoard.getLand().get(nPosition).triggerEvent(gameBoard, this);
        return event;
    }
    
    /**
     * This checks if the Player owns any property that can be traded
     * @param gameBoard  Gameboard where the Players are playing on
     * @return boolean value to confirm
     */
    public boolean canTrade(GameBoard gameBoard){
        //goes through Player's assets
        if(gameBoard.getLand().get(nPosition) instanceof Property){
            for(int i = 0; i < this.getProperties().size(); i++ ){
                //Checks if there is at least one Property subclass in the Player's assets
                if(this.getProperties().get(i) instanceof Property)
                    return true;
            }
        }
        return false;
    }

    /**
     * This charges rent to the Player
     * @param gameBoard  Gameboard where the Players are playing on
     * @return string event to be displayed on the window
     */
    public String payRent(GameBoard gameBoard) {
         String event = gameBoard.getLand().get(nPosition).triggerEvent(gameBoard, this);
         return event;
    }

    /**
     * Purchasing a Land Tile
     * @param gameBoard Gameboard where the Players are playing on
     * @return string which contains the details of the event
     */
    public String purchase (GameBoard gameBoard) {
        String event = "";
        //sets the current Player as the owner of the Property
        if(gameBoard.getLand().get(nPosition) instanceof Property){
            ((Property)gameBoard.getLand().get(nPosition)).setOwner(this); 
            //adds the land to the current Player's list of Property owned
            properties.add(((Ownable)gameBoard.getLand().get(nPosition))); 
            //subtracts the money from the current Player
            dMoney -= ((Property)gameBoard.getLand().get(nPosition)).getPrice(); 
            //gives the money to the bank
            gameBoard.getBank().receiveMoney(((Property)gameBoard.getLand().get(nPosition)).getPrice()); 
            event += gameBoard.getLand().get(nPosition).getName() + " was purchased by " + getName() + " for $" + ((Property)gameBoard.getLand().get(nPosition)).getPrice() + "\n";
        }
        //sets the current Player as the owner of the Utility
        else if(gameBoard.getLand().get(nPosition) instanceof Utility){
            ((Utility)gameBoard.getLand().get(nPosition)).setOwner(this); 
             //adds the land to the current Player's list of Utility owned
            properties.add(((Ownable)gameBoard.getLand().get(nPosition)));
            //subtracts the money from the current Player
            dMoney -= ((Utility)gameBoard.getLand().get(nPosition)).getPrice(); 
             //gives the money to the bank
            gameBoard.getBank().receiveMoney(((Utility)
            gameBoard.getLand().get(nPosition)).getPrice());
            event += gameBoard.getLand().get(nPosition).getName() + " was purchased by " + getName() + " for $" + ((Utility)gameBoard.getLand().get(nPosition)).getPrice() + "\n";
        }
        else if(gameBoard.getLand().get(nPosition) instanceof Railroad){
             //sets the current Player as the owner of the Railroad
            ((Railroad)gameBoard.getLand().get(nPosition)).setOwner(this);
            //adds the land to the current Player's list of Railroad owned
            properties.add(((Ownable)gameBoard.getLand().get(nPosition))); 
             //subtracts the money from the current Player
            dMoney -= ((Railroad)gameBoard.getLand().get(nPosition)).getPrice();
             //gives the money to the bank
            gameBoard.getBank().receiveMoney(((Railroad)gameBoard.getLand().get(nPosition)).getPrice());
            event += gameBoard.getLand().get(nPosition).getName() + " was purchased by " + getName() + " for $" + ((Railroad)gameBoard.getLand().get(nPosition)).getPrice() + "\n";
        }

        return event;
    }

    /**
     * Conducts the trading of property
     * @param gameBoard Gameboard where the Players are playing on
     * @param landedOwnable landed Ownable
     * @param chosenOwnable Ownable to be given
     * @return the summary of the trade event
     */
    public String trade(GameBoard gameBoard, Ownable landedOwnable, Ownable chosenOwnable) {

        //temprary holdings of Ownable
        Player temp = chosenOwnable.getOwner();
        Player temp2 = landedOwnable.getOwner();

        //Sets owner to Player and removes property traded from owned properties
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
     *  @param gameBoard Gameboard where the Players are playing on
     * @return string which contains the details of the event
     */
    public String develop(GameBoard gameBoard) {
        String event = "";
        //Charges the Player for the development costs
        dMoney -=  ((Property)gameBoard.getLand().get(nPosition)).getDetails()[1];
        //Adds development
        ((Property)gameBoard.getLand().get(nPosition)).setDevelopment(1);
       return gameBoard.getLand().get(nPosition).getName() + " was developed. " +
               "Now at Development Level: " + ((Property)gameBoard.getLand().get(nPosition)).getDevelopment() + "\n";
    }

    /**
     * Checks if the land can be purchased or not
     * @param gameBoard Gameboard where the Players are playing on
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
     * @param gameBoard Gameboard where the Players are playing on
     * @return boolean if the land is eligible
     */
    public boolean eligibleDev (GameBoard gameBoard) { //NOTE: FootTraffic does not reset for every development made
         //checks if the landed spot is indeed a proprty, therefore eligible for a development
        if(gameBoard.getLand().get(nPosition) instanceof Property){
            //checks if the Player has enough cash to develop
            if(dMoney >= ((Property)gameBoard.getLand().get(nPosition)).getDetails()[1]) { 
                //checks if either the property has accumulated enough rent or foottraffic on that spot is more than the multiplier * # of Players requirement
                if( (((Property)gameBoard.getLand().get(nPosition)).getRentCollected() >=((Property)gameBoard.getLand().get(nPosition)).getDetails()[1]) || (((Property)gameBoard.getLand().get(nPosition)).getFootTraffic() >=  ((Property)gameBoard.getLand().get(nPosition)).getDetails()[8] * gameBoard.getPlayers().length) ) { 
                    //checks if the property has not yet reached max development
                    if(((Property)gameBoard.getLand().get(nPosition)).getDevelopment() <= 4) { 
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