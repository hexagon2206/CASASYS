package objects;
import java.util.*;

public class Funk extends LocalService {

	protected Collection<Trucker> registered;

	/**
	 * sends a message m to a Trucker to, if he is available for this funk.
	 * @param m
	 * @param to
	 * @return true, if the message could be delivered; false if not.
	 */
	public boolean send(Message m, Trucker to) {
		// TODO - implement Funk.send
		throw new UnsupportedOperationException();
	}

	/**
	 * returns the number of receiving truckers
	 * @param m : message to be sent to all truckers
	 */
	public int broadCast(Message m) {
		int count = 0;
		for(Trucker to : registered) {
			if(send(m, to)) count++;
		}
		return count;
	}

	/**
	 * 
	 * @param participant
	 */
	public void register(Trucker participant) {
		if(participant != null) registered.add(participant);
	}

	/**
	 * 
	 * @param participant
	 */
	public boolean unregister(Trucker participant) {
		return registered.remove(participant);
	}

	/**
	 * 
	 * @param uID
	 */
	public Funk(String uID) {
		super(uID);
	}

}