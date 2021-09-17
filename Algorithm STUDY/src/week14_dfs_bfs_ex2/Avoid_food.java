package week14_dfs_bfs_ex2;

import java.util.Scanner;

/*백준 1743 - 음식물 피하기
 *version 1
 */


public class Avoid_food {
	
	/*앞선 문제 전쟁-전투와 비슷한 문제이므로 접근 방식은 동일*/
	
	private static final int[] DX = {0, 1, 0, -1};
	private static final int[] DY = {-1, 0, 1, 0};
	//왼쪽 아래 오른쪽 위
	
	private static int n;
	private static int m;
	//세로, 가로
	
	private static int[][] field;
	//전체 필드
	private static boolean[][] check;
	//방문 여부
	
	private static int count;
	//음식물 덩이 수
	
	private static int[] result = new int[10000];
	//음식물 덩이 의 음식물 수가 담길 배열
	//입력조건에 n, m 은 100인 값이므로 필드의 최대크기는 100 * 100 
	//따라서 존재할수 있는 음식물 덩이 수는 10000이하
	
	public static void DFS(int x, int y) {
		int nx, ny;
		
		result[count]++;
		
		for(int i = 0; i < 4; i++) {
			
			nx = x + DX[i];
			ny = y + DY[i];
			
			if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if(field[nx][ny] == 1 && !check[nx][ny]) {
					check[nx][ny] = true;
					DFS(nx, ny);
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		m = input.nextInt();
		int cases = input.nextInt();
		
		field = new int[n][m];
		check = new boolean[n][m];
		
		for(int i = 0; i < cases; i++) {
			int x = input.nextInt() - 1;
			int y = input.nextInt() - 1;
			//음식물이 놓일 절대 좌표는 배열 인덱스 보다 1 크기 때문에 입력값에 -1을 해줌
			
			field[x][y] = 1;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(field[i][j] == 1 && !check[i][j]) {
					//음식물을 찾으면
					check[i][j] = true;
					count++;
					//음식물 덩이 수 카운트
					DFS(i, j);
				}
			}
		}
		
		int max = 0;
		
		for(int i = 0; i < result.length; i++) {
			if(result[i] != 0) {
				//음식물 덩이 배열에서 0이 아니면
				max = Math.max(max, result[i]);
				//최댓값 비교후 저장
			}
		}
		System.out.println(max);
	}

}
