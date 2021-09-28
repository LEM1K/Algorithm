package week15_bit_masking;

import java.util.Scanner;

/*백준 1062 - 가르침
 *version 1
 */

public class Teaching {
	
	/*문제 접근
	  북극의 언어는 anta ~ .. ~ tica로 구성하므로
	  최소 알아야 하는 알파벳 a, c, i, n, t이다.
	  
	 조건 1. 알파벳은 최소 5개를 알아야하므로 k는 5이하의 값이 입력되면 0을 출력해야한다.
	 조건 2. 알파벳은 최대 26개 이므로 k가 26이면 입력되는 n개의 문자열은 전부 알 수 있다.
	
	 */
	
	private static String strs[];
	private static boolean alpha[];
	//알파벳 검사 배열
	private static int total_count;

	public static void backtracking(int start, int depth, int n, int k) {
		if (depth == k - 5) {
			//깊이가 k - 5랑 같아지면 모든 문자열에 대한 탐색 완료
			int count = 0;
			
			for (int i = 0; i < n; i++) {
				if (check(strs[i])) {
					//체크에 성공하면
					count++;
					//배울 수 있는 문자열 카운트
				}
			}
			total_count = Math.max(total_count, count);
			//최댓값 비교
		}
		
		//백트래킹
		for (int i = start; i < 26; i++) {
			if (alpha[i] == false) {
				alpha[i] = true;
				backtracking(i, depth + 1, n, k);
				alpha[i] = false;
			}
		}
	}

	public static boolean check(String s) {
	
		for (int i = 0; i < s.length(); i++) {
			if (!alpha[s.charAt(i) - 97]) {
				//문자열의 각 문자에 해당하는 알파벳 배열의 인덱스가 단 하나라도 false 이면
				return false;
				
				
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int k = input.nextInt();

		strs = new String[n];
		alpha = new boolean[26];

		for (int i = 0; i < n; i++) {
			String s = input.next();
			s = s.replace("anta", "");
			//어두 anta 는 무조건 알아야 하므로 빈 문자열로 대체 
			s = s.replace("tica", "");
			//어미 tica 는 무조건 알아야 하므로 빈 문자열로 대체
			strs[i] = s;
		}

		if (k < 5) {
			//위에서 본 조건 1에 해당.
			System.out.println(0);
			return;
		} 
		else if (k == 26) {
			//위에서 본 조건 2에 해당.
			System.out.println(n);
			return;
		}

		alpha['a' - 'a'] = true;
		alpha['c' - 'a'] = true;
		alpha['n' - 'a'] = true;
		alpha['i' - 'a'] = true;
		alpha['t' - 'a'] = true;
		//a, c, n, i, t 각 알파벳에 해당하는 인덱스를 아스키 코드값으로 변경해 방문여부를 미리 true로 초기화
		
		backtracking(0, 0, n, k);
		System.out.println(total_count);

	}

}
