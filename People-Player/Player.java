/**
 * Player Class
 *    
 *      New Changes:        develop()
                            eligibleDev()
 * 
        Last Changes Made:  Other half Roll (Trade, Purchase)    
                            setPosition()
                            getLastRoll()  
                            purchase()   
                            trade()     
   
 * Version 1.03
 */

import java.util.ArrayList;

public class Player extends People{

    ////private ArrayList<Property> properties;
    //private ArrayList<Card> cards;
    private int nPosition;
    private int nDiceRoll;

    /**
     * This constructor creats a new Player
     */
    public Player(String strName) {
        super(strName, false);
        ////this.properties = new ArrayList<Property>();
        //this.cards = new ArrayList<card>();
        this.nPosition = 0;
        this.nDiceRoll = 0;
    }

    /**
     * Getter for Current Position
     * @return current position of the player
     */
    public int getPosition() {
        return this.nPosition;
    }

    /**
     * Getter for the cards on hand (One card at a time, first card always)
     * @return first card on hand (if there are any)
     */
    //public Card getCard() {
        //if(!cards.isEmpty())
            //return this.cards.get(0);
    //}

    /**
     * Getter for the properties
     * @return properties arrayList
     */
    //public Property getProperty() {
        //return this.properties;
    //}
    

    /**
     * Getter for the last roll value
     * @return last number rolled
     */
    public Property getLastRoll() {
        return this.nDiceRoll;
    }

    /**
     * Setter for the Player's positoin
     * @param roll number of spaces the token moves
     */
    public void setPosition(int nRoll) {
        if(this.nPosition + nRoll > 31) { //checks if the token went through the whole board already
            this.nPosition = nRoll - (31 - this.nPosition) - 1;
        }
        this.nPosition += nRoll;
    }
        
        
    /**
     * Method that performs the rolling of die and the calculation of steps of the Player's token
     * @param gameBoard Gameboard where the players are playing on
     */
    public void roll(GameBoard gameBoard) {
        int nRoll;
        int start = this.nPosition; //Initializes the starting position of the token
        //Properties temp;
        nRoll = (int)((Math.random() * (6 - 1)) + 1 ); //generates a random number form 1 - 6 
        this.nDiceRoll = nRoll;
        
        for( int i = start + 1 ; i <= start + nRoll; i++ ) {

            if( i > 31 ) { //Checks if the token has reached the end of the board 
                nRoll = nRoll + start -i;  
                i = 0;
                this.nPosition = 0; //this sets the token at start (index 0)
                start = 0;
                this.dMoney += 200; //the player received 200$ from the bank
                gameBoard.getBank().giveMoney(this,200); //the bank shells out 200$
            }
            else {
                this.nPosition += 1;
            }
            //temp = properties.get(i);
            //temp.addFootTraffic();
            //properties.set(i,temp);
        }

    action(gameBoard); //calls the actions to be offered to the player
    
    }

    /**
     * This lets the player choose from a set of actions he/she may do during the turn
     * @param gameBoard Gameboard where the players are playing on
     */
    public void action(GameBoard gameboard) {
        switch(gameBoard.getLand().get(this.nPosition).getLandType()) {
            case "income":
            case "luxury":
            case "chance":
            case "corner": gameBoard.getLand().triggerEvent(this, gameboard); break; //if the player lands on a non own-able land tile, call triggerEvent
            case "railroad":
            case "utility": 
            case "property": {
                if(!isMine) { //checks if the current Player owns that piece of land
                    if (gameBoard.getLand().get(this.nPosition).getOwner() != null) //checks if the landed tile is owned by the current Player
                        gameBoard.getLand().triggerEvent(this, gameboard);
                    else { //If not, checks if that tile is free to purchase form the bank
                        if(this.dMoney >= gameBoard.getLand().get(this.nPosition).arrAttributes[0]) { //checks if the current player has sufficient funds before offering to buy that land 
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
     * @return if current Player owns that land
     */
    public boolean isMine() {
        return this.properties.contains(gameBoard.getLand().get(this.nPosition));
    }

    /**
     * Purchasing a Land Tile
     * @param gameBoard Gameboard where the players are playing on
     */
    private void purchase (GameBoard gameBoard) {
        gameBoard.getLand.get(this.nProperty).setOwner(this); //sets the current player as the owner of the land
        this.properties.add(gameBoard.getLand.get(this.nProperty)); //adds the land to the current Player's list of land owned
        this.dMoney -= gameBoard.getLand().get(this.nPosition).arrAttributes[0]; //subtracts the money from the current Player
        gameBoard.getBank().receiveMoney(gameBoard.getLand().get(this.nPosition).arrAttributes[0]); //gives the money to the bank
    } 

    /**
     * Trades with another Player
     * @param gameBoard Gameboard where the players are playing on
     */
    private void trade(GameBoard gameBoard) {
        //choose which property to trade with (index)
        int nChosenProperty;
        //assuming other end agrees,
        gameBoard.getLand.get(this.nProperty).setOwner(gameBoard.getLand.get(this.nProperty).getOwner(nChosenProperty));

        gameBoard.getLand.get(nChosenProperty).setOwner(this);
    }

    /**
     * Develops land of the owner
     */
    private void develop(GameBoard gameBoard) {
       this.dMoney -=  gameBoard.getLand().get(this.nPosition).arrAttributes[1];
       gameBoard.getLand().get(this.nPosition).setDevelopment(1);
    }

    /**
     * Checker whether or not this land is eligible for development
     * @return boolean if the land is eligible
     */
    private boolean eligibleDev (GameBoard gameBoard) {
        if(this.dMoney >= gameBoard.getLand().get(this.nPosition).arrAttributes[1]) {
            if( (gameBoard.getLand().get(this.nPosition).getRentCollected() >= gameBoard.getLand().get(this.nPosition).arrAttributes[1]) || (gameBoard.getLand().get(this.nPosition).getFootTraffic() >=  gameBoard.getLand().get(this.nPosition).arrAttributes[8] * gameBoard.getPlayers().length) ) {
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