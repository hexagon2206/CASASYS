import java.util.*;

public class SchwarzesBrett extends LocalService {

	protected Collection<Message> messages;
	private static int MAX_MESSAGES = 20;
	/**
	 * 
	 * @param m
	 */
	public void pin(Message m) {
		if(m == null) return;
		if(messages.size() == MAX_MESSAGES) messages.remove(0);
		messages.add(m);
		//TODO: unter welchen Bedingungen werden alte nachrichten entfernt?
		//derzeit maximale Anzahl an nachrichten.
	}

	/**
	 * 
	 * @param uID
	 */
	public SchwarzesBrett(String uID) {
		super(uID);
		this.messages = new LinkedList<Message>();
	}

}