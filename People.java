/**
 * People Class
 *    
 *      New Changes: Minor adjustment to constructors (Bank)

 * 
 *      Last Changes Made: Brought Back receivedMoney()

 * Version 1.03
 */


public class People{

    private String strName;
    protected double dMoney;
    private boolean isBank;

    /**
     * This constructor creates a People object that is assumed to be a player (due to the lack of isBank identifier)
     @param strName name of the Player 
     */
    public People(String strName) {
        this.strName = strName;
        this.dMoney = 1500;
        this.isBank = false;
    }

    /**
     * This constructor creates a People object that can either be a Player or a bank
     @param strName name of the Player 
     @param isBank  identifies if it is a bank or a Player
     @param nPlayers number of players in the game for the bank to initialize cash
     */
    public People(String strName, boolean isBank, int nPlayers) {
        this.strName = strName;
        if(!isBank) {
            this.dMoney = 1500;
            this.isBank = !(isBank);
        }
        else {
            this.dMoney = nPlayers * 2500;
            this.isBank = isBank;
        }
    }

    /**
     * Gets Person's Name
     * @return Person's name
     */
    public String getName() {
        return this.strName;
    }

    /**
     * Gets Person's money
     * @return current money of the Person
     */
    public double getMoney(){
        return this.dMoney;
    }

    /**
     * Receives Money to a Player
     * @param amount amount of money to be paid to the Player
     */
    public void receiveMoney(double amount) {
        this.dMoney += amount;
    }


    /**
     * Gives Money to a Player
     * @param amount amount of money to be paid to the Player
     */
    public void giveMoney(double amount) {
        this.dMoney -= amount;
    }

}