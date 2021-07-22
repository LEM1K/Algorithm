package week2_dynamicProgramming;

import java.util.Scanner;

/*백준 1463 - 1로 만들기
 *version 1
 */

/*public class Make_One {
	 
	private static Integer[] dp;
	
	public static int recur(int N) {
		 
		if (dp[N] == null) {
			
			// 3으로만 나눠지는 경우 
			if (N % 3 == 0) {
				dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
			}
			// 2로만 나눠지는 경우 
			else if (N % 2 == 0) {
				dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
			}
			// 2와 3으로 나누어지지 않는 경우
			else {
				dp[N] = recur(N - 1) + 1;
			}
		}
		return dp[N];
	}
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
 
		dp = new Integer[N + 1];
		dp[0] = 0;
		dp[1] = 0;
		
		recur(N);
		
		for(int i = 0; i < dp.length; i++) {
			System.out.println(dp[i]);
		}
		
		//System.out.print(recur(N));
 
	}
}*/

public class Make_One {
	
	private static int arr[];
	//메모이제이션
	
	public static int solution(int n) {
		
		if(arr[n] == 0) {
			//배열 요소가 0일 경우 
			
			//조건 1. x가 3으로 나누어 떨어지면 3으로 나눔
			if(n % 3 == 0) {
				arr[n] = Math.min(solution(n / 3), solution(n - 1)) + 1;
			}
			
			//조건 2. x가 2로 나누어 떨어지면 2로 나눔
			else if(n % 2 == 0) {
				arr[n] = Math.min(solution(n / 2), solution(n - 1)) + 1;
			}
			
			//조건 3. 위 두 경우에 해당하지 않으면 1을 뺌
			else {
				arr[n] = solution(n - 1) + 1;
			}	
		}
		
		return arr[n];
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		
		System.out.println("1로 만들 숫자를 입력하시오  >> ");
		n = input.nextInt();
		
		arr = new int[n + 1];
		//배열 초기화
		
		arr[0] = 1;
		arr[1] = 1;
		//초기값 
		
		
		System.out.println();
		
		System.out.println(n + " to 1 needs count : " + (solution(n) - 1));
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
