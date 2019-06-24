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
System.out.println(nRoll);

        for( int i = start + 1 ; i <= start + nRoll; i++ ) {

             if( i > 31 ) {
                nRoll = nRoll + start -i; 
                i = 0;
                this.nPosition = 0;
                start = 0;
                this.dMoney += 200;
// System.out.println("TRUE");
// System.out.println( i);
// System.out.println( nRoll);
                //temp = properties.get(i);
                //temp.addFootTraffic();
                //properties.set(i,temp);
            }
            else {
                //temp = properties.get(i);
                //temp.addFootTraffic();
                //properties.set(i,temp);
System.out.println("D ");
                this.nPosition += 1;
            }
        }
    }
}