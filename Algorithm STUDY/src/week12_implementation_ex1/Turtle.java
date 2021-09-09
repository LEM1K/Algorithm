package week12_implementation_ex1;

import java.util.Scanner;

/*백준 8911 - 거북이
 *version 1
 */

public class Turtle {
	
	private static final int[] DX = {1, 0, -1, 0};
	private static final int[] DY = {0, 1, 0, -1};
	//아래, 오른쪽, 위, 왼쪽
	
	//private static int arr[][] = new int[500][500];
	//굳이 사용할 필요가 없음
	public static int function(String s) {
		int result = 1;
		
		int nx = 0;
		int ny = 0;
		int cursor = 0;
		
		int min_x = 0;
		int min_y = 0;
		int max_x = 0;
		int max_y = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			switch(s.charAt(i)) {
			case 'F': 
				nx += DX[cursor];
				ny += DY[cursor];
				//F일때 커서 방향에 따라 한칸 앞으로 전진
			break;
			case 'B':
				nx -= DX[cursor];
				ny -= DY[cursor];
				//B일때 커서 방향에 따라 한칸 뒤로 후진
				break;
			case 'R': 
				cursor = (cursor + 1) % 4; 
				//R일때 핸들 조정 
				//(R한번 사용시 (0 + 1) % 4 = 1(오른쪽), R두번  (1 + 1) % 4 = 2 (위쪽), R세번 (2 + 1) % 4 = 3 (왼쪽), R네번 (3 + 1) % 4 = 0(아래))
				break;
			case 'L': 
				cursor = (cursor + 3) % 4;
				//L일때 핸들 조정 
				//(L한번 사용시 (0 + 3) % 4 = 3(왼쪽), R두번  (3 + 3) % 4 = 2 (위쪽), R세번 (6 + 3) % 4 = 1 (오른쪽), R네번 (9 + 3) % 4 = 0(아래)) 
				break;
			}
			
			min_x = Math.min(nx, min_x);
			//전진 후진에 대한 x좌표 최댓값
			max_x = Math.max(nx, max_x);
			//전진 후진에 대한 x좌표 최솟값
			min_y = Math.min(ny, min_y);
			//전진 후진에 대한 y좌표 최댓값
			max_y = Math.max(ny, max_y);
			//전진 후진에 대한 y좌표 최솟값
		}
		
		result = (max_x - min_x) * (max_y - min_y);
		//한방향에 대한 일렬로 전진. 혹은 후진시에 평면이아닌 선분이 도출되므로 값은 0.
		/*ex) FFFBBBRFFFBBB 일때,
		 FFF => nx = 3, ny = 0
		 BBB => nx = 0, ny = 0
		  따라서  max_x = 3, min_x = 0
		 R 이후 y좌표 증감.
		 FFF => nx = 0, ny = 3
		 BBB => nx = 0, ny = 0
		  따라서 max_y = 3, min_y = 0
		 
		 => result = (3 - 0) * (3 - 0) = 9
		 
		 */
		
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int cases = input.nextInt();
		
		for(int i = 0; i < cases; i++) {
			String s = input.next();
			
			sb.append(function(s) + "\n");
			//결과값을 리턴받아 스트링빌더에 추가
		}
		System.out.println(sb.toString());
	}

}
