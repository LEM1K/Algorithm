package week13_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interesting_Prime_Number2 {

	private static int n;
	private static StringBuffer sb;
	
	//소수 판별 함수
	public static boolean is_prime(int x) {
		if(x < 2) {
			return false;
		}
		for(int i = 2; i <= Math.sqrt(x); i++) {
			if(x % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void dfs(int start, int depth) {
		if(n == depth) {
			//입력받은 자리수가 탐색 깊이랑 같아지면
			sb.append(start + "\n");
			//정해진 소수를 스트링버퍼에 추가하고 리턴
			return;
		}
		
		
		for(int i = 0; i <= 9; i++) {
			//1 ~ 9까지 루프
			//start 0
			int num = (10 * start) + i;
			//ex) dfs(0, 0)에서  i = 2일때, num = 2
			//아래 조건을 충족하므로 dfs(2, 1)
			//이 루프문을 위의 파라미터 2, 1로 오면 num은 20 ~ 29사이에서 소수인 수(ex. 23)가 다음 깊이의 탐색을 수행함.
			//(23, 3) -> 230 ~ 239
			//따라서 n = 4일때, '1000의 자리', '1000의자리' + '100의자리', '1000의자리' + '100의자리' + '10의자리'
			//마지막으로 '1000의자리' + '100의자리' + '10의자리' + '1의자리' 가 모두 소수인 값을 추가하게 됨.
			
			if(is_prime(num)) {
				//위 값이 소수이면
				dfs(num, depth + 1);
				//다음 깊이(자릿수) 탐색
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		sb = new StringBuffer();
		
		dfs(0, 0);
		
		System.out.println(sb.toString());
	}

}
