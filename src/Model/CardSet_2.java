
package Model;

import java.util.Random;

/**
 * Card subclass which contains cards from group 2. This includes the
 * proceed to property, proceed to utility, and proceed to railroad cards.
 */

public class CardSet_2 extends Card{

    public CardSet_2(int nIndex,int nGroup, boolean canKeep, String[][] list){
        super(nIndex, nGroup, canKeep, list);
    }

    /**
     * Abstracted method that triggers the effects of each card
     * @param player    player who got the card
     * @param gameBoard GameBoard where the Players are playing on
     * @return string which contains the details of the event
     */
    @Override
    public String useCard(Player player, GameBoard gameBoard){
        String event = "";
        //gets the index of the card to navigate through its set
        int nIndex = player.getCards().get(player.getCards().size() - 1).getIndex(); 
        //Travel to a random property
        if(nIndex == 0){
            //Checks of it's a random property
            Random rand = new Random();
            int nRandProperty = rand.nextInt(32);
            //Loops until a property is found
            while(!(gameBoard.getLand().get(nRandProperty) instanceof Property)){
                nRandProperty = rand.nextInt(32);
            }

            //While player has not landed on property
            while(player.getPosition() != nRandProperty){
                player.setPosition(1);//Player moves one space
                if (gameBoard.getLand().get(player.getPosition()) instanceof Property)
                 //If land is owned and is property class
                    if (((Property)gameBoard.getLand().get(player.getPosition())).getOwner() != null){
                        ((Property)gameBoard.getLand().get(player.getPosition())).addFootTraffic();
                    }
            }

            event += player.getName() + " landed on " + gameBoard.getLand().get(player.getPosition()).getName() + "\n";
        }
        //Travel to closest utility
        else if (nIndex == 1) {
            //Loops until a utility is found
            while(!(gameBoard.getLand().get(player.getPosition()) instanceof Utility)) {
                player.setPosition(1);

                //the bank shells out 200$
                if(player.getPosition() == 0){
                    event += ((Start)gameBoard.getLand().get(player.getPosition())).triggerEvent(gameBoard, player);
                }

                if (gameBoard.getLand().get(player.getPosition()) instanceof Property)
                //If land is owned and is Property
                    if (((Property)gameBoard.getLand().get(player.getPosition())).getOwner() != null){
                        ((Property)gameBoard.getLand().get(player.getPosition())).addFootTraffic();
                    }
            }
            event += player.getName() + " landed on " + gameBoard.getLand().get(player.getPosition()).getName() + "\n";
        }
        //Travel to closest railroad
        else if (nIndex == 2) {

            //Loops until a utility is found
            while(!(gameBoard.getLand().get(player.getPosition()) instanceof Railroad)) {
                player.setPosition(1);

                //the bank shells out 200$
                if(player.getPosition() == 0){
                    event += ((Start)gameBoard.getLand().get(player.getPosition())).triggerEvent(gameBoard, player);
                }

                if(gameBoard.getLand().get(player.getPosition()) instanceof Property) {
                    //If land is owned and is Property
                    if (((Property)gameBoard.getLand().get(player.getPosition())).getOwner() != null)
                        ((Property)gameBoard.getLand().get(player.getPosition())).addFootTraffic();
                }
            }

            event += player.getName() + " landed on " + gameBoard.getLand().get(player.getPosition()).getName() + "\n";

        }

        //put used card into card discarded pile
        gameBoard.addCardDiscard(player.getCards().get(player.getCards().size() - 1)); 
        //remove from the player's hand
        player.getCards().remove(player.getCards().size() - 1); 
        return event;
    }

}