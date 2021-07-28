package week3_queue_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*백준 3078 - 좋은 친구
 *version 1
 */

public class Friends {
	static String friends[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n;
		int range;
		int count = 0;
		boolean check = false;
		String s;
		
		n = Integer.parseInt(bf.readLine());
		//배열 범위
		range = Integer.parseInt(bf.readLine());
		//비교 범위
		friends = new String[n];
		//친구 배열 초기화
		
		for(int i = 0; i < n; i++) {
			s = bf.readLine();
			friends[i] = s;
		}
		//친구 입력
		
		for(int i = 0; i < n; i++) {
			int tmp = i + 1;
			for(int j = tmp; j < range + tmp; j++) {
				if(friends[i].length() == friends[j].length()) {
					//첫번째 친구와 RANGE에 인접한 친구들 길이가 같으면 
					count++;
					//COUNT UP;
				}
				if(range + tmp >= n) {
					//비교 범위가 배열 범위보다 커지면 중단
					check = true;
					break;
				}
			}
			if(check) {
				//체크 확인 시 중단
				break;
			}
		}
		
		System.out.println(count);
	}

}
