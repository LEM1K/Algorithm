package week3_queue_stack;

import java.util.*;

/*백준 1918 - 후위표기식1
 *version 1
 */

public class Postfix1 {
	
	public static int priority(char op) {
		if (op == '*' || op == '/') 
			return 2;
		else if(op == '+' || op == '-') 
			return 1;
		else
			return 0;
	}
	//연산자 우선순위 분별

	public static void infix_to_postfix(String infix) {
		//중위표기식 >> 후위표기식
		char[] c = infix.toCharArray();
		Stack<Character> stk = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		//결과값을 얻을 스트링 빌더
 		for(int i = 0; i < c.length; i++) {
 			
			if(c[i] >= 'A' && c[i] <= 'Z') {
				sb.append(c[i]);
			}
			//요소가 피연산자  A to Z 면 스트링빌더에 문자 추가
			
			//아니면 다음 조건
			else {
				if(c[i] == '(') {
					stk.push(c[i]);
				}
				//요소가 소괄호 ( 일때  스택에 PUSH
				else if(c[i] == ')') {
					while(!stk.isEmpty() && stk.peek() != '(') {
						sb.append(stk.pop());
					}
					if(!stk.isEmpty()) {
						stk.pop();
					}
				}
				//요소가 소괄호 ) 일때  스택이 빌때까지 POP후 스트링빌더에 피연산자 추가. POP한 결과가 소괄호 ( 일때까지 반복
				else {
					while(!stk.isEmpty() && priority(stk.peek()) >= priority(c[i])) {
						sb.append(stk.pop());
					}
					stk.push(c[i]);
				}
				//요소가 연산자 일때 PUSH. 스택이 비지 않았다면 PEEK값과 현재 요소의 연산자 우선순위를 계산후 POP한 요소를 스트링빌더에 연산자 추가
			}
		}
 		while(!stk.isEmpty()) {
 			sb.append(stk.pop());
 		}
 		//스택이 비지 않았다면 나머지 요소들을 POP
		System.out.println(sb.toString());
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		
		infix_to_postfix(str);
		
	}
}
