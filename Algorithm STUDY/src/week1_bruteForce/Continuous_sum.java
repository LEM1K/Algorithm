package week1_bruteForce;

import java.util.Random;

/*백준 1912 - 연속합
 *version 1
 */

public class Continuous_sum {
	
	static int[] arr1;	//원 배열
	static int[] arr2;	//연속합 배열
	static int max;		//결과값
	
	static int result(int n, int[] arr1, int[] arr2, int max) {
		for(int i = 1; i < n; i++) {
			arr2[i] = Math.max(arr2[i - 1] + arr1[i], arr1[i]);
			//원배열과 연속합 배열의 인덱스 값을 비교 후 높은 값 적재
			max = Math.max(max, arr2[i]);
			//연속합 배열의 인덱스 값과 과 맥스 값을 비교 후 높은 값 적재
		}
		return max;
	}
	//점화식 결과 값 반환

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long seed = System.currentTimeMillis();
		Random rand = new Random(seed);
		//시드 초기화
		
		int n = rand.nextInt(5) + 5;
		//배열 랜덤 사이즈(5 - 10)
		System.out.println("N : " + n);
		
		arr1 = new int[n];
		arr2 = new int[n];
		//각 배열 초기화
		
		for(int i = 0; i < n; i++) {
			arr1[i] = rand.nextInt(20) - 10;
		}
		//원 배열에 랜덤 값 추가 (-10 - 10)
		
		
		System.out.println("array generated");
		System.out.print("arr >> ");
		for(int i = 0; i < n; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		//배열 출력
		
		arr2[0] = arr1[0];
		//첫 째 연속합을 적재(기저 상태)
		max = arr1[0];
		//최초 연속합 실행시 맥스는 최초 값이므로 맥스에 적재 
		
		max = result(n, arr1, arr2, max);
		//점화식 값 맥스에 적재
		System.out.println("최댓 값 : " + max);
		
	}

}
