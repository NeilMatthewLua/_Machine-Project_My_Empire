import java.util.ArrayList;
import java.util.Collections;

/**
 * Land class which acts as a template for the different places found on the board
 *
 *  New Changes Made: getRent() utilities -> utilities
 *
 *  Last Changes Made: Players can now use cards to get out of jail
 *
 *   @author  Lua & Tanting
 *   @version 1.2
 */
public class Land {
    private String strName;
    private String strLandType;
    private double dPrice;
    private Player owner;
    private double dMultiplier;
    /**
     * Creates a land object with name and land type. (Constructor for corners, luxury, and chance spaces)
     * @param strName This contains the name of the land
     * @param strLandType Land can be one of the following:
     property, railroad, utility, chance, luxury, income or corner
     */
    public Land(String strName, String strLandType){
        this.strName  = strName;
        this.strLandType = strLandType;
        owner = null;
        dMultiplier = 1;
    }

    /**
     * Creates a land object with name, land type, and price. (i.e. property, railroad, utility)
     * @param strName Name of the Land
     * @param strLandType Type of land
     * @param dPrice Price of the land
     */
    public Land(String strName, String strLandType, double dPrice){
        this.strName  = strName;
        this.strLandType = strLandType;
        this.dPrice = dPrice;
        dMultiplier = 1;
    }

    /**
     * Gets name of the land
     * @return name of the land
     */
    public String getName() {
        return strName;
    }

    /**
     * Gets land type of the land
     * @return land type of the land
     */
    public String getLandType() {
        return strLandType;
    }

    /**
     * Gets the price of the land
     * @return price of the land
     */
    public double getPrice() {
        return dPrice;
    }

    /**
     * Gets the owner of the land
     * @return that owns the land
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * Gets the rent multiplier for the land
     * @return multiplier for land price
     */
    public double getMultiplier() {
        return dMultiplier;
    }

    /**
     * Gets property details
     * @return nothing since only Property contains property details
     */
    public double[] getDetails(){
        return null;
    }

    /**
     * Gets the rent collected from the property;
     * @return nothing since only Property contains rentCollected attribute
     */
    public double getRentCollected(){
        return 0;
    }

    /**
     * Gets the foot traffic of the property
     * @return zero since normal land does not count foot traffic
     */
    public double getFootTraffic(){
        return 0;
    }

    /**
     * Gets the foot traffic of the property
     * @return null since normal land does not have a color
     */
    public String getColor(){
        return null;
    }

    /**
     * Gets development of land
     * @return 0 since normal land does not have a development level
     */
    public int getDevelopment(){
        return 0;
    }

    /**
     * Adds multiplier from parameter unto the multiplier of the rent for the land
     * @param multiplier is the multiplier percentage to stack
     */
    public void setMultiplier(double multiplier){
        dMultiplier *= multiplier;
    }

    /**
     * Sets development of land but method is empty as only Property can have development levels
     */
    public void setDevelopment(int n){
    }

    /**
     * Sets double rent of land but method is empty as only Property can have double rent
     */
    public void setDoubleRent(boolean val){
    }

    /**
     * Sets the owner of the property to specified player
     * @param player player which will now own the property
     */
    public void setOwner(Player player){
        owner = player;
    }

    /**
     * Only exists to be overridden by Property class
     */
    public void addFootTraffic(){
    }

