package objects;
import java.util.*;

public class Ort extends MObject {

	protected Collection<LocalService> services;
	protected Collection<Strasse> verbindungen;

	/**
	 * 
	 * @param uID
	 */
	public Ort(String uID) {
		super(uID);
		this.services = new ArrayList<>();
		this.verbindungen = new ArrayList<>();
	}

	/**
	 * erzeugt eine Straße von diesem zu einem anderen Ort.
	 * @param other
	 * @param kosten
	 */
	public void connect(Ort other, int kosten) {
		Strasse s = new Strasse(other,kosten);
		this.verbindungen.add(s);
	}

	/**
	 * 
	 * @param l
	 */
	public void registerService(LocalService l) {
		this.services.add(l);
	}

	public Collection<Strasse> getStreets() {
		return verbindungen;
	}

	public Collection<LocalService> getServices() {
		return services;
	}

}