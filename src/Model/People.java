package Model;

/**
 * People Class parent class of players and contains name and money
 */


public class People{

    //Name of the Player / "Bank"
    private String strName;
    //Money of the Person
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
     @param nPlayers number of players on board
     */
    public People(String strName, int nPlayers) {
        this.strName = strName;
        this.dMoney = nPlayers * 2500;
    }

    /**
     * Getter for People name
     * @return People name
     */
    public String getName() {
        return this.strName;
    }

    /**
     * Getter for People money
     * @return current money of People
     */
    public double getMoney(){
        return this.dMoney;
    }

    /**
     * Receives Money from People
     * @param amount amount of money to be received
     */
    public void receiveMoney(double amount) {
        this.dMoney += amount;
    }


    /**
     * Gives Money to People
     * @param receiver People that will receive the money
     * @param amount amount of money to be paid to People
     * @return boolean value that determines whether or not the player was able to pay full price
     */
    public boolean giveMoney(People receiver, double amount) {
        //Checks if the current People has enough money
        if(this instanceof Player && this.dMoney - amount >= 0){
            //Receiver receives the money
            receiver.receiveMoney(amount);
            //Money is deducted from the current People
            this.dMoney -= amount;
            //Return true to show that the transaction was successful
            return true;
        }
        else if(this.dMoney - amount > 0){
            //Receiver receives the money
            receiver.receiveMoney(amount);
            //Money is deducted from the current People
            this.dMoney -= amount;
            //Return true to show that the transaction was successful
            return true;
        }
        else{
            //Receiver receives whatever the current People has left
            receiver.receiveMoney(this.dMoney);
            //Current People's money is now 0
            this.dMoney = 0;
            //Returns false to show that someone is now bankrupt
            return false;
        }
    }

}