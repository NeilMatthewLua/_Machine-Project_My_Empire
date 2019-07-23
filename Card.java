import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Card class which acts as a template for the cards that can be used during the game
 *
 *  New Changes Made: Fixed Bugs (Again)
 
 *  Last Changes Made: Fixed Bugs
 
 *   @author  Lua and Tanting
 *   @version 1.7
 */
    public abstract class Card {

        private int nIndex; //Index of the card from the set
        private boolean canKeep;
        private String strDescription;

        public Card(int nIndex,int nGroup, boolean canKeep, String[][] list){
            this.nIndex = nIndex;
            this.canKeep = canKeep;
            strDescription = list[nGroup][nIndex];
        }

        /**
         * Returns the index of the card from the set
         * @return index of the card
         */
        public int getIndex(){
            return this.nIndex;
        }

        /**
         * Returns the description of the card
         * @return description of the card
         */
        public String getDescription(){
            return this.strDescription;
        }

        /**
         * Returns the value whether or not player can keep the card
         * @return boolean value determining canKeep or not
         */
        public boolean getCanKeep(){
            return this.canKeep;
        }

        /**
         * Abstracted method that triggers the effects of each card
         * @param player    player who got the card
         * @param gameBoard the gameboard
         * @return
         */
        public abstract String useCard(Player player, GameBoard gameBoard);
}
