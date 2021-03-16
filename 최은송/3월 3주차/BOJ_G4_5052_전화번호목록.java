package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BOJ_G4_5052_전화번호목록 {


	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(in.readLine());
			String[] nums = new String[N];
			
			for(int i=0; i<N; i++) {
				String temp = in.readLine();
				nums[i] = temp;
			}
			
			Arrays.sort(nums);

			boolean contain = false;
			for(int i=0; i<N-1; i++) {
				String num1 = nums[i];
				String num2 = nums[i+1];
				if(num1.length() < num2.length()) {
					if(num1.equals(num2.substring(0, num1.length()))) {
						contain = true;
						break;
					}
				}
			}
			String ans = contain ? "NO" : "YES";
			System.out.println(ans);
	      }

	}
}

/*
		틀린코드 
	
		String[] list = new String[N];
			
			for(int i=0; i<N; i++)
				list[i] = in.readLine();
			
			Arrays.sort(list, (o1, o2) -> o1.length() - o2.length());
			
			boolean contain = false;
			loop: for(int i=0; i<N-1; i++) {
				String num1 = list[i];
				
				for(int j=i+1; j < N; j++) {
					String num2 = list[j];
					if(num1.length() < num2.length()) {
						if(num1.equals(num2.substring(0, num1.length()))) {
							contain = true;
							break loop;
						}
					}
				}
			}
			if(contain)
				System.out.println("NO");
			else
				System.out.println("YES");


*/