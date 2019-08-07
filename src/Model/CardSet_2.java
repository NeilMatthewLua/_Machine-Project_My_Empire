/**
 * Card subclass which contains cards from group 2. This includes the
 * proceed to property, proceed to utility, and proceed to railroad cards.
 *
 *  New Changes Made: Fixed Bugs

 *  Last Changes Made: Created this subclass
 *   @author  Lua and Tanting
 *   @version 1.7
 */

package Model;

import java.util.Random;

public class CardSet_2 extends Card{

    public CardSet_2(int nIndex,int nGroup, boolean canKeep, String[][] list){
        super(nIndex, nGroup, canKeep, list);
    }

    /**
     * Abstracted method that triggers the effects of each card
     * @param player    player who got the card
     * @param gameBoard the gameboard
     * @return string which contains the details of the event
     */
    @Override
    public String useCard(Player player, GameBoard gameBoard){
        String event = "";
        int nIndex = player.getCards().get(player.getCards().size() - 1).getIndex(); //gets the index of the card to navigate through its set

        if(nIndex == 0){//Travel to a random property

            //CHECKS IF PROPERTY SUBCLASS
            Random rand = new Random();
            int nRandProperty = rand.nextInt(32);
            while(!(gameBoard.getLand().get(nRandProperty) instanceof Property)){//Loops until a property is found
                nRandProperty = rand.nextInt(32);
            }

            while(player.getPosition() != nRandProperty){//While player has not landed on property
                player.setPosition(1);//Player moves one space
                if (gameBoard.getLand().get(player.getPosition()) instanceof Property)
                    if (((Property)gameBoard.getLand().get(player.getPosition())).getOwner() != null){
                        //If land is owned and is property class
                        ((Property)gameBoard.getLand().get(player.getPosition())).addFootTraffic();
                    }
            }

            event += player.getName() + " landed on " + gameBoard.getLand().get(player.getPosition()).getName() + "\n";
        }
        else if (nIndex == 1) {//Travel to closest utility
            while(!(gameBoard.getLand().get(player.getPosition()) instanceof Utility)) {//Loops until a utility is found
                player.setPosition(1);

                if(player.getPosition() == 0){
                    //the bank shells out 200$
                    event += ((Start)gameBoard.getLand().get(player.getPosition())).triggerEvent(gameBoard, player);
                }

                if (gameBoard.getLand().get(player.getPosition()) instanceof Property)
                    if (((Property)gameBoard.getLand().get(player.getPosition())).getOwner() != null){
                        //If land is owned and is property type
                        ((Property)gameBoard.getLand().get(player.getPosition())).addFootTraffic();
                    }
            }
            event += player.getName() + " landed on " + gameBoard.getLand().get(player.getPosition()).getName() + "\n";
        }
        else if (nIndex == 2) {//Travel to closest railroad

            while(!(gameBoard.getLand().get(player.getPosition()) instanceof Railroad)) {//Loops until a utility is found
                player.setPosition(1);

                if(player.getPosition() == 0){
                    //the bank shells out 200$
                    event += ((Start)gameBoard.getLand().get(player.getPosition())).triggerEvent(gameBoard, player);
                }

                if(gameBoard.getLand().get(player.getPosition()) instanceof Property) {
                    if (((Property)gameBoard.getLand().get(player.getPosition())).getOwner() != null)
                        //If land is owned and is property type
                        ((Property)gameBoard.getLand().get(player.getPosition())).addFootTraffic();
                }
            }

            event += player.getName() + " landed on " + gameBoard.getLand().get(player.getPosition()).getName() + "\n";

        }

        gameBoard.addCardDiscard(player.getCards().get(player.getCards().size() - 1)); //put used card into card discarded pile
        player.getCards().remove(player.getCards().size() - 1); //remove from the player's hand
        System.out.println(event);
        return event;
    }

}