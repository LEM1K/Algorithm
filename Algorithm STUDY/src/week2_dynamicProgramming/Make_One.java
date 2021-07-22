package week2_dynamicProgramming;

import java.util.Scanner;

/*백준 1463 - 1로 만들기
 *version 1
 */

public class Make_One {
	
	private static Integer arr[];
	//메모이제이션
	//초기값이 0으로 초기화 되기 때문에 나머지 요소들은 null로 초기화 되는 Integer형 사용
	public static int solution(int n) {
		
		if(arr[n] == null) {
			//배열 요소가 null일 경우 
			
			//조건 1. x가 3으로 나누어 떨어지면 3으로 나눔
			if(n % 3 == 0) {
				arr[n] = Math.min(solution(n / 3), solution(n - 1)) + 1;
				//점화식 1 : d[n] = d[n / 3] + 1
				//최소값 비교를 위해 점화식 3과 비교 후 적은 값 저장
			}
			
			//조건 2. x가 2로 나누어 떨어지면 2로 나눔
			else if(n % 2 == 0) {
				arr[n] = Math.min(solution(n / 2), solution(n - 1)) + 1;
				//점화식2 : d[n] = d[n / 2] + 1
				//최소값 비교를 위해 점화식 3과 비교 후 적은 값 저장
			}
			
			//조건 3. 위 두 경우에 해당하지 않으면 1을 뺌
			else {
				arr[n] = solution(n - 1) + 1;
				//점화식3 : d[n] = d[n - 1] + 1
			}	
		}
		
		return arr[n];
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		
		System.out.println("1로 만들 숫자를 입력하시오  >> ");
		n = input.nextInt();
		
		arr = new Integer[n + 1];
		//배열 초기화
		
		arr[0] = 0;
		arr[1] = 0;
		//초기값 
		
		System.out.println();
		
		System.out.println(n + " to 1 needs count : " + (solution(n)));
		
	}

}
