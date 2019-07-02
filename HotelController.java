import java.awt.event.*;
import java.util.*;

public class HotelController implements ActionListener, ItemListener
{
	private HotelGUI gui;
	
	Hotel hotel;

	
	/* TO DO: declare reference to Hotel object as the second parameter of this constructor */
	public HotelController (HotelGUI gui, Hotel h)
	{
		/* TO DO: assign to hotel attribute the reference in the parameter */
		hotel = h;
		this.gui = gui;
		gui.addListeners (this);
	}
	
	// ActionListener
	public void actionPerformed (ActionEvent e)
	{
		if (e.getActionCommand ().equals ("Book"))
		{
			gui.updateCenterPane (gui.ADD_GUEST);
		}
		else if (e.getActionCommand ().equals ("Save"))
		{
			// collect data
			StringTokenizer strData = new StringTokenizer (gui.getItemSelected (), "Room ");
			int roomno = Integer.parseInt (strData.nextToken ());
			
			/* TO DO: Fill in the type of data for the ArrayList with your declared class for guests
			 */
			ArrayList<Guest> guests = getGuests ();
			
			/* TO DO: update room booking
			 - book guest/s to the room number roomno

			 - note that guests has one element only if one guest is added only.
			 */
			hotel.addGuest(roomno, guests);
			gui.resetGuestInfo ();
			
			/* TO DO : call update method, pass in the parameter the room info (i.e. guest data) */
			update(hotel.displayGuests(roomno));
		}
		else if (e.getActionCommand ().equals ("Cancel"))
		{
			gui.resetGuestInfo ();
			gui.updateCenterPane (gui.BOOK);
		}
	}


	/* TO DO: Fill in the type of data for the ArrayList with your declared class for guests
	 */
	public ArrayList<Guest> getGuests ()
	{
		ArrayList<Guest> guests = new ArrayList<Guest> ();
		/* TO DO: Declare a reference to Guest object */


		String name, nationality;
		int j;
		
		for (j = 0; j < gui.MAX_GUEST; j++)
		{
			name = gui.getGuestName (j);
			nationality = gui.getGuestNationality (j);
			
			if (!name.equals (""))
			{
				/* TO DO: instantiate a new guest with name and nationality,
				 		  and add the new guest to the list */
				guests.add(new Guest(name, nationality));

			}
		}
		
		return guests;
	}
	
	public void resetAndUpdate ()
	{
		gui.resetComboSelection ();
		gui.updateCenterPane (gui.BLANK);
	}
	
	public void update (String info)
	{
		gui.updateRoomInfo (info);
		gui.updateCenterPane (gui.ROOM_INFO);
	}
	
	public void book ()
	{
		gui.updateCenterPane (gui.BOOK);
	}
	
	// ItemListener
	public void itemStateChanged (ItemEvent e)
	{
		if (e.getStateChange () == ItemEvent.SELECTED)
		{
			if (e.getItem ().toString ().substring (0, "Room ".length ()).equals ("Room "))
			{
				String strCommand = e.getItem ().toString ();
				
				StringTokenizer strData = new StringTokenizer (strCommand, "Room ");
				int roomno = Integer.parseInt (strData.nextToken ());
				
				
				/* TO DO:
				 	- if room is occupied,
				 		call update method, pass in the parameter the room info (i.e. guest data)
				 	- otherwise,
				 		call book();
				 */
				if(hotel.getRooms()[roomno].isFull()){
					update(hotel.displayGuests(roomno));
				}
				else
					book();
			}
			else // <Select Room> selected
			{
				resetAndUpdate ();
			}
		}
	}
}
