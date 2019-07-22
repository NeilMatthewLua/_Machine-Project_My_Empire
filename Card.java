import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Card class which acts as a template for the cards that can be used during the game
 *
 *  New Changes Made: Fixed Bugs
 
 *  Last Changes Made: Seprarated Card class to subclasses
 
 *   @author  Lua and Tanting
 *   @version 1.6
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

        public int getIndex(){
            return this.nIndex;
        }
        
        public String getDescription(){
            return this.strDescription;
        }

        public boolean getCanKeep(){
            return this.canKeep;
        }    

        public abstract String useCard(Player player, Gameboard gameboard);
}
