/**
 * Card class which acts as a template for the cards that can be used during the game
 *
 *  New Changes Made: Fixed Bugs

 *  Last Changes Made: Created this subclass

 */

package Model;

import java.util.*;

public class CardSet_5 extends Card{

    private double multiplier; //multiplier that can be applied to a property

    public CardSet_5(int nIndex,int nGroup, boolean canKeep, String[][] list){
        super(nIndex, nGroup, canKeep, list);
        multiplier = 1;
    }

    /**
     * Returns the multiplier value of a card
     * @return the multiplier of the card
     */
    public double getMultiplier(){
        return multiplier;
    }


    /**
     * Finds the index of the ownable from the player's ownables
     * @param player player whose properties will be checked
     * @return index of the property inside the player's properties
     */
    public int findIndex(Player player, Ownable chosen) {
        for( int i = 0; i <  player.getProperties().size(); i++) {
                if(player.getProperties().get(i).getName().equalsIgnoreCase(chosen.getName())) {
                    return i;
                }
        }
        return 0;
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
        int nChosenIndex = 0;
        int nIndex = player.getCards().get(player.getCards().size() - 1).getIndex(); //gets the index of the card to navigate through its set

        //gets the index of the chosen tile from the player's Ownable tiles
        if (player.getChosen() instanceof Property)
            nChosenIndex = findIndex(player, player.getChosen());
        else if (player.getChosen() instanceof Utility)
            nChosenIndex = findIndex(player, player.getChosen());
        else if (player.getChosen() instanceof Railroad)
            nChosenIndex = findIndex(player, player.getChosen());

        if (nIndex >= 0 && nIndex <= 2) {//For properties

            if (nIndex == 0) {//Double Rent
                multiplier = 2;
                //adds the multiplier card to the property
                player.getProperties().get(nChosenIndex).getCardMultipliers().add(this);
                event += "Rent of " + player.getProperties().get(nChosenIndex).getName() + " doubled for next collection.\n";
            }
            else if (nIndex == 1) {//Renovation
                double dRenovation = 0; //Renovation price
                if (((Property) player.getProperties().get(nChosenIndex)).getDevelopment() >= 1) {//Calculates price of renovation
                    if (((Property) player.getProperties().get(nChosenIndex)).getDevelopment() == 5) {
                        dRenovation += 50;
                        dRenovation += (((Property) player.getProperties().get(nChosenIndex)).getDevelopment() - 1) * 25;
                    }
                    else
                        dRenovation += ((Property) player.getProperties().get(nChosenIndex)).getDevelopment() * 25;
                }

                player.giveMoney(gameBoard.getBank(), dRenovation);
                multiplier = 1.5;
                player.getProperties().get(nChosenIndex).getCardMultipliers().add(this);
                event += "Rent of " + player.getProperties().get(nChosenIndex).getName() + " increased by 50%\n";
            }
            else if (nIndex == 2) {//Dilapidated Houses
                multiplier = 0.9;
                 player.getProperties().get(nChosenIndex).getCardMultipliers().add(this);
                event += "Rent of " + player.getProperties().get(nChosenIndex).getName() + " decreased by 10%";
            }
        }
        else if(nIndex == 3 || nIndex == 4){//For utilities / railroad

            if(nIndex == 3){//Decrease by 10%
                multiplier = 0.9;
                event += "Rent of " +player.getProperties().get(nChosenIndex).getName()+ " decreased by 10%";
            }
            else if(nIndex == 4){//Increase by 10%
                multiplier = 1.1;
                 player.getProperties().get(nChosenIndex).getCardMultipliers().add(this);
                event += "Rent of " +player.getProperties().get(nChosenIndex).getName()+ " increased by 10%";
            }
        }

        player.getCards().remove(player.getCards().size() - 1); //remove from the player's hand
        return event;
    }
}