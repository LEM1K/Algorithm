package week2_dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/*백준 2294 - 동전 2
 *version 1
 */

public class Coin2 {
	private static int n;
	private static int sum;
	private static int[] coin_arr;
	private static int[] dp;
	
	public static int solution(int n, int sum) {
		Arrays.fill(dp, 100001);
		dp[0] = 0; 
		for (int i = 0; i < n; i++) { 
			for (int j = coin_arr[i]; j <= sum; j++) { 
				dp[j] = Math.min(dp[j], dp[j - coin_arr[i]] + 1); 
			} 
		}
		return dp[sum];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("코인 갯수 >> ");
		n = input.nextInt();
		System.out.print("목표 합    >> ");
		sum = input.nextInt();
		
		coin_arr = new int[n];
		dp = new int[sum + 1];
		
		dp[0] = 0;
		
		System.out.println("동전 종류");
		for(int i = 0; i < coin_arr.length; i++) {
			coin_arr[i] = input.nextInt();
		}
		
		System.out.println("사용 코인 수  : " + solution(n, sum));

	}

}
