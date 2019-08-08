package Model;

/**
 * Card subclass which contains cards from group 3. This includes
 * various payments from the bank to the player or vice versa.
 */

public class CardSet_3 extends Card{

    public CardSet_3(int nIndex,int nGroup, boolean canKeep, String[][] list){
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
        double dPayment = 0;
        //temprarily holds the current money of the bank in the event bank goes bankrupt
        double temp  = gameBoard.getBank().getMoney();
        String event = "";
        //gets the index of the card to navigate through its set
        int nIndex = player.getCards().get(player.getCards().size() - 1).getIndex(); 

        //Does the transactions depending on the card description value
        if(nIndex == 0) {
            dPayment = 50;
        }
        else if (nIndex == 1) {
            dPayment = 100;
        }
        else if (nIndex == 2) {
            //Brings the Player to Start
            while(!(gameBoard.getLand().get(player.getPosition()) instanceof Start)){
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
            //If bank can't pay
            else{
                event += "Bank pays $"+ temp +" to: " + player.getName() + "\n";
                event += "Bank is now bankrupt. Game is over.";
                gameBoard.setIsWin(true);
            }
        }

        //put used card into card discarded pile
        gameBoard.addCardDiscard(player.getCards().get(player.getCards().size() - 1)); 
        //remove from the player's hand
        player.getCards().remove(player.getCards().size() - 1); 
        return event;
    }
}