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
		
		Queue<Integer>[] queue = new Queue[21];
		
		for(int i = 0; i < 21; i++) {
			queue[i] = new LinkedList<>();
		}
		
		
		
		
		for(int i = 0; i < friends_num; i++) {
			String name = input.next();
			int len = name.length();
			
			
			if(queue[len].isEmpty()) {
				queue[len].offer(i);
			}
			else {
				while(i - queue[len].peek() > range) {
					queue[len].poll();
					if(queue[len].isEmpty()) {
						break;
					}
				}
				
				count += queue[len].size();
				queue[len].offer(i);
			}
		}

		
		System.out.println(count);
	}

}
