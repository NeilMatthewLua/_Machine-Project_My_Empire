public class Guest {
    String strName;
    String strNationality;

    public Guest(String name, String nationality){
        strName = name;
        strNationality = nationality;
    }

    public String getName(){return strName;}
    public String getNationality(){return strNationality;}
}