    /**
     * Determines event when player steps on land (only triggers when land is owned by other players or can't be owned (i.e. luxury, income, corners)
     * @param player player that stepped on the land
     * @param gameBoard is the game board which contains all the information about the game
     */
    public void triggerEvent(Player player, GameBoard gameBoard){
        double dPayment;
        if(strLandType.equals("property") || strLandType.equals("railroad") || strLandType.equals("utility")){
            //If land is property, railroad, or utility
            dPayment = getRent(player) * dMultiplier;
            System.out.println("Payment for" + strLandType + "space is: $" + dPayment);
            if(player.getMoney() - dPayment >= 0){
                player.giveMoney(dPayment);
                owner.receiveMoney(dPayment);
                System.out.println(owner.getName() + "was given " + dPayment);
            }
            else{
                System.out.println("Game is over. " + player.getName() + " is bankrupt");
                gameBoard.setIsWin(false);
                owner.receiveMoney(player.getMoney());
                player.giveMoney(player.getMoney());
            }
        }
        else if(strLandType.equals("luxury") || strLandType.equals("income")) {
            //If land is luxury or income tax space
            dPayment = getTax(player);
            System.out.println("Payment for " + strLandType + " space is: $" + dPayment);
            if(player.getMoney() - dPayment >= 0){
                player.giveMoney(dPayment);
                gameBoard.getBank().receiveMoney(player.getMoney());
                System.out.println("Bank was given " + dPayment);
            }
            else{
                System.out.println("Game is over. " + player.getName() + " is bankrupt");
                gameBoard.setIsWin(false);
                gameBoard.getBank().receiveMoney(player.getMoney());
                player.giveMoney(player.getMoney());
            }
        }
        else if(strLandType.equals("chance")){
            //If land is chance space
            player.addCard(gameBoard.drawChance());
            System.out.println("Player"  + player.getName() + "gets a card. " + player.getCard().
                    get(player.getCard().size()-1).getDescription());
            if(player.getCard().get(player.getCard().size()-1).getCanKeep() == false) //If card can't be kept
                player.getCard().get(player.getCard().size()-1).useCard(player,gameBoard);

        }
        else if (strLandType.equals("corner")){
            //If Land is a corner
            switch(player.getPosition()){
                case 8: //Community Service
                    System.out.println("Community Service, pay 50$.");
                    dPayment = 50;
                    if(player.getMoney() - dPayment >= 0){
                        gameBoard.getBank().receiveMoney(dPayment);
                        player.giveMoney(dPayment);
                        System.out.println("Bank was given " + dPayment);
                    }
                    else{
                        System.out.println("Game is over. " + player.getName() + " is bankrupt");
                        gameBoard.setIsWin(false);
                        gameBoard.getBank().receiveMoney(player.getMoney());
                        player.giveMoney(player.getMoney());
                    }
                    break;
                case 16: //Free Parking
                    System.out.println("Free Parking! Wait for next turn.");
                    break;
                case 24: //Jail
                    System.out.println("Welcome to Jail. Pay 50$ at the start of your next turn");
                    if(player.getCard().size() > 0)
                    if(player.getCard().get(player.getCard().size()-1).getDescription().equals("Get out of jail free.")){
                        //If player has get out of jail car.
                        System.out.println("Get out of jail free card used");
                        player.getCard().get(player.getCard().size()-1).useCard(player,gameBoard);
                    }
                    else //Player will be fined next turn
                        player.setJail(true);
                    break;
            }
        }
    }

    /**
     * Calculates the amount of rent to be paid on utility or railroad land
     * @return the amount of rent to be paid
     */
    public double getRent(Player player){
        int nCounter = 0;
        double dRent = 0;
        if(strLandType.equals("railroad")){ //If land is railroad, count number of railroads owner has
            for(int i = 0; i < owner.getProperties().size(); i++)
                if(owner.getProperties().get(i).getLandType().equals("railroad"))
                    nCounter++;
            switch(nCounter) {//Calculations made based on no. of railroads owner has
                case 1:
                    dRent = 25;
                    break;
                case 2:
                    dRent = 50;
                    break;
                case 3:
                    dRent = 150;
                    break;
                default: break;
            }
        }
        else if(strLandType.equals("utility")) { //If land is utility count, count number of land owner has
            for (int i = 0; i < owner.getProperties().size(); i++)
                if (owner.getProperties().get(i).getLandType().equals("utility")) {
                    nCounter++;
                }
            switch (nCounter) {//Calculations made based on owned properties and dice rolls
                case 1:
                    dRent = player.getLastRoll() * 4;
                    break;
                case 2:
                    dRent = player.getLastRoll() * 10;
                    break;
                default:
                    break;
            }
        }
        return dRent;
    }

    /**
     * Calculates the tax on luxury or income tax land
     * @param player Player that will be paying the tax
     * @return the tax amount to be paid
     */
    private double getTax(Player player){
        double dRent = 0;
        if(strLandType.equals("luxury"))
            dRent = 75;
        else if(strLandType.equals("income"))
            dRent = ((player.getMoney() * .10) >= 200) ? player.getMoney() * .10 : 200;
        return dRent;
    }

}
