package week8_recursion_and_binary_search;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*백준 1759 - 암호 만들기
 *version 1
 */

public class Make_Password {
	
	private static char[] pw;
	private static boolean[] check;
	
		
	/*
	  조건 1. 암호는 알파벳 모음중 최소 하나가 들어가야됨
	  조건 2. 암호는 알파벳 자음중 두개 이상이 들어가야됨
	  조건 3. 암호는 오름차순으로만 사용 가능
	  조건 4. 사용된 알파벳은 재사용 되지 않음
	  
	  조건 1, 2에 대한 추론으로 암호는 최소 세자 이상
	  조건 3에 대한 추론으로 암호가 될 문자배열은 정렬이 되어야한다
	  조건 4에 대한 추론으로 문자배열에서 조합을 이용해 문자열을 만들어야한다
	 */
	
	public static void Combination(int start, int depth, int l, int c) {
		if(depth == l) {
			
			int vo = 0;
			//모음
			int co = 0;
			//자음
			
			StringBuilder sb = new StringBuilder();
			
			
			for(int i = 0; i < c; i++) {
				if(check[i]) {
					sb.append(pw[i]);
					
					
					if(pw[i] == 'a' || pw[i] == 'e' || pw[i] == 'i' || pw[i] == 'o' || pw[i] == 'u') {
						vo++;
					}
					else {
						co++;
					}
					
					System.out.print(pw[i]);
				}
			}
			if(vo >= 1 && co >= 2) {
				System.out.println(sb);
			}
			//위 for문 부터 여기까지 조건 1, 2에 해당
		
		}
		
		for(int i = start; i < c; i++) {
			check[i] = true;
			Combination(i + 1, depth + 1, l, c);
			check[i] = false;
		}
		//조건 4 조합에 해당
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		int l = input.nextInt();
		int c = input.nextInt();
		
		pw = new char[c];
		check = new boolean[c];
		
		for(int i = 0; i < c; i++) {
			String s = input.next();
			pw[i] = s.charAt(0);
		}
		
		Arrays.sort(pw);
		//조건 3에 해당
		
		Combination(0, 0, l, c);
	}

}
