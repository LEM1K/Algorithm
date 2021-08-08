package week1_bruteForce;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*백준1182 - 부분 수열의 합
 *version 1
 
 *dfs 활용 문제 이므로 3주차까지 보류
 */

public class Sum_of_Subsequence {
	
	private static int[] arr;
	
	private static int count = 0;
	private static int n, s;
	
	private static void DFS(int v, int sum) {
		if(v == n) {
			if(sum == s) {
				count++;
			}
			return;
		}
		DFS(v + 1, sum);
		DFS(v + 1, sum + arr[v]);
	}
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		s = input.nextInt();
		
		arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}
		
		DFS(0, 0);
		
		if(s == 0) {
			count--;
			System.out.println(count);
		}
		else {
			System.out.println(count);
		}
	}
}

