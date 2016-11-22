import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;

public class MainFrame implements ActionListener{
	
	protected JPanel gui = new JPanel(new BorderLayout());
	public JTextField firstText = new JTextField("Insert Text");
	public JTextArea secondText = new JTextArea(25,40);
	protected JButton submit = new JButton("SUBMIT");
	protected JButton listOfRooms = new JButton("LIST OF ROOMS");
	protected JButton inventory = new JButton("INVENTORY");
	protected JButton equipment = new JButton("EQUIPMENT");
	protected JButton searchRoom = new JButton("SEARCH ROOM");
	protected String name;
	protected JFrame startGameFrame = new JFrame("The Evo Man");
	protected ButtonActionCommandHandler bach = new ButtonActionCommandHandler();
	
	protected CommunicationDialog cd = new CommunicationDialog();
	
	public MainFrame(){
		gui.setBorder(new EmptyBorder(2,3,2,3));
		bach.getRooms("Basement");
	}
	
	public void Display()
	{
		SetTexts();
		SetButtons();
        
        startGameFrame.add(gui);
        startGameFrame.setResizable(false);
        
        JFrame getNameFrame = new JFrame("Name yourself");
		name = JOptionPane.showInputDialog(getNameFrame, "Oh hello there, what do they call you by?");
		getNameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		listOfRooms.setVisible(true);
		
		bach.getSetName(name);
		cd.setName(name);
        
        secondText.append(cd.Name());
		secondText.append(cd.Mission());
		firstText.setText("Say I'm ready! to begin!");
		startGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startGameFrame.setLocationByPlatform(true);
		startGameFrame.pack();
        
		
		startGameFrame.setVisible(true);
	}
	
	public void SetTexts()
	{
		JPanel textPanel = new JPanel(new BorderLayout(2,2));
		
		JScrollPane firstScroll = new JScrollPane(firstText);
		firstScroll.setAutoscrolls(true);
		
		firstScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		DefaultCaret caret = (DefaultCaret) secondText.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
        secondText.setLineWrap(true);
        secondText.setWrapStyleWord(true);
        secondText.setEditable(false);
		JScrollPane secondScroll = new JScrollPane(secondText);
		secondScroll.setViewportView(secondText);
		secondScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		textPanel.add(firstScroll, 
                BorderLayout.PAGE_START);
        textPanel.add(secondScroll);
        gui.add(textPanel, BorderLayout.CENTER);
	}
	
	public void SetButtons()
	{
		JPanel buttonCenter = new JPanel(new GridBagLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(5,0));
        
        
        submit.setActionCommand("Submit");
        submit.addActionListener(this);
        
        listOfRooms.setActionCommand("List of Rooms"); 
        listOfRooms.addActionListener(this);
        
        listOfRooms.setVisible(false);
        inventory.setVisible(false);
        equipment.setVisible(false);
        searchRoom.setVisible(false);
        
        buttonPanel.add(submit);
        buttonPanel.add(listOfRooms);
        buttonPanel.add(inventory);
        buttonPanel.add(equipment);
        buttonPanel.add(searchRoom);
        
        JPanel twoComponent = new JPanel(new BorderLayout());
        
        twoComponent.add(buttonCenter, BorderLayout.NORTH);
        
        buttonCenter.add(buttonPanel);
        gui.add(twoComponent, BorderLayout.EAST);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JButton o = (JButton)e.getSource();
		String name = o.getText();
		
		//t.testing(firstText);
		bach.actionPerformed(name, firstText, secondText, listOfRooms, inventory, equipment, searchRoom);
		
		if (name == "LIST OF ROOMS")
		{
			try {
				Thread.sleep(2000);
				listOfRooms.setEnabled(true);
			} catch (InterruptedException ae) {
				// TODO Auto-generated catch block
				ae.printStackTrace();
			}
		}
	}
	
	public void windowClosed(WindowEvent e){
	    System.exit(0);
	}
}