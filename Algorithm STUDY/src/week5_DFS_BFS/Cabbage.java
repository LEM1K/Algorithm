package week5_DFS_BFS;

import java.util.Scanner;

/*백준 1012 - 유기농 배추
 *version 1
 */

public class Cabbage {
	private static int width;
	private static int height;
	private static int cabbage;
	
	private static int[][] field;
	private static boolean[][] checked;
	
	private static int[] dx = {0, 1, 0, -1}; 
	private static int[] dy = {-1, 0, 1, 0};
	//위, 오른쪽, 아래, 왼쪽

	public static void DFS(int y, int x) {
		int nx, ny;
		
		for(int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			//현재 좌표에서 상하좌우 반복
			
			if(ny >= 0 && nx >= 0 && ny < height && nx < width) {
				//배열 범위 초과 예외 처리
				if(field[ny][nx] == 1 && !checked[ny][nx]) {
					//배추가 있고 체크 되어있지 않으면			
					checked[ny][nx] = true;
					DFS(ny, nx);
					//체크 후 그 좌표에서 재탐색
					
				}				
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int cases = input.nextInt();
		
		for(int i = 0; i < cases; i++) {
			width = input.nextInt();
			height = input.nextInt();
			cabbage = input.nextInt();
			//가로, 세로, 배추 수

			field = new int[height][width];
			checked = new boolean[height][width];
			//배열 초기화
			int count = 0;
			
			for(int j = 0; j < cabbage; j++) {
				int x = input.nextInt();
				int y = input.nextInt();
				
				field[y][x] = 1;
				//배추 수만큼 배추 좌표 입력 후 초기화
			}
			
			for(int a = 0; a < height; a++) {	
				for(int b = 0; b < width; b++) {
					
				
					if(field[a][b] == 1 && !checked[a][b]) {
						//현재 배추가 있고 체크가 되어있지 않으면
						
						count++;
						//지렁이 수 카운팅
						checked[a][b] = true;
						//체크 했으니 true
						DFS(a, b);
						//해당 좌표로 탐색
					}
				}
			}
			
			System.out.println(count);
		}
	}
}
