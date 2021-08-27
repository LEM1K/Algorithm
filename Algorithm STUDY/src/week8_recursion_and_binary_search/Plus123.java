package week8_recursion_and_binary_search;

import java.util.Scanner;

/*백준 9095 - 1 2 3 더하기
 *version 1
 */

public class Plus123 {

	
	public static int recur(int x) {
		//초기값
		
		if(x == 0) {
			//x = 1 일때 경우의수
			return 1;
		}
		if(x == 1) {
			//x = 2일때 경우의수
			return 2;
		}
		if(x == 2) {
			//x = 3일때 경우의수
			return 4;
		}
		
		/*
		ex) x = 5이면
		1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 1+2+2, 1+1+3, 1+3+1 
		=> 1+(뒤는 4가 되는 경우)
		2+1+1+1, 2+1+2, 2+2+1, 2+3
		=> 2+(뒤는 3이 되는 경우)									
		3+1+1, 3+2
		=> 3+(뒤는 2가 되는 경우)
		*/
		
		
		//따라서 점화식 x > 3일때,  d(x) = d(x-1) + d(x-2) + d(x-3)
		return recur(x - 3) + recur(x - 2) + recur(x - 1); 
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int cases = input.nextInt();
		
		for(int i = 0; i < cases; i++) {
			int tmp = input.nextInt();
			System.out.println(recur(tmp - 1));
			//함수가 0부터 시작하므로 받은 값의 1을 뺌
			//(원래 배열을 이용해서 하려고 이런식으로 값을 넣어줬는데 사용안해도 통과하여 코드수정을 안함)
		}
		
	}

}
