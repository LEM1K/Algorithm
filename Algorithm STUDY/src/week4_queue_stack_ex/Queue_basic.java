package week4_queue_stack_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*백준 10845 - 큐
 *version 1
 */

public class Queue_basic {
	
	private static int queue[];
	private static int front = 0;
	private static int rear = 0;
	private static int num = 0;
	
	
	public static int empty(int a[]) {
		if (num == 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public static void push(int a[], int x) {
		rear = rear + 1;
		num++;
		a[rear] = x;
	}
	
	public static int pop(int a[]) {
		if(empty(a) == 1) {
			return -1;
		}
		front = front + 1;
		num--;
		return a[front];
	}
	
	public static int size(int a[]) {
		return num;
	}
	
	public static int front(int a[]) {
		if(empty(a) == 1) {
			return -1;
		}
		return a[front + 1];
	}
	
	public static int back(int a[]) {
		if(empty(a) == 1) {
			return -1;
		}
		return a[rear];
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		queue = new int[n];
		for(int i = 0; i < n; i++) {
			String s = bf.readLine();
			
			switch(s) {
			case "push":
				int a = Integer.parseInt(bf.readLine());
				push(queue, a);
				break;
			case "pop":
				System.out.println(pop(queue));
				break;
			case "size":
				System.out.println(size(queue));
				break;
			case "empty":
				System.out.println(empty(queue));
				break;
			case "front":
				System.out.println(front(queue));
				break;
			case "back":
				System.out.println(back(queue));
				break;
			}
		}
	}

}
