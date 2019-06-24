import java.util.ArrayList;

/**
 * Player class which inherits from People Class and is used for making the players in the game
 *   @author  Lua & Tanting
 *   @version 1.0
 */
public class Player extends People{

    private ArrayList<Property> properties;
    private ArrayList<Card> cards;
    private int nPosition;
    private int nDiceRoll;

    /**
     * This constructor creates a new Player with a given name
     * @param strName name of the player
     */
    public Player(String strName) {
        super(strName, false);
        properties = new ArrayList<Property>();
        cards = new ArrayList<Card>();
        nPosition = 0;
        nDiceRoll = 0;
    }

    /**
     * Gets the integer position of the player on the board
     * @return (int) player position
     */
    public int getPosition() {
        return nPosition;
    }

    /**
     * Gets a card that the user that is currently in possession of
     * @return (Card) card of the user
     */
    public Card getCard() {
        if(!cards.isEmpty())
            return this.cards.get(0);
        else
            return null;
    }

    /**
     * Gets the number which resulted from the player's dice roll
     * @return (int) dice roll number
     */
    public int getDiceRoll(){
        return nDiceRoll;
    }

    /**
     * Gets an arrayList of properties owned by the player
     * @return (ArrayList<Property>) list of properties owned by user
     */
    public ArrayList<Property> getProperties() {
        return properties;
    }

    /**
     * Adds a given card to the cards which the player possesses
     * @param c Card which is to be addede to the player
     * @return (void)
     */
    public void addCard(Card c){
        cards.add(c);
    }

    /**
     * Updates player position and game board state based off player's dice roll
     * @param gameBoard Contains the game board that the player is playing at
     * @return (void)
     */
    public void roll(GameBoard gameBoard) {
        int nRoll;
        nRoll = (int)(Math.random() * (6 - 1) + 1 );
        System.out.println(nRoll);
        nDiceRoll = nRoll;
        for( int i = nPosition + 1 ; i <= nPosition + nRoll; i++ ) {
            if (i > 31) {//If position has gone past the edge of the board then go back to start
                nRoll -= i;
                i = 0;
                nPosition = 0;
                dMoney += 200;
            } else {
                nPosition += 1;
            }
            if (gameBoard.getLand().get(i).getOwner().getName() != null &&
                    gameBoard.getLand().get(i).getLandType().equalsIgnoreCase("property")) {
                //If land is owned and is property type
                gameBoard.getLand().get(i).addFootTraffic();
            }
        }
    }
}