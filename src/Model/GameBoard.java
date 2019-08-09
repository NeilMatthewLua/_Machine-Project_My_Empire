package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * GameBoard class contains methods which contains the different components of the game
 */
public class GameBoard {
    //Array of Players who will play the game
    private Player[] players;
    //ArrayList which contains the Land spaces on the board
    private ArrayList<Land> land;
    //ArrayList of Cards that can be drawn from
    private ArrayList<Card> cardPile;
    //ArrayList of Cards which act as a discard pile
    private ArrayList<Card> cardDiscard;
    //Boolean which is false while no one has won, true if someone has
    private boolean isWin;
    //People which acts as the bank in the game
    private People bank;
    //ArrayList<String> of the different events that occur during the game
    private ArrayList<String> events;

    public GameBoard(){
        //Initialize the events arrayList
        events = new ArrayList<String>();
        //Initialize the Land
        initializeLand();
        //Initialize the Cards
        initializeCards();
        //Set the initial game state to false to play
        isWin = false;
    }

    /**
     * Getter for the GameBoard Players
     * @return GameBoard's players
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * Getter for the GameBoard land
     * @return GameBoard's land
     */
    public ArrayList<Land> getLand() {
        return land;
    }

    /**
     * Getter of the GameBoard bank
     * @return GameBoard's bank
     */
    public People getBank(){
        return bank;
    }

    /**
     * Getter for the GameBoard isWin state
     * @return GameBoard game state
     */
    public boolean getIsWin(){return isWin;}

    /**
     * Getter for the GameBoard events
     * @return GameBoard events
     */
    public ArrayList<String> getEvents(){
        return events;
    }

    /**
     * Setter for the GameBoard isWin
     * @param value boolean state of isWin
     */
    public void setIsWin(boolean value){
        isWin = value;
    }


    /**
     * Setter for the GameBoard land
     * @param newLand land to set
     */
    public void setLand(ArrayList<Land> newLand){
        land = new ArrayList<Land>(newLand);
        for(int i = 0; i < land.size();i++){
            System.out.println(land.get(i).getName());
        }
    }


    /**
     * Initializes the Land objects and stores them in an ArrayList
     * @return the ArrayList of Land which was created
     */
    public ArrayList<Land> initializeLand(){
        //Double[][] which contains the details of the different Properties
        /*  Index:
            0 = Price, 1 = Price per House, 2 = Rent unimproved, 3 = Rent (1 House),
            4 = Rent (2 House), 5 = Rent (3 House), 6 = Rent (4 House), 7 = Rent (Hotel),
            8 = Foot Traffic Multiplier
         */
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
        /*
        String[][] which contains the different String-related Property details
            Index:
            0 = Property Name, 1 = Property Color
         */
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
        //Initialize land arrayList
        land = new ArrayList<Land>();
        //Decrement takes into account the different corner spaces
        int nDecrement = 0;
        //Add in the different Land spaces
        for(int i = 0; i <= 31;i++){
            //Add in Start at the first corner
            if(i == 0) {
                land.add(new Start("Start"));
                nDecrement++;
            }
            //Add in Community at the second corner
            else if(i == 8){
                land.add(new Community("Community Service"));
                nDecrement++;
            }
            //Add in Jail in the third corner
            else if(i == 16){
                land.add(new Jail("Jail"));
                nDecrement++;
            }
            //Add in Parking at the fourth corner
            else if(i == 24) {
                land.add(new Parking("Free Parking"));
                nDecrement++;
            }
            //Add in the Railroads
            else if(i <= 23 && i >= 21){
                if(i == 21)
                    land.add(new Railroad("North",200));
                else if(i == 22)
                    land.add(new Railroad("South",200));
                else
                    land.add(new Railroad("Metro",200));
            }
            //Add in the Utilities
            else if(i == 25)
                land.add(new Utility("Electric",150));
            else if(i == 26)
                land.add(new Utility("Water",150));
            //Add in the Chance spaces
            else if(i <= 29 && i >= 27)
                land.add(new Chance("Chance"));
            //Add in the Tax Spaces
            else if(i == 30)
                land.add(new Tax("Income Tax"));
            else if(i == 31)
                land.add(new Tax("Luxury Tax"));
            //Add in the Property spaces
            else{
                    land.add(new Property(strPropertyDetails[i-nDecrement][0],strPropertyDetails[i-nDecrement][1],dPropertyDetails[i-nDecrement]));
            }
        }
        return land;
    }


