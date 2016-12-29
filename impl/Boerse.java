import java.util.*;

public class Boerse extends LocalService {

	public Collection<Versteigerung> versteigerung;

	/**
	 * 
	 * @param auftrag
	 */
	public void auction(Auftrag auftrag) {
		// TODO - implement Boerse.auction
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param auftrag
	 * @param kaeufer
	 * @param bid
	 */
	public boolean bid(Auftrag auftrag, Trucker kaeufer, int bid) {
		// TODO - implement Boerse.bid
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param uID
	 */
	public Boerse(String uID) {
		super(uID);
		this.versteigerung = new ArrayList<Versteigerung>();
	}

	/**
	 * get all currently available auctions
	 */
	public Collection<Versteigerung> getAuctions() {
		return versteigerung;
	}

}