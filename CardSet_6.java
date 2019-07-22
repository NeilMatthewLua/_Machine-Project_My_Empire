public abstract class CardSet_6 extends Card{

    public CardSet_6(int nIndex,int nGroup, boolean canKeep, String[][] list){
        super(nIndex, nGroup, canKeep, list);
    }

    @Override
    public String useCard(Player player, Gameboard gameboard){
        String event = "";
        int nIndex = player.getCards().get(player.getCards().size() - 1).getIndex(); //gets the index of the card to navigate through its set

        int[] arrChoices = {50,100,150};
        Random rand = new Random();
        int value = rand.nextInt(3);
        event += strDescription + " " + arrChoices[value];
    if(gameBoard.getBank(), player.giveMoney(arrChoices[value])){//If player can't pay then he gives all he has and loses
        event += player.getName() + " pays $" + arrChoices[value] + " to: Bank" + "\n";
    }
    else{
        event += player.getName() + " pays $" + temp + " to: Bank" + "\n";
        event += player.getName() + " is now bankrupt. Game is over.";
        gameBoard.setIsWin(true);
    }


        return event;
    }
}