import java.util.*;

public class Message extends MObject {

	TimeStamp createdAt;
	protected Trucker creator;
	Collection<Knowledge> contains;

	/**
	 * creates a message with given information
	 * @param uID
	 * @param knowledge : Collection of all information, the message shall contain
	 */
	public Message(String uID, Collection<Knowledge> knowledge) {
		super(uID);
		this.contains = knowledge;
		this.createdAt = TimeStamp.now();
	}

}