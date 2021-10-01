package week16_dynamicProgramming_ex1;

import java.util.*;

/*백준 1495 - 기타리스트
 *version 1
 */

public class Guitar {

	/*문제 접근
	 1. 시작 볼륨 에서 다음곡 볼륨으로 변경 시 더하거나 뺄 수 있다. 
	 2. 위의 결과에서 볼륨 범위에 해당하지 않으면 제거한다.
	 
	 시작 볼륨 -> 마지막곡 볼륨에 대한 트리 구성
	 						5
	 다음:5			10				0
	 다음:3		13		7 		3		-3
	 다음:7 	  20  6   14  0   10 -4    4  -10	
	 
	 따라서 조건에 만족하는 최댓값 : 10
	 
	 */
	
	
	private static int n;
	private static int s;
	private static int m;

	private static int[] vol;
	private static boolean[][] dp;
	
	private static int max = -1;
	
	//dfs -> 시간초과
	public static void dfs(int start, int depth) {
		if(depth == n + 1) {
			//깊이가 마지막곡 연주 할때와 같아지고
			if(start >= 0 && start <= m) {
				//볼륨 범위를 만족하면
				max = Math.max(max, start);		
				//최댓값 비교
			}
			return;
		}
		
		if(start >= 0 && start <= m) {
			//볼륨범위를 만족하면
			dfs(start + vol[depth], depth + 1);
			//다음곡 연주시 볼륨 증가
			dfs(start - vol[depth], depth + 1);	
			//다음곡 연주시 볼륨 감소
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		s = input.nextInt();
		m = input.nextInt();
		
		vol = new int[n + 1];
		dp = new boolean[n + 1][m + 1];
		//곡 의 수를 row, 볼륨범위를 column으로 초기화
		
		for(int i = 1; i <= n; i++) {
			vol[i] = input.nextInt();
		}
		//dfs(s, 0);
		
		dp[0][s] = true;
		//첫 곡 연주 볼륨의 값을 dp배열의 인덱스로 설정 후 연주 여부를 true로 변환
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= m; j++) {
				if(dp[i - 1][j]) {
					//연주가 끝났다면
					if(j + vol[i] > m && j - vol[i] < 0) {
						//볼륨 범위를 벗어났을때 스킵
						continue;
					}
					if(j + vol[i] <= m) {
						//다음 볼륨을 더했을 때 볼륨 범위에 있다면 연주
						dp[i][j + vol[i]] = true;
					}
					if(j - vol[i] >= 0) {
						//다음 볼륨을 뺐을때 볼륨 범위에 있다면 연주
						dp[i][j - vol[i]] = true;
					}
				}
			}
		}
		//마지막 곡 연주 여부만 탐색
		for(int i = 0; i <= m; i++) {
			if(dp[n][i]) {
				//연주 되었다면
				max = Math.max(max, i);
				//최댓값 비교
			}
		}
		
		System.out.println(max);
	}

}
