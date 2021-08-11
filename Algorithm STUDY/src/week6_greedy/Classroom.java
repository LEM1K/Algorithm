package week6_greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*백준 11000 - 강의실 배정
 *version 1
 */

public class Classroom {
	
	private static int lec[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		lec = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			int start = input.nextInt();
			int end = input.nextInt();
			
			lec[i][0] = start;
			lec[i][1] = end;
		}
		
		Arrays.sort(lec, new Comparator<int[]>() {
		//시작시간 기준으로 정렬
			@Override
			public int compare(int[] start, int[] end) {
				// TODO Auto-generated method stub
				if(start[0] == end[0]) {
					//시작시간이 같을 경우
					return start[1] - end[1];
					//종료시간이 낮은 객체 부터 리턴
				}
				return start[0] - end[0];
			}
			
		});
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		//우선순위 큐 정의
		
		for(int i = 0; i < n; i++) {
			//강의 수만큼 반복
			queue.offer(lec[i][1]);
			//큐에 강의 종료시간 추가
			if(!queue.isEmpty() && queue.peek() <= lec[i][0]) {
				//큐가 비어있지 않고 다음 강의 시작시간이 이전 강의 종료시간보다 크거나 같으면
				queue.poll();
				//해당 강의실에 다음강의 시작 처리
			}
			
		}
		
		System.out.println(queue.size());
	}

}
