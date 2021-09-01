package week2_dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*백준 2294 - 동전 2
 *version 2
 */

public class Coin2 {
	private static int coins[];
	private static int dp[];
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int k = input.nextInt();
		
		coins = new int[n];
		dp = new int[k + 1];
		
		for(int i = 0; i < n; i++) {
			int tmp = input.nextInt();
			coins[i] = tmp;
		}
		
		Arrays.fill(dp, 100001);
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 0; i < n; i++) {
			
			for(int j = coins[i]; j <= k; j++) {					
				dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);

			}
		}
		
		
		System.out.print(dp[k]);	
		
	}
}
