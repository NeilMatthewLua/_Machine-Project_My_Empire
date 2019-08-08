package Model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Card class which acts as a template for the cards that can be used during the game
 */
    public abstract class  Card {

         //Index of the card from the set
        private int nIndex;
        //Index of the group from the set of cards
        private int nGroup;
        //Boolean value to confirm if can/can not keep card
        private boolean canKeep;
        //Description of the card's effect
        private String strDescription;

        public Card(int nIndex,int nGroup, boolean canKeep, String[][] list){
            this.nIndex = nIndex;
            this.canKeep = canKeep;
            this.nGroup = nGroup;
            strDescription = list[nGroup][nIndex];
        }

        /**
         * Getter for the index of the card from the set
         * @return index of the card in its card group
         */
        public int getIndex(){
            return this.nIndex;
        }

        /**
         * Getter for the card group of the card from the set
         * @return index of the card group of the card
         */
        public int getGroup(){
            return this.nGroup;
        }

        /**
         * Getter for the description of the card
         * @return description of the card
         */
        public String getDescription(){
            return this.strDescription;
        }

        /**
         * Getter for the value whether or not player can keep the card
         * @return boolean value determining canKeep or not
         */
        public boolean getCanKeep(){
            return this.canKeep;
        }

        /**
         * Abstracted method that triggers the effects of each card
         * @param player    player who got the card
         * @param gameBoard the gameboard
         * @return string which contains the details of the event
         */
        public abstract String useCard(Player player, GameBoard gameBoard);
}
