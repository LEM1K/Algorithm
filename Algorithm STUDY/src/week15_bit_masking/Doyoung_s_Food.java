package week15_bit_masking;

import java.io.*;
import java.util.*;

/*백준 2961 - 도영이가 만든 맛있는 음식
 *version 1
 */

public class Doyoung_s_Food {
	
	//조합으로도 간단히 풀 수 있는 문제
	
	private static int n;
	private static int result = 1000000000;
	//출력 조건에서 쓴맛, 신맛은 1000000000이하
	
	private static int[][] sb;
	//각 재료의 신맛, 쓴맛 수치
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		
		sb = new int[n][2];
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			
			sb[i][0] = Integer.parseInt(st.nextToken());
			//column1은 신맛 수치
			sb[i][1] = Integer.parseInt(st.nextToken());
			//column2는 쓴맛 수치
		}
		
		
		for(int i = 1; i < (1 << n); i++) {
			
			//i를 비트 마스크 하기 위해 1부터 시작
			//범위는 n만큼 left shift
			//ex) n = 4 면 1 ~ 15까지 루프
			int s = 1;
			int b = 0;
			
			for(int j = 0; j < n; j++) {
				//ex) n = 4면  3 * 15 = 45로 총 45번의 루프를 수행한다.
				
				if((i & (1 << j)) > 0) {
					
					//ex) i = 3일때 이진수 변환 011 이므로  j = 0(001), j = 1(010)일때 만족
					s *= sb[j][0];
					b += sb[j][1];
					//만족했을때 각 조합의 수를 더해
				}
			}
			result = Math.min(result, Math.abs(s - b));
			//최소값 저장 
		}
		System.out.println(result);
		
	}

}
