import java.util.*;

public class Boerse extends LocalService {

	public Map<Auftrag, Versteigerung> versteigerung;

	/**
	 * put a job for auction
	 * @param auftrag
	 */
	public void auction(Auftrag auftrag) {
		if(auftrag == null) return;
		versteigerung.put(auftrag, new Versteigerung(MObjectRepo.getNewUID(), auftrag));
	}

	/**
	 * place a bid for a job
	 * @param auftrag : job to bid on
	 * @param kaeufer : bidding trucker
	 * @param bid : amount to bid with
	 * @return : true, if bid was accepted
	 */
	public boolean bid(Auftrag auftrag, Trucker kaeufer, int bid) {
		Versteigerung auction = versteigerung.get(auftrag);
		if(auction == null) return false;
		return auction.bid(kaeufer, bid);
	}

	/**
	 * 
	 * @param uID
	 */
	public Boerse(String uID) {
		super(uID);
		this.versteigerung = new HashMap<Auftrag, Versteigerung>();
	}

	/**
	 * get all currently available auctions
	 */
	public Collection<Versteigerung> getAuctions() {
		return versteigerung.values();
	}

}