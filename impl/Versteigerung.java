import java.util.*;

public class Versteigerung extends MObject {

	public Auftrag auftrag;
	public Collection<TimeStamp> endsAt;
	public Trucker bidder;
	private int currentBid;

    //TODO: was für ein auktionsverfahren? startwert 0 und das höchste gebot gewinnt?
    //TODO: wann laufen Auktionen aus?

	/**
	 * place a bid for this auction
	 * @param kaeufer
	 * @param bid
	 */
	public boolean bid(Trucker kaeufer, int bid) {
		// TODO - implement Versteigerung.bid
		throw new UnsupportedOperationException();
	}

	/**
	 * create a new Versteigerung for auftrag
	 * @param uID
	 * @param auftrag
	 */
	public Versteigerung(String uID, Auftrag auftrag) {
		super(uID);
		this.auftrag = auftrag;
		//TODO: start value
	}

	public int currentBid() {
		return currentBid;
	}
}