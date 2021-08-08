package week5_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/*백준 2178 - 미로 탐색
 *version 1
 */

public class Search_maze {

	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	//상하좌우
	
	private static int[][] map;
	private static boolean[][] visited;

	private static int n;
	private static int m;

	public static void bfs(int x, int y) {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		//넘긴 좌표를 큐에 삽입

		while (!q.isEmpty()) {
			
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			//큐의 값을 빼서 해당좌표의
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				//상하좌우 탐색
				
				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
					continue;
				//좌표 값이 배열 범위를 초과하였을 경우 다시
				if (visited[nextX][nextY] || map[nextX][nextY] == 0)
					continue;
				//방문된 좌표거나 좌표상 미로로 된 값(0)이면 다시
				
				q.add(new int[] { nextX, nextY });
				//위 두조건이 아니면 큐에 삽입
				map[nextX][nextY] = map[nowX][nowY] + 1;
				//해당 좌표를 이전 좌표에 + 1
				visited[nextX][nextY] = true;
				//방문 확인
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner input = new Scanner(System.in);

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		visited = new boolean[n][m];
		visited[0][0] = true;
		bfs(0, 0);
		//0, 0부터 시작하여
		System.out.println(map[n - 1][m - 1]);
		//마지막 좌표 출력
	}

}
