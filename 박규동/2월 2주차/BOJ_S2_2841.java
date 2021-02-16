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
		stack = new Stack[7];
		int line,pret;
		for(int i=1;i<=6;i++) {
			stack[i] = new Stack<Integer>();
			stack[i].push(0);
		}
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			line = Integer.parseInt(st.nextToken());
			pret = Integer.parseInt(st.nextToken());
			
			while(true) {
				int cur = stack[line].peek();
				if(cur>pret) {
					stack[line].pop();
					answer++;
				}
				else if(cur<pret) {
					stack[line].push(pret);
					answer++;
					break;
				}
				else break;
			}	
		}
		System.out.println(answer);
	}
}
