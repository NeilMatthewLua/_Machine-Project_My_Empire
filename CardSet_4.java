/**
 * Card class which acts as a template for the cards that can be used during the game
 *
 *  New Changes Made: Fixed Bugs
 
 *  Last Changes Made: Created this subclass

 */

public abstract class CardSet_4 extends Card{

    public CardSet_4(int nIndex,int nGroup, boolean canKeep, String[][] list){
        super(nIndex, nGroup, canKeep, list);
    }

    @Override
    public String useCard(Player player, Gameboard gameboard){
    
        String event = "";
        int nIndex = player.getCards().get(player.getCards().size() - 1).getIndex(); //gets the index of the card to navigate through its set

        if(nIndex == 0){//Trip to jail, no money on start
            while(player.getPosition() != 24){
                player.setPosition(1);//Player moves one space
                if (gameBoard.getLand().get(player.getPosition()).getOwner() != null)
                    if(gameBoard.getLand().get(player.getPosition()) instanceof Property) {
                    //If land is owned and is property type
                        ((Property)gameBoard.getLand().get(player.getPosition())).addFootTraffic();
                }
            }
        }
        else if(nIndex == 1){//Trip to random property
            Random rand = new Random();
            int nRandProperty = rand.nextInt(32);
            while(!gameBoard.getLand().get(nRandProperty) instanceof Property){//Loops until a property is found
                nRandProperty = rand.nextInt(32);
            }
            while(player.getPosition() != nRandProperty){//While player has not landed on property
                player.setPosition(1);//Player moves one space
                if(player.getPosition() == 0){
double temp  = gameBoard.getBank().getMoney();
if(gameBoard.getBank().giveMoney(player, 200)){
    event += "Bank pays $"+ 200 +" to: " + player.getName();
}
else{//If bank can't pay
    event += "Bank pays $"+ temp +" to: " + player.getName() + "\n";
    event += "Bank is now bankrupt. Game is over.";
    gameBoard.setIsWin(true);
}
                }
                if (gameBoard.getLand().get(player.getPosition()).getOwner() != null)
                    if(gameBoard.getLand().get(player.getPosition()) instanceof Property) {
                    //If land is owned and is property type
                        ((Property)gameBoard.getLand().get(player.getPosition())).addFootTraffic();
                    }
            }

            if(!player.isMine(gameBoard)) { //checks if the current Player owns that piece of land
                if (gameBoard.getLand().get(player.getPosition()).getOwner() != null) //checks if the landed tile is owned by the current Player
                    event += ((Property)gameBoard.getLand().get((player.getPosition()))).triggerEvent(gameBoard, player); //collects rent from property
                else { //If not, checks if player is able to buy that title to the land
                        if(player.getMoney() >= ((Property)gameBoard.getLand().get((player.getPosition()))).getDetails()[0]) { //checks if the current player has sufficient funds before offering to buy that land
                            event += player.purchase(gameBoard);
                    }
                }
            }
            else { //this means the land tile is owned by the current Player
                event += player.trade(gameBoard);
            }
        }

        return event;
    }
}