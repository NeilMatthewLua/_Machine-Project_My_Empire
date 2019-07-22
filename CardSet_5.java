import java.util.*;

public abstract class CardSet_5 extends Card{

    public CardSet_5(int nIndex,int nGroup, boolean canKeep, String[][] list){
        super(nIndex, nGroup, canKeep, list);
    }

    @Override
    public String useCard(Player player, Gameboard gameboard){
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

            if(tempArr.size() > 0)
                isValid = true;

            if(isValid){
for(int i = 0; i < tempArr.size(); i++)//Display possible properties to add effect
System.out.println(i + "." + player.getProperties().get(tempArr.get(i)).getName());
                Scanner sc = new Scanner(System.in);
                nUserInput = sc.nextInt();
                if(nIndex == 0){//Double Rent
                    player.getProperties().get(nUserInput).setDoubleRent(true);
                    event += "Rent of " + player.getProperties().get(nUserInput).getName() + " doubled for next collection.";
                }
                else if(nIndex == 1){//Renovation
                    double dRenovation = 0; //Renovation price
                    if(player.getProperties().get(nUserInput).getDevelopment() >= 1){//Calculates price of renovation
                        if(player.getProperties().get(nUserInput).getDevelopment() == 5){
                            dRenovation += 50;
                            dRenovation += (player.getProperties().get(nUserInput).getDevelopment() - 1) * 25;
                        }
                        else
                            dRenovation += player.getProperties().get(nUserInput).getDevelopment() * 25;
                    }

                    if(player.getMoney() - dRenovation > 0){//If rent is applicable
                        player.giveMoney(gameBoard.getBank(),dRenovation);
                        player.getProperties().get(nUserInput).setMultiplier(1.5);
                        System.out.println("Rent of " +player.getProperties().get(nUserInput).getName()+" increased by 50%");
                    }
                    else
System.out.println("Insuficient Funds. Cannot Develop");
                }
                else if(nIndex == 2){//Dilapidated Houses
                    player.getProperties().get(nUserInput).setMultiplier(.9);
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
                if(player.getProperties().get(i).getLandType().equals("utility") || player.getProperties().get(i).getLandType().equals("railroad")){
                    tempArr.add(i);
                }

                if(tempArr.size() > 0)
                    isValid = true;

            if(isValid){
for(int i = 0; i < tempArr.size(); i++)//Display possible utilities/railroads to add effect
    System.out.println(i + "." + player.getProperties().get(tempArr.get(i)).getName());
                Scanner sc = new Scanner(System.in);
                nUserInput = sc.nextInt();

                if(nIndex == 3){//Decrease by 10%
                    player.getProperties().get(nUserInput).setMultiplier(.9);
System.out.println("Rent of " +player.getProperties().get(nUserInput).getName()+ " decreased by 10%");
                }
                else if(nIndex == 4){//Increase by 10%
                    player.getProperties().get(nUserInput).setMultiplier(1.1);
System.out.println("Rent of " +player.getProperties().get(nUserInput).getName()+ " increased by 10%");
                }
            }
            else
System.out.println("Not applicable. No owned utilities or railroads.");
        }


        return event;
    }
}