/**
 * Player Class
 *    
<<<<<<< HEAD
 *      New Changes: Fixed bugs under Trade (ArrayoutofBounds)
                      setOwner first before handing property
   
        Last Changes Made:  Arranged method ordering in code,
 *                   Added Jail fine in roll(),
 *                   adjusted trade() to allow players to choose properties to trade
   
 * Version 1.08
=======
 *      New Changes: Arranged method ordering in code,
 *                   Added Jail fine in roll(),
 *                   adjusted trade() to allow players to choose properties to trade
   
        Last Changes Made: Fixed some method calls
   
 * Version 1.07
>>>>>>> 5e3e8be9f09e038ef3147b67a2f0d3336ae9c353
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
    public void roll(GameBoard gameBoard) {
        int nRoll;
        int start = nPosition; //Initializes the starting position of the token
        Land temp;
        nRoll = (int)((Math.random() * (6 - 1)) + 1 ); //generates a random number form 1 - 6 
        this.nDiceRoll = nRoll;
        System.out.println("Rolled "+ nRoll); // Display dice roll
        if(inJail){//If player is in jail then exact fine
            if(this.getMoney() - 50 >= 0){//If player can pay
                this.giveMoney(50);
                gameBoard.getBank().receiveMoney(50);
                System.out.println("Bank was given 50$ for Jail fine.");
            }
            else{//If player can't pay
                System.out.println("Game is over." + getName() +" was not able to pay Jail Fine.");
                gameBoard.setIsWin(false);
                gameBoard.getBank().receiveMoney(this.getMoney());
                this.giveMoney(this.getMoney());
            }
        }
        for( int i = start + 1 ; i <= start + nRoll; i++ ) {

            if( i > 31 ) { //Checks if the token has reached the end of the board 
                nRoll = nRoll + start -i;  
                i = 0;
                nPosition = 0; //this sets the token at start (index 0)
                start = 0;
                dMoney += 200; //the player received 200$ from the bank
                gameBoard.getBank().giveMoney(200); //the bank shells out 200$
                System.out.println("Bank pays 200 to: " + getName());
            }
            else {
                nPosition += 1;
            }
            if (gameBoard.getLand().get(this.getPosition()).getOwner() != null)
                if(gameBoard.getLand().get(this.getPosition()).getLandType().equalsIgnoreCase("property")) {
                    //If land is owned and is property type
                    gameBoard.getLand().get(this.getPosition()).addFootTraffic();
                }
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
                        if(dMoney >= gameBoard.getLand().get(nPosition).getPrice()) { //checks if the current player has sufficient funds before offering to buy that land
                            purchase(gameBoard);
                        }
                        else
                        System.out.println(this.getName() + "has insufficient funds");
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
    public void purchase (GameBoard gameBoard) {
        gameBoard.getLand().get(nPosition).setOwner(this); //sets the current player as the owner of the land
        properties.add(gameBoard.getLand().get(nPosition)); //adds the land to the current Player's list of land owned
        dMoney -= gameBoard.getLand().get(nPosition).getPrice(); //subtracts the money from the current Player
        gameBoard.getBank().receiveMoney(gameBoard.getLand().get(nPosition).getPrice()); //gives the money to the bank
        System.out.println(gameBoard.getLand().get(nPosition).getName() + " was purchased by " + getName());
    } 

    /**
     * Trades with another Player
     * @param gameBoard Gameboard where the players are playing on
     */
    public void trade(GameBoard gameBoard) {
        int nChosenPosition = 0; //Property which player wants to get
        int nChosenPlayer = 0; //Player which this player wishes to trade with
        int nProperty = 0; //Property which this player wishes to trade in return
        Scanner sc = new Scanner(System.in);
        System.out.println("Which player to trade to:");
        for(int i = 0; i < gameBoard.getPlayers().length; i++)
            if(gameBoard.getPlayers()[i].getName() != getName())
                System.out.println(i+"."+gameBoard.getPlayers()[i].getName());
        nChosenPlayer = sc.nextInt();

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
        temp.setOwner(this);
        this.properties.add(temp);

        //Sets your chosen property to be owned by other player
<<<<<<< HEAD
        properties.get(nProperty).setOwner(gameBoard.getPlayers()[nChosenPlayer]);
        gameBoard.getPlayers()[nChosenPlayer].properties.add(properties.get(nProperty));

        //Remove traded properties from both players
        this.properties.remove(properties.get(nProperty ));
=======
        gameBoard.getPlayers()[nChosenPlayer].properties.add(properties.get(nProperty));
        properties.get(nProperty).setOwner(gameBoard.getPlayers()[nChosenPlayer]);

        //Remove traded properties from both players
        this.properties.remove(properties.get(nPosition));
>>>>>>> 5e3e8be9f09e038ef3147b67a2f0d3336ae9c353
        gameBoard.getPlayers()[nChosenPlayer].properties.remove(nChosenPosition);

        System.out.println(getName() + " now owns " + gameBoard.getLand().get(nChosenPosition).getName());
        System.out.println(gameBoard.getLand().get(nPosition).getOwner().getName() +" now owns " +
                gameBoard.getLand().get(nPosition).getName());
    }

    /**
     * Develops land of the owner
     *  @param gameBoard Gameboard where the players are playing on
     */
    private void develop(GameBoard gameBoard) {
       dMoney -=  gameBoard.getLand().get(nPosition).getDetails()[1];
       gameBoard.getLand().get(nPosition).setDevelopment(1);
       System.out.println(gameBoard.getLand().get(nPosition).getName() + " was developed. " +
               "Now at Development Level: " + gameBoard.getLand().get(nPosition).getDevelopment());
    }

    /**
     * Checker whether or not this land is eligible for development
     * @param gameBoard Gameboard where the players are playing on
     * @return boolean if the land is eligible
     */
    private boolean eligibleDev (GameBoard gameBoard) {
        if(gameBoard.getLand().get(nPosition).getLandType().equals("property")){
            if(dMoney >= gameBoard.getLand().get(nPosition).getDetails()[1]) {
                if( (gameBoard.getLand().get(nPosition).getRentCollected() >= gameBoard.getLand().get(nPosition).getDetails()[1]) || (gameBoard.getLand().get(nPosition).getFootTraffic() >=  gameBoard.getLand().get(nPosition).getDetails()[8] * gameBoard.getPlayers().length) ) {
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
        else
            return false;
    }
}