/**
 * Player Class
 *    
 *      New Changes:        private inJail
                            getJail()
                            setJail       
                            edited method calls and mismatch attribute names                   
   
        Last Changes Made:  develop()
                            trade() 
   
 * Version 1.04
 */

import java.util.ArrayList;

/**
 * Player class which inherits from People Class and is used for making the players in the game
 *   @author  Lua & Tanting
 *   @version 1.0
 */
public class Player extends People{

    private ArrayList<Property> properties;
    private ArrayList<Card> cards;
    private int nPosition;
    private int nDiceRoll;
    private boolean inJail;

    /**
     * This constructor creates a new Player with a given name
     * @param strName name of the player
     */
    public Player(String strName) {
        super(strName, false);
        properties = new ArrayList<Property>();
        cards = new ArrayList<Card>();
        nPosition = 0;
        nDiceRoll = 0;
    }

    /**
     * Gets the integer position of the player on the board
     * @return (int) player position
     */
    public int getPosition() {
        return nPosition;
    }

    /**
     * Gets a card that the user that is currently in possession of
     * @return (Card) card of the user
     */
    public Card getCard() {
        if(!cards.isEmpty())
            return this.cards.get(0);
        else
            return null;
    }

    /**
     * Gets the number which resulted from the player's dice roll
     * @return (int) dice roll number
     */
    public int getDiceRoll(){
        return nDiceRoll;
    }

    /**
     * Getter for the properties
     * @return properties arrayList
     */
    public ArrayList<Property> getProperty() {
        return this.properties;
    }    

    /**
     * Getter for the last roll value
     * @return last number rolled
     */
    public int getLastRoll() {
        return this.nDiceRoll;
    }

    /**
     * Adds a given card to the cards which the player possesses
     * @param c Card which is to be addede to the player
     * @return (void)
     */
    public void addCard(Card c){
        cards.add(c);
    }

    /**
     * Updates player position and game board state based off player's dice roll
     * @param gameBoard Contains the game board that the player is playing at
     * @return (void)
     */
    public void roll(GameBoard gameBoard) {
        int nRoll;
        nRoll = (int)(Math.random() * (6 - 1) + 1 );
        System.out.println(nRoll);
        nDiceRoll = nRoll;
        for( int i = nPosition + 1 ; i <= nPosition + nRoll; i++ ) {
            if (i > 31) {//If position has gone past the edge of the board then go back to start
                nRoll -= i;
                i = 0;
                nPosition = 0; //this sets the token at start (index 0)
                start = 0;
                dMoney += 200; //the player received 200$ from the bank
                gameBoard.getBank().giveMoney(200); //the bank shells out 200$
            }
            else {
                nPosition += 1;
            }
            temp = properties.get(i);
            temp.addFootTraffic();
            properties.set(i,temp);
        }

    action(gameBoard); //calls the actions to be offered to the player
    
    }

    /**
     * This lets the player choose from a set of actions he/she may do during the turn
     * @param gameBoard Gameboard where the players are playing on
     */
    public void action(GameBoard gameBoard) {
        switch(gameBoard.getLand().get(nPosition).getLandType()) {
            case "income":
            case "luxury":
            case "chance":
            case "corner": gameBoard.getLand().get(nPosition).triggerEvent(this, gameBoard); break; //if the player lands on a non own-able land tile, call triggerEvent
            case "railroad":
            case "utility": 
            case "property": {
                if(!isMine(gameBoard)) { //checks if the current Player owns that piece of land
                    if (gameBoard.getLand().get(nPosition).getOwner() != null) //checks if the landed tile is owned by the current Player
                        gameBoard.getLand().get(nPosition).triggerEvent(this, gameBoard);
                    else { //If not, checks if that tile is free to purchase form the bank
                        if(dMoney >= gameBoard.getLand().get(nPosition).getDetails()[0]) { //checks if the current player has sufficient funds before offering to buy that land 
                            purchase(gameBoard);
                        }
                    }
                }
                else { //this means the land tile is owned by the current Player
                    
                    trade(gameBoard);

                    if(eligibleDev(gameBoard)) { //checks if the land is eligible for development before offering it 
                        develop(gameBoard);
                    }
                }
                break;
            } 

        }
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
    private void purchase (GameBoard gameBoard) {
        gameBoard.getLand().get(nPosition).setOwner(this); //sets the current player as the owner of the land
        this.properties.add(gameBoard.getLand().get(nPosition)); //adds the land to the current Player's list of land owned
        dMoney -= gameBoard.getLand().get(nPosition).getDetails()[0]; //subtracts the money from the current Player
        gameBoard.getBank().receiveMoney(gameBoard.getLand().get(nPosition).getDetails()[0]); //gives the money to the bank
    } 

    /**
     * Trades with another Player
     * @param gameBoard Gameboard where the players are playing on
     */
    private void trade(GameBoard gameBoard) {
        //choose which property to trade with (index)
int nChosenPosition = 0;
        //assuming other end agrees,
        gameBoard.getLand().get(nPosition).setOwner(gameBoard.getLand().get(nChosenPosition).getOwner());

        gameBoard.getLand().get(nChosenPosition).setOwner(this);
    }

    /**
     * Develops land of the owner
     */
    private void develop(GameBoard gameBoard) {
       dMoney -=  gameBoard.getLand().get(nPosition).getDetails()[1];
       gameBoard.getLand().get(nPosition).setDevelopment(1);
    }

    /**
     * Checker whether or not this land is eligible for development
     * @return boolean if the land is eligible
     */
    private boolean eligibleDev (GameBoard gameBoard) {
        if(dMoney >= gameBoard.getLand().get(nPosition).getDetails()[1]) {
            if( (gameBoard.getLand().get(nPosition).getRentCollected() >= gameBoard.getLand().get(nPosition).getDetails()[1]) || (gameBoard.getLand().get(nPosition).getFootTraffic() >=  gameBoard.getLand().get(nPosition).getDetails()[8] * gameBoard.getPlayers()) ) {
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
}