/**
 * Card class which acts as a template for the cards that can be used during the game
 *
 *  New Changes Made: Fixed Bugs
 
 *  Last Changes Made: Created this subclass

 */

public class CardSet_3 extends Card{

    public CardSet_3(int nIndex,int nGroup, boolean canKeep, String[][] list){
        super(nIndex, nGroup, canKeep, list);
    }

    /**
     * Abstracted method that triggers the effects of each card
     * @param player    player who got the card
     * @param gameBoard the gameboard
     * @return
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
            dPayment = 200;
        }
        else if (nIndex == 3) {
            dPayment = 300;
        }
        else if (nIndex == 4) {
            dPayment = 150;
        }
        if(gameBoard.getBank().giveMoney(player, dPayment)){
            event += "Bank pays $"+ dPayment +" to: " + player.getName();
        }
        else{//If bank can't pay
            event += "Bank pays $"+ temp +" to: " + player.getName() + "\n";
            event += "Bank is now bankrupt. Game is over.";
            gameBoard.setIsWin(true);
        }

        gameBoard.addCardDiscard(player.getCards().get(player.getCards().size() - 1)); //put used card into card discarded pile
        player.getCards().remove(player.getCards().size() - 1); //remove from the player's hand
        return event;
    }
}