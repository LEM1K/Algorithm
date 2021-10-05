package week17_backtracking_ex1;

import java.util.Scanner;

/*백준 15649 - N과 M (1)
 *version 1
 */

public class N_M_1 {

	private static int n;
	private static int m;
	
	private static int arr[];
	private static boolean visit[];
	//방문 여부
	
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
			
			if(visit[i] == false) {
				visit[i] = true;
				arr[depth] = i + 1;
				backtracking(depth + 1);
				visit[i] = false;
			}
			
			//ex) i = 0					i = 1				i = 2				i = 3
			// 	  visit[0] = true       visit[1] = true     visit[2] = true     visit[3] = true
			//	  arr[0] = 1		    arr[0] = 2          arr[0] = 3          arr[0] = 4
 			//    backtracking(1)       backtracking(1)     backtracking(1)     backtracking(1)
			//	    다음 깊이에서 실행되는 반복문의 i + 1
			//    2  |  3  |  4         1  |  3  |  4		1  |  2  |  4		1  |  2  |  3
			
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
		
		backtracking(0);
	}

}
