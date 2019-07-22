public abstract class CardSet_3 extends Card{

    public CardSet_3(int nIndex,int nGroup, boolean canKeep, String[][] list){
        super(nIndex, nGroup, canKeep, list);
    }

    @Override
    public String useCard(Player player, Gameboard gameboard){
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
        if(gameBoard.getBank().giveMoney(dPayment)){
            event += "Bank pays $"+ dPayment +" to: " + player.getName();
        }
        else{//If bank can't pay
            event += "Bank pays $"+ temp +" to: " + player.getName() + "\n";
            event += "Bank is now bankrupt. Game is over.";
            gameBoard.setIsWin(true);
        }

        return event;
    }
}