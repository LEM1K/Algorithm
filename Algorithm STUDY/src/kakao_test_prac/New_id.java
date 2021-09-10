package kakao_test_prac;

import java.util.Scanner;

/*2021 KAKAO BLINE RECRUITMENT 1번 - 신규 아이디 추천*/

public class New_id {
	
	public static String function(String str) {
		String result = "";
		
		//1단계. 대문자 -> 소문자
		String sub_result1 = str.toLowerCase();
		
		
		//2단계. 알파벳, 소문자, '-', '_', '.' 가 아니면 제외
		String sub_result2 = "";
		
		for(int i = 0; i < sub_result1.length(); i++) {
			char tmp = sub_result1.charAt(i);
			if(Character.isAlphabetic(tmp) || Character.isDigit(tmp) || tmp == '-' || tmp == '_' || tmp == '.') {
				sub_result2 += tmp;
			}
		}
		
		//3단계. '..' 를 '.'으로 대체
		String sub_result3 = sub_result2.replace("..", ".");
		while(sub_result3.contains("..")) {
			sub_result3 = sub_result3.replace("..", ".");
		}
		
		
		//4단계. 처음이나 끝부분이 '.'면 제거
		String sub_result4 = sub_result3;
		if(sub_result4.length() > 0) {
			if(sub_result3.charAt(0) == '.') {
				sub_result4 = sub_result4.substring(1, sub_result4.length());
			}	
		}
		
		if(sub_result4.length() > 0) {
			if(sub_result4.charAt(sub_result4.length() - 1) == '.') {
				sub_result4 = sub_result4.substring(0, sub_result4.length() - 1);
			}	
		}
		
		
		//5단계. 빈문자열이면 'a'로 대체
		String sub_result5 = sub_result4;
		
		if(sub_result5.equals("")) {
			sub_result5 = "a";
		}
		
		
		//6단계. 문자열 길이가 16이상이면 첫번째 문자 ~ 15번째 문자 이외의 문자 제거.
		//만약 마지막문자가 '.'이면 '.'까지 제거
		String sub_result6 = sub_result5;
		
		if(sub_result6.length() >= 16) {
			sub_result6 = sub_result6.substring(0, 15);
			
			if(sub_result6.charAt(sub_result6.length() - 1) == '.') {
				sub_result6 = sub_result6.substring(0, sub_result6.length() - 1);
			}
		}
		
		//7단계. 문자열 길이가 2이하이면 마지막 문자를 길이가 3이 될때 까지 추가
		String sub_result7 = sub_result6;
		
		if(sub_result6.length() <= 2) {
			char tmp = sub_result7.charAt(sub_result7.length() - 1);
			
			while(sub_result7.length() < 3) {
				sub_result7 += tmp;
			}
		}
		
		result = String.valueOf(sub_result7);
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		String str = input.nextLine();
		
		System.out.println(function(str));
	}

}
