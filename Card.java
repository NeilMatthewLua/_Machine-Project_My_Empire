import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Card class which acts as a template for the cards that can be used during the game
 *
 *  New Changes Made:  get out of jail
 *                     move to property chance to own / trade / pay rent
 *
 *  Last Changes Made:
 *
 *   @author  Tanting
 *   @version 1.2
 */
public class Card {
    private int nGroup; //Group which card belongs to
    private int nIndex; //Index of card within group
    private boolean canKeep;
    private String strDescription;

    /**
     * Creates a card with the specified attributes.
     *
     * @param nGroup         The index of which group the card belongs to
     * @param nIndex         The index of the card within said group
     * @param boolCanKeep    True if the user can hold onto the card, false if it has to be used
     * @param strDescription Description of what the card does
     */
    public Card(int nGroup, int nIndex, boolean boolCanKeep, String strDescription) {
        this.nGroup = nGroup;
        this.nIndex = nIndex;
        this.canKeep = boolCanKeep;
        this.strDescription = strDescription;
    }

    /**
     * Gets the description of the card
     * @return description of the card
     */
    public String getDescription() {
        return strDescription;
    }

    /**
     * Gets if canKeep variable of the card
     * @return true if the player can keep, false if the player cannot
     */
    public boolean getCanKeep(){
        return canKeep;
    }

