package Model;

import java.util.*;

/**
 * Card subclass which contains cards from group 5. This includes rent modifying cards such as:
     double rent, dilapidated houses, renovation, and increase/decrease the rent of utilities and railroads
 */


public class CardSet_5 extends Card{

    //multiplier that can be applied to a property
    private double multiplier; 

    public CardSet_5(int nIndex,int nGroup, boolean canKeep, String[][] list){
        super(nIndex, nGroup, canKeep, list);
        multiplier = 1;
    }

    /**
     * Getter for the multiplier value of a card
     * @return the multiplier of the card
     */
    public double getMultiplier(){
        return multiplier;
    }

    /**
     * Method that triggers the effects of each card (For Property)
     * @param player    player who got the card
     * @param gameBoard the gameboard
     * @return string which contains the details of the event
     */
    @Override
    public String useCard(Player player, GameBoard gameBoard) {
        String event = "";
        //gets the index of the card to navigate through its set
        int nIndex = player.getCards().get(player.getCards().size() - 1).getIndex(); 

        //For properties
        if (nIndex >= 0 && nIndex <= 2) {

            //Double Rent
            if (nIndex == 0) {
                //adds the multiplier card to the property
                multiplier = 2;
                //Adds this multiplier card to a Property's set of multipliers
                player.getChosen().getCardMultipliers().add(this);
                event += "Rent of " +  player.getChosen().getName() + " doubled for next collection.\n";
            }
            //Renovation
            else if (nIndex == 1) {
                 //Renovation price
                double dRenovation = 0;
                //Calculates price of renovation
                if (((Property)  player.getChosen()).getDevelopment() >= 1) {
                    //Checks if the Property already has a hotel
                    if ((((Property)  player.getChosen()).getDevelopment() )== 5) {
                        //Adds 50 if yes
                        dRenovation += 50;
                        //Adds 25 for every house owned
                        dRenovation += ((((Property)  player.getChosen()).getDevelopment()) - 1) * 25;
                    }
                    else
                    //Adds 25 for every house owned
                        dRenovation += (((Property)  player.getChosen()).getDevelopment()) * 25;
                }
                player.giveMoney(gameBoard.getBank(), dRenovation);
                multiplier = 1.5;
                player.getChosen().getCardMultipliers().add(this);
                event += "Rent of " + player.getChosen().getName() + " increased by 50%\n";
            }
            //Dilapidated Houses
            else if (nIndex == 2) {
                multiplier = 0.9;
                player.getChosen().getCardMultipliers().add(this);
                event += "Rent of " +  player.getChosen().getName() + " decreased by 10%\n";
            }
        }
        //For utilities / railroad
        else if(nIndex == 3 || nIndex == 4){

            //Decrease by 10%
            if(nIndex == 4){
                multiplier = 0.9;
                player.getChosen().getCardMultipliers().add(this);
                event += "Rent of " +  player.getChosen().getName()+ " decreased by 10%";
            }
            //Increase by 10%
            else if(nIndex == 3){
                multiplier = 1.1;
                player.getChosen().getCardMultipliers().add(this);
                event += "Rent of " +  player.getChosen().getName()+ " increased by 10%";
            }
        }
        player.getCards().remove(player.getCards().size() - 1); //remove from the player's hand
        return event;
    }
}