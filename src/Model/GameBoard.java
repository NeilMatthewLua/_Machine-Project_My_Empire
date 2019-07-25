package Model;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * GameBoard class contains methods which plays the game
 *
 * New Changes Made: Adjustments for new project Design. Changed initialization of land and checking for complete sets
 *
 * Last Changes Made: Added conditional in checkForCompleteSet
 * @author  Lua & Tanting
 * @version 1.2
 */
public class GameBoard {
    private Player[] players;
    private ArrayList<Land> land;
    private ArrayList<Card> cardPile;
    private ArrayList<Card> cardDiscard;
    private boolean isWin;
    private People bank;
    private ArrayList<String> events;
    /**
     * Creates a GameBoard object initialized with land, random set of cards, and players
     */
    public GameBoard(){
        initializeLand();
        initializeCards();
        randomizeLand();
        isWin = false;
    }

    /**
     * Gets the players in the current game board
     * @return array of players in the game
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * Gets the arrayList of land which comprises the current game board
     * @return the arrayList of land
     */
    public ArrayList<Land> getLand() {
        return land;
    }

    /**
     * Gets the bank player object from the board
     * @return bank player object
     */
    public People getBank(){
        return bank;
    }

    /**
     * Gets the variable which checks whether or not the game is over
     * @return true if the game has ended, false if not
     */
    public boolean getIsWin(){return isWin;}

    public ArrayList<String> getEvents(){
        return events;
    }

    /**
     * Changes the value of isWin variable to either true or false
     * @param value the value to be set to isWin
     */
    public void setIsWin(boolean value){
        isWin = value;
    }

