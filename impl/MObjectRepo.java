import java.util.*;

public class MObjectRepo {

	Map<String,MObject> objekts;

	private static MObjectRepo r;
	
	{
		r=new MObjectRepo();
	}
	
	/**
	 * 
	 * @param name the uID of the MObject to Retrieve
	 */
	public static MObject getMObject(String name) {
		return r.objekts.get(name);
	}

	/**
	 * 
	 * @param o
	 */
	public static boolean register(MObject o) {
		return null==r.objekts.put(o.getUID(), o);
	}

	public static String getNewUID() {
		return UUID.randomUUID().toString();
	}

	private MObjectRepo() {
		objekts = new HashMap<>();
	}

}