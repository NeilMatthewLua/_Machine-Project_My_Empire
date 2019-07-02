import javax.swing.*;

public class HotelDriver
{
	public static void main (String[] args)
	{
		String strHotel;
		int nRooms;
		
		HotelOpen dialog = new HotelOpen (null, true);
		
		strHotel = dialog.getHotelName ();
		nRooms = dialog.getRoomCount ();
		
		if (strHotel != null && nRooms != 0)
		{

			Hotel hotel = new Hotel (strHotel, nRooms);
			HotelGUI gui = new HotelGUI (strHotel, nRooms);
		
			
			HotelController controller;

			controller = new HotelController (gui, hotel);
		}
	}
}
