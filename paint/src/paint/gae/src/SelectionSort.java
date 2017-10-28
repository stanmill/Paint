
public class SelectionSort extends RunTime implements SortInterface{

	@Override
	public void sort(Integer[] arrayToSort) {
		startTime = System.nanoTime();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < arrayToSort.length-1; i++)
        {
            // Find the minimum element in unsorted array
            int mini = i;
            for (int j = i+1; j < arrayToSort.length; j++)
                if (arrayToSort[j] < arrayToSort[mini])
                	mini = j;
 
            // Swap the found minimum element with the first
            // element
            int temp = arrayToSort[mini];
            arrayToSort[mini] = arrayToSort[i];
            arrayToSort[i] = temp;
        }
        endTime =System.nanoTime();
        runTime= endTime - startTime;
        addRunTime(runTime);
	}

}
