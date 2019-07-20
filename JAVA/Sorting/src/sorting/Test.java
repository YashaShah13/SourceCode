package sorting;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[]= {10,5,12,7,9,6,3,4,1,2};
		
		Sorting.quickSort(A, 0, A.length-1);
		
		System.out.print("sorted array :\n");
		for(int i=0;i<A.length;i++)
		{
			System.out.println(A[i]);
		}
		
	}

}
