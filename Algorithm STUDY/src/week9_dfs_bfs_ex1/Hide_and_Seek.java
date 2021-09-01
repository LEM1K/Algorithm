package week9_dfs_bfs_ex1;


import java.util.*;

/*백준 1697 - 숨바꼭질
 *version 1
 */

public class Hide_and_Seek {

	private static int min = 100001;

	/*5 -> 17일 때 그려지는 트리
	
	d=0 			     5
	d=1		  	       6 4 10
	d=2       7 5 12	5 3 8 	11 9 20
	d=3  8 6 14 ....		9 7 16 ....
	d=4....                    17 15 32 ....
	*/
	
	
	public static void DFS(int start, int dest, int depth) {
		if (start < 0 || start > dest || depth > min) {
			//시작값이 0보다 작거나 도착값보다 크고, 깊이가 최소값보다 커지면 리턴
			return;
		} 
		if (start == dest) {
			//시작 값이 도착값이랑 같아지면
			min = depth;
			//소요된 시간인 깊이를 최소값에 저장 후 리턴
			return;
		}
		
		/*3가지 이동조건에 대한 탐색*/
		
		DFS(start * 2, dest, depth + 1);
		//이동 조건 1. n * 2 
		DFS(start + 1, dest, depth + 1);
		//이동 조건2. n + 1
		DFS(start - 1, dest, depth + 1);
		//이동 조건3. n - 1
	}
	
	public static int BFS(int start, int dest) {
		
		Queue<Integer> queue = new LinkedList<>();
		int[] result = new int[100001];
		//결과값을 누적할 배열
		
		queue.offer(start);
		result[start] = 1;
		//출발점 초기화
		
		while(!queue.isEmpty()) {
			//큐가 빌때까지
			
			int tmp = queue.poll();
			//큐에 있는 항목 꺼내기
			
			
			/*3가지 이동조건에 대한 탐색*/
			for(int i = 0; i < 3; i++) {
				int next;
				
				 
				if(i == 0) {
					next = tmp * 2;
				}
				//이동 조건 1. n * 2
				else if(i == 1) {
					next = tmp + 1;
				}
				//이동 조건 2. n + 1 
				
				else {
					next = tmp - 1;
				}
				//이동 조건 1. n - 1 
				
				if(next == dest) {
					//다음 이동할 인덱스 값이 도착지점과 동일하면
					return result[tmp];
					//현재 배열 요소 반환
				}
				
				if(0 <= next && next < 100001) {
					//배열 범위를 만족하고
					if(result[next] == 0) {
						//다음 탐색 값이 0이면
						queue.offer(next);
						//다음 탐색 인덱스를 큐에 삽입
						result[next] = result[tmp] + 1;
						//이동 시간이 어떤 조건이든 1초가 소요되므로 그 다음 요소 값에 현재 요소값 + 1
					}
				}
			}
			
			
		}
		return 0;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int start = input.nextInt();
		int dest = input.nextInt();
		
		//DFS 결과값 출력
		 if(start > dest) {
			System.out.println(start - dest);
			//d출발점이 도착점보다 크면 뒤로 이동하는 방법밖에 없으므로 지점의 차만큼이 소요시간이 됨
		}
		else {
			DFS(start, dest, 0);
			System.out.println(min);	
		}
		
		 
		//BFS 결과값 출력
		if(start == dest) {
			System.out.println(0);
			//출발점과 도착점이 같으면 이동할 필요가 없으므로 0
		}
		else if(start > dest) {
			System.out.println(start - dest);
			//출발점이 도착점보다 크면 뒤로 이동하는 방법밖에 없으므로 지점의 차만큼이 소요시간이 됨
		}
		else {
			System.out.println(BFS(start, dest));
		}
	}

}
