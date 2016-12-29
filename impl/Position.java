public class Position {

	public final Strasse at;
	/**
	 * The Position is described via a Street and a value between 0 and 1.
	 * The value describes by how many Percent the destination is reached.
	 * A 1 means we are at the destination of the street
	 */
	public Double done;

	new Position(Strasse at) {
		this.at = at;
		this.done = 0.0;
	}

}