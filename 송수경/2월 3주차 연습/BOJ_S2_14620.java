package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S2_14620 {
	static int N;	//정사각형 한 변의 길이
	static int[] points;
	static int min;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		
		map = new int[N][N];
//		화단의 지점당 가격 이차원배열로 받기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min+=map[i][j];
			}
		}
		
		points = new int[3];
		comb(0, N+1, N*N-N-1);	//N^2 C 3 (숫자 3개 뽑아 좌표로 변환)
		
		System.out.println(min);
	}

	
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, -1, 1};
	private static void comb(int idx, int start, int end) {
		if(idx == 3) {
			int location[][] = new int[3][2];
			// 숫자를 좌표로 바꾸기
			for(int i=0; i<3; i++) {
				location[i][0] = points[i]/N;
				location[i][1] = points[i]%N;
			}
			
			
			// 겹치는지 검사
			if(Math.abs(location[0][0]-location[1][0])+Math.abs(location[0][1]-location[1][1])<3 ||
					Math.abs(location[1][0]-location[2][0])+Math.abs(location[1][1]-location[2][1])<3 ||
					Math.abs(location[2][0]-location[0][0])+Math.abs(location[2][1]-location[0][1])<3) return;
			
			// 비용 구하기
			int cost = 0;
			int nr, nc;
			for(int i=0; i<3; i++) {
				for(int j=0; j<5; j++) {
					nr = location[i][0] + dr[j];
					nc = location[i][1] + dc[j];
					cost += map[nr][nc];
				}
			}
			min = Math.min(min, cost);
			
			return;
		}
		
		// 조합
		for (int i = start; i < end; i++) {
			points[idx] = i;
			if(points[idx]%N==0 || points[idx]%N==N-1) continue;
			comb(idx+1, i+1, end);
		}
	}
}
