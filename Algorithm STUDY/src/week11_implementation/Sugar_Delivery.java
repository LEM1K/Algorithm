package week11_implementation;

import java.util.Arrays;
import java.util.Scanner;

/*백준 2839 - 설탕배달
 *version 1
 */

public class Sugar_Delivery {
	
	/*문제 접근
	 ex) n = 20일때
	 0, 1, 2, 4, 7은 3과 5를 조합해 나올 수 없는 수로 -1
	 3은 1, 5는 1, 6은 3*2, 8은 3-5, 9는 3*3, 10은 5*2, 11은 3*2-5...
	 
	 
	 idx    1   2   3   4   5 ||  6   7   8   9   10 ||  11   12   13   14   15 ||  16   17   18   19   20
	 val   -1  -1   1  -1   1 ||  2  -1   2   3   2  ||  3    4    3    4    3  ||  4    5    4    5    4
	 
	 다음과 같이 5 단위로 나눴을때 조합해서 나올수 없는 수 말고는 단위마다 일정한 규칙을 가짐 
	 만약 조합이 된다는 가정하에 해당 규칙으로 배열을 재 나열 하자면
	 
	 idx    1   2   3   4   5 ||  6   7   8   9   10 ||  11   12   13   14   15 ||  16   17   18   19   20
	 val    1   2   1   2   1 ||  2   3   2   3   2  ||  3    4    3    4    3  ||  4    5    4    5    4
	 
	 다음과 같은 규칙으로 배열이 생성 될 것이다.
	 따라서 해당 규칙을 만족하도록 배열 크기만 큼 값을 채워 넣고 n에 해당하는 요소값을 출력 해주면 된다.
	 */
	
	
	private static int[] dp;
	
	public static void func(int[] dp, int n) {
		dp[1] = 1;
		//초기 값
		for(int i = 2; i <= n; i++) {
			if(i % 5 == 0) {
				//인덱스(재야하는 무게)가 5로 나눠 떨어지면
				dp[i] = i / 5;
				//5로 나눈 몫이 됨.	
			}
			
			if(i % 5 == 1 || i % 5 == 3) {
				//재야하는 무게가 5로 나눈 나머지의 그 다음 그 다다다음 일경우(ex. 1~5 까지면 1, 3에 해당)
				dp[i] = i / 5 + 1;
				//규칙에 따라 5로 나눈 몫 + 1이 됨.
			}
			
			if(i % 5 == 2 || i % 5 == 4) {
				//재야하는 무게가 5로 나눈 나머지의 그 다다음 그 다다다다음 일경우(ex. 1~5 까지면 2, 4에 해당)
				dp[i] = i / 5 + 2;
				//규칙에 따라 5로 나눈 몫 + 2가 됨.
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		dp = new int[n + 1];
		
		if(n == 0 || n == 1 || n == 2 || n == 4 || n == 7) {
			//0, 1, 2, 4, 7은 3과 5를 조합해 나올 수 없는 수로 -1을 출력한다.
			System.out.println(-1);
		}
		else {
			func(dp, n);
			System.out.println(dp[n]);
			//해당위치의 요소값 출력
		}
		
		
		
	}

}
