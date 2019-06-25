import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * GameBoard class contains methods which plays the game
 *
 * New Changes Made: Added initializePlayers(), playGame(), getChance()
 *
 * Last Changes Made: Added initializeLand() and initializeCards()
 * @author  Lua & Tanting
 * @version 1.1
 */
public class GameBoard {
    private Player[] players;
    private ArrayList<Land> land;
    private ArrayList<Land> landLeft;
    private ArrayList<Card> cardPile;
    private ArrayList<Card> cardDiscard;
    private boolean isWin;
    private People bank;

    /**
     * Creates a GameBoard object initialized with land, random set of cards, and players
     */
    public GameBoard(){
        initializeLand();
        initializeCards();
        initializePlayers();
    }

    /**
     * Gets the number of players in the current game board
     * @return number of players
     */
    public int getPlayers() {
        return players.length;
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
     * Changes the value of isWin variable to either true or false
     * @param value the value to be set to isWin
     */
    public void setIsWin(boolean value){
        isWin = value;
    }

    /**
     * Prints Land in Order
     */
    private void printLand(){
        int[] arrPositions = new int[players.length];
        for(int i = 0; i < players.length;i++)
            arrPositions[i] = players[i].getPosition();
        for(int i = 0; i < landLeft.size();i++){
            System.out.println(i +"."+ landLeft.get(i).getName());
            for(int j = 0; j < players.length; j++)
                if(i == arrPositions[j])
                    System.out.println("Player:" + players[j].getName() + "is here.");
        }
    }
    /**
     * Creates land objects to be used in the board and places it in landLeft
     */
    private void initializeLand(){
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
        landLeft = new ArrayList<Land>();
        int nDecrement = 0;
        for(int i = 0; i <= 31;i++){
            if(i == 0) {
                landLeft.add(new Land("Start", "corner"));
                nDecrement++;
            }
            else if(i == 8){
                landLeft.add(new Land("Community Service", "corner"));
                nDecrement++;
            }
            else if(i == 16) {
                landLeft.add(new Land("Free Parking", "corner"));
                nDecrement++;
            }
            else if(i == 24){
                landLeft.add(new Land("Jail", "corner"));
            }
            else if(i <= 23 && i >= 21){
                if(i == 21)
                    landLeft.add(new Land("North","railroad",200));
                else if(i == 22)
                    landLeft.add(new Land("South","railroad",200));
                else
                    landLeft.add(new Land("Metro","railroad",200));
            }
            else if(i == 25)
                landLeft.add(new Land("Electric","utility",150));
            else if(i == 26)
                landLeft.add(new Land("Water","utility",150));
            else if(i <= 29 && i >= 27)
                landLeft.add(new Land("Chance","chance"));
            else if(i == 30)
                landLeft.add(new Land("Income Tax","luxury"));
            else if(i == 31)
                landLeft.add(new Land("Luxury Tax","luxury"));
            else{
                    landLeft.add(new Property(strPropertyDetails[i-nDecrement][0],strPropertyDetails[i-nDecrement][1],dPropertyDetails[i-nDecrement]));
            }
        }
    }

    /**
     * Prints Cards in Order
     */
    private void printCards(){
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
        cardPile.add(new Card(0,0,true,"Get out of Jail Free."));
        cardPile.add(new Card(0,0,true,"Get out of Jail Free."));
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
                cardPile.add(new Card(i,nRandInt,false,cardDesc[i][nRandInt]));
            }
        }
        Collections.shuffle(cardPile);
    }

    /**
     * Initializes players based on the number specified by user and randomizes their order
     *
     */
    private void initializePlayers(){
        int nPlayers = 4; //Adjust to add more players
        bank = new People("Bank",true); //Initialize bank
        players = new Player[nPlayers];
        for(int i = 0; i < nPlayers; i++){
            players[i] = new Player("Albert" + i);
        }
        Random rgen = new Random();  // Random number generator

        for (int i=0; i<players.length; i++) {//Randomizes the order of the players inside the array
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
            if(player.getProperties().get(j).getName().equalsIgnoreCase("silver")){
                nPropertyCount[0] += 1;
                if(nPropertyCount[0] == 2)
                    nFullSet += 1;
            }
            else if(player.getProperties().get(j).getName().equalsIgnoreCase("purple")){
                nPropertyCount[1] += 1;
                if(nPropertyCount[1] == 3)
                    nFullSet += 1;
            }
            else if(player.getProperties().get(j).getName().equalsIgnoreCase("pink")){
                nPropertyCount[2] += 1;
                if(nPropertyCount[2] == 3)
                    nFullSet += 1;
            }
            else if(player.getProperties().get(j).getName().equalsIgnoreCase("green")){
                nPropertyCount[3] += 1;
                if(nPropertyCount[3] == 3)
                    nFullSet += 1;
            }
            else if(player.getProperties().get(j).getName().equalsIgnoreCase("blue")){
                nPropertyCount[4] += 1;
                if(nPropertyCount[4] == 3)
                    nFullSet += 1;
            }
            else if(player.getProperties().get(j).getName().equalsIgnoreCase("red")){
                nPropertyCount[5] += 1;
                if(nPropertyCount[5] == 2)
                    nFullSet += 1;
            }
            else if(player.getProperties().get(j).getName().equalsIgnoreCase("yellow")){
                nPropertyCount[6] += 1;
                if(nPropertyCount[6] == 2)
                    nFullSet += 1;
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
     * Method for playing the board until a player has won
     */
    public  void playGame(){
        while(!isWin){//While no one has won
            for(int i = 0; i < players.length && !isWin; i++){
                checkForWin();
                printLand();
                players[i].roll(this);
            }
        }
    }

    /**
     * Gives player a card from the topmost card in cardPile
     * @return card that the user got from the pile
     */
    public Card drawChance(){
        Card temp = cardPile.get(cardPile.size()-1); //Remove topmost card in cardPile
        cardPile.remove(cardPile.size()-1);
        if(cardPile.size() == 0) //If cardPile is empty then shuffle discardPile into cardPile
            for(int i = 0; i < cardDiscard.size(); i++){
                cardPile.add(cardDiscard.get(0));
                cardDiscard.remove(0);
            }
        Collections.shuffle(cardPile);
        return temp;
    }
}
