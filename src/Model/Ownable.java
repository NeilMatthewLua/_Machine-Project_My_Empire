package Model;

import java.util.ArrayList;

/**
 * Ownable class is a subclass of land and are spaces which can be owned by the player.
 */

public abstract class Ownable extends Land {

    //Price of the Ownable
    private double dPrice;
    //Player owner of the Ownable
    private Player owner;
    //ArrayList<Card> of card multipliers applied to the Ownable
    private ArrayList<Card> cardMultipliers;


    public Ownable(String strName,double dPrice){
        super(strName);
        cardMultipliers = new ArrayList<Card>();
        this.dPrice = dPrice;
    }

    /**
     * Gets the price to buy the Ownable space
     * @return Ownable price
     */
    public double getPrice(){
        return dPrice;
    }

    /**
     * Returns the owner of Ownable
     * @return Ownable price
     */
    public Player getOwner(){
        return owner;
    }


    /**
     * Gets the array list of card multipliers on Ownable
     * @return Ownable ArrayList Card multipliers
     */
    public ArrayList<Card> getCardMultipliers(){
        return cardMultipliers;
    }

    /**
     * Setter of the People owner
     * @param owner the Player owner of the Property
     */
    public void setOwner(Player owner){
        this.owner = owner;
    }

}
