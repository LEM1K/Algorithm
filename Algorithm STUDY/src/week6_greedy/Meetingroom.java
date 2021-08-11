package week6_greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*백준 1931 - 회의실 배정
 *version 1
 */

public class Meetingroom {

	private static int[][] conf;
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		int cases = input.nextInt();
		int count = 0;
		//최대 회의 수
		int prev = 0;
		//시간 초기화
		
		conf = new int[cases][2];
		
		for(int i = 0; i < cases; i++) {
			int start = input.nextInt();
			int end = input.nextInt();
			
			conf[i][0] = start;
			conf[i][1] = end;
		}
		
		Arrays.sort(conf, new Comparator<int[]>() {
		//종료시간을 기준으로 정렬
			@Override
			public int compare(int[] arg, int[] arg1) {
				// TODO Auto-generated method stub
				if(arg[1] == arg1[1]) {
					//종료시간이 같을 경우
					return arg[0] - arg1[0];
					//시작시간이 낮은 객체 부터 리턴
				}
				return arg[1] - arg1[1];
			}
			
		});
		
		
		for(int i = 0; i < cases; i++) {
			//이전 종료시간 0 >> 회의를 시작하지 않았으므로
			if(prev <= conf[i][0]) {
				//이전종료시간 보다 시작시간이 크면
				prev = conf[i][1];
				//해당회의의 종료시간을 이전종료시간으로 변경 후 카운트 업
				count++;
			}
		}
		System.out.println(count);
		
		
	}
}
