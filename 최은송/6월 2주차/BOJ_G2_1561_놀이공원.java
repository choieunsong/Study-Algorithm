package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G2_1561_놀이공원 {
    static int M, rides[];
    static long N;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Long.parseLong(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rides = new int[M];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < M; i++)
            rides[i] = Integer.parseInt(st.nextToken());

        if(N <= M){
            System.out.println(N);
        }else{
            System.out.println(binarySearch());
        }
    }
    static int binarySearch(){
        long left = 0l; long right = 60000000000l;
        long mid = 0l;
        while(left <= right){
            mid = (left + right) / 2;
            long cnt = find(mid);

            if(cnt <= N && N < find(mid+1)){
                break;
            } else if(cnt > N){
                right = mid + 1;
            } else{
                left = mid - 1;
            }
        }
        long prev = find(mid);
        int ret = 0;
        for(int i = 0, idx = 0; i < M; i++){
            if((mid % rides[i]) == 0)  idx++;
            if(prev + idx == N){
                ret = i;
                break;
            }
        }
        return ret;
    }
    static long find(long time){
        long cnt = 0;
        for(int i = 0; i < M; i++){
            cnt += time / rides[i] + 1;
        }
        return cnt;
    }
}