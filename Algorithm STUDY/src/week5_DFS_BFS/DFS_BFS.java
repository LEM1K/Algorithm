package week5_DFS_BFS;

import java.io.*;
import java.util.*;

/*백준 1260 - DFS와 BFS
 *version 1
 */

public class DFS_BFS {
	private static int[][] graph;
	private static boolean[] checked;
	
	
	//인접 행렬 DFS
	public static void DFS1(int start) {
		checked[start] = true;
		System.out.print(start + " ");
		
		for(int i = 1; i < graph.length; i++) {
			if(graph[i][start] == 1 && checked[i] == false) {
				DFS1(i);
			}
		}
	}
	
	
	//인접 행렬 BFS
	public static void BFS1(int start) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(start);
		checked[start] = true;
		System.out.print(start + " ");
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			
			for(int i = 1; i < graph.length; i++) {
				if(graph[tmp][i] == 1 && checked[i] == false) {
					queue.offer(i);
					checked[i] = true;
					System.out.print(i + " ");	
				}
			}
		}
	}
	
	
	//인접 리스트 DFS
	public static void DFS2(int start) {
		
	}
	
	
	//인접 리스트 BFS
	public static void BFS2(int start) {
		
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int nodes = input.nextInt();
		int edges = input.nextInt();
		int start = input.nextInt();
		
		graph = new int[nodes + 1][nodes + 1];
		checked = new boolean[nodes + 1];
		
		for(int i = 0; i < edges; i++) {
			int node1 = input.nextInt();
			int node2 = input.nextInt();
			
			graph[node1][node2] = 1;
			graph[node2][node1] = 1;
		}
		DFS1(start);
		System.out.println();
		Arrays.fill(checked, false);
		BFS1(start);
	}

}
