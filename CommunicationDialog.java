
public class CommunicationDialog {
	
	protected String givenName;
	
	public void setName(String name)
	{
		givenName = name;
	}
	
	public String Name ()
	{
		String returnString = "Nice to meet you " + givenName;
		
		return returnString;
	}
	
	public String Mission()
	{
		String returnString = "\nWell, " + givenName + " you have been invited to practicipted in what we call, the "
				+ "fallen prisoner, get ready, begin\n";
		
		return returnString;
	}
	
	public String Info()
	{
		String returnString = "\nAren't I glad you are ready!, you will start of by search for items." 
				+ "\nYou can see that there is 4 other buttons have appeared! They are self-explanatory. \nList of Rooms are "
				+ "rooms you have been in previously. \nInventory is to check what you already have. \nEquipment, this might come in"
				+ " handy when you need to use something for some reason... \nAnd finally Search... this is useful... a lot..."
				+ "\nGo ahead you can try them... if you want... I know you want too... there is basic commands to nevigate through"
				+ " this game... what's your name again... oh I remember " + givenName + " if you don't like the name you told me"
						+ " I can ask for it to be changed... but it might take a long time... finally.. Do you want to know the basic"
						+ " commands? (reply Help)\n";
		return returnString;
	}
	
	public String BasicCommands()
	{
		String returnString = "\nThe following are the basics you need  to operate in this game. \nTyping Move 'and the room you want "
				+ "to move to'"
				+ "\nTyping Search 'will search the room'"
				+ "\nTyping Move To 'Add the name of room you want to go to, e.g. Move to Basment'"
				+ "\nTyping Yes/Sure 'To accept'"
				+ "\nTyping No 'To refuse'\n";
		
		return returnString;
	}
}
