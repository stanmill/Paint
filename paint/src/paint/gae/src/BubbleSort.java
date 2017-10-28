
public class BubbleSort extends RunTime implements SortInterface{

	@Override
	public void sort(Integer[] arrayToSort) {
		
		startTime = System.nanoTime();
		 for (int i = 0; i < arrayToSort.length-1; i++)
	            for (int j = 0; j < arrayToSort.length-i-1; j++)
	            	//checks if the value on the left is bigger than the value on the right in order to shift them
	                if (arrayToSort[j] > arrayToSort[j+1]){
	                
	                    // swap the temporary value and arratToSort[i]
	                    int temp = arrayToSort[j];
	                    arrayToSort[j] = arrayToSort[j+1];
	                    arrayToSort[j+1] = temp;
	                }
		 	endTime =System.nanoTime();
	        runTime= endTime - startTime;
	        addRunTime(runTime);
	}

}
