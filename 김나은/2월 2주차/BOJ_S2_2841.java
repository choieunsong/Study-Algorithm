// 외계인의 기타 연주

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_S2_2841 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		Stack<Integer>[] stack = new Stack[7]; // 1번 줄부터 6번 줄(0은 dummy)
		for (int i = 1; i <=6 ; i++) {
			stack[i] = new Stack<>();
		}
		
		int finger = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken()); // 줄의 번호
			int fret = Integer.parseInt(st.nextToken()); // 그 줄에서 눌러야 하는 프렛의 번호
			
			// 프렛 누르기
			if(stack[line].isEmpty() || stack[line].peek() < fret) {
				stack[line].push(fret);
				finger++;
				continue;
			}
			
			// 프렛 떼기
			while(!stack[line].isEmpty() && stack[line].peek() > fret) {
				stack[line].pop();
				finger++;
			}
			
			// 프렛을 떼고 난 후 눌러야하는 프렛의 번호가 같은 경우 손가락을 움직이지 않음
			if(!stack[line].isEmpty() && stack[line].peek() == fret) continue;
			
			stack[line].push(fret);
			finger++;
			
		}
		System.out.println(finger);
	}
}