    /**
     * Randomizes the GameBoard's ArrayList land
     */
    public void randomizeLand(){
        //Create a temporary container
        ArrayList<Land> landLeft = new ArrayList<Land>(1);
        //For each Land in land add it to the temp arraylist
        for(int i = 0; i < land.size();i++ ){
            //If land is not a corner then add them
            if(!(land.get(i).getName().equals("Start") ||
                    land.get(i).getName().equals("Community Service") ||
                    land.get(i).getName().equals("Free Parking") ||
                    land.get(i).getName().equals("Jail")))
            landLeft.add(land.get(i));
        }
        //Shuffle the land
        Collections.shuffle(landLeft);
        //Add in the corner spaces
        landLeft.add(0,land.get(0));
        landLeft.add(8,land.get(8));
        landLeft.add(16,land.get(16));
        landLeft.add(24,land.get(24));
        //Set land equal to the temp container
        land = new ArrayList<Land>(landLeft);
    }

    /**
     * Initializes the card pile and shuffles it
     */
    private void initializeCards(){
        //Initialize the Card pile to draw from
        cardPile = new ArrayList<Card>();
        //Initialize the Card where the discarded Cards go
        cardDiscard = new ArrayList<Card>();
        //The number of needed Cards from each group
        int[] cardCount = {2,6,6,4,7,3};
        //String[][] of card descriptions
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
        //Add in the two get out of jail Cards
        cardPile.add(new CardSet_1(0, 0, true, cardDesc));
        cardPile.add(new CardSet_1(0,0,true,cardDesc));
        //Create a random generator
        Random rand = new Random();
        int nRandInt;
        //Loop through the remaining Card sets
        for(int i = 1; i < 6;i++){
            //While the number of needed Cards in the group is above zero then keep adding Cards to that group
            for(int j = cardCount[i];j > 0;j--){
                //If from group 4 or 6 then only two choices of Cards
                if(i == 3 || i == 5){
                    nRandInt = rand.nextInt(2);
                }
                //If from group 2 then three choices of Cards to add
                else if(i == 1){
                    nRandInt = rand.nextInt(3);
                }
                //If Group 3 then there are five choices of Cards to add
                else {
                    nRandInt = rand.nextInt(5);
                }
                //If adding to CardSet_Two
                if(i == 1){
                    cardPile.add(new CardSet_2(nRandInt,i,false,cardDesc));
                }
                //If adding to CardSet_Three
                else if(i == 2){
                    cardPile.add(new CardSet_3(nRandInt,i,false,cardDesc));
                }
                //If adding to CardSet_Four
                else if(i == 3){
                    cardPile.add(new CardSet_4(nRandInt,i,false,cardDesc));
                }
                //If adding to CardSet_Five
                else if(i == 4){
                    cardPile.add(new CardSet_5(nRandInt,i,false,cardDesc));
                }
                //If adding to CardSet_Six
                else{
                    cardPile.add(new CardSet_6(nRandInt,i,false,cardDesc));
                }
            }
        }
        //Shuffle the card pile
        Collections.shuffle(cardPile);
    }

    /**
     * Initializes the Players using an ArrayList player names
     * @param strPlayers the array list of Player names
     */
    public void initializePlayers(ArrayList<String> strPlayers){
        //Initialize bank
        bank = new People("Bank",strPlayers.size());
        //Initialize players array
        players = new Player[strPlayers.size()];
        //Create Players based from the given ArrayList of player names
        for(int i = 0; i < strPlayers.size(); i++){
            players[i] = new Player(strPlayers.get(i));
        }
        // Random number generator
        Random rgen = new Random();

        //Randomizes the order of the players inside the array
        for (int i=0; i < players.length; i++) {
            //Assign a random position
            int randomPosition = rgen.nextInt(players.length);
            //Create a temporary variable to store chosen Player
            Player temp = players[i];
            //Swap chosen Player and Player at index i
            players[i] = players[randomPosition];
            players[randomPosition] = temp;
        }
    }

