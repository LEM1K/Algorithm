package week11_implementation;

import java.io.*;

/*백준 1913 - 달팽이
 *version 1
 */

public class Snail {
	
	/*
	 ex) n = 5 
	 25 10 11 12 13
	 24 9  2  3  14
	 23 8  1  4  15
	 22 7  6  5  16
	 21 20 19 18 17
	 
	 1. 25에서 시작한 다음 배열의 x범위 최대까지 값이 감소(아래 : 25 -> 21)
	 2. x범위로 더 이상 갈 수 없으므로 y범위로 전환 후 y범위 최대까지 이동하면서 값이 감소(오른쪽 : 21 -> 17) 
	 3. y범위로 더 이상 갈 수 없으므로 x범위로 전환 후 x범위 최소까지 이동하면서 값이 감소(위 : 17 -> 13)
	 4. x범위로 더 이상 갈 수 없으므로 y범위로 전환 후 y범위 최소 혹은 이미 숫자가 기록된 위치(25) 전까지 이동하면서 값이 감소(왼쪽 : 13 -> 10)
	 5. 이런식으로 반복 
	*/
	
	 
	
	
	private static final int[] DX = {1, 0, -1, 0};
	private static final int[] DY = {0, 1, 0, -1};
	//이동 방향 [아래 -> 오른쪽 -> 위 -> 왼쪽]
	
	private static int[][] snail;
	
	public static void paint(int[][] arr, int n) {
		int start = n * n;
		//처음 시작값 n^2
		
		int x = 0;
		int y = 0;
		int d = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				//배열 크기만큼 루프
				
				arr[x][y] = start--;
				//x, y 좌표에 대해 점점 줄여나감
				
				if(y + DY[d] < 0 || x + DX[d] < 0 || y + DY[d] >= n || x + DX[d] >= n
						|| arr[x + DX[d]][y + DY[d]] != 0) {
					//배열 범위를 벗어나거나  인덱스요소가 0이 아니면
					
					d++;
					//방향 전환
					
					if(d == 4) {
						//전방향 탐색이 끝나면
						d = 0;
						//이동 4방향 이므로 아->오->위->왼 순이 끝나면 다시 아래->...  
						
					}
				}
				x += DX[d];
				y += DY[d];	
				//x, y좌표에 다음 이동방향 값을 더해줌
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int val = Integer.parseInt(bf.readLine());
		int result_x = 0;
		int result_y = 0;
		
		snail = new int[n][n];
		
		paint(snail, n);
		
		StringBuilder sb = new StringBuilder();
		//시간초과를 방지하기 위한 스트링빌더 선언
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				sb.append(snail[i][j] + " ");
				if(snail[i][j] == val) {
					result_x = i + 1;
					result_y = j + 1;
					//2차원 배열의 인덱스가 아닌 절대 좌표가 필요하므로 각각 +1
				}
			}
			sb.append("\n");
			
		}
		System.out.print(sb.toString());
		System.out.println(result_x + " " + result_y);
	}

}
