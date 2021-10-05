package week17_backtracking_ex1;

import java.util.Scanner;

/*백준 15651 - N과 M (3)
 *version 1
 */

public class N_M_3 {

	private static int n;
	private static int m;
	
	private static int arr[];
	
	
	public static void backtracking(int depth) {
		if(depth == m) {
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		//ex) n = 4, m = 2
		for(int i = 0; i < n; i++) {

			arr[depth] = i + 1;
			backtracking(depth + 1);
			
			//ex) i = 0					  i = 1				    i = 2				  i = 3
			//	  arr[0] = 1		      arr[0] = 2            arr[0] = 3            arr[0] = 4
 			//    backtracking(1)         backtracking(1)       backtracking(1)       backtracking(1)
			//	    다음 깊이에서 실행되는 반복문의 i + 1
			//    1  |  2  |  3  |  4     1  |  2  |  3  |  4   1  |  2  |  3  |  4   1  |  2  |  3  |  4
			
			//의 트리형태로 순환구조가 이루어짐.
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		m = input.nextInt();
		
		arr = new int[m];
		
		backtracking(0);
	}
}
