package week18_backtracking_ex2;

import java.util.Scanner;

/*백준 14888 - 연산자 끼워넣기
 *version 1
 */

public class Insert_Operator {
	
	/*문제 접근
	 ex) 피연산자  : [3, 4, 5],
	 	  연산자(덧셈, 뺄셈, 곱셈, 나눗셈 순서): [1, 0, 1, 0] 일때
	 
	 				3				depth 0
	 		+= 7		*= 12		depth 1
	 		*= 35		+= 17		depth 2
	 		*
	 		*
	 		
	 	
	 	의 트리형태를 구성
	  
	  */
	
	private static int[] operator = new int[4];
	private static int[] operand;
	private static int max = Integer.MIN_VALUE;
	private static int min = Integer.MAX_VALUE;
	
	public static void backtracking(int start, int depth) {
		if(depth == operand.length - 1) {
			//최대깊이까지 탐색이 끝나면 최대, 최소 분별
			max = Math.max(max, start);
			min = Math.min(min, start);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(operator[i] > 0) {
				//연산자가 존재할 경우
				operator[i]--;
				//연산 수행
				
				if(i == 0) {
					//덧셈
					backtracking(start + operand[depth + 1], depth + 1);
				}
				else if(i == 1) {
					//뺄셈
					backtracking(start - operand[depth + 1], depth + 1);
				}
				else if(i == 2) {
					//곱셈
					backtracking(start * operand[depth + 1], depth + 1);
				}
				else if(i == 3) {
					//나눗셈
					backtracking(start / operand[depth + 1], depth + 1);
				}
				operator[i]++;
				//수행한 연산자 복구
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		operand = new int[n];
		
		for(int i = 0; i < n; i++) {
			operand[i] = input.nextInt();
		}
		//피연산자 배열
		
		for(int i = 0; i < 4; i++) {
			operator[i] = input.nextInt();
		}
		//연산자 배열
		
		backtracking(operand[0], 0);
		//초기 피연산자와 깊이가 넘어감
		
		System.out.println(max);
		System.out.println(min);
	}

}
