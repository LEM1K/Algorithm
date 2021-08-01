package week3_queue_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*백준 3078 - 좋은 친구
 *version 1
 */

public class Friends {
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int friends_num = input.nextInt();
		int range = input.nextInt();
		int count = 0;
		
		int[] arr = new int[friends_num];
		for(int i = 0; i < friends_num; i++) {
			String friend = input.next();
			arr[i] = friend.length();
			//입력한 친구의 길이(문자수)를 배열에 저장
		}

		
		for(int i = 0; i < arr.length; i++) {
			
			int tmp = arr[i];
			//배열의 요소 임시 저장
			int grade = range + i;
			//성적 격차
			if(grade >= arr.length - 1) {
			
				grade = arr.length - 1;
				//배열 범위 초과 예외를 처리하기 위해 성적 격차가 배열의 사이즈보다 높거나 같으면 배열 사이즈 만큼 재설정
			}
			
			
			else {
				for(int j = i + 1; j <= grade; j++) {
					//다음 배열요소부터 격차까지 반복
					if(tmp == arr[j]) {
						count++;
						//임시 저장한 요소와 그 다음 요소 길이가 같으면 카운트 업
					}
				}
			}
		}
		System.out.println(count);
		
		//ps. 값은 제대로 나오나 시간초과. 큐를 사용하여 알고리즘 개선 필요
	}

}
