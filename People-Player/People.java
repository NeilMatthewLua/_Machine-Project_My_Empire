/**
 * People Class
 *    
 *      New Changes: Edited the Receive Give Method (Avoided infinite loop)
                     Removed receivedMoney()
 * 
 *      Last Changes Made: 

 * Version 1.02
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
        this.dMoney = 2500;
        this.isBank = false;
    }

    /**
     * This constructor creates a People object that can either be a Player or a bank
     @param strName name of the Player 
     @param isBank  identifies if it is a bank or a Player
     */
    public People(String strName, boolean isBank) {
        this.strName = strName;
        if(!isBank) {
            this.dMoney = 1500.00;
            this.isBank = !(isBank);
        }
        else {
           // this.dMoney = GameBoard.getPlayers() * 2500.00;
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
     * Gives Money to a Player
     * @param player Player that you will pay to
     * @param amount amount of money to be paid to the Player
     */
    public void giveMoney(double amount) {
        this.dMoney -= amount;
    }

}