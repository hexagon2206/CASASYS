package objects;
import java.util.*;
import java.util.stream.Stream;

public class MObjectRepo {

	Map<String,MObject> objects;

	private static MObjectRepo r;
	
	static {
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

	public static Stream<MObject> getStream() {
		return r.objects.values().stream();
	}

}