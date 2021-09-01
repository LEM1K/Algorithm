package week10_greedy_ex1;

import java.util.Scanner;

/*백준 1969 - DNA
 *version 1
 */

public class DNA {
	
	/*
	  Hamming Distance의 최소값을 뽑아내기 위해 주어진 유전자들의 각 문자를 비교
	  ex) 
	  T A T G A T A C
	  T A A G C T A C
      A A A G A T C C
      T G A G A T A C
      T A A G A T G T
      
             일때, 1행을 보면 T가 4개, A가 1개로 추출될 유전자의 Hamming Distance를 줄이기 위해 제일 자주 나온 T가 선정 된다
             이렇게 되면 현재  Hamming Distance는 1이 된다. 반대로 다른 문자 A를 집어 넣을경우 4, C나 G를 넣을 경우 겹치는 것이 단 하나도 없기에 5가 된다.
             따라서 원하는 결과값 즉, 최소 Hamming Distance에 도달 할 수 없기에 무조건 T를 선정해야 한다
             이런 방식으로 마지막 문자 까지 탐색
	 */
	
	private static String strs[]; 
	private static int resultCount = 0;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int m = input.nextInt();
		
		strs = new String[n];
		
		for(int i = 0; i < n; i++) {
			String s = input.next();
			strs[i] = s;
		}
		
		StringBuilder sb = new StringBuilder();
		//결과 DNA를 담을 스트링빌더
		
		for(int i = 0; i < m; i++) {
			int[] al_count = new int[4];
			//각 알파벳  A C G T의 갯수를 카운트할 배열
			//사전순 출력을 요구하므로 순서대로 나열
			for(int j = 0; j < n; j++) {
				char tmp = strs[j].charAt(i);
				
				if(tmp == 'A') {
					al_count[0]++;
				}
				else if(tmp == 'C') {
					al_count[1]++;
				}
				else if(tmp == 'G') {
					al_count[2]++;
				}
				else {
					al_count[3]++;
				}
			}
			
			int max = 0;
			int tmp2 = al_count[0];
			
			for(int k = 0; k < al_count.length; k++) {
				if(tmp2 < al_count[k]) {
					//인덱스 별 요소가 해당 문자열의 A C G T의 숫자이므로 갯수의 최댓값에 해당하는 인덱스를  max로 추출
					tmp2 = al_count[k];
					max = k;
				}
			}
			
			switch(max) {
			
			case 0: sb.append('A'); break;
			case 1: sb.append('C'); break;
			case 2: sb.append('G'); break;
			case 3: sb.append('T'); break;
			}
			
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(sb.charAt(j) != strs[i].charAt(j)) {
					//문자열 배열에 있는 문자열들과 추출된 유전자 문자열의 각 문자를 비교해 다르면 결과값(Hamming Distance) 카운트업
					resultCount++;
				}
			}
		}
		
		System.out.println(sb.toString());
		System.out.println(resultCount);
		
	}

}
