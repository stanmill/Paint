
public class InsertionSort extends RunTime implements SortInterface{

	@Override
	public void sort(Integer[] arrayToSort) {
		startTime = System.nanoTime();
        for (int i=1; i<arrayToSort.length; ++i) {
        
            int key = arrayToSort[i];
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arrayToSort[j] > key)
            {
            	arrayToSort[j+1] = arrayToSort[j];
                j = j-1;
            }
            arrayToSort[j+1] = key;
        }
        endTime =System.nanoTime();
        runTime= endTime - startTime;
        addRunTime(runTime);
        
	}

}
