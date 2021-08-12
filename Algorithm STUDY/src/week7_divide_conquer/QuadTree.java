package week7_divide_conquer;

import java.util.Scanner;

/*백준 1992 - 쿼드트리
 *version 1
 */

public class QuadTree {
	private static int[][] quadtree;
	private static StringBuilder sb;

	public static boolean check(int x, int y, int size) {
		
		int tmp = quadtree[x][y];
		
		boolean checked;

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (tmp != quadtree[i][j]) {
					//넘겨받은 좌표의 값이 배열 크기만큼 돌았을때 한 요소라도 다르면 압축 여부를 false로 리턴 
					checked = false;
					return checked;
				}
			}
		}
		checked = true;
		return checked;
		//가능하면 true 리턴
	}
	
	public static void divide(int x, int y, int size) {
		
		if (check(x, y, size)) {
			//해당 좌표부터 사이즈까지 체크가 되었으면
			sb.append(quadtree[x][y]);
			//압축한 결과 스트링빌더에 추가
			return;
		}
		//check = false 일 경우
		
		int resize = size / 2;
		//size를 반으로 나눔
		
		
		sb.append("(");
		
		//2차원 배열의 가로, 세로를 원래 사이즈의 반으로 상하좌우를 나눴을때
		
		divide(x, y, resize);
		//왼쪽 위
		divide(x, y + resize, resize);
		//오른쪽 위
		divide(x + resize, y, resize);
		//왼족 아래
		divide(x + resize, y + resize, resize);
		//오른쪽 아래
		
		sb.append(")");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		quadtree = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String s = input.next();
			
			for(int j = 0; j < n; j++) {
				quadtree[i][j] = s.charAt(j) - '0';
			}
		}
		//이미지 비트 입력		
		
		sb = new StringBuilder();
		
		divide(0, 0, n);
		//0, 0 부터 순환 시작
		
		System.out.println(sb);
	}

}
