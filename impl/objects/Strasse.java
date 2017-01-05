package objects;
public class Strasse {

	protected Ort ziel;
	private int kosten;

	/**
	 * 
	 * @param target : Ort, zu der diese Strasse fuehrt
	 * @param kosten : Reisekosten zum vollstaendigen Befahren dieser Strasse
	 */
	public Strasse(Ort target, int kosten) {
		this.ziel = target;
		this.kosten = kosten;
	}
	
	public int getKosten() {
		return kosten;
	}

}