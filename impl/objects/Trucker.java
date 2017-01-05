package objects;
import java.util.*;

public class Trucker extends MObject {

	Collection<Knowledge> knows;
	protected Collection<Ladung> ladung;
	public Position isAt;
	protected Collection<Funk> registerd;
	protected Collection<Auftrag> besitzt;
	private int kapazizaet;
	private int tankfuellung;
	private int kapital;

	/**
	 * 
	 * @param amount
	 */
	public void bookMoney(int amount) {
		this.kapital -= amount;
	}

	/**
	 * fills this trucker with specified amount of gasoline
	 * @param units : amount of gasoline to fill in
	 */
	public void fillUp(int units) {
		this.tankfuellung+=units;
	}

	/**
	 * 
	 * @param uID
	 * @param kapazizaet
	 * @param tank
	 * @param kapital
	 */
	public Trucker(String uID, int kapazizaet, int tank, int kapital,Position p) {
		super(uID);
		this.kapazizaet = kapazizaet;
		this.tankfuellung = tank;
		this.kapital = kapital;
		this.isAt = p;
		
		this.ladung = new ArrayList<>();
		this.registerd = new ArrayList<>();
		this.besitzt = new ArrayList<>();
	}

	/**
	 * 
	 * @param ladung
	 */
	public void load(Ladung ladung) {
		this.ladung.add(ladung);
		ladung.geladenVon=this;
		ladung.gelagertIn=null;
	}

}