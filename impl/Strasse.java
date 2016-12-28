public class Strasse {

	protected Ort ziel;
	private int kosten;

	/**
	 * 
	 * @param target
	 * @param kosten
	 */
	public Strasse(Ort target, int kosten) {
		this.ziel = target;
		this.kosten = kosten;
	}

}