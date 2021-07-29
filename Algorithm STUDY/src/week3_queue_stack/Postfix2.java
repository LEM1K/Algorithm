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
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		double[] op = new double[n];
		
		char[] postfix = br.readLine().toCharArray();
		
		Stack<Double> stack = new Stack<>();

		for(int i = 0; i < n; i++) {	
			op[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i < postfix.length; i++) {
			
			if(Character.isAlphabetic(postfix[i])) {
				int index = (int)postfix[i] - 65;
				stack.push(op[index]);
				
			}else {
				double result = 0.0;
				double op1 = stack.pop();
				double op2 = stack.pop();
				
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
