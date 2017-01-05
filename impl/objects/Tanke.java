package objects;
public class Tanke extends LocalService {

	private int preis;

	/**
	 * erzeugt eine neue Tanke mit festgelegtem Preis
	 * @param preis : preis pro Liter an dieser Tankstelle
	 * @param uID
	 */
	public Tanke(int preis, String uID) {
		super(uID);
		this.preis = preis;
	}

	/**
	 * tankt einen Truck t um units Einheiten Benzin auf. Dem Trucker wird units * preis Geld abgebucht.
	 * @param t : zu befuellender Truck
	 * @param units : zu tankende Menge
	 */
	public void fillUp(Trucker t, int units) {
		int total = units * preis;
		t.bookMoney(total);
		t.fillUp(units);
	}

}