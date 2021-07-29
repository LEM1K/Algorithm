package week4_queue_stack_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*백준 10828 - 스택
 *version 2
 */

public class Stack_basic_p {
	private static int stack[];
	private static int size;
	
	public static void push(int a[], int x) {
		a[size] = x;
		size++;
	}
	
	public static int pop(int a[]) {
		if(size == 0) {
			return -1;
		}
		int tmp = a[size - 1];
		a[size - 1] = 0;
		size--;
		return tmp;
	}
	
	public static int size(int a[]) {
		return size;
	}
	
	public static int empty(int a[]) {
		if(size == 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public static int top(int a[]) {
		if(size == 0) {
			return -1;
		}
		return a[size - 1];
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(size);
		int n = Integer.parseInt(bf.readLine());		
		stack = new int[n];
		
		for(int i = 0 ; i < n; i++) {
			String s = bf.readLine();
			
			switch(s) {
			case "push":
				int a = Integer.parseInt(bf.readLine());
				push(stack, a);
				break;
			case "pop":
				System.out.println(pop(stack));
				break;
			case "size":
				System.out.println(size(stack));
				break;
			case "empty":
				System.out.println(empty(stack));
				break;
			case "top":
				System.out.println(top(stack));
				break;
			}
		}
	}

}
