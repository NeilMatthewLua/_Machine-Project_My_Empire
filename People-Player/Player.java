import java.util.ArrayList;
import People;

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
        //Properties temp;

        nRoll = (int)(Math.random() * (6 - 1) + 1 );
System.out.println(nRoll);

        for( int i = nPosition + 1 ; i <= nPosition + nRoll; i++ ) {
            if( i > 31 ) {
                this.nRoll -= i; 
                i = 0;
                this.nPosition = 0;
                this.dMoney += 200;

                //temp = properties.get(i);
                temp.addFootTraffic();
                //properties.set(i,temp);
            }
            else {
                //temp = properties.get(i);
                temp.addFootTraffic();
                //properties.set(i,temp);

                this.nPosition += 1;
            }
        }
    }
}