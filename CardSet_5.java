/**
 * Card class which acts as a template for the cards that can be used during the game
 *
 *  New Changes Made: Fixed Bugs
 
 *  Last Changes Made: Created this subclass

 */

package Model;

import java.util.*;

public class CardSet_5 extends Card{

    private double multiplier; //multiplier that can be applied to a property

    public CardSet_5(int nIndex,int nGroup, boolean canKeep, String[][] list){
        super(nIndex, nGroup, canKeep, list);
        multiplier = 1;
    }

    /**
     * Returns the multiplier value of a card
     * @return the multiplier of the card
     */
    public double getMultiplier(){
        return multiplier;
    }

    /**
     * Abstracted method that triggers the effects of each card
     * @param player    player who got the card
     * @param gameBoard the gameboard
     * @return
     */
    @Override
    public String useCard(Player player, GameBoard gameBoard){
        String event = "";
        int nIndex = player.getCards().get(player.getCards().size() - 1).getIndex(); //gets the index of the card to navigate through its set

        if(nIndex >= 0 && nIndex <= 2){//For properties
            int nUserInput = 0;
            boolean isValid = false;
            //Loops through properties to check if player has property of applicable type
            ArrayList<Integer> tempArr = new ArrayList<Integer>(player.getProperties().size());

            for(int i = 0; i < player.getProperties().size();i++)
                if(player.getProperties().get(i) instanceof Property){
                    tempArr.add(i);
                }

            if(tempArr.size() > 0) //if there is at least one property class owned
                isValid = true;

            if(isValid){

for(int i = 0; i < tempArr.size(); i++)//Display possible properties to add effect
System.out.println(i + "." + player.getProperties().get(tempArr.get(i)).getName());
                Scanner sc = new Scanner(System.in);
                nUserInput = sc.nextInt();

                if(nIndex == 0){//Double Rent
                    multiplier = 2;
                    event += "Rent of " + player.getProperties().get(nUserInput).getName() + " doubled for next collection.";
                }
                else if(nIndex == 1){//Renovation
                    double dRenovation = 0; //Renovation price
                    if(((Property)player.getProperties().get(nUserInput)).getDevelopment() >= 1){//Calculates price of renovation
                        if(((Property)player.getProperties().get(nUserInput)).getDevelopment() == 5){
                            dRenovation += 50;
                            dRenovation += (((Property)player.getProperties().get(nUserInput)).getDevelopment() - 1) * 25;
                        }
                        else
                            dRenovation += ((Property)player.getProperties().get(nUserInput)).getDevelopment() * 25;
                    }

                    if(player.getMoney() - dRenovation > 0){//If rent is applicable
                        player.giveMoney(gameBoard.getBank(),dRenovation);
                        multiplier = 1.5;
                        System.out.println("Rent of " +player.getProperties().get(nUserInput).getName()+" increased by 50%");
                    }
                    else
System.out.println("Insuficient Funds. Cannot Develop");
                }
                else if(nIndex == 2){//Dilapidated Houses
                    multiplier = 0.9;
                    event += "Rent of " +player.getProperties().get(nUserInput).getName()+" decreased by 10%";
                }
            }
            else
System.out.println("Not applicable. No owned properties.");
        }
        else if(nIndex == 3 || nIndex == 4){//For utilities / railroad
            int nUserInput = 0;
            boolean isValid = false;
            //Loops through properties to check if player has property of applicable type
            ArrayList<Integer> tempArr = new ArrayList<Integer>(player.getProperties().size());
            for(int i = 0; i < player.getProperties().size();i++)
                if(player.getProperties().get(i) instanceof Utility || player.getProperties().get(i) instanceof Railroad){
                    tempArr.add(i);
                }

                if(tempArr.size() > 0) //if there is at least one utility / railroad class
                    isValid = true;

            if(isValid){
for(int i = 0; i < tempArr.size(); i++)//Display possible utilities/railroads to add effect
    System.out.println(i + "." + player.getProperties().get(tempArr.get(i)).getName());
                Scanner sc = new Scanner(System.in);
                nUserInput = sc.nextInt();

                if(nIndex == 3){//Decrease by 10%
                    multiplier = 0.9;
System.out.println("Rent of " +player.getProperties().get(nUserInput).getName()+ " decreased by 10%");
                }
                else if(nIndex == 4){//Increase by 10%
                    multiplier = 1.1;
System.out.println("Rent of " +player.getProperties().get(nUserInput).getName()+ " increased by 10%");
                }
            }
            else
System.out.println("Not applicable. No owned utilities or railroads.");
        }


              
        player.getCards().remove(player.getCards().size() - 1); //remove from the player's hand
        return event;
    }
}