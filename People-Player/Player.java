/**
 * Player Class
 *    
 *      New Changes: Changed implementation of Roll() and Action()
   
        Last Changes Made: Added conditionals to prevent bankrupt player from moving, Changes in roll()
   
 * Version 1.09

 */

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends People{

    private ArrayList<Land> properties;
    private ArrayList<Card> cards;
    private int nPosition;
    private int nDiceRoll;
    private boolean inJail;

    /**
     * This constructor creats a new Player
     * @param strName is the name to be assigned to the player
     */
    public Player(String strName) {
        super(strName);
        this.properties = new ArrayList<Land>();
        this.cards = new ArrayList<Card>();
        nPosition = 0;
        this.nDiceRoll = 0;
    }


    /**
     * Getter for the properties
     * @return properties arrayList owned by the player
     */
    public ArrayList<Land> getProperties() {
        return this.properties;
    }

    /**
     * Getter for the cards on hand (One card at a time, first card always)
     * @return cards the player has
     */
    public ArrayList<Card> getCard() {
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
        if(nPosition + nRoll > 31) { //checks if the token went through the whole board already
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
     * Method that performs the rolling of die and the calculation of steps of the Player's token
     * @param gameBoard Gameboard where the players are playing on
     */
    public String roll(GameBoard gameBoard) {//
        int nRoll;
        int start = nPosition; //Initializes the starting position of the token
        Land temp;
        nRoll = (int)((Math.random() * (6 - 1)) + 1 ); //generates a random number form 1 - 6
        if(inJail){//If player is in jail then exact fine
            if(this.giveMoney(gameBoard.getBank(),50) == true)
                gameBoard.getEvents().add("Bank was given 50$ for Jail fine.");
            else{//If player can't pay
                gameBoard.getEvents().add(getName() +" was not able to pay Jail Fine.");
                gameBoard.setIsWin(true);
            }
        }
        gameBoard.getEvents().add(this.getName() + " rolled "+ nRoll); // Display dice roll
        String event = "";
        if(!gameBoard.getIsWin()){
            for( int i = start + 1 ; i <= start + nRoll; i++ ) {
                if( i > 31 ) { //Checks if the token has reached the end of the board
                    nRoll = nRoll + start -i;
                    i = 0;
                    nPosition = 0; //this sets the token at start (index 0)
                    start = 0;
                    gameBoard.getEvents().add(gameBoard.getLand().get(0).triggerEvent(gameBoard,this));
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
            event = action(gameBoard); //calls the actions to be offered to the player
        }
        return event;
    }

    /**
     * This lets the player choose from a set of actions he/she may do during the turn
     * @param gameBoard Gameboard where the players are playing on
     */
    public String action(GameBoard gameBoard) {
        String event = "";
        //TODO Connect functionality with GUI
        if((gameBoard.getLand().get(nPosition) instanceof Tax) || (gameBoard.getLand().get(nPosition) instanceof Chance) || (gameBoard.getLand().get(nPosition) instanceof Community) ||
                (gameBoard.getLand().get(nPosition) instanceof Jail) || (gameBoard.getLand().get(nPosition) instanceof Parking)){
            gameBoard.getLand().get(nPosition).triggerEvent(gameBoard, this);
        }
        else if((gameBoard.getLand().get(nPosition) instanceof Utility) || (gameBoard.getLand().get(nPosition) instanceof Railroad) || (gameBoard.getLand().get(nPosition) instanceof Property)){
                if(!isMine(gameBoard)) { //checks if the current Player owns that piece of land
                    if (((Property) gameBoard.getLand().get(nPosition)).getOwner() != null || ((Railroad) gameBoard.getLand().get(nPosition)).getOwner() != null ||
                            ((Utility) gameBoard.getLand().get(nPosition)).getOwner() != null) //checks if the landed tile is owned by the current Player
                        gameBoard.getLand().get(nPosition).triggerEvent(gameBoard, this);
                    else { //If not, checks if that tile is free to purchase form the bank
                        if (dMoney >= ((Property) gameBoard.getLand().get(nPosition)).getPrice()) { //checks if the current player has sufficient funds before offering to buy that land
                            event = purchase(gameBoard);
                        }
                    }
                }
                else { //this means the land tile is owned by the current Player
                    
                    event = trade(gameBoard);

                    if(eligibleDev(gameBoard)) { //checks if the land is eligible for development before offering it 
                        event = develop(gameBoard);
                    }
                }
        }
        return event;
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
     * Purchasing a Land Tile
     * @param gameBoard Gameboard where the players are playing on
     */
    public String purchase (GameBoard gameBoard) {
        ((Property)gameBoard.getLand().get(nPosition)).setOwner(this); //sets the current player as the owner of the land
        properties.add(gameBoard.getLand().get(nPosition)); //adds the land to the current Player's list of land owned
        dMoney -= ((Property)gameBoard.getLand().get(nPosition)).getPrice(); //subtracts the money from the current Player
        gameBoard.getBank().receiveMoney(((Property)gameBoard.getLand().get(nPosition)).getPrice()); //gives the money to the bank
        return gameBoard.getLand().get(nPosition).getName() + " was purchased by " + getName();
    } 

    /**
     * Trades with another Player
     * @param gameBoard Gameboard where the players are playing on
     */
    public String trade(GameBoard gameBoard) {
        int nChosenPosition = 0; //Property which player wants to get
        int nChosenPlayer = 0; //Player which this player wishes to trade with
        int nProperty = 0; //Property which this player wishes to trade in return
        Scanner sc = new Scanner(System.in);
        System.out.println("Which player to trade to:");
        for(int i = 0; i < gameBoard.getPlayers().length; i++)
            if(gameBoard.getPlayers()[i].getName() != getName())
                System.out.println(i+"."+gameBoard.getPlayers()[i].getName());
        nChosenPlayer = sc.nextInt();

        //TODO Connect this with GUI
        System.out.println("Which property to trade?");
        for(int i = 0; i < gameBoard.getPlayers()[nChosenPlayer].getProperties().size();i++)
            System.out.println(i+"."+gameBoard.getPlayers()[nChosenPlayer].getProperties().get(i).getName());
        nChosenPosition = sc.nextInt();

        System.out.println("Which property to trade? to " + gameBoard.getPlayers()[nChosenPlayer].getName());
        for(int i = 0; i < properties.size();i++)
            System.out.println(i+"."+properties.get(i).getName());
        nProperty = sc.nextInt();


        //assuming other end agrees,
        Land temp = gameBoard.getPlayers()[nChosenPlayer].getProperties().get(nChosenPosition);
        //Sets owner to player and removes property traded from owned properties
        ((Property)temp).setOwner(this);
        this.properties.add(temp);

        //Sets your chosen property to be owned by other player
        ((Property)properties.get(nProperty)).setOwner(gameBoard.getPlayers()[nChosenPlayer]);
        gameBoard.getPlayers()[nChosenPlayer].properties.add(properties.get(nProperty));

        //Remove traded properties from both players
        this.properties.remove(properties.get(nProperty ));

        gameBoard.getPlayers()[nChosenPlayer].properties.remove(nChosenPosition);
        String event = "";
        event += getName() + " now owns " + this.properties.get(properties.size()-1).getName();
        event += gameBoard.getPlayers()[nChosenPlayer].getName() +" now owns " +
                gameBoard.getPlayers()[nChosenPlayer].properties.get(gameBoard.getPlayers()[nChosenPlayer].properties.size()-1).getName();
        return event;
    }

    /**
     * Develops land of the owner
     *  @param gameBoard Gameboard where the players are playing on
     */
    private String develop(GameBoard gameBoard) {
        String event = "";
       dMoney -=  ((Property)gameBoard.getLand().get(nPosition)).getDetails()[1];
        ((Property)gameBoard.getLand().get(nPosition)).setDevelopment(1);
       return gameBoard.getLand().get(nPosition).getName() + " was developed. " +
               "Now at Development Level: " + ((Property)gameBoard.getLand().get(nPosition)).getDevelopment();
    }

    /**
     * Checker whether or not this land is eligible for development
     * @param gameBoard Gameboard where the players are playing on
     * @return boolean if the land is eligible
     */
    private boolean eligibleDev (GameBoard gameBoard) { //NOTE: FootTraffic does not reset for every development made
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