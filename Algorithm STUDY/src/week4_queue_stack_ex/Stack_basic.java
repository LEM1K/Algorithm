package week4_queue_stack_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/*백준 10828 - 스택
 *version 1
 */

public class Stack_basic {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stk = new Stack<>();
		
		int cases;
		cases = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < cases; i++) {
			String s = bf.readLine();
			
			switch(s) {
			case "push":
				int a = Integer.parseInt(bf.readLine());
				stk.add(a);
				break;
			case "pop":
				System.out.println(stk.isEmpty() ? -1 : stk.pop());
				break;
			case "size":
				System.out.println(stk.size());
				break;
			case "empty":
				System.out.println(stk.isEmpty() ? 1 : 0);
				break;
			case "top":
				System.out.println(stk.isEmpty() ? -1 : stk.peek());
				break;
			}
		}
	}
}
