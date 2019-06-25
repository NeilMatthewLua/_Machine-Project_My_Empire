/**
 * Player Class
 *    
 *      New Changes:        public isMine()
                            added isMind on UML
                            public void action()
                                - 1/2 Switch Case, Determines if Tax Tile, Chance Tile, Rairoad, or Start Tile
                                -1/2 Determines if property tile is yours or theirs or free for buying              
 * 
        Last Changes Made:  public Player(String strName)
                            public int getPosition()
                            public Card getCard() 
                            public Property getProperty()
                            public void roll()
   
 * Version 1.01
 */

import java.util.ArrayList;

public class Player extends People{

    ////private ArrayList<Property> properties;
    //private ArrayList<Card> cards;
    private int nPosition;
    private int nDiceRoll;

    /**
     * This constructor creats a new Player
     */
    public Player(String strName) {
        super(strName, false);
        ////this.properties = new ArrayList<Property>();
        //this.cards = new ArrayList<card>();
        this.nPosition = 0;
        this.nDiceRoll = 0;
    }

    public int getPosition() {
        return this.nPosition;
    }

    
    //public  Card getCard() {
        //if(!cards.isEmpty())
            //return this.cards.get(0);
    //}

    //public Property getProperty() {
        //return this.properties;
    //}
    

    public void roll() {
        int nRoll;
        this.nPosition = 29;
        int start = this.nPosition;
        //Properties temp;
        nRoll = (int)((Math.random() * (7 - 1)) + 1 );

        for( int i = start + 1 ; i <= start + nRoll; i++ ) {

             if( i > 31 ) {
                nRoll = nRoll + start -i; 
                i = 0;
                this.nPosition = 0;
                start = 0;
                this.dMoney += 200;
                //temp = properties.get(i);
                //temp.addFootTraffic();
                //properties.set(i,temp);
            }
            else {
                //temp = properties.get(i);
                //temp.addFootTraffic();
                //properties.set(i,temp);
                this.nPosition += 1;
            }
        }

        action();
    }

    public void action() {
        switch(gameBoard.getLand().get(this.nPosition).getLandType()) {
            case "railroad":
            case "income":
            case "utility": Land.triggerEvent(this, gameboard); break;
            case "property": {
                if(!isMine) {
//Method need here for check if someone owns it
                    Land.triggerEvent(this, gameboard); break;
                }
                else {

                }

            } 

        }
    }

    public boolean isMine() {
        return this.properties.contains(gameBoard.getLand().get(this.nPosition));
    }

}