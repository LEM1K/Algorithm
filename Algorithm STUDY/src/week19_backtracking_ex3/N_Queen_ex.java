package week19_backtracking_ex3;

import java.util.Arrays;
import java.util.Scanner;

/*백준 9663 - N-Queen 경우의수 확인
 */

public class N_Queen_ex {
	
	private static final int[] DX = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static final int[] DY = {0, 1, 1, 1, 0, -1, -1, -1};
	
	private static int n;
	private static int[][] square;
	private static boolean[][] check;
	private static int result;
	
	public static void function(int start, int depth) {
		
		
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		
		square = new int[n][n];
		check = new boolean[n][n];
		for(boolean a[] : check) {
			Arrays.fill(a, Boolean.TRUE);	
		}
			
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(square[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(result);
		
		
	}

}
