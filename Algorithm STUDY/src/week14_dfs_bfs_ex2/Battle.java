package week14_dfs_bfs_ex2;

import java.util.Scanner;

/*백준 1303 - 전쟁 - 전투
 *version 1
 */

public class Battle {
	
	/*문제 접근
	 기존에 풀었던 문제 '단지번호 붙이기'를 활용
	 
	 각 진영이 놓여져 있는 전체 필드를 병사가 뭉쳐져 있는 단위 진영으로 구분
	 
	 W B W W W   -> 뭉쳐져 있는 B는 1개 : 적의 단위진영 1번
	 W W W W W   -> 뭉쳐져 있는 W는 9개 : 아군의 단위진영 1번
	 B B B B B   -> 뭉쳐져 있는 B는 8개 : 적의 단위진영 2번
	 B B B W W   -> 뭉쳐져 있는 W는 7개 : 아군의 단위진영 2번
	 W W W W W
	
	 따라서,
	 아군의 총 병력합 = 단위진영 1의 병사 수 : 9^2 + 단위진영 2의 병사 수 : 7^2 = 81 + 49 = 130
	 적군의 총 병력합 = 단위진영 2의 병사 수 : 1^2 + 단위진영 2의 병사 수 : 8^2 = 1 + 64 = 65
	 
	 */
	
	private static final int[] DX = {0, 1, 0, -1};
	private static final int[] DY = {-1, 0, 1, 0};
	//왼쪽 아래 오른쪽 위
	
	private static int[][] field;
	//입력되는 병사 배치 필드
	private static boolean[][] check;
	//필드 방문 여부
	
	private static int n;
	private static int m;
	//가로, 세로
	
	private static int team_area;
	private static int enemy_area;
	//각 진영의 병사들이 뭉쳐져 있는 단위 진영 수
	
	private static int[] team_count = new int[10000];
	private static int[] enemy_count = new int[10000];
	//각 단위 진영의 병사 수가 담길 배열
	//입력조건에 n, m 은 100인 값이므로 필드의 최대크기는 100 * 100 
	//따라서 존재할수 있는 단위진영의 수는 10000이하
	
	private static int team_power;
	private static int enemy_power;
	//결과값 : 각 진영의 병력 합
	
	public static void tDFS(int x, int y) {
		//아군 진영의 단위 진영 탐색
		int nx, ny;
		
		team_count[team_area]++;
		//탐색 중 아군을 찾았을 때 이미 단위 진영 수가 카운트 됐으므로 해당 단위진영에 아군이 더있으면 호출 될때마다 아군 수 카운트 
		
		for(int i = 0; i < 4; i++) {
			nx = x + DX[i];
			ny = y + DY[i];
			//현재 위치에서 상하 좌우 탐색
			
			if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
				if(field[nx][ny] == 1 && !check[nx][ny]) {
					//현재 위치가 아군이고 방문되어있지 않다면
					check[nx][ny] = true;
					//방문 확인
					tDFS(nx, ny);
					//현재위치에서 재탐색
				}
			}
		}
		
	}
	
	public static void eDFS(int x, int y) {
		//적군 진영의 단위 진영 탐색, 동작 방식은 tDFS()와 동일
		int nx, ny;
		
		enemy_count[enemy_area]++;
		
		for(int i = 0; i < 4; i++) {
			nx = x + DX[i];
			ny = y + DY[i];
			
			if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
				if(field[nx][ny] == 0 && !check[nx][ny]) {
					check[nx][ny] = true;
					eDFS(nx, ny);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		m = input.nextInt();
		
		field = new int[m][n];
		check = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			String s = input.next();
			for(int j = 0; j < n; j++) {
				char tmp = s.charAt(j);
				
				if(tmp == 'W') {
					//아군이면 1
					field[i][j] = 1;
				}
				else {
					//적군이면 0
					field[i][j] = 0;
				}
			}
		}
	
		for(int i = 0; i < m; i++) {	
			for(int j = 0; j < n; j++) {
				if(field[i][j] == 1 && !check[i][j]) {
					//전체 진영에서 아군을 찾으면
					team_area++;
					//아군의 단위 진영 수 카운트
					check[i][j] = true;
					tDFS(i, j);
				}
			}
		}
		
		for(int i = 0; i < m; i++) {	
			for(int j = 0; j < n; j++) {
				if(field[i][j] == 0 && !check[i][j]) {
					//전체 진영에서 적군을 찾으면
					enemy_area++;
					//적군의 단위 진영 수 카운트
					check[i][j] = true;
					eDFS(i, j);
				}
			}
		}
		
		for(int i = 0; i < team_count.length; i++) {
			if(team_count[i] != 0) {
				//단위 진영별로 병사 수가 적재되어 있는 배열이므로 병사 수가 있다면
				team_power += (int) Math.pow(team_count[i], 2);
				//총 병력 합에 가산
			}
		}
		
		//위와 동일한 방식으로 적군의 병력 합도 계산
		for(int i = 0; i < enemy_count.length; i++) {
			if(enemy_count[i] != 0) {
				enemy_power += (int) Math.pow(enemy_count[i], 2);
			}
		}
		
		System.out.println(team_power + " " + enemy_power);
	}

}
