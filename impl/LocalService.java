import java.util.*;

public abstract class LocalService extends MObject {

	protected Collection<Ort> availableAt;

	/**
	 * 
	 * @param uID
	 */
	public LocalService(String uID) {
		super(uID);
	}

}