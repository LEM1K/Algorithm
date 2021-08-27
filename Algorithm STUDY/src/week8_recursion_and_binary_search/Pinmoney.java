package week8_recursion_and_binary_search;

import java.util.Scanner;

/*백준 6236 - 용돈 관리
 *version 1
 */

public class Pinmoney {
	
	private static int arr[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int m = input.nextInt();
		
		arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			int tmp = input.nextInt();
			arr[i] = tmp;
		}
		
		int left = arr[0];
		int right = 0;
		int mid = 0;
		
		for(int i = 0; i < n; i++) {
			if(arr[i] > left) {
				left = arr[i];
			}
			
			right += arr[i];
		}
		
		while (left <= right) {
			mid = (left + right) / 2;
			
			int sum = 0; 
			int count = 0;
			
			for(int i = 0; i < n; i++) {
				if(sum + arr[i] > mid) {
					sum = 0;
					count++;
				}
				sum += arr[i];
			}
			
			if(sum != 0) {
				count++;
			}
			if(count <= m) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		System.out.println(left);
		
	}

}
