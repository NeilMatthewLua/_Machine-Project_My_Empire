package Model;
/**
 * People Class parent class of players and contains name and money
 *    
 *      New Changes: Changed class constructor implementation

 * 
 *      Last Changes Made: Changed the implementation of giveMoney()
 * Version 1.03
 */


public class People{

    private String strName;
    protected double dMoney;

    /**
     * This constructor creates a People object that is assumed to be a player
     @param strName name of the Player 
     */
    public People(String strName) {
        this.strName = strName;
        this.dMoney = 1500;
    }

    /**
     * This constructor creates a People object that is a bank
     @param strName name of the Player
     */
    public People(String strName, int nPlayers) {
        this.strName = strName;
        this.dMoney = nPlayers * 2500;
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
    public void receiveMoney( double amount) {
        this.dMoney += amount;
    }


    /**
     * Gives Money to a Player
     * @param amount amount of money to be paid to the Player
     * @return true if player is able to give money, false if not
     */
    public boolean giveMoney(People receiver, double amount) {
        if(this.dMoney - amount > 0){
            receiver.receiveMoney(amount);
            this.dMoney -= amount;
            return true;
        }
        else{
            receiver.receiveMoney(this.dMoney);
            this.dMoney = 0;
            return false;
        }
    }

}