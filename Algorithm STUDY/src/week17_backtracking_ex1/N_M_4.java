package week17_backtracking_ex1;

import java.util.Scanner;

/*백준 15652 - N과 M (4)
 *version 1
 */

public class N_M_4 {

	private static int n;
	private static int m;
	
	private static int arr[];
	private static boolean visit[];
	//방문 여부
	
	public static void backtracking(int start, int depth) {
		if(depth == m) {
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		//ex) n = 4, m = 2
		for(int i = start; i <= n; i++) {

			arr[depth] = i;
			backtracking(i, depth + 1);
			
			//ex) i = 1					  i = 2				    i = 3				  i = 4
			//	  arr[0] = 1		      arr[0] = 2            arr[0] = 3            arr[0] = 4
 			//    backtracking(1, 1)      backtracking(2, 1)    backtracking(3, 1)    backtracking(4, 1)
			//	    다음 깊이에서 실행되는 반복문의 i + 1
			//    1  |  2  |  3  |  4     2  |  3  |  4         3  |  4               4
			
			//의 트리형태로 순환구조가 이루어짐.
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		m = input.nextInt();
		
		arr = new int[m];
		visit = new boolean[n];
		
		
		backtracking(1, 0);
	}

}
