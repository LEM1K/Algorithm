package practice;

import java.util.Scanner;

public class prac1 {
	private static int num;		//3 <= num <= 100
	private static int max;		//10 <= max <= 300000
	static int arr[];			//arr 각요소  <= 100000
	
	public static int solution(int[] arr, int num, int max) {
		int result = 0;
		int tmp;
		
		for(int i = 0; i < num - 2; i++) {
			for(int j = i + 1; j < num - 1; j++) {
				for(int k = j + 1; k < num; k++) {
					tmp = arr[i] + arr[j] + arr[k];
					
					if (max == tmp) {
						return tmp;
					}
					
					if (result < tmp && tmp < max) {
						result = tmp;
					}
				}
			}
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("배열 크기  >>  ");
		num = input.nextInt();
		System.out.print("최댓 값  >>  ");
		max = input.nextInt();
		
		arr = new int[num];
		
		System.out.print(num + "개의 배열 요소");
		for(int i = 0; i < num; i++) {
			arr[i] = input.nextInt();
		}
		
		System.out.println(solution(arr, num, max));
	}

}
