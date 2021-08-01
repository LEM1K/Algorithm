package week3_queue_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/*백준 1935 - 후위표기식2
 *version 1
 */

public class Postfix2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		double[] op = new double[n];
		//피연산자를 담을 배열
		char[] postfix = br.readLine().toCharArray();
		//입력받을 후위 표기식
		
		Stack<Double> stack = new Stack<>();
		//부동소수형 스택 초기화
		for(int i = 0; i < n; i++) {	
			op[i] = Integer.parseInt(br.readLine());
			//문자형 피연산자에 대응되는 정수 입력
		}
		for(int i = 0; i < postfix.length; i++) {
			
			if(Character.isAlphabetic(postfix[i])) {
				//표기식의 알파벳 구분
				int index = (int)postfix[i] - 65;
				//A to Z 아스키코드 값으로 변환 후 피연산자 배열의 인덱스로 넘김(0 ~ 25) (ex. A : 1...) 
				stack.push(op[index]);
				//스택에 피연산자 푸쉬
			}else {
				double result = 0.0;
				double op1 = stack.pop();
				double op2 = stack.pop();
				//후위표기식의 문자가 연산자 일 경우 POP한 값과 연산
				
				if(postfix[i] == '+') {
					result = op2 + op1;
				}
				
				if(postfix[i] == '-') {
					result = op2 - op1;
				}
				
				if(postfix[i] == '*') {
					result = op2 * op1;
				}
				
				if(postfix[i] == '/') {
					result = op2 / op1;
				}
				stack.push(result);
			}
		}
		System.out.printf("%.2f", stack.pop());
	}
}
