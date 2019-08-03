package Controller;

public class creator {
    public static void main(String[] args) {
        String s1 = "owners.add(owner";
        String s2 = ");";
        for(int i = 1; i <= 28; i++){
            System.out.print(s1+i+s2);
            if(i % 5 == 0)
                System.out.println();
        }
    }
}
