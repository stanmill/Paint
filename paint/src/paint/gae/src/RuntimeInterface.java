

public interface RuntimeInterface {
	
	public long getLastRunTime();
	
	public long[] getRunTimes();
	
	public void resetRunTimes();
	
	public void addRunTime(long runTime);
	
	public double getAverageRunTime();

}
