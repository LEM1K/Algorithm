package week7_divide_conquer;

import java.util.Scanner;

/*백준 2447 - 별찍기
 *version 1
 */

public class Star10 {
	
	private static char pattern[][];
	
	public static void star(char[][] arr, int x, int y, int n) {
		if(n == 1) {
			//사이즈가 1 이면 해당요소는 * 찍기
			arr[x][y] = '*';
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(!(i == 1 && j == 1)) {
					//i, j 가 1이 아니면
					star(arr, x + i * (n / 3), y + j * (n / 3), n / 3);
					//재귀함수를 돌면서 해당좌표에 * 찍기
				}
			}
		}
	}
	
	
	/*
	 	ex) 3*3 배열 일경우
	
		시작 파라미터로 0, 0, 3이 들어가게됨
		처음 조건은 만족하지 않으므로

		다음 코드인 이중 for문 수행
		i = 0일 때
		j = 0일 경우 수행되는 메소드 파라미터로 0, 0, 1이 들어감
		j = 1일 경우 0, 1, 1
		j = 2일 경우 0, 2, 1
		위의 세 메소드는 (arr을 제외한) 세번째 파라미터로 1이 넘어가므로 해당 위치에 *을 찍음.
		
		마찬가지로 i = 1일 때
		j = 0일 경우 1, 0, 1
		j = 1일 경우 1, 1, 1 
		j = 2일 경우 1, 2, 1
		j = 1일 경우엔 조건문 !(i == 1 && j == 1) 이부분을 충족하지 않으므로 스킵 
		따라서 가운데에 *은 찍히지 않고 그대로 공백으로 남음.
		
		같은 원리로 나머지를 돌면 
		*********
		* ** ** * 
		*********
		* 가 완성
		
		문제는 9 * 9 배열일 경우 중요
		시작 파라미터로 0, 0, 9가 들어가게됨
		첫째 예시와 마찬가지로 처음 조건은 만족하지 않으므로
		
		다음코드인 이중 for문 수행
		i = 0일 때 
		j = 0일 경우 수행되는 메소드 파라미터로 0, 0, 3이 들어감
		첫번째 예시에서 본 파라미터랑 일치 하므로 해당 파라미터가 넘어간 메소드는
		***
		* * 
		***를찍는다는것을 확정
		j = 1일 경우에 수행되는 메소드 파라미터는 0, 3, 3
		3 * 3배열 일때 마지막 인덱스 값은 2이므로 좌표 0, 3부터 찍게됨
		해당 파라미터를 넘겼을때 (0, 3, 1), (0, 4, 1), (0, 5, 1) .... 로 순환을 돌게 됨으로 위와 같은 모양을 찍게됨
		그렇게 쭉 순환을 돌다가
		i = 1, j = 1일 경우 조건을 충족하지 않으므로 다음 넘겨지는 파라미터(3, 3, 3)은 스킵
		만약 3, 3, 3이 넘어갔을경우 (3, 4, 1), (3, 5, 1), (3, 6, 1) .... (6, 6, 1) 순으로 로 순환을 돌기 때문에
		처음 배열 크기의 딱 가운데가 됨 따라서 해당 파라미터로 넘어가는걸 스킵한다.
	  */
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = input.nextInt();
		
		pattern = new char[n][n];
		
		for(int i = 0; i < pattern.length; i++) {
			for(int j = 0; j < pattern[i].length; j++) {
				pattern[i][j] = ' ';
			}
		}
		//배열 모든요소를 빈칸으로 채움
		
		star(pattern, 0, 0, n);
		//0,0 부터 순환시작
		
		for(int i = 0; i < pattern.length; i++) {
			for(int j = 0; j < pattern[i].length; j++) {
				sb.append(pattern[i][j]);
			}
			sb.append("\n");
		}
		//스트링빌더로 묶어서 출력
		
		System.out.println(sb);
	}
	

}
