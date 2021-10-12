package week18_backtracking_ex2;

import java.util.Arrays;
import java.util.Scanner;

/*백준 9663 - N-Queen
 *version 1
 */

public class N_Queen {
	
	private static int n;
	private static int result;
	private static int[] arr;
	
	public static void function(int depth) {
		
		if(depth == n) {
			//모든 깊이까지 탐색이 완료되면
			result++;
			//결과값 가산
			return;
		}
		
		for(int i = 0; i < n; i++) {
			arr[depth] = i;
			
			//체크가 완료되면
			if(check(depth)) {
				//다음 깊이로 탐색
				function(depth + 1);
			}
			
		}
	
	}
	public static boolean check(int depth) {
		for(int i = 0; i < depth; i++) {
			//다음 놓일 퀸이 이전 퀸의 행, 열 상에 존재하면 false
			if(arr[depth] == arr[i]) {
				return false;
			} 
			//다음 놓일 퀸이 이전 퀸의 양대각 상에 존재하면 false
			else if(Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		arr = new int[n];
		
		function(0);
		
		System.out.println(result);
		
	}

}
