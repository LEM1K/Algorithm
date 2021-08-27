package week9_dfs_bfs_ex1;

import java.io.*;
import java.util.*;


/*백준 7576 - 토마토
 *version 1
 */

class Point {
	protected int x;
	protected int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Tomato {
	private static final int[] dx = {-1, 0, 1, 0};
	private static final int[] dy = {0, -1, 0, 1};
	//인덱스 순서대로 [위 -> 왼 -> 아래 -> 오]
	
	private static int[][] arr;
	private static int result = 0;
	
	public static void bfs(int n, int m) {
		Queue<Point> queue = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 1) {
					queue.add(new Point(i, j));
					//토마토가 심어져 있는 부분의 지점을 큐에 삽입
				}
			}
		}
		
		while(!queue.isEmpty()) {
			//큐가 빌때까지
			
			Point p = queue.poll();
			//해당 지점을 꺼내서
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				//상하 좌우 반복
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
					//필드를 벗어나면 스킵
				}
				if(arr[nx][ny] != 0) {
					continue;
					//이미 토마토가 있다거나 비어져있는경우(-1)이면 스킵
				}
				
				arr[nx][ny] = arr[p.x][p.y] + 1;
				//해당 좌표에 토마토 심은 일수를 표기
				queue.add(new Point(nx, ny));
				//그 포인트로 재탐색
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0) {
					System.out.println(-1);
					return;
					//토마토가 아예없는 경우 리턴
				}
				result = Math.max(result, arr[i][j]);
				//모든 배열중 최대값을 비교하여 결과값으로 선정
			}
		}
		
		System.out.println(result - 1);
		//처음에 1로 시작했으므로 -1을 한값을 출력
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(bf.readLine());
		int n = Integer.parseInt(bf.readLine());
		
		arr = new int[n][m];
		StringTokenizer st;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		bfs(n, m);
		
		
	}

}
