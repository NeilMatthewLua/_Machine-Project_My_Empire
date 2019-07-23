/**
 * Card class which acts as a template for the cards that can be used during the game
 *
 *  New Changes Made: Fixed Bugs
 
 *  Last Changes Made: Created this subclass

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
     * @return
     */
    @Override
    public String useCard(Player player, GameBoard gameBoard){
        String event = "";
        int nIndex = player.getCards().get(player.getCards().size() - 1).getIndex(); //gets the index of the card to navigate through its set

        if(nIndex == 0){

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

            if(!player.isMine(gameBoard)) { //checks if the current Player owns that piece of land
                if (((Property)gameBoard.getLand().get(player.getPosition())).getOwner() != null) //checks if the landed tile is owned by the current Player
                    event += (gameBoard.getLand().get((player.getPosition()))).triggerEvent(gameBoard, player); //collects rent from property
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
        else if (nIndex == 1) {
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

            if(((Utility)gameBoard.getLand().get(player.getPosition())).getOwner() != null) { //checks if the utility tile is owned by anyone
                if(!(player.isMine(gameBoard))) { //checks if you don't own it, you'll pay 10 times dice roll to the owner
                    Random rand = new Random();
                    int nRand = rand.nextInt(7);

                    double temp = player.getMoney();

                    if(player.giveMoney(((Utility)gameBoard.getLand().get(player.getPosition())).getOwner(), 10 * nRand)){
                        event += player.getName() + " pays $" + (10 * nRand) + " to: " + ((Utility)gameBoard.getLand().get(player.getPosition())).getOwner().getName();
                    }
                    else{//If player can't pay
                        event += player.getName() + " pays $" + temp + " to: " + ((Utility)gameBoard.getLand().get(player.getPosition())).getOwner().getName() + "\n";
                        event += player.getName() +" is now bankrupt. Game is over.";
                        gameBoard.setIsWin(true);
                    }
                }
            }
            else { //the utility tile is free to buy
                if(player.getMoney() >= ((Utility)gameBoard.getLand().get(player.getPosition())).getPrice()) { //checks if the current player has sufficient funds before offering to buy that land
                    player.purchase(gameBoard);
                }
            }
        }
        else if (nIndex == 2) {
            Random rand = new Random();
            int nRand = rand.nextInt(7);

            double temp = player.getMoney();

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

            if(((Railroad)gameBoard.getLand().get(player.getPosition())).getOwner() != null) { //checks if the Railroad tile is owned by anyone
                if(!(player.isMine(gameBoard))) { //checks if you don't own it, you'll pay rent to the owner
                    if(player.giveMoney(((Railroad)gameBoard.getLand().get(player.getPosition())).getOwner(), ((Railroad)gameBoard.getLand().get(player.getPosition())).getRent())){
                        event += player.getName() + " pays $" + (10 * nRand) + " to: " + ((Railroad)gameBoard.getLand().get(player.getPosition())).getOwner().getName();
                    }
                    else{//If player can't pay
                        event += player.getName() + " pays $" + temp + " to: " + ((Railroad)gameBoard.getLand().get(player.getPosition())).getOwner().getName() + "\n";
                        event += player.getName() +" is now bankrupt. Game is over.";
                        gameBoard.setIsWin(true);
                    }
                }

            }
            else { //the railroad tile is free to buy
                if(player.getMoney() >= ((Railroad)gameBoard.getLand().get(player.getPosition())).getPrice()) { //checks if the current player has sufficient funds before offering to buy that land
                    player.purchase(gameBoard);
                }
            }
            
        }

        gameBoard.addCardDiscard(player.getCards().get(player.getCards().size() - 1)); //put used card into card discarded pile
        player.getCards().remove(player.getCards().size() - 1); //remove from the player's hand
        return event;
    }

}