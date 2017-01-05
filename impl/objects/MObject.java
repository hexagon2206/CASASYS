package objects;
/**
 * An base Class for all Objects which should be loadable and savable
 */
public abstract class MObject {

	private String uID;

	/**
	 * 
	 * @param uID
	 */
	public MObject(String uID) {
		this.uID = uID;
		MObjectRepo.register(this);
	}

	public String getUID() {
		return this.uID;
	}

}