public class Tanke extends LocalService {

	private int preis;

	/**
	 * erzeugt eine neue Tanke mit festgelegtem Preis
	 * @param preis
	 * @param uID
	 */
	public Tanke(int preis, String uID) {
		super(uID);

		this.preis = preis;
	}

	/**
	 * tankt einen Truck t um units Einheiten Benzin auf. Dem Trucker wird units * preis geld abgebucht.
	 * @param t
	 * @param units
	 */
	public void fillUp(Trucker t, int units) {
		int total = units * preis;
		t.bookMoney(total);
		t.fillUp(units);
	}

}