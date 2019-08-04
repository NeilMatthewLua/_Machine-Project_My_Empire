package Model;
/**
 * Card subclass which contains cards from group 3. This includes
 * various payments from the bank to the player or vice versa.
 *
 *  New Changes Made: Fixed Bugs
 *
 *  Last Changes Made: Created this subclass
 *
 *   @author  Lua and Tanting
 *   @version 1.7
 */

public class CardSet_3 extends Card{

    public CardSet_3(int nIndex,int nGroup, boolean canKeep, String[][] list){
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
        double dPayment = 0;
        double temp  = gameBoard.getBank().getMoney();
        String event = "";
        int nIndex = player.getCards().get(player.getCards().size() - 1).getIndex(); //gets the index of the card to navigate through its set

        if(nIndex == 0) {
            dPayment = 50;
        }
        else if (nIndex == 1) {
            dPayment = 100;
        }
        else if (nIndex == 2) {
            while(!(gameBoard.getLand().get(player.getPosition()) instanceof Start)){
                System.out.println(gameBoard.getLand().get(player.getPosition()));
                player.setPosition(1);
            }
            event += gameBoard.getLand().get((player.getPosition())).triggerEvent(gameBoard,player);
        }
        else if (nIndex == 3) {
            dPayment = 300;
        }
        else if (nIndex == 4) {
            dPayment = 150;
        }
        if(nIndex != 2){
            if(gameBoard.getBank().giveMoney(player, dPayment)){
                event += "Bank pays $"+ dPayment +" to: " + player.getName() + "\n";
            }
            else{//If bank can't pay
                event += "Bank pays $"+ temp +" to: " + player.getName() + "\n";
                event += "Bank is now bankrupt. Game is over.";
                gameBoard.setIsWin(true);
            }
        }

        gameBoard.addCardDiscard(player.getCards().get(player.getCards().size() - 1)); //put used card into card discarded pile
        player.getCards().remove(player.getCards().size() - 1); //remove from the player's hand
        return event;
    }
}