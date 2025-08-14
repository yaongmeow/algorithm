import java.io.*;
import java.util.*;


public class Solution {

    static long answer, N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Long.parseLong(br.readLine());
            answer = 0;
            while(N != 2){
                long r = (long) Math.sqrt(N);
                if(r*r == N){
                    N = r;
                    answer++;
                }
                else{
                    answer += (r+1)*(r+1) - N + 1;
                    N = r+1;
                }
            }
            System.out.printf("#%d %d\n", tc, answer);
        }
    }

}
