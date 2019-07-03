import javax.swing.*;

public class HotelDriver
{
	public static void main (String[] args)
	{
		String strHotel;
		int nRooms;
		int nCapacity;

		HotelOpen dialog = new HotelOpen (null, true);
		
		strHotel = dialog.getHotelName ();
		nRooms = dialog.getRoomCount ();
		nCapacity = dialog.getRoomCapacity();

		if (strHotel != null && nRooms != 0)
		{

			Hotel hotel = new Hotel (strHotel, nRooms, nCapacity);
			HotelGUI gui = new HotelGUI (strHotel, nRooms, nCapacity);
		
			
			HotelController controller;

			controller = new HotelController (gui, hotel);
		}
	}
}
