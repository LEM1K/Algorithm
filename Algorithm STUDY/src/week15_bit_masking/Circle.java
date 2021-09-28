package week15_bit_masking;

import java.util.*;
import java.io.*;

/*백준 2098 - 외판원 순회
 *version 1
 */

public class Circle {
	
	private static int n;
	private static int[][] w, dp;
	private static final int INF = 16000000;

	public static int dfs(int node, int visit) {

		if (visit == (1 << n) - 1) { 
			if (w[node][0] == 0)
				return INF;
			return w[node][0];
		}

		if (dp[node][visit] != INF) {
			return dp[node][visit];
		}

		for (int i = 0; i < n; i++) {
			if ((visit & (1 << i)) == 0 && w[node][i] != 0) {
				
				dp[node][visit] = Math.min(dp[node][visit], dfs(i, visit | (1 << i)) + w[node][i]);
			}
		}

		return dp[node][visit];
	}
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n][(1 << n) - 1];
		w = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(input[j]);
			}
		}
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], INF);
		}
		
		System.out.println(dfs(0, 1));
	}




}
