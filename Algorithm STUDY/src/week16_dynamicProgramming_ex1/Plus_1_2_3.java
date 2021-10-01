package week16_dynamicProgramming_ex1;

import java.util.*;

/*백준 15989 - 1, 2, 3 더하기 4
 *version 1
 */

public class Plus_1_2_3 {

	/*문제 접근
	 n이 1 ~ 5까지는 증가할때마다 경우의 수가 1씩 증가
	 문제는 n = 6일 때 경우의 수가 7이 나옴
	 이에 n = 11일때 까지 따져본 결과 
	 
	  n  1   2   3   4   5   6   7   8   9   10   11   12 
	 val 1   2   3   4   5   7   8  10  12   14   16   19
	 로 나옴

	 해결 1. 등차수열로 지속되다가 공차가 달라지는 지점전을 초기값, 이후를 점화식으로 풀이
	 해결 2. 수열에서 n항을 기준으로 n항은 n - 1항의 경우를 모두 만족하기에 무조건 합산해야함.
	 ex) n = 3일때, 1+1+1, 1+2, 3 | n = 4일때, 1+(3이되는 경우의 합 : 1+1+1, 1+2, 1+3), 2+2
	 해결 3. 수열에서 n항을 기준으로 n - 1항의 경우를 합산한 값에서  (n - 2)항과 (n - 3)항의 공차를 합산함
	 해결 4. 위의 합산값에서 n이 3의 배수이면 결과값에 +1이 됨.
	 
	 따라서 점화식 => f(n) = f(n - 1) + (f(n - 2) + f(n - 3))
	           추가조건 => n % 3 == 0 이면 f(n) + 1
	 */
	
	private static StringBuilder sb;
	public static int[] dp = new int[10001];
	
	public static void function(int n) {
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 4;
		dp[5] = 5;
		//초기값
		
		if(n > 5) {
			for(int i = 5; i < n + 1; i++) {
				dp[i] = dp[i - 1] + (dp[i - 2] - dp[i - 3]);
				//점화식
				if(i % 3 == 0) {
					//추가 조건
					dp[i]++;
				}
			}	
		}
		sb.append(dp[n] + "\n");
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int cases = input.nextInt();
		sb = new StringBuilder();
		
		for(int i = 0; i < cases; i++) {
			int n = input.nextInt();
			
			function(n);
		}
		System.out.println(sb.toString());
	}
}
