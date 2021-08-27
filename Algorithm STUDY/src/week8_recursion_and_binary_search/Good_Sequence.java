package week8_recursion_and_binary_search;

import java.util.Scanner;

/*백준 2661 - 좋은 수열
 *version 1
 */

public class Good_Sequence {
	
	private static final int START = 1;
	private static final int END = 3;
	
	static boolean endCheck = false;
	
	
	public static void func(int n, int size, String str) {
		if(endCheck) {
			return;
		}
		if(size - 1 == n) {
			System.out.println(str);
			endCheck = true;
			return;
		}
		
		for(int num = START; num <= END; num++) {
			String next = str + num;			
			int len = size / 2;
			boolean check = true;
			for(int i = 1; i <= len; i++) {
				
				String a = next.substring(size - i, size);
				String b = next.substring(size - i - i, size - i);
				
				if(a.equals(b)) {
					check = false;
					break;
				}
			}
			if(!check) {
				continue;
			}
			else {
				func(n, size + 1, next);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		func(n, 1, "");
	}
}
