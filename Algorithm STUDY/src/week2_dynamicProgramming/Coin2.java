package week2_dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*백준 2294 - 동전 2
 *version 1
 */

public class Coin2 {
	private static int n;
	private static int sum;
	private static int[] coin_arr;
	private static int[] dp;
	
	public static int solution(int n, int sum) {
		
		for(int i = 0; i < n; i++) {
			for(int j = coin_arr[i]; j <= sum; j++) {
				dp[j] = dp[j] + 1; 
			}
		}
		return dp[sum];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("코인 갯수 >> ");
		n = Integer.parseInt(bf.readLine());
		System.out.print("목표 합    >> ");
		sum = Integer.parseInt(bf.readLine());
		
		coin_arr = new int[n];
		dp = new int[sum + 1];
		dp[0] = 0;
		
		
		System.out.println("동전 종류");
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		for(int i = 0; i < coin_arr.length; i++) {
			coin_arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println("사용 코인 수  : " + solution(n, sum));
		for(int i = 0; i < sum; i++) {
			System.out.print(dp[i] + " ");
		}
	}

}
