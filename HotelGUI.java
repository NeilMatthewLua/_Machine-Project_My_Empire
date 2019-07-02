import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class HotelGUI extends JFrame
{
	private final int NAME = 0;
	private final int NATIONALITY = 1;
	
	public final int MAX_GUEST = 2;
	
	public final String BLANK = "Blank";
	public final String BOOK = "Book";
	public final String ADD_GUEST = "Add Guest";
	public final String ROOM_INFO = "Room Info";
	
	private JComboBox<String> cmbRooms;
	private JTextArea taRoom;
	private JButton btnBook;
	private JPanel panelRoomInfo;
	private JPanel panelBook;
	private JPanel panelAddGuest;
	private JButton btnSave;
	private JButton btnCancel;
	private JTextField[][] tfGuest;
	private JPanel centerPane;
	
	
	public HotelGUI (String name, int rooms)
	{
		super (name);
		
		setLayout (new BorderLayout ());
		setup (rooms);
		init ();

		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setSize (400, 400);
		setVisible (true);
	}
	
	public void init ()
	{
		JPanel panel;
		JPanel subPanel;
		
		centerPane = new JPanel ();
		centerPane.setLayout (new CardLayout ());
		
		// blank
		panel = new JPanel ();
		centerPane.add (panel, BLANK);
		
		// room info
		panelRoomInfo = new JPanel ();
		panelRoomInfo.setLayout (new BorderLayout ());
		
		taRoom = new JTextArea ();
		taRoom.setEditable (false);
		JScrollPane scroll = new JScrollPane (taRoom);
		panelRoomInfo.add (scroll, BorderLayout.CENTER);

		centerPane.add (panelRoomInfo, ROOM_INFO);
		
		
		// book button
		panelBook = new JPanel ();
		panelBook.setLayout (new FlowLayout ());
		btnBook = new JButton ("Book");
		panelBook.add (btnBook);
		
		centerPane.add (panelBook, BOOK);
		
		
		// add guest and save
		panelAddGuest = new JPanel ();
		panelAddGuest.setLayout (new GridLayout (3, 1));
		
		tfGuest = new JTextField[MAX_GUEST][2];
		
		int j, k;
		for (j = 0; j < tfGuest.length; j++)
		{
			panel = new JPanel ();
			panel.setBorder(BorderFactory.createLineBorder(Color.black));
			panel.setLayout (new GridLayout (3, 1, 0, 0));
			subPanel = new JPanel ();
			subPanel.setLayout (new FlowLayout (FlowLayout.LEFT));
			subPanel.add (new JLabel ("Guest " + (j + 1)));
			panel.add (subPanel);
			for (k = 0; k < tfGuest[j].length; k++)
			{
				subPanel = new JPanel ();
				subPanel.setLayout (new FlowLayout (FlowLayout.LEFT, 50, 0));
				
				switch (k)
				{
					case NAME:
						subPanel.add (new JLabel ("Name:"));
						break;
					case NATIONALITY:
						subPanel.add (new JLabel ("Nationality: "));
						break;
				}
				tfGuest[j][k] = new JTextField (15);
				
				subPanel.add (tfGuest[j][k]);
				panel.add (subPanel);

			}
			panelAddGuest.add (panel);
		}
		
		panel = new JPanel ();
		panel.setLayout (new FlowLayout ());
		btnSave = new JButton ("Save");
		btnCancel = new JButton ("Cancel");
		panel.add (btnSave);
		panel.add (btnCancel);
		panelAddGuest.add (panel);
		
		centerPane.add (panelAddGuest, ADD_GUEST);
		
		add (centerPane, BorderLayout.CENTER);
	}
	
	
	
	public void setup (int rooms)
	{
		String[] strRooms = new String[rooms + 1];
		int j;
		
		
		strRooms[0] = "<Select Room>";
		for (j = 1; j < strRooms.length; j++)
		{
			strRooms[j] = "Room " + j;
		}
		
		cmbRooms = new JComboBox<> (strRooms);
		JPanel panel = new JPanel ();
		panel.setLayout (new FlowLayout ());
		
		panel.add (cmbRooms);
		add (panel, BorderLayout.NORTH);
	}

	public void addListeners (EventListener listener)
	{
		cmbRooms.addItemListener ((ItemListener) listener);
		
		btnSave.addActionListener ((ActionListener) listener);
		btnCancel.addActionListener ((ActionListener) listener);
		btnBook.addActionListener ((ActionListener) listener);
	}
	
	public void resetComboSelection ()
	{
		cmbRooms.setSelectedIndex (0);
	}
	
	public void updateRoomInfo (String info)
	{
		taRoom.setText (info);
	}
	
	public String getItemSelected ()
	{
		return (String) cmbRooms.getSelectedItem ();
	}
	
	public void updateCenterPane (String name)
	{
		CardLayout cards = (CardLayout) centerPane.getLayout ();
		
		cards.show(centerPane, name);
	}
	
	public void resetGuestInfo ()
	{
		int j, k;
		
		for (j = 0; j < tfGuest.length; j++)
		{
			for (k = 0; k < tfGuest[j].length; k++)
			{
				tfGuest[j][k].setText ("");
			}
		}
	}
	
	public String getGuestName (int index)
	{
		return tfGuest[index][NAME].getText ();
	}
	
	public String getGuestNationality (int index)
	{
		return tfGuest[index][NATIONALITY].getText ();
	}
}
