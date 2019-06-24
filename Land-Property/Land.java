import java.util.ArrayList;
import java.util.Collections;

/**
 * Land class which acts as a template for the different places found on the board
 *   @author  Lua & Tanting
 *   @version 1.0
 */
public class Land {
    private String strName;
    private String strLandType;
    private double dPrice;
    private Player owner;
    private double dMultiplier;
    /**
     * Creates a land object with name and land type.
     * @param strName This contains the name of the land
     * @param strLandType Land can be one of the following:
     property, railroad, utility, chance, luxury, income or corner
     */
    public Land(String strName, String strLandType){
        this.strName  = strName;
        this.strLandType = strLandType;
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
     * @return (String) name of the land
     */
    public String getName() {
        return strName;
    }

    /**
     * Gets land type of the land
     * @return (String) land type of the land
     */
    public String getLandType() {
        return strLandType;
    }

    /**
     * Gets the price of the land
     * @return (double) price of the land
     */
    public double getPrice() {
        return dPrice;
    }

    /**
     * Gets the owner of the land
     * @return (Player) that owns the land
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * Gets the rent multiplier for the land
     * @return (double) multiplier for land price
     */
    public double getMultiplier() {
        return dMultiplier;
    }

    /**
     * Adds foot traffic when players pass by, only exists to be overridden by property
     */
    public void addFootTraffic(){
    }

    /**
     * Determines event when player steps on land (only triggers when land is owned by other players or can't be owned (i.e. luxury, income, corners)
     * @param player player that stepped on the land
     * @param gameBoard is the game board which contains all the information about the game
     * @return (void)
     */
    public void triggerEvent(Player player, GameBoard gameBoard){
        double dPayment;
        if(strLandType.equals("property") || strLandType.equals("railroad") || strLandType.equals("utility")){
            //If land is property, railroad, or utility
            dPayment = getRent(player) * dMultiplier;
            if(player.getMoney() - dPayment >= 0)
                player.giveMoney(owner,dPayment);
            else
                gameBoard.setIsWin(false);
        }
        else if(strLandType.equals("luxury") || strLandType.equals("income")) {
            //If land is luxury or income tax space
            dPayment = getTax(player);
            if(player.getMoney() - dPayment >= 0)
                player.giveMoney(owner,dPayment);
            else
                gameBoard.setIsWin(false);
        }
        else if(strLandType.equals("chance")){
            //If land is chance space
            player.addCard(getChance(player,gameBoard.getCardPile(),gameBoard.getCardDiscard()));
            System.out.println("Player"  + player.getName() + "gets a card" );
        }
        else if (strLandType.equals("corner")){
            //If Land is a corner
            switch(player.getPosition()){
                case 8: //Community Service
                    System.out.println("Community Service, pay 50$.");
                    dPayment = 50;
                    if(player.getMoney() - dPayment >= 0)
                        player.giveMoney(owner,dPayment);
                    else
                        gameBoard.setIsWin(false);
                    break;
                case 16: //Free Parking
                    System.out.println("Free Parking! Wait for next turn.");
                    break;
                case 24: //Jail
                    System.out.println("Welcome to Jail. Pay 50$ at the start of your next turn");
                    break;
            }
        }
    }

    /**
     * Calculates the amount of rent to be paid on utility or railroad land
     * @return (double) the amount of rent to be paid
     */
    private double getRent(Player player){
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
        else if(strLandType.equals("utility")){ //If land is utility count, count number of land owner has
            for(int i = 0; i < owner.getProperties().size(); i++)
                if(owner.getProperties().get(i).getLandType().equals("utilities"))
                    nCounter++;
            switch(nCounter){//Calculations made based on owned properties and dice rolls
                case 1:
                    dRent = player.getDiceRoll()* 4;
                    break;
                case 2:
                    dRent = player.getDiceRoll() * 10;
                    break;
                default: break;
            }
        }
        return dRent;
    }

    /**
     * Calculates the tax on luxury or income tax land
     * @param player Player that will be paying the tax
     * @return (double) the tax amount to be paid
     */
    private double getTax(Player player){
        double dRent = 0;
        if(strLandType.equals("luxury"))
            dRent = 75;
        else if(strLandType.equals("income"))
            dRent = ((player.getMoney() * .10) >= 200) ? player.getMoney() * .10 : 200;
        return dRent;
    }

    /**
     * Gives player a card from the topmost card in cardPile
     * @param player Player which drew the card
     * @param cardPile CardPile where the player drew the card from
     * @return (Card) that the user got from the pile
     */
    private Card getChance(Player player, ArrayList<Card> cardPile, ArrayList<Card> discardPile){
        Card temp = cardPile.get(cardPile.size()-1); //Remove topmost card in cardPile
        cardPile.remove(cardPile.size()-1);
        if(cardPile.size() == 0) //If cardPile is empty then shuffle discardPile into cardPile
            for(int i = 0; i < discardPile.size(); i++){
                cardPile.add(discardPile.get(0));
                discardPile.remove(0);
            }
        Collections.shuffle(cardPile);
        return temp;
    }

}
