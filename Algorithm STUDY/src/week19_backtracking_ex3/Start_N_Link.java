package week19_backtracking_ex3;

import java.io.*;
import java.util.*;

/*백준 14889 - 스타트와 링크
 *version 1
 */


public class Start_N_Link {
	
	private static int n;
	private static int part;
	
	private static boolean[] visit;
	private static int[][] arr;
	
	private static int min = Integer.MAX_VALUE;
	
	//N 과 M(2) 과 같은 방식으로 조합을 생성해 팀을 구분(true : 1팀, false : 2팀)
	public static void backtracking(int start, int depth) {
		
		if(depth == part) {
			function();
			return;
		}
		
		for(int i = start; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				backtracking(i + 1, depth + 1);
				visit[i] = false;
			}
		}
	}
	
	public static void function() {
		int ability_t1 = 0;
		int ability_t2 = 0;
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				
				
				if(visit[i] == true && visit[j] == true) {
					ability_t1 += arr[i][j];
					ability_t1 += arr[j][i];
				}
				else if(visit[i] == false && visit[j] == false) {
					ability_t2 += arr[i][j];
					ability_t2 += arr[j][i];
				}
			}
		}
		
		int sub = Math.abs(ability_t1 - ability_t2); 
		
		if(sub == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		min = Math.min(min, sub);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		
		part = n / 2;
		//두 팀이 나와야 하므로 
		
		arr = new int[n][n];
		visit = new boolean[n];
		
		StringTokenizer st;
		
		for(int i = 0; i < n; i++) {
			String s = bf.readLine();
			st = new StringTokenizer(s);
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		backtracking(0, 0);
		
		System.out.println(min);
	}

}
