package week1_bruteForce;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*백준1182 - 부분 수열의 합
 *version 1
 
 *dfs 활용 문제 이므로 3주차까지 보류
 */

public class Sum_of_Subsequence {
	static int[] arr;
	static int n, s, cnt = 0;
	
	private static void dfs(int v, int su) {
		if(v == n) {
			if(su == s) cnt++;
			return;
		}

		dfs(v + 1, su + arr[v]);
		dfs(v + 1, su);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		//배열 사이즈
		s = input.nextInt();
		//결과 값
		arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}
		Arrays.sort(arr);
		//배열 정렬
		
		dfs(0, 0);
		System.out.print(s == 0? --cnt : cnt);
	}
}

