package objects;
import java.util.*;

public class Ladebucht extends LocalService {

	protected Collection<Ladung> ladungen;

	/**
	 * 
	 * @param ladung
	 */
	public void store(Ladung ladung) {
		ladung.gelagertIn = this;
		ladung.geladenVon = null;
		this.ladungen.add(ladung);
	}

	/**
	 * 
	 * @param ladung
	 * @param trucker
	 */
	public boolean load(Ladung ladung, Trucker trucker) {
		if(!this.ladungen.contains(ladung)) return false;
		if(!(1!=trucker.isAt.done)) return false;
		if(!trucker.isAt.at.ziel.getServices().contains(this)) return false;
		trucker.load(ladung);
		return true;
	}

	/**
	 * 
	 * @param uID
	 */
	public Ladebucht(String uID) {
		super(uID);
		this.ladungen = new ArrayList<>();
	}

}