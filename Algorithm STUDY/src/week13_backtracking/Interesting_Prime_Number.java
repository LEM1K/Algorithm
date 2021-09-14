package week13_backtracking;

import java.io.*;
import java.util.Scanner;

/*백준 2023 - 신기한 소수
 *version 1
 */

//메모리 초과

public class Interesting_Prime_Number {
	
	private static boolean[] prime;
	
	//에라토스테네스의 체
	public static void is_prime() {
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) {
                continue;
            }
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		int range1 = (int)Math.pow(10, n - 1);
		int range2 = (int)Math.pow(10, n);
		//자리수에 대한 범위 설정
		
		prime = new boolean[range2 + 1];
		
		is_prime();
		//배열 크기만큼 소수인지 아닌지 구별(false : 소수)
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = range1; i < range2; i++) {
			int count = 0;
			
			if(!prime[i]) {
				//소수라면
				int tmp = i;
				
				//루프문을 돌면서 수의 각 자리수를 제거해 소수인지 판별
				while(tmp != 0) {
					tmp = tmp / 10;
					if(!prime[tmp]) {
						count++;
						//판별시 카운트업
					}
					 
				}
				if(count == n - 1) {
					//카운트가 n - 1이면 출력
					//ex) 7331 -> 733(prime F, count = 1)
					//		   -> 73 (prime F, count = 2)
					//		   -> 7	 (prime F, count = 3)
					sb.append(i + "\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

}
