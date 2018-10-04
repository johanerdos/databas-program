package errorCode;

public class ResponseTime {
	
	public String responseTime() {
		long timeStart = System.nanoTime();
		long timeEnd = System.nanoTime();
		long time = timeEnd - timeStart;
		String timeFormat = String.format("%, .3f", time / 1000.0);
		return timeFormat;
	}
	
	
	
}
