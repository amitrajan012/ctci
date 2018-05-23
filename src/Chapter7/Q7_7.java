package Chapter7;

import java.util.ArrayList;

/**
 * 
 * Explain how you would design a chat server. 
 * In particular, provide details about the various backend components, classes, and methods. What would be the hardest problems to solve?
 *
 */
public class Q7_7 {

}

class User {
	private String ID;
	private String dispayName;
	private StatusType status;
	private ArrayList<User> contacts;
	
	public User(String id, String name) {
		ID = id;
		dispayName = name;
	}
	
	public static User createUser(String id, String name) {
		return new User(id, name);
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	public String getDispayName() {
		return dispayName;
	}

	public void setDispayName(String dispayName) {
		this.dispayName = dispayName;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public ArrayList<User> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<User> contacts) {
		this.contacts = contacts;
	}
}

enum StatusType {
	ONLINE, OFFLINE, AWAY;
}

enum RequestStatus {
	SUCCESS, FAILURE;
}

class Server {
	public static RequestStatus createAccount(String name) {
		User u = User.createUser(generateUniqueID(), name);
		System.out.println("User successfully created with ID: " + u.getID());
		return RequestStatus.SUCCESS;
	}
	
	public static ArrayList<User> getContactList(User user) {
		return user.getContacts();
	}
	
	public static ArrayList<User> getOnlineContacts(User user) { 
		ArrayList<User> onlineContacts = new ArrayList<User>();
		for(User u : user.getContacts()) {
			if(u.getStatus() == StatusType.ONLINE) {
				onlineContacts.add(u);
			}
		}
		return onlineContacts;
	}
	
	private static String generateUniqueID() {
		//Generates Unique UserID for users
		return null;
	}
}