

public class RunTime implements RuntimeInterface{
	long[] runTimes = new long[10];
	long average;
	
	long startTime;
	long endTime;
	long runTime = endTime - startTime;
	
	@Override//prints the last value in the array
	public long getLastRunTime() {
		System.out.println(runTimes[runTimes.length-1]);

		return runTimes.length-1;
	}

	@Override//this prints all the values inside of the array
	public long[] getRunTimes() {
		for(int i = 0; i < runTimes.length; i++) {
			 System.out.println(runTimes[i]);
		}

		return runTimes;
	}

	@Override//sets all the spaces in the array to 0
	public void resetRunTimes() {
		for(int i = 0; i<runTimes.length; i++) {
			runTimes[i] = 0;
		}
		
	}

	@Override
	public void addRunTime(long runTime) {
		if(runTimes.length > 10) {
			for(int i=0,j = 1; i < runTimes.length; i++,j++) {
				runTimes[i] = runTimes[j];
		}
	  }
		else {
		  for(int i = 0; i < runTimes.length; i++) {
			  runTimes[i] = runTime;
		  }
	  }
		
	}

	@Override//searches for the contents in the array and then divides by the counter to get average
	public double getAverageRunTime() {
		long total = 0;
		if(runTimes.length == 0) {
			return average;
		}else {
			int i;
		for(i = 0; i < runTimes.length; i++) {
			System.out.println(runTimes[i]);
			total += runTimes[i];
			}
		average = total / i;
		return average;
		}
		
	}

}

