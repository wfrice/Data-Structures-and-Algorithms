package QuadraticSort;

public class SortArrayRunner {
	
	public static void main(String[] args) {
		
		// int[][] stats500 = new int[10][2];
		
		// int avgSwaps = 0;
		// int avgComparisons = 0;

		// for (int i = 0; i < stats500.length; i++ ) {
		// 	SortArray array = new SortArray(500, 2);
		// 	array.sort();
		// 	stats500[i][0] = array.getSwaps();
		// 	avgSwaps += array.getSwaps() / stats500.length;
		// 	stats500[i][1] = array.getComparisons();
		// 	avgComparisons += array.getComparisons() / stats500.length;
		// }

		// System.out.println("#\tSwaps\tComparisons");
		// for ( int i = 0; i < stats500.length; i++ ) {

		// 	System.out.println((i+1) + "\t" + stats500[i][0] + "\t" + stats500[i][1]);

		// }

		// System.out.println("\nAverage Results -");
		// System.out.println("Swaps:\t\t" + avgSwaps);
		// System.out.println("Comparisons:\t" + avgComparisons);

		SortArray array;

		array = new SortArray(500, 0);
		System.out.println(array.sort());
		
		array = new SortArray(5000, 0);
		System.out.println(array.sort());

		array = new SortArray(50000, 0);
		System.out.println(array.sort());

		array = new SortArray(500, 1);
		System.out.println(array.sort());
		
		array = new SortArray(5000, 1);
		System.out.println(array.sort());

		array = new SortArray(50000, 1);
		System.out.println(array.sort());

		array = new SortArray(500, 2);
		System.out.println(array.sort());
		
		array = new SortArray(5000, 2);
		System.out.println(array.sort());

		array = new SortArray(50000, 2);
		System.out.println(array.sort());

	}

}

/*

500 Items
Swaps:          0
Comparisons:    124750

5000 Items
Swaps:          0
Comparisons:    12497500

50000 Items
Swaps:          0
Comparisons:    1249975000

500 Items
Swaps:          124750
Comparisons:    124750

5000 Items
Swaps:          12497500
Comparisons:    12497500

50000 Items
Swaps:          1249975000
Comparisons:    1249975000

500 Items
Swaps:          64155
Comparisons:    124750

5000 Items
Swaps:          6171020
Comparisons:    12497500

50000 Items
Swaps:          626697811
Comparisons:    1249975000

*/