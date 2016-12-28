public class TimeStamp {

	private long value;
	private static long now;
	{
		now = 0;
	}
	
	public static TimeStamp now() {
		return new TimeStamp(now);
		
	}

	public static void stepp() {
		now ++;
		throw new UnsupportedOperationException();
	}

	public long getValue() {
		return this.value;
	}

	/**
	 * 
	 * @param time
	 */
	public TimeStamp(long time) {
		this.value = time;
	}

}