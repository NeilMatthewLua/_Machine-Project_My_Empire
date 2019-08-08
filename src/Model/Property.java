package Model;

/**
 * Property Class which is a subclass of land and is used as the property space on game board.
 * It also implements the IsRentable interface.
 */
public class Property extends Ownable implements IsRentable{
    //Contains the color of the Property
    private String strColor;
    //Double array which contains the details of the Property such as rent, development cost, etc.
    private double[] arrAttributes;
    //Contains the development level of the Property
    private int nDevelopment;
    //Contains the amount of foot traffic of the Property
    private double dFootTraffic;
    //Contains the amount of rent collected of the Property
    private double dRentCollected;

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
        nDevelopment = 0;
        dRentCollected = 0;
        dFootTraffic = 0;
    }

    /**
     * Getter for Property color
     * @return Property color
     */
    public String getColor() {
        return strColor;
    }

    /**
     * Getter for Property details
     * @return Property details
     */
    public double[] getDetails() {
        return arrAttributes;
    }

    /**
     * Getter for Property development level
     * @return Property development level
     */
    public int getDevelopment() {
        return nDevelopment;
    }

    /**
     * Getter for Property foot traffic
     * @return Property foot traffic
     */
    public double getFootTraffic() {
        return dFootTraffic;
    }

    /**
     * Getter for Property rent collected
     * @return Property rent collected
     */
    public double getRentCollected() {
        return dRentCollected;
    }


    /**
     * Adds development to Property based on the parameter
     * @param n the value to add to Property development
     */
    public void setDevelopment(int n){
        nDevelopment += n;
    }

    /**
     * Adds an amount to the rent collected by the Property based on the parameter
     * @param n the amount to be added to rent collected
     */
    public void setRentCollected(double n){
        dRentCollected += n;
    }

    /**
     * Increments footTraffic counter when Player passes over Property
     */
    public void addFootTraffic(){
        dFootTraffic += 1;
    }

    /**
     * Calculates the given rent of a Property
     * @param player the owner of the Property
     * @return the computed cost of the rent
     */
    public double getRent(Player player){
        //Counts the number of Properties of the same color the owner has
        int nCounter = 0;
        //Stores the value of the rent of the Property
        double dRent = 0;
        //Count the number of Properties of the same color of the owner
        for(int i = 0; i < this.getOwner().getProperties().size();i++){
            if(this.getOwner().getProperties().get(i) instanceof Property){
                if(this.strColor.equals(((Property) this.getOwner().getProperties().get(i)).getColor()))
                    nCounter++;
            }
        }
        //If the owner has two of the same color
        if(nCounter == 2)
            dRent += 10;
        //If the owner has three of the same color
        else if(nCounter == 3)
            dRent += 20;
        //Add the rent based off the development level
        dRent += arrAttributes[nDevelopment + 2];

        //The rent multiplier to be applied to rent
        double multiplier = 1;
        //Loops through the different Card multipliers
        for(int i = 0; i < getCardMultipliers().size();i++){
            if(getCardMultipliers().get(i) instanceof CardSet_5 && getCardMultipliers().get(i).getIndex() == 0){//Remove double rent card
                multiplier *= 2;
            }
            else{
                multiplier *= ((CardSet_5)getCardMultipliers().get(i)).getMultiplier();
            }
        }
        //Apply the multiplier to the rent
        dRent *= multiplier;

        return dRent;
    }

    /**
     * Overridden method which will prompt Player to pay rent when stepped on
     * @param gameBoard instance of GameBoard which contains the game elements
     * @param player the Player which triggered the event
     * @return string which contains the details of the event
     */
    @Override
    public String triggerEvent(GameBoard gameBoard, Player player){

        //Stores the calculated rent for the Property
        double dRent = getRent(this.getOwner());
        dRent = Math.round(dRent * 10) / 10;
        //Loop through the Card multipliers of the Property
        for(int i = 0; i < getCardMultipliers().size();i++){//Check cards for double rent to remove
            //If the Property has a double rent then remove it and return it to the discardPile in the gameBoard
            if(getCardMultipliers().get(i) instanceof CardSet_5 && getCardMultipliers().get(i).getIndex() == 0){
                //Add to gameBoard
                gameBoard.addCardDiscard(getCardMultipliers().get(i));
                //Remove from Property
                getCardMultipliers().remove(i);
                i--;
            }
        }
        //Updates the rent collected tracker
        this.setRentCollected(dRent);

        //String which contains event details
        String event = "";
        //Temporarily stores player money
        double dAmount = player.getMoney();
        //If player is able to pay
        if(player.giveMoney(this.getOwner(), dRent)){
            event += player.getName() + " paid " + dRent + " to " + this.getOwner().getName() + ".\n";
        }
        //If the player cannot pay
        else{
            event += player.getName() + " paid " + dAmount + " to " + this.getOwner().getName() + ".\n";
            event += player.getName() + " is now bankrupt.\n";
            //Game ends
            gameBoard.setIsWin(true);
        }
        //Returns summary of event
        return event;
    }
}