    /**
     * Checks if a Player has 2 full sets
     * @return true if a Player has 2 full sets, false otherwise
     */
    public Boolean isCompleteSet(){
        //Iterate through all the Players playing
        for(int i = 0; i < players.length;i++){
            //Stores the counts of each color/railroad/utility in their corresponding indices
            int[] nPropertyCount = {0,0,0,0,0,0,0,0,0};
            //Counts the number of full sets
            int nFullSet = 0;
            //Loops through the Ownables of the Player
            for(int j = 0; j < players[i].getProperties().size() && nFullSet < 2;j++){
                //If Ownable is Property
                if(players[i].getProperties().get(j) instanceof Property){
                    //If color is Silver
                    if(((Property)players[i].getProperties().get(j)).getColor().equalsIgnoreCase("silver")){
                        nPropertyCount[0] += 1;
                        if(nPropertyCount[0] == 2)
                            nFullSet += 1;
                    }
                    //If color is Purple
                    else if(((Property)players[i].getProperties().get(j)).getColor().equalsIgnoreCase("purple")){
                        nPropertyCount[1] += 1;
                        if(nPropertyCount[1] == 3)
                            nFullSet += 1;
                    }
                    //If color is Pink
                    else if(((Property)players[i].getProperties().get(j)).getColor().equalsIgnoreCase("pink")){
                        nPropertyCount[2] += 1;
                        if(nPropertyCount[2] == 3)
                            nFullSet += 1;
                    }
                    //If color is Green
                    else if(((Property)players[i].getProperties().get(j)).getColor().equalsIgnoreCase("green")){
                        nPropertyCount[3] += 1;
                        if(nPropertyCount[3] == 3)
                            nFullSet += 1;
                    }
                    //If color is Blue
                    else if(((Property)players[i].getProperties().get(j)).getColor().equalsIgnoreCase("blue")){
                        nPropertyCount[4] += 1;
                        if(nPropertyCount[4] == 3)
                            nFullSet += 1;
                    }
                    //If color is Red
                    else if(((Property)players[i].getProperties().get(j)).getColor().equalsIgnoreCase("red")){
                        nPropertyCount[5] += 1;
                        if(nPropertyCount[5] == 2)
                            nFullSet += 1;
                    }
                    //If color is Yellow
                    else if(((Property)players[i].getProperties().get(j)).getColor().equalsIgnoreCase("yellow")){
                        nPropertyCount[6] += 1;
                        if(nPropertyCount[6] == 2)
                            nFullSet += 1;
                    }
                }
                //If Ownable is Utility
                else if(players[i].getProperties().get(j) instanceof Utility){
                    nPropertyCount[7] += 1;
                    if(nPropertyCount[7] == 2)
                        nFullSet += 1;
                }
                //If Ownable is Railroad
                else if(players[i].getProperties().get(j) instanceof Railroad){
                    nPropertyCount[8] += 1;
                    if(nPropertyCount[8] == 3)
                        nFullSet += 1;
                }

                //If Player has two or more full sets
                if(nFullSet >= 2){
                    isWin = true;
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * Gets the topmost Card from the draw pile
     * @return Card drawn
     */
    public Card drawChance(){
        //If cardPile is empty then shuffle discardPile into cardPile
        if(cardPile.size() == 0){

            events.add("Card pile empty. Shuffling discard pile into card pile.\n");
            //Add in the Cards from the discard pile into the draw pile
            for(int i = 0; i < cardDiscard.size(); i++){
                cardPile.add(cardDiscard.get(0));
                cardDiscard.remove(0);
            }
            //Shuffle CardPile
            Collections.shuffle(cardPile);
        }
        //Remove topmost card in cardPile
        Card temp = cardPile.get(0);
        cardPile.remove(0);
        //Return drawn card
        return temp;
    }

    /**
     * Adds Card to discard pile
     * @param card is the Card to be added
     */
    public void addCardDiscard(Card card){
       cardDiscard.add(card);
    }


}
