
package Model;
 
 import java.util.Random;

 /**
 * Card subclass which contains cards from group 4. This includes
 * the go to jail card or take a trip to property card.
 */


public class CardSet_4 extends Card{

    public CardSet_4(int nIndex,int nGroup, boolean canKeep, String[][] list){
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
        //gets the index of the card to navigate through its set
        int nIndex = player.getCards().get(player.getCards().size() - 1).getIndex(); 

        //Trip to jail, no money on start
        if(nIndex == 0){
            while(player.getPosition() != 16){
                player.setPosition(1);//Player moves one space
                if (gameBoard.getLand().get(player.getPosition()) instanceof Property)
                //If land is owned and is property type
                    if (((Property)gameBoard.getLand().get(player.getPosition())).getOwner() != null){
                        ((Property)gameBoard.getLand().get(player.getPosition())).addFootTraffic();
                    }
            }
        }
        //Trip to random property
        else if(nIndex == 1){
            Random rand = new Random();
            int nRandProperty = rand.nextInt(32);
            while(!(gameBoard.getLand().get(nRandProperty) instanceof Property)){//Loops until a property is found
                nRandProperty = rand.nextInt(32);
            }
            //While player has not landed on property
            while(player.getPosition() != nRandProperty){
                //Player moves one space
                player.setPosition(1);
                if(player.getPosition() == 0){
                    event += ((Start)gameBoard.getLand().get(player.getPosition())).triggerEvent(gameBoard, player);

                }
                if (gameBoard.getLand().get(player.getPosition()) instanceof Property)
                     //If land is owned and is property type
                    if (((Property)gameBoard.getLand().get(player.getPosition())).getOwner() != null){
                        ((Property)gameBoard.getLand().get(player.getPosition())).addFootTraffic();
                    }
            }

        }

        //put used card into card discarded pile
        gameBoard.addCardDiscard(player.getCards().get(player.getCards().size() - 1)); 
        //remove from the player's hand
        player.getCards().remove(player.getCards().size() - 1); 
        return event;
    }
}