

public interface DriverInterface {
	
	public Integer[] createArray(ArrayType arrayType, int arraySize);
	
	public RunTime runSort(SortType sortType, ArrayType arrayType, int arraySize, int numberOfTimes);

	public static enum SortType {BubbleSort, SelectionSort, InsertionSort};

	public static enum ArrayType {Equal, Random, Increasing, Decreasing, IncreasingAndRandom};
}
