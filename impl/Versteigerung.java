import java.util.*;

public class Versteigerung extends MObject {

	public Auftrag auftrag;
	public Collection<TimeStamp> endsAt;
	public Trucker bidder;
	private int currentBid;

	/**
	 * 
	 * @param kaeufer
	 * @param bid
	 */
	public boolean bid(Trucker kaeufer, int bid) {
		// TODO - implement Versteigerung.bid
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param uID
	 * @param auftrag
	 */
	public Versteigerung(String uID, Auftrag auftrag) {
		super(uID);
		// TODO - implement Versteigerung.Versteigerung
		throw new UnsupportedOperationException();
	}

}