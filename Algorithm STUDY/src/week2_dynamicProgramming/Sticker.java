package week2_dynamicProgramming;

import java.util.Scanner;

/*백준 9465 - 스티커
 *version 1
 */

public class Sticker {
	
	public static int arr[][];
	public static int n;
	
	public static int solution(int[][] arr) {
		int result = 0;
		int max = arr[0][0];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(max <= arr[i][j]) {
					max = arr[i][j];
					result += max;
					arr[i][j + 1] = 0;
					arr[i][j - 1] = 0;
					arr[i + 1][j] = 0;
					
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		//n = input.nextInt();
		
		int this_arr[][] = {{50, 10, 100, 20, 40}, 
						{30, 50, 70, 10, 60}};
		
		System.out.println(solution(this_arr));
		
	
	}

}
