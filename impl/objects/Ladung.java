package objects;
/**
 * Ladung kann nur in einer Ladebucht ODER auf einem Truck sein.
 */
public class Ladung extends MObject {

	protected Ort ziel;
	protected Ladebucht gelagertIn;
	protected Trucker geladenVon;

	/**
	 * 
	 * @param uID
	 * @param ziel
	 * @param pos
	 */
	public Ladung(String uID, Ort ziel, Ladebucht pos) {
		super(uID);
		this.ziel = ziel;
		this.gelagertIn = pos;
		this.geladenVon = null;
	}

}