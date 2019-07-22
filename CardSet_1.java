public abstract class CardSet_1 extends Card{

    public CardSet_1(int nIndex,int nGroup, boolean canKeep, String[][] list){
        super(nIndex, nGroup, canKeep, list);
    }

    @Override
    public String useCard(Player player, Gameboard gameboard){
        String event = "";
        player.setJail(false);
        event += player.getName() + "used a get of jail card!";

        return event;
    }

}