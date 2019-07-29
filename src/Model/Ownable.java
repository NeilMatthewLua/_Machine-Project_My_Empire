package Model;

public abstract class Ownable extends Land {

    private double dPrice;
    private Player owner;

    public Ownable(String strName,double dPrice){
        super(strName);
        this.dPrice = dPrice;
    }

    /**
     * Gets the price to buy the ownable space
     * @return price of the ownable space
     */
    public double getPrice(){
        return dPrice;
    }

    /**
     * Returns the owner of the ownable space
     * @return owner of the ownable space
     */
    public Player getOwner(){
        return owner;
    }

    /**
     * Sets the owner of the ownable space to parameter
     * @param owner the new owner of the property
     */
    public void setOwner(Player owner){
        this.owner = owner;
    }

}
