public class main {
    public static void main (String[] args) {
        Player a = new Player("Albert");

        System.out.println(a.getPosition());
        a.roll();
        System.out.println(a.getPosition());


    }
}