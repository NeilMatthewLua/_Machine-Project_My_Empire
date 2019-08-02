package Model;

import java.util.ArrayList;

public abstract class Ownable extends Land {

    private double dPrice;
    private Player owner;
    private ArrayList<Card> cardMultipliers;


    public Ownable(String strName,double dPrice){
        super(strName);
        cardMultipliers = new ArrayList<Card>();
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
     * Gets the array list of card multipliers currently on the property
     * @return ArrayList of Cards
     */
    public ArrayList<Card> getCardMultipliers(){
        return cardMultipliers;
    }

    /**
     * Sets the owner of the ownable space to parameter
     * @param owner the new owner of the property
     */
    public void setOwner(Player owner){
        this.owner = owner;
    }

}
