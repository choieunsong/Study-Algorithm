// 별 찍기 - 10

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_S1_2447 {

	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], ' ');
		}

		recursive(N, 0, 0);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			System.out.println(sb);
			sb.setLength(0);
		}
	}

	private static void recursive(int N, int row, int col) {
		if (N == 1) {
			map[row][col] = '*';
			return;
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) continue;
				recursive(N/3, row + i*N/3, col + j*N/3);
			}
		}
	}

}
