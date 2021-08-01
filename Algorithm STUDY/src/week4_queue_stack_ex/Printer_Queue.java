package week4_queue_stack_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*백준 1966 - 프린터큐
 *version 1
 */

public class Printer_Queue {

	public static void main(String[] args) { 
        Scanner input = new Scanner(System.in); 
        int cases = input.nextInt(); 
        int doc_num, search, count; 
        
        for(int i = 0; i < cases; i++) { 
            LinkedList<int[]> queue = new LinkedList<>(); 
            count = 0; 
            doc_num = input.nextInt();
            search = input.nextInt(); 
            
            for(int j = 0; j < doc_num; j++) {
                queue.add(new int[] {j, input.nextInt()});
                //큐에 문서, 중요도 enqueue
            }
 
            while(!queue.isEmpty()){ 
                //큐가 빌때까지
                int[] tmp = queue.poll(); 
                //첫번째 큐 항목 enqueue
                boolean check = true; 
                
                for (int[] q : queue) {
                	//queue size 까지 반복
                    if(q[1] > tmp[1]) {
                    	//dequeue한 값의 중요도가 큐의 다음 값의 중요도보다 작으면
                        check = false;
                        
                    }     
                }
                    
                if (check) { 
                    count++;
                  //check = true시 해당값 출력후 카운트 업
                    if (tmp[0] == search){
                    //만약 dequeue 값이 입력한 search 값과 동일하면 break
                        break;
                    }      
                } 
                else {
                    queue.add(tmp); 
                    //check = false 시, dequeue한 값을 큐에 재 enqueue
                }
            } 
            System.out.println(count); 
        } 
    } 

}
