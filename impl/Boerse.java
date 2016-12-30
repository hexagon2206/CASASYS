import java.util.*;

public class Boerse extends LocalService {

	public Map<Auftrag, Versteigerung> versteigerung;

	/**
	 * 
	 * @param auftrag
	 */
	public void auction(Auftrag auftrag) {
		if(auftrag == null) return;
		versteigerung.put(auftrag, new Versteigerung(MObjectRepo.getNewUID(), auftrag));
	}

	/**
	 * 
	 * @param auftrag
	 * @param kaeufer
	 * @param bid
	 */
	public boolean bid(Auftrag auftrag, Trucker kaeufer, int bid) {
		versteigerung.get(auftrag).bid(kaeufer, bid);
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