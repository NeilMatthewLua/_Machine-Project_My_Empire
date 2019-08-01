package Controller;

public class creator {
    public static void main(String[] args) {
        String s1 = "player4Spaces.add(playerFour";
        String s2 = ");";
        for(int i = 1; i <= 32; i++){
            System.out.print(s1+i+s2);
        }
    }
}
