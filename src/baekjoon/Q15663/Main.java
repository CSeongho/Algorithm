package baekjoon.Q15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] arr;
	static int[] input;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	static void dfs(int at, int depth) {
		if(depth == M) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		int numBefore = 0;
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				if(numBefore != input[i] || i == 0) {
					visited[i] = true;
					numBefore = input[i];
					arr[depth] = input[i];
					dfs(input[i], depth+1);
					visited[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		arr = new int[M];
		
		dfs(0, 0);
		System.out.println(sb);
	}
}
