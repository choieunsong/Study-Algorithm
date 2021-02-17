import java.util.Scanner;

public class Main_2447 {

	static StringBuilder sb;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		sb=new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				draw(i,j,N);
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
		
	}
	
	private static void draw(int i, int j, int N) {
		
		if(i % 3 == 1 && j % 3 == 1) {
			sb.append(' ');
			return;
		} //공백인 경우 좌표의 규칙 -> i,j를 3으로 나누었을 때 나머지 1
		
		else if(N==1){
			sb.append('*');
			return;
		} //최소까지 N이 쪼개졌는데 공백에 해당하는 좌표가 아니라면 별찍기
		
		else draw(i/3,j/3,N/3); // 입력 좌표를 1까지 쪼개기 위해 3으로 나눠서 재귀 돌리기
		
	}

}
