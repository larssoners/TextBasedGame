import java.util.*;

public class SelectionOfRooms {
	
	protected ArrayList<String> listOfRooms = new ArrayList<String>();
	
	public void SetListOfRooms(String room)
	{
		listOfRooms.add(room);
	}
	
	public ArrayList<String> getListOfRooms()
	{
		return listOfRooms;
	}
}
