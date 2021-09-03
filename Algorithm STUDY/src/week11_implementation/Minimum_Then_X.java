package week11_implementation;

import java.util.Scanner;

/*백준 10871 - X보다 작은 수
 *version 1
 */

public class Minimum_Then_X {

	private static int arr[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int x = input.nextInt();
		
		arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			int tmp = input.nextInt();
			arr[i] = tmp;
		}
		
		StringBuilder sb = new StringBuilder();
		//결과값을 얻을 스트링빌더
		for(int i = 0; i < n; i++) {
			if(arr[i] < x) {
				//배열 요소를 돌면서 요소가 x보다 작으면
				sb.append(arr[i] + " ");
				//스트링빌더에 추가
			}
		}
		
		System.out.println(sb);
	}

}
