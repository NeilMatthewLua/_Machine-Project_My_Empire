/**
 * Card class which acts as a template for the cards that can be used during the game
 *   @author  Lua & Tanting
 *   @version 1.0
 */
public class Card {
    private int nGroup; //Group which card belongs to
    private int nIndex; //Index of card within group
    private boolean boolCanKeep;
    private String strDescription;

    /**Creates a card with the specified attributes.
     * @param nGroup The index of which group the card belongs to
     * @param nIndex The index of the card within said group
     * @param boolCanKeep True if the user can hold onto the card, false if it has to be used
     * @param strDescription Description of what the card does
     */
    public Card(int nGroup, int nIndex, boolean boolCanKeep, String strDescription){
        this.nGroup  = nGroup;
        this.nIndex  = nIndex;
        this.boolCanKeep = boolCanKeep;
        this.strDescription = strDescription;
    }

    /**
     * Gets the description of the card
     * @return (String) description of the card
     */
    public String getDescription(){
        return strDescription;
    }
}