    /**
     *
     * @param player that used the card
     * @param gameBoard current gameBoard
     */
    public void useCard (Player player, GameBoard gameBoard) {
        if(nGroup == 0){
                player.setJail();
        }
        else if (nGroup == 1){
            if(nIndex == 0) {
                Random rand = new Random();
                int nRandProperty = rand.nextInt(32);
                while(gameBoard.getLand().get(nRandProperty).getLandType().equals("property")){//Loops until a property is found
                    nRandProperty = rand.nextInt(32);
                }
                while(player.getPosition() != nRandProperty){//While player has not landed on property
                    player.setPosition(1);//Player moves one space
                    if (gameBoard.getLand().get(player.getPosition()).getOwner().getName() != null &&
                            gameBoard.getLand().get(player.getPosition()).getLandType().equalsIgnoreCase("property")) {
                        //If land is owned and is property type
                        gameBoard.getLand().get(player.getPosition()).addFootTraffic();
                    }
                }
                
                if(!isMine(gameBoard)) { //checks if the current Player owns that piece of land
                    if (gameBoard.getLand().get(player.getPosition()).getOwner() != null) //checks if the landed tile is owned by the current Player
                        gameBoard.getLand().get((player.getPosition()).triggerEvent(player, gameBoard));
                    else { //If not, checks if that tile is free to purchase form the bank
                        if(player.getMoney() >= gameBoard.getLand().get((player.getPosition()).getDetails()[0])) { //checks if the current player has sufficient funds before offering to buy that land 
                            purchase(gameBoard);
                        }
                    }
                }
                else { //this means the land tile is owned by the current Player
                        trade(gameBoard);
                    }
            }
        }
        else if (nIndex == 1) {

        }
        else if (nIndex == 2) {

        }
        else if(nGroup == 2){
            if(nIndex == 0) {

            }
            else if (nIndex == 1) {

            }
            else if (nIndex == 2) {

            }
            else if (nIndex == 3) {

            }
            else if (nIndex == 4) {

            }
        }
        else if(nGroup == 3){//Trip to jail(index 24) or property
            if(nIndex == 0){//Trip to jail, no money on start
                while(player.getPosition() != 24){
                    player.setPosition(1);//Player moves one space
                    if (gameBoard.getLand().get(player.getPosition()).getOwner().getName() != null &&
                            gameBoard.getLand().get(player.getPosition()).getLandType().equalsIgnoreCase("property")) {
                        //If land is owned and is property type
                        gameBoard.getLand().get(player.getPosition()).addFootTraffic();
                    }
                }
            }
            else if(nIndex == 1){//Trip to random property
                Random rand = new Random();
                int nRandProperty = rand.nextInt(32);
                while(gameBoard.getLand().get(nRandProperty).getLandType().equals("property")){//Loops until a property is found
                    nRandProperty = rand.nextInt(32);
                }
                while(player.getPosition() != nRandProperty){//While player has not landed on property
                    player.setPosition(1);//Player moves one space
                    if(player.getPosition() == 0){
                        player.receiveMoney(200);
                        gameBoard.getBank().giveMoney(200);
                    }
                    if (gameBoard.getLand().get(player.getPosition()).getOwner().getName() != null &&
                            gameBoard.getLand().get(player.getPosition()).getLandType().equalsIgnoreCase("property")) {
                        //If land is owned and is property type
                        gameBoard.getLand().get(player.getPosition()).addFootTraffic();
                    }
                }
            }
        }
        else if(nGroup == 4){//Rent modifiers
            if(nIndex >= 0 || nIndex <= 2){//For properties
                int nUserInput = 0;
                boolean isValid = false;
                //Loops through properties to check if player has property of applicable type
                ArrayList<Integer> tempArr = new ArrayList<Integer>(player.getProperties().size());
                for(int i = 0; i < player.getProperties().size();i++)
                    if(player.getProperties().get(i).getLandType().equals("property")){
                        isValid = true;
                        tempArr.add(i);
                    }
                if(isValid){
                    for(int i = 0; i < tempArr.size(); i++)//Display possible properties to add effect
                        System.out.println(i + "." + player.getProperties().get(tempArr.get(i)).getName());
                    Scanner sc = new Scanner(System.in);
                    nUserInput = sc.nextInt();
                    if(nIndex == 0){//Double Rent
                        player.getProperties().get(nUserInput).setDoubleRent(true);
                        System.out.println("Rent of " +player.getProperties().get(nUserInput).getName()+ " doubled for next collection.");
                    }
                    else if(nIndex == 1){//Renovation
                        double dRenovation = 0; //Renovation price
                        if(player.getProperties().get(nUserInput).getDevelopment() >= 1){//Calculates price of renovation
                            if(player.getProperties().get(nUserInput).getDevelopment() == 5){
                                dRenovation += 50;
                                dRenovation += (player.getProperties().get(nUserInput).getDevelopment() - 1) * 25;
                            }
                            else
                                dRenovation += player.getProperties().get(nUserInput).getDevelopment() * 25;
                        }
                        if(player.getMoney() - dRenovation > 0){//If rent is applicable
                            player.giveMoney(dRenovation);
                            gameBoard.getBank().receiveMoney(dRenovation);
                            player.getProperties().get(nUserInput).setMultiplier(1.5);
                            System.out.println("Rent of " +player.getProperties().get(nUserInput).getName()+" increased by 50%");
                        }
                        else
                            System.out.println("Not applicable. No owned properties.");
                    }
                    else if(nIndex == 2){//Dilapidated Houses
                        player.getProperties().get(nUserInput).setMultiplier(.9);
                        System.out.println("Rent of " +player.getProperties().get(nUserInput).getName()+" decreased by 10%");
                    }
                }
                else
                    System.out.println("Not applicable. No owned properties.");
            }
            else if(nIndex == 3 || nIndex == 4){//For
                int nUserInput = 0;
                boolean isValid = false;
                //Loops through properties to check if player has property of applicable type
                ArrayList<Integer> tempArr = new ArrayList<Integer>(player.getProperties().size());
                for(int i = 0; i < player.getProperties().size();i++)
                    if(player.getProperties().get(i).getLandType().equals("utility") || player.getProperties().get(i).getLandType().equals("railroad")){
                        isValid = true;
                        tempArr.add(i);
                    }
                if(isValid){
                    for(int i = 0; i < tempArr.size(); i++)//Display possible utilities/railroads to add effect
                        System.out.println(i + "." + player.getProperties().get(tempArr.get(i)).getName());
                    Scanner sc = new Scanner(System.in);
                    nUserInput = sc.nextInt();

                    if(nIndex == 3){//Decrease by 10%
                        player.getProperties().get(nUserInput).setMultiplier(.9);
                        System.out.println("Rent of " +player.getProperties().get(nUserInput).getName()+ " decreased by 10%");
                    }
                    else if(nIndex == 4){//Increase by 10%
                        player.getProperties().get(nUserInput).setMultiplier(1.1);
                        System.out.println("Rent of " +player.getProperties().get(nUserInput).getName()+ " increased by 10%");
                    }
                }
                else
                    System.out.println("Not applicable. No owned utilities or railroads.");
            }
        }
        else if(nGroup == 5){//Pay for community development/tax (Random amount)
            int[] arrChoices = {50,100,150};
            Random rand = new Random();
            int value = rand.nextInt(3);
            System.out.println(strDescription + arrChoices[value]);
            if(player.getMoney() - arrChoices[value] < 0){//If player can't pay then he gives all he has and loses
                gameBoard.setIsWin(true);
                gameBoard.getBank().receiveMoney(player.getMoney());
                player.giveMoney(player.getMoney());
            }
            else{
                gameBoard.getBank().receiveMoney(arrChoices[value]);
                player.giveMoney(arrChoices[value]);
            }

        }

    }
}
