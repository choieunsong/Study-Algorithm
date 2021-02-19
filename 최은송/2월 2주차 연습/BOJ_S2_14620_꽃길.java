package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_14620_꽃길2 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,-1,1};
	static int min = Integer.MAX_VALUE;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0);
		System.out.println(min);
	}
	
	private static void dfs(int cnt, int cost) {
		if(cost >= min)
			return;
		if(cnt == 3) {
			min = Math.min(min, cost);
			return;
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!check(r,c))	continue;
					
				int sum = setVisit(r,c,true);
				dfs(cnt+1, cost+sum);
				setVisit(r,c,false);
			}
		}
	}
	
	private static int setVisit(int r, int c, boolean flag) {
		visited[r][c] = flag;
		int nr = 0, nc = 0;
		int sum= map[r][c];
		for(int i=0; i<4; i++) {
			nr = r+dr[i];
			nc = c+dc[i];
			sum += map[nr][nc];
			visited[nr][nc] = flag;
		}
		return sum;
	}
	
	private static boolean check(int r, int c) {
		if(visited[r][c])	return false;
		int nr,nc;
		for(int i=0; i<4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(nr<0 || nr >=N ||  nc<0 || nc>=N || visited[nr][nc])
				return false;
		}
		return true;
	}
}
