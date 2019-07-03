import java.util.ArrayList;
public class Room {
    final int roomNo ;
    ArrayList<Guest> guests;
    final int nCapacity;


    public Room(int roomNo){
        this.roomNo = roomNo;
        guests = new ArrayList<Guest>();
        this.nCapacity = 6;
    }

    public Room(int roomNo, int nCapacity){
        this.roomNo = roomNo;
        guests = new ArrayList<Guest>();
        this.nCapacity = nCapacity;
    }

    public int getRoomNo(){
        return roomNo;
    }
    public int getGuestSize(){
        return guests.size();
    }
    public ArrayList<Guest> getGuests(){
        return guests;
    }

    public void addGuest(Guest g){
        if(!isFull()){
            guests.add(g);
        }
    }

    public void removeGuest(Guest g){
        if(guests.size() > 0){
            guests.remove(g);
        }
    }

    public boolean isFull(){
        return (guests.size() == nCapacity);
    }

    @Override
    public String toString(){
        String info = "";
        for(int i = 0; i < guests.size(); i++){
            info += "Guest: ";
            info += guests.get(i).getName();
            info += "\n Nationality: ";
            info += guests.get(i).getNationality();
            info += "\n";
        }
        return info;
    }
}