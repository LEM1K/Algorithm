package week6_greedy;

import java.util.Scanner;

/*백준 11047 - 동전 0
 *version 1
 */

public class Coin0 {
	
	private static int coin_arr[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int sum = input.nextInt();
		int count = 0;
		
		coin_arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			int coin = input.nextInt();
			coin_arr[i] = coin;
			//동전 종류 입력 받음
		}
		
		for(int i = n - 1; i >= 0; i--) {
			//동전 배열 끝에서부터
			if(coin_arr[i] <= sum) {
				//동전이 목표합보다 작으면 
				count += (sum / coin_arr[i]);
				//목표합에서 해당 동전을 나눈값을 카운트
				sum = sum % coin_arr[i];
				//목표합은 해당 동전으로 나눈 나머지값이 됨
			}
		}
		System.out.println(count);
	}

}
