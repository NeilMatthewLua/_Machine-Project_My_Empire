/**
 * People Class
 *    
 *      New Changes: 
 * 
 *      Last Changes Made: public People(String strName)
                           public People(String strName, boolean isBank)
                           public String getName()
                           public double getMoney()
                           public void receiveMoney(People player, double amount)
                           public void giveMoney(People player, double amount)

 * Version 1.01
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
     * Receive Money from a Player
     * @param player Player that will pay you
     * @param amount amount of money to be received from the Player
     */
    public void receiveMoney(People player, double amount) {
        this.dMoney += amount;
        player.giveMoney(this, amount);
    }

    /**
     * Gives Money to a Player
     * @param player Player that you will pay to
     * @param amount amount of money to be paid to the Player
     */
    public void giveMoney(People player, double amount) {
        this.dMoney -= amount;
        player.receiveMoney(this, amount);
    }

}