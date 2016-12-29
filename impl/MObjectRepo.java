import java.util.*;

public class MObjectRepo {

	Map<String,MObject> objects;

	private static MObjectRepo r;
	
	{
		r=new MObjectRepo();
	}
	
	/**
	 * 
	 * @param name the uID of the MObject to Retrieve
	 */
	public static MObject getMObject(String name) {
		return r.objects.get(name);
	}

	/**
	 * 
	 * @param o
	 */
	public static boolean register(MObject o) {
		return null==r.objects.put(o.getUID(), o);
	}

	public static String getNewUID() {
		return UUID.randomUUID().toString();
	}

	private MObjectRepo() {
		objects = new HashMap<>();
	}

}