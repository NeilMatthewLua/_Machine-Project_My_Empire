import java.util.ArrayList;

/**
 * Property class which inherits from Land and is used for making property objects inside the board
 *
 *  New Changes Made: Adjustments for new design
 *
 *  Last Changes Made: Call the setRentCollected method in getRent()
 *
 *   @author  Lua & Tanting
 *   @version 1.1
 */
public class Property extends Land {
    private String strColor;
    private double[] arrAttributes;
    private int nDevelopment;
    private double dFootTraffic;
    private double dRentCollected;
    private ArrayList<Card> cardMultipliers;
    private Player owner;

    /**
     * Creates a property subclass which inherits from Land
     * @param strName       String name of the property
     * @param strColor      String color of the property
     * @param arrAttributes Array of attributes of the property
     */
    public Property(String strName, String strColor, double[] arrAttributes) {
        super(strName);
        this.strColor = strColor;
        this.arrAttributes = new double[9];
        this.arrAttributes = arrAttributes;
        nDevelopment = 0;
        dRentCollected = 0;
        dFootTraffic = 0;
    }

    /**
     * Gets the price to buy the property
     * @return price of the property
     */
    public double getPrice(){
        return arrAttributes[0];
    }

    public Player getOwner(){
        return owner;
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

    public ArrayList<Card> getCardMultipliers(){
        return cardMultipliers;
    }

    public void setOwner(Player player){
        this.owner = player;
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

    public String triggerEvent(GameBoard gameBoard, Player player){
        int nCounter = 0;
        double dRent = 0;
        for(int i = 0; i < owner.getProperties().size();i++){
            //Count the number of properties of the same color owned by player
            if(owner.getProperties().get(i) instanceof Property){
                if(this.strColor.equals(((Property) owner.getProperties().get(i)).getColor()))
                    nCounter++;
            }
        }
        if(nCounter == 2)
            dRent += 10;
        else if(nCounter == 3)
            dRent += 20;
        dRent += arrAttributes[nDevelopment + 2]; //Add development level
        double multiplier = 1;
        //TODO Implement Card Multipliers
        for(int i = 0; i < cardMultipliers.size();i++){
            //if()
        }
        dRent *= multiplier;

        this.setRentCollected(dRent); //Updates the rent collected tracker

        String event = "";
        double dAmount = player.getMoney();
        if(player.giveMoney(owner, dRent) == true){
            event += player.getName() + "paid " + dRent + "to " + owner.getName() + ".";
        }
        else{
            event += player.getName() + "paid " + dRent + "to " + owner.getName() + ". ";
            event += player.getName() + "is now bankrupt.";
        }
        return event;
    }


}