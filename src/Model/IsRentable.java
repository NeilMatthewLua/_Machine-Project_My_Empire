package Model;

/**
 * Interface which is implemented by certain Ownable objects
 */
public interface IsRentable{

    /**
     * Abstract method which will return the rent of a space
     * @param player the Player which will be used in calculating the rent cost
     * @return the rent price of the space
     */
    public double getRent(Player player);
}