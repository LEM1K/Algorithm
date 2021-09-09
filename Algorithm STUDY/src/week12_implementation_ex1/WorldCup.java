package week12_implementation_ex1;

import java.util.Scanner;
import java.util.StringTokenizer;

/*백준 6987 - 월드컵
 *version 1
 */

public class WorldCup {
	
	/*문제 접근
	 
	 처음 문제 접근시에 승 무 패 합과 무승부가 나오는 조건 등을 모두 하드 코딩으로 구현 해봤는데 실패하여
	 검색한 결과 여럿 조건을 찾아 하드코딩으로 짤 수 없다는 결론과 백트래킹 코드를 찾아 풀이.
	 */
	
	
	private static int[] team1 = new int[] {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
	private static int[] team2 = new int[] {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
	//여섯팀의 경기 매칭
	
	private static int[] win = new int[6];
	private static int[] draw = new int[6];
	private static int[] lose = new int[6];
	
	private static boolean check;
	
	public static void function(int depth) {
		if(check) {
			return;
		}
		
		if(depth == 15) {
			check = true;
			return;
		}
		
		int t1 = team1[depth];
		int t2 = team2[depth];
		
		//백트래킹 코드
		if(win[t1] > 0 && lose[t2] > 0) {
			win[t1]--;
			lose[t2]--;
			function(depth + 1);
			win[t1]++;
			lose[t1]++;
		}
		
		if(lose[t1] > 0 && win[t2] > 0) {
			lose[t1]--;
			win[t2]--;
			function(depth + 1);
			lose[t1]++;
			win[t2]++;
		}
		
		if(draw[t1] > 0 && draw[t2] > 0) {
			draw[t1]--;
			draw[t2]--;
			function(depth + 1);
			draw[t1]++;
			draw[t2]++;
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 4 ; i++) {
			
			int wins = 0;
			int draws = 0;
			int loses = 0;
			check = false;
			
			String s = input.nextLine();
			StringTokenizer st = new StringTokenizer(s);
			//팀별 승 무 패를 문자열로 입력받아 문자열의 공백을 제거한 한 문자씩 토근으로 구별 
			
			for(int j = 0; j < 6; j++) {
				win[j] = Integer.parseInt(st.nextToken());
				draw[j] = Integer.parseInt(st.nextToken());
				lose[j] = Integer.parseInt(st.nextToken());
				//승 무 패 배열에 토큰을 적재
				
				wins += win[j];
				draws += draw[j];
				loses += lose[j];
				//승 무 패의 합
			}
			
			if(wins + draws + loses != 30) {
				//승 무 패의 합이 30이 아니면
				check = false;
				//체크 실패
			}
			else {
				function(0);
				//승 무 패 합이 30이면 함수 실행
			}
			
			if(check) {
				sb.append(1 + " ");
				//체크에 성공하면 1
			}
			else {
				sb.append(0 + " ");
				//실패하면 0
			}
		}
		System.out.println(sb.toString());
	}

}
