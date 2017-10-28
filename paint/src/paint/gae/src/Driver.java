import java.util.Random;

public class Driver implements DriverInterface{
	
	public static void main(String[] args) {
		
		
		Driver s = new Driver();
		//s.createArray(ArrayType.Increasing, 1000);
		//s.runSort(SortType.BubbleSort, ArrayType.Increasing, 1000, 10);
		
		
		s.runSort(SortType.BubbleSort, ArrayType.Equal, 1000, 10);
		
		
		
	}
	

	@Override
	public Integer[] createArray(ArrayType arrayType, int arraySize) {
		switch(arrayType) {
		case Increasing:
			Integer[] Increasing = new Integer[arraySize];
			 for (int i =0; i<arraySize; i++) {
			          Increasing[i] =i;

			    }

			return Increasing;
		case Decreasing:
			Integer[] Decreasing = new Integer[arraySize];
			 for (int j = 0; j<Decreasing.length; j++) {
			       Decreasing[j]= Decreasing.length-j;

			    }

			return Decreasing;
		case Equal:
			Integer[] Equal = new Integer[arraySize];
			for(int i =0; i<Equal.length; i++) {
				Equal[i]=0;

			}

			return Equal;
		case Random:
			Integer[] Random = new Integer[arraySize];
			Random ran = new Random();
			for(int t = 0;t<arraySize;t++) {
				Random[t]=ran.nextInt();			
				}

			return Random;
		case IncreasingAndRandom:
			Integer[] IncreasingAndRandom = new Integer[arraySize];
			int normal = (int) (arraySize * 0.9);
			int otherrandom = arraySize-normal;
			for(int i = 0; i<normal;i++) {
				IncreasingAndRandom[i]=i;
			}
			Random ran2 = new Random();
			for(int t = 0;t<otherrandom;t++) {
				IncreasingAndRandom[normal++]=ran2.nextInt();
			}

			return IncreasingAndRandom;
			
		}

		return null;
	}

	@Override
	public RunTime runSort(SortType sortType, ArrayType arrayType, int arraySize, int numberOfTimes) {
		switch(sortType) {
		case BubbleSort:
			Integer[] bubble = createArray(arrayType, arraySize);
			BubbleSort bs = new BubbleSort();
			for(int i = 0;i<numberOfTimes;i++) {
			bs.sort(bubble);
			}
			return bs;
			
		case InsertionSort:
			Integer[] insert = createArray(arrayType, arraySize);
			InsertionSort is = new InsertionSort();
			for(int i = 0;i<numberOfTimes;i++) {
			is.sort(insert);
			}
			return is;
			
		case SelectionSort:
			Integer[] selection = createArray(arrayType, arraySize);
			SelectionSort ss = new SelectionSort();
			for(int i = 0;i<numberOfTimes;i++) {
			ss.sort(selection);
			}
			return ss;
		}
		return null;
	}	
	
}
