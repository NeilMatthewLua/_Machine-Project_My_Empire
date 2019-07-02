import java.util.ArrayList;
public class Hotel {
    Room[] rooms;
    final int nSize;
    final String name;
    public Hotel (String name, int roomsNo){
        nSize = roomsNo;
        this.name = name;
        rooms = new Room [nSize];
        for(int i = 0; i < nSize; i++){
            rooms[i] = new Room(i+1);
        }
    }
    public void addGuest(int room, ArrayList<Guest> g){
        for(int i = 0; i < g.size(); i++)
            rooms[room].addGuest(g.get(i));
    }

    public String displayGuests(int room){
        return rooms[room].toString();
    }

    public Room[] getRooms(){
        return rooms;
    }
}