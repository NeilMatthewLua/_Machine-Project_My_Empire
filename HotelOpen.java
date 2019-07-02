import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelOpen extends JDialog implements ActionListener
{
	private JTextField tfName;
	private JTextField tfCount;
	private JButton btnOk;
	
	public HotelOpen (JFrame owner, boolean modal)
	{
		super (owner, modal);
		init ();
		
		setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
		setSize (300, 150);
		setVisible (true);
	}
	
	public void init ()
	{
		setLayout (new GridLayout (3, 1));
		
		tfName = new JTextField (15);
		tfCount = new JTextField (5);
		btnOk = new JButton ("Create");
		
		JPanel panel = new JPanel ();
		panel.setLayout (new FlowLayout ());
		
		panel.add (new JLabel ("Hotel Name: "));
		panel.add (tfName);
		
		add (panel);
		
		panel = new JPanel ();
		panel.setLayout (new FlowLayout ());
		
		panel.add (new JLabel ("Number of Rooms: "));
		panel.add (tfCount);
		
		add (panel);
		
		panel = new JPanel ();
		panel.setLayout (new FlowLayout ());
		
		panel.add (btnOk);
		btnOk.addActionListener (this);
		
		add (panel);

	}
	
	public void actionPerformed (ActionEvent event)
	{
		if (event.getActionCommand ().equals ("Create"))
		{
			dispose ();
		}
	}
	
	public String getHotelName ()
	{
		return tfName.getText ();
	}
	
	public int getRoomCount ()
	{
		if (tfCount.getText ().length () != 0)
			return Integer.parseInt (tfCount.getText ());
		return 0;
	}
}
