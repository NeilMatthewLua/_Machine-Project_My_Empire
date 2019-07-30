package Model;
import java.util.ArrayList;

/**
 * Property Class which is a subclass of land and is used as the property space on game board
 *
 *  New Changes Made: Adjustments for new design
 *
 *  Last Changes Made: Call the setRentCollected method in getRent()
 *
 *   @author  Lua & Tanting
 *   @version 1.1
 */
public class Property extends Ownable {
    private String strColor;
    private double[] arrAttributes;
    private int nDevelopment;
    private double dFootTraffic;
    private double dRentCollected;
    private ArrayList<Card> cardMultipliers;

    /**
     * Creates a property subclass which inherits from Land
     * @param strName       String name of the property
     * @param strColor      String color of the property
     * @param arrAttributes Array of attributes of the property
     */
    public Property(String strName, String strColor, double[] arrAttributes) {
        super(strName,arrAttributes[0]);
        this.strColor = strColor;
        this.arrAttributes = new double[9];
        this.arrAttributes = arrAttributes;
        cardMultipliers = new ArrayList<Card>();
        nDevelopment = 0;
        dRentCollected = 0;
        dFootTraffic = 0;
    }

    /**
     * Gets the color of the property
     * @return (String) color of the property
     */
    public String getColor() {
        return strColor;
    }

    /**
     * Gets the different attributes associated with the property
     * @return (double[]) of details regarding the property
     */
    public double[] getDetails() {
        return arrAttributes;
    }

    /**
     * Gets the development level of the property
     * @return development level of the property
     */
    public int getDevelopment() {
        return nDevelopment;
    }

    /**
     * Gets the foot traffic of the property
     * @return foot traffic of the property
     */
    public double getFootTraffic() {
        return dFootTraffic;
    }

    /**
     * Gets the amount of rent collected by the property
     */
    public double getRentCollected() {
        return dRentCollected;
    }


    /**
     * Adds development to property based on the parameter
     * @param n the value to add to property development
     */
    public void setDevelopment(int n){
        nDevelopment += n;
    }

    /**
     * Gets the array list of card multipliers currently on the property
     * @return ArrayList of Cards
     */
    public ArrayList<Card> getCardMultipliers(){
        return cardMultipliers;
    }

    /**
     * Adds an amount to the rent collected by the property based on the parameter
     * @param n the amount to be addded
     */
    public void setRentCollected(double n){
        dRentCollected += n;
    }

    /**
     * Increments footTraffic counter when player passes over property
     */
    public void addFootTraffic(){
        dFootTraffic += 1;
    }

    /**
     * Overridden method which prompts player to pay rent when stepped on
     * @param gameBoard instance of the game board
     * @param player the player which triggered the event
     * @return string which contains the details of the event
     */
    @Override
    public String triggerEvent(GameBoard gameBoard, Player player){
        int nCounter = 0;
        double dRent = 0;
        for(int i = 0; i < this.getOwner().getProperties().size();i++){
            //Count the number of properties of the same color owned by player
            if(this.getOwner().getProperties().get(i) instanceof Property){
                if(this.strColor.equals(((Property) this.getOwner().getProperties().get(i)).getColor()))
                    nCounter++;
            }
        }
        if(nCounter == 2)
            dRent += 10;
        else if(nCounter == 3)
            dRent += 20;
        dRent += arrAttributes[nDevelopment + 2]; //Add development level
        double multiplier = 1;
        for(int i = 0; i < cardMultipliers.size();i++){
            if(cardMultipliers.get(i) instanceof CardSet_5 && cardMultipliers.get(i).getIndex() == 0){//Remove double rent card
                multiplier *= 2;
                gameBoard.addCardDiscard(cardMultipliers.get(i)); // Add to discard pile
                cardMultipliers.remove(i); //Remove from property
            }
            else{
                multiplier *= ((CardSet_5)cardMultipliers.get(i)).getMultiplier();
            }
        }
        dRent *= multiplier;

        this.setRentCollected(dRent); //Updates the rent collected tracker

        String event = "";
        double dAmount = player.getMoney();
        if(player.giveMoney(this.getOwner(), dRent)){
            event += player.getName() + "paid " + dRent + " to " + this.getOwner().getName() + ".";
        }
        else{
            event += player.getName() + "paid " + dAmount + " to " + this.getOwner().getName() + ". ";
            event += player.getName() + "is now bankrupt.";
            gameBoard.setIsWin(true);
        }
        return event;
    }
}