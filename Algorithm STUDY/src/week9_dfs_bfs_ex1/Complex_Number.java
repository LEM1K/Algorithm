package week9_dfs_bfs_ex1;

import java.util.Arrays;
import java.util.Scanner;

/*백준 2667 - 단지번호 붙이기
 *version 1
 */

public class Complex_Number {
	
	private static final int[] dx = {-1, 0, 1, 0};
	private static final int[] dy = {0, -1, 0, 1};
	//인덱스 순서대로 [위 -> 왼 -> 아래 -> 오]
	
	private static int n;
	private static int count = 0;
	private static int[][] arr;
	private static boolean[][] checked;
	private static int result[] = new int[625];
	//n의 범위가 최대 25이므로 단지를 나타내는 2차원 배열 최대크기 25 * 25
	public static void dfs(int x, int y) {
		int nx, ny;
		
		result[count]++;
		//이부분을 제외하고는 유기농 배추와 같음
		//우연히 얻어걸린 해답 : 탐색중 아파트(1)를 찾았을 때 동시에 count는 1 증가 하므로 해당 인덱스에 해당하는 요소값이 호출될때마다 증가 
		
		for(int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(ny >= 0 && nx >= 0 && ny < n && nx < n) {
				
				if(arr[nx][ny] == 1 && !checked[nx][ny]) {
					checked[nx][ny] = true;
					dfs(nx, ny);
					
				}
			}
			
		}
		
	}
	
	/*
	 * 이전에 풀었던 DFS문제인 유기농 배추와 흡사한 문제
	 * 
	 * */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		
		
		checked = new boolean[n][n];
		arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String s = input.next();
			for(int j = 0; j < n; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
						   
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				
				if(arr[i][j] == 1 && !checked[i][j]) {
					count++;
					checked[i][j] = true;
					dfs(i, j);
				}
			}
		}
		System.out.println(count);
		
		
		/*이부분을 제외하고는 유기농 배추와 같음*/
		Arrays.sort(result);
		//오름차순 출력을 요구함으로 정렬
		for(int i = 0; i < result.length; i++) {
			if(result[i] != 0) {
				//배열요소가 0이 아니면 출력(단지의 아파트수)
				System.out.println(result[i]);
			}
		}
	
	}

}