    /**
     * Prints Land in Order
     */
    public void printLand(Player player){
        System.out.println("TURN: " + player.getName());
//        int[] arrPositions = new int[players.length];
//        for(int i = 0; i < players.length; i++)
//            arrPositions[i] = players[i].getPosition();
        for(int i = 0; i < land.size(); i++){
            if(land.get(i) instanceof Property)
            if(((Property)land.get(i)).getOwner() != null )
                if(((Property)land.get(i)).getOwner().equals(player))
                    System.out.print("(OWNED) ");
            System.out.println(i +"."+ land.get(i).getName());
//            for(int j = 0; j < players.length; j++)
//                if(i == arrPositions[j])
//                    System.out.println("Player: " + players[j].getName() + "is here. at " + i);
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }
    /**
     * Creates land objects to be used in the board and places it in landLeft
     */
    public void initializeLand(){
        double[][] dPropertyDetails = {
                {60,50,2,10,30,90,160,250,2.5},
                {60,50,4,20,60,180,320,450,3.0},
                {100,50,6,30,90,270,400,550,3.5},
                {100,50,6,30,90,270,400,550,4.0},
                {120,50,6,40,100,300,450,600,4.0},
                {140,100,10,50,150,450,625,750,4.5},
                {140,100,10,50,150,450,625,750,4.5},
                {160,100,12,60,180,500,700,900,5.0},
                {180,100,14,70,200,550,750,950,5.0},
                {180,100,14,70,200,550,750,950,5.5},
                {200,100,16,80,220,600,800,1000,5.5},
                {220,150,18,90,250,700,875,1050,6.0},
                {220,150,18,90,250,700,875,1050,6.0},
                {240,150,20,100,300,750,925,1100,6.5},
                {260,150,22,110,330,800,975,1150,6.5},
                {260,150,22,110,330,800,975,1150,7.0},
                {300,200,26,130,390,900,1100,1275,7.0},
                {320,200,28,150,450,1000,1200,1400,8.0}
        };
        String[][] strPropertyDetails = {
                {"Almond Drive","Silver"},
                {"Kasoy Street","Silver"},
                {"Rodeo Drive","Purple"},
                {"Orange Street","Purple"},
                {"Ventura Street","Purple"},
                {"Juan Luna","Pink"},
                {"Ylaya","Pink"},
                {"J. Abad Santos","Pink"},
                {"Madison","Green"},
                {"Annapolis","Green"},
                {"Connecticut","Green"},
                {"Bougainvilla","Blue"},
                {"Dama de Noche","Blue"},
                {"Acacia","Blue"},
                {"Solar Street","Red"},
                {"Galaxy Street","Red"},
                {"9th Street","Yellow"},
                {"5th Avenue","Yellow"},
        };
        land = new ArrayList<Land>();
        int nDecrement = 0;
        for(int i = 0; i <= 31;i++){
            if(i == 0) {
                land.add(new Start("Start"));
                nDecrement++;
            }
            else if(i == 8){
                land.add(new Community("Community Service"));
                nDecrement++;
            }
            else if(i == 16) {
                land.add(new Parking("Free Parking"));
                nDecrement++;
            }
            else if(i == 24){
                land.add(new Jail("Jail"));
            }
            else if(i <= 23 && i >= 21){
                if(i == 21)
                    land.add(new Railroad("North",200));
                else if(i == 22)
                    land.add(new Railroad("South",200));
                else
                    land.add(new Railroad("Metro",200));
            }
            else if(i == 25)
                land.add(new Utility("Electric",150));
            else if(i == 26)
                land.add(new Utility("Water",150));
            else if(i <= 29 && i >= 27)
                land.add(new Chance("Chance"));
            else if(i == 30)
                land.add(new Tax("Income Tax"));
            else if(i == 31)
                land.add(new Tax("Luxury Tax"));
            else{
                    land.add(new Property(strPropertyDetails[i-nDecrement][0],strPropertyDetails[i-nDecrement][1],dPropertyDetails[i-nDecrement]));
            }
        }
    }

    public void randomizeLand(){
        ArrayList<Land> landLeft = new ArrayList<Land>(1);
        for(int i = 0; i < land.size();i++ ){
            if(!(land.get(i).getName().equals("Start") ||
                    land.get(i).getName().equals("Community Service") ||
                    land.get(i).getName().equals("Free Parking") ||
                    land.get(i).getName().equals("Jail")))
            landLeft.add(land.get(i));
        }
        Collections.shuffle(landLeft);
        landLeft.add(0,land.get(0));
        landLeft.add(8,land.get(8));
        landLeft.add(16,land.get(16));
        landLeft.add(24,land.get(24));
        land = (ArrayList<Land>) landLeft.clone();
    }

    /**
     * Prints Cards in Order
     */
    public void printCards(){
        for(int i = 0; i < cardPile.size();i++){
            System.out.println(i +"."+ cardPile.get(i).getDescription());
        }
    }
    /**
     * Initializes Cards to cardPile and shuffles it
     *
     */
    private void initializeCards(){
        cardPile = new ArrayList<Card>();
        cardDiscard = new ArrayList<Card>();
        int[] cardCount = {2,6,6,4,7,3};
        String[][] cardDesc = {
                {"Get out of jail free."},
                {"Proceed to property, do not collect money when passed START.You may buy the property if unowned, pay rent, or propose trade."
                ,"Go to nearest utility. If unowned, you may buy from the bank ;otherwise throw dice and pay owner 10 times the value of the dice.",
                "Go to nearest railroad. If unowned, you may buy from the bank otherwise pay rent"},

                {"Congratulations! Bank pays dividend of $50",
                "Tax refund. Collect $100 from the bank.",
                "Advance to START, collect $200.",
                "It’s your birthday! Collect $300 gift money.",
                "You won the competition, collect $150 prize money."},

                {"Go to jail. When passing START, do not collect $200",
                 "Take a trip to property, collect money when passing START"
                },

                {"Double rent. Apply this card to a property you own, and you can collect double rent from the next player who lands on it. If you do not own any property, discard this card.",
                  "Apply this card to a property you own. Renovation costs $25 per house, or $50 per hotel. From now on, rent is increased by 50%. If you do not own any property, discard this card.",
                  "Apply this card to a property you own. Dilapidated houses. From now on, rent is decreased by 10%. If you do not own any property, discard this card. ",
                  "Apply this card to a utility or railroad you own. Increase charge by 10%. If you do not own any utility or railroad, discard this card. ",
                  "Apply this card to a utility or railroad you own. Decrease charge by 10%. If you do not own any utility or railroad, discard this card. "},


                { "Donate money for community development",
                    "Pay taxes (random amount)"
                }
        };
        cardPile.add(new CardSet_1(0, 0, true, cardDesc));
        cardPile.add(new CardSet_1(0,0,true,cardDesc));
        Random rand = new Random();
        int nRandInt;
        for(int i = 1; i < 6;i++){
            for(int j = cardCount[i];j > 0;j--){
                if(i == 3 || i == 5){
                    nRandInt = rand.nextInt(2);
                }
                else if(i == 1){
                    nRandInt = rand.nextInt(3);
                }
                else {
                    nRandInt = rand.nextInt(5);
                }
                if(i == 1){
                    cardPile.add(new CardSet_2(nRandInt,i,false,cardDesc));
                }
                else if(i == 2){
                    cardPile.add(new CardSet_3(nRandInt,i,false,cardDesc));
                }
                else if(i == 3){
                    cardPile.add(new CardSet_4(nRandInt,i,false,cardDesc));
                }
                else if(i == 4){
                    cardPile.add(new CardSet_5(nRandInt,i,false,cardDesc));
                }
                else{
                    cardPile.add(new CardSet_6(nRandInt,i,false,cardDesc));
                }
            }
        }
        Collections.shuffle(cardPile);
    }

    /**
     * Initializes players based on the number specified by user and randomizes their order
     *
     */
    public void initializePlayers(ArrayList<String> strPlayers){
        bank = new People("Bank",strPlayers.size()); //Initialize bank
        players = new Player[strPlayers.size()];
        for(int i = 0; i < strPlayers.size(); i++){
            players[i] = new Player(strPlayers.get(i));
        }

        Random rgen = new Random();  // Random number generator

        for (int i=0; i < players.length; i++) {//Randomizes the order of the players inside the array
            int randomPosition = rgen.nextInt(players.length);
            Player temp = players[i];
            players[i] = players[randomPosition];
            players[randomPosition] = temp;
        }

        for (int i = 0; i < players.length;i++){
            System.out.println(players[i].getName());
        }
    }

    /**
     * Checks if player has two full sets
     * @param player player whose property will be checked
     * @return true if the player has 2 full sets, false if less than 2 full sets
     */
    private boolean isCompleteSet(Player player){
        int[] nPropertyCount = {0,0,0,0,0,0,0}; //Counts the no. of properties player has per color
        int nFullSet = 0;
        for(int j = 0; j < player.getProperties().size() && nFullSet < 2;j++){
            if(player.getProperties().get(j) instanceof Property){
                if(((Property)player.getProperties().get(j)).getColor().equalsIgnoreCase("silver")){
                    nPropertyCount[0] += 1;
                    if(nPropertyCount[0] == 2)
                        nFullSet += 1;
                }
                else if(((Property)player.getProperties().get(j)).getColor().equalsIgnoreCase("purple")){
                    nPropertyCount[1] += 1;
                    if(nPropertyCount[1] == 3)
                        nFullSet += 1;
                }
                else if(((Property)player.getProperties().get(j)).getColor().equalsIgnoreCase("pink")){
                    nPropertyCount[2] += 1;
                    if(nPropertyCount[2] == 3)
                        nFullSet += 1;
                }
                else if(((Property)player.getProperties().get(j)).getColor().equalsIgnoreCase("green")){
                    nPropertyCount[3] += 1;
                    if(nPropertyCount[3] == 3)
                        nFullSet += 1;
                }
                else if(((Property)player.getProperties().get(j)).getColor().equalsIgnoreCase("blue")){
                    nPropertyCount[4] += 1;
                    if(nPropertyCount[4] == 3)
                        nFullSet += 1;
                }
                else if(((Property)player.getProperties().get(j)).getColor().equalsIgnoreCase("red")){
                    nPropertyCount[5] += 1;
                    if(nPropertyCount[5] == 2)
                        nFullSet += 1;
                }
                else if(((Property)player.getProperties().get(j)).getColor().equalsIgnoreCase("yellow")){
                    nPropertyCount[6] += 1;
                    if(nPropertyCount[6] == 2)
                        nFullSet += 1;
                }
            }
            if(nFullSet == 2)
                return true;
        }
        return false;
    }

    /**
     * Checks if the game has ended. Game can end if:
     * Player does not have enough money to pay for rent,
     * Player owns 2 full sets of properties with the same color
     * or Bank is out of cash
     */
    private void checkForWin(){
        if(bank.getMoney() <= 0)
            this.isWin = true;
        for(int i = 0; i < players.length && !this.isWin;i++){
            this.isWin = isCompleteSet(players[i]);
        }
    }

    /**
     * Gives player a card from the topmost card in cardPile
     * @return card that the user got from the pile
     */
    public Card drawChance(){
        if(cardPile.size() == 0) //If cardPile is empty then shuffle discardPile into cardPile
            events.add("Card pile empty. Shuffling discard pile into card pile.");
            for(int i = 0; i < cardDiscard.size(); i++){
                cardPile.add(cardDiscard.get(0));
                cardDiscard.remove(0);
            }
        Collections.shuffle(cardPile);
        Card temp = cardPile.get(cardPile.size()-1); //Remove topmost card in cardPile
        cardPile.remove(cardPile.size()-1);
        return temp;
    }

    /**
     * Adds card from the parameter to discard pile
     * @param c is the card to be added
     */
    public void addCardDiscard(Card c){
        cardDiscard.add(c);
    }

    /**
     * Method for playing the board until a player has won
     */
    public  void playGame(){
        while(!isWin){//While no one has won
            for(int i = 0; i < players.length && !isWin; i++){
                checkForWin();
                printLand(players[i]);
                events.add(players[i].roll(this));
            }
        }
        endResults();
    }

    /**
     * Prints end results with players arranged in descending order of money
     */
    public void endResults(){
        String pattern = "###,##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        for(int i = 1; i < players.length; i++){
            Player current = players[i];
            int j = i - 1;
            while(j >= 0 && current.getMoney() < players[j].getMoney()) {
                players[j+1] = players[j];
                j--;
            }
            // at this point we've exited, so j is either -1
            // or it's at the first element where current >= a[j]
            players[j+1] = current;
        }
        for(int i = players.length-1; i >= 0; i--){
            if(players[i].getMoney() == 0)
                System.out.print("BANKRUPT");
            System.out.println(i+1 + "." + players[i].getName() + " Money: " +
                    decimalFormat.format(players[i].getMoney()));
        }
    }

}
