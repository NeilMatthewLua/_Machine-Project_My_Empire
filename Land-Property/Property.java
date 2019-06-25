/**
 * Property class which inherits from Land and is used for making property objects inside the board
 *
 *  New Changes Made: N/A
 *
 *  Last Changes Made: N/A
 *
 *   @author  Lua & Tanting
 *   @version 1.0
 */
public class Property extends Land {
    private String strColor;
    private double[] arrAttributes;
    private int nDevelopment;
    boolean doubleRent;
    private double dFootTraffic;
    private double dRentCollected;

    /**
     * Creates a property subclass which inherits from Land
     * @param strName       String name of the property
     * @param strColor      String color of the property
     * @param arrAttributes Array of attributes of the property
     */
    public Property(String strName, String strColor, double[] arrAttributes) {
        super(strName, "property",arrAttributes[0]);
        this.strColor = strColor;
        this.arrAttributes = new double[9];
        this.arrAttributes = arrAttributes;
        nDevelopment = 0;
        dRentCollected = 0;
        dFootTraffic = 0;
        doubleRent = false;
    }

    /**
     * Gets the price to buy the property
     * @return price of the property
     */
    @Override
    public double getPrice(){
        return arrAttributes[0];
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
     * @return (int) development level of the property
     */
    public int getDevelopment() {
        return nDevelopment;
    }

    /**
     * Gets the foot traffic of the property
     * @return (double) foot traffic of the property
     */
    public double getFootTraffic() {
        return dFootTraffic;
    }

    /**
     * Gets the amount of rent collected by the property
     * @return (double) amount of rent collected by property
     */
    public double getRentCollected() {
        return dRentCollected;
    }

    /**
     * Changes the variable whether if a double rent card is applied
     * @param val value to set the doubleRent variable to
     */
    public void setDoubleRent(boolean val){
        doubleRent = val;
    }
    /**
     * Similar to the getRent() function of parent class land but computes differently for property land
     * @return (double) rent to be paid
     */
    private double getRent(){
        int nCounter = 0;
        double dRent = 0;
        for(int i = 0; i < getOwner().getProperties().size();i++){
            //Count the number of properties of the same color owned by player
            if(getLandType().equals(getOwner().getProperties().get(i).getLandType())){
                if(strColor.equals(getOwner().getProperties().get(i).strColor))
                    nCounter++;
            }
        }
        if(nCounter == 2)
            dRent += 10;
        else if(nCounter == 3)
            dRent += 20;
        dRent += arrAttributes[nDevelopment + 2]; //Add development level
        dRent *= getMultiplier(); //Multiply multipliers
        if(doubleRent){
            dRent *= 2;
            doubleRent = false;
        }
        return dRent;
    }

    /**
     * Increments footTraffic counter when player passes over property
     * return (void)
     */
    @Override
    public void addFootTraffic(){
        dFootTraffic += 1;
    }
}