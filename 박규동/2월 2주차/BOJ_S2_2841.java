import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2841 {
	
	static int N,P;
	static StringTokenizer st;
	static Stack<Integer> stack[];
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		P=Integer.parseInt(st.nextToken());
		stack = new Stack[7];	//인덱스를 1~6까지 사용하기 위해 7짜리 스택배열 생성
		int line,fret;
		for(int i=1;i<=6;i++) {
			stack[i] = new Stack<Integer>();
			stack[i].push(0);
		} //스택 객체 생성
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			line = Integer.parseInt(st.nextToken());
			fret = Integer.parseInt(st.nextToken());
			
			while(true) {
				int cur = stack[line].peek();
				if(cur>fret) {
					stack[line].pop();
					answer++;
				}
				else if(cur<fret) {
					stack[line].push(fret);
					answer++;
					break;
				}
				else break;
			}	//while end	//라인과 프랫이 입력으로 들어오면 라인을 인덱스로 하는 스택에서 조건에 맞게 pop과 push후 answer증가
		}
		System.out.println(answer);
	}
}
