import java.util.*;

import javax.swing.*;

import java.util.concurrent.*;

public class ButtonActionCommandHandler{
	
	protected CommunicationDialog cd = new CommunicationDialog();
	protected SelectionOfRooms sr = new SelectionOfRooms();
	
	private int count = 0;
	
	public void getSetName(String name)
	{
		cd.setName(name);
	}
	
	public void getRooms(String room)
	{
		sr.SetListOfRooms(room);
	}
	
	public void actionPerformed(String e, JTextField firstText, JTextArea secondText, JButton listOfRooms, JButton inventory,
			JButton equipment, JButton searchRoom)
	{
		if ("SUBMIT".equals(e))
		{
			if (firstText.getText().equals("I'm ready!"))
			{
				secondText.append(cd.Info());
				
				listOfRooms.setVisible(true);
		        inventory.setVisible(true);
		        equipment.setVisible(true);
		        searchRoom.setVisible(true);
		        firstText.setText("");
			}
			else if (firstText.getText().equals("Help"))
			{
				secondText.append(cd.BasicCommands());
			}
			else
			{
				for (int i = count; i < 3; i++)
				{
					secondText.append("\nSorry didn't quite get that...");
					count++;
				}
			}
		}
		else if ("LIST OF ROOMS".equals(e))
		{
			ArrayList <String> getList = new ArrayList<String>(sr.getListOfRooms());
			
			for(int i = 0; i < getList.size(); i++) {   
				secondText.append("\n" + getList.get(i));
				
				listOfRooms.setEnabled(false);
			}
		}
	}
}
