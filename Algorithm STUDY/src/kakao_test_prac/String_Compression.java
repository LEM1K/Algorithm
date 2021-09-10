package kakao_test_prac;

import java.util.Scanner;

/*2020 KAKAO BLINE RECRUITMENT 1번 - 문자열 압축*/

public class String_Compression {
	
	public static int function(String s) {
		int answer = 1000;
		
		if(s.length() == 1) {
			return 1;
		}
		
		for(int i = 1; i < s.length() / 2; i++) {
			String now, next = "", result = "";
			int tmp = 1;
			
			for(int j = 0; j <= s.length() / i; j++) {
				int start = j * i;
				int end = i * (j + 1) > s.length() ? s.length() : i * (j + 1);
				now = next;
				next = s.substring(start, end);
				
				if(now.equals(next)) {
					tmp++;
				}
				else {
					
				}
			}
		}
		
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		String s = input.nextLine();
		
		System.out.println(function(s));
	}

}
