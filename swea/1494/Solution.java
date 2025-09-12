import java.io.*;
import java.util.*;

public class Solution{
    static int N;
    static long answer;
    static int[][] j;

    static int xs, ys;
    static boolean[] s;

    static void calculate(){
        int x = 0, y = 0;
        for(int i = 0; i < N; i++){
            if(!s[i]) continue;
            x += j[i][0];
            y += j[i][1];
        }
        int xr = xs - x, yr = ys - y;
        long tmp = (long) (Math.pow(xr - x, 2) + Math.pow(yr - y, 2));
        answer = Long.min(answer, tmp);
    }

    static void comb(int cnt, int start){
        if(cnt == N / 2){
            calculate();
            return;
        }

        for(int i = start; i < N; i++){
            s[i] = true;
            comb(cnt + 1, i + 1);
            s[i] = false;
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            
            N = Integer.parseInt(br.readLine());
            answer = Long.MAX_VALUE; j = new int[N][2];

            xs = 0; ys = 0; s = new boolean[N];
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                j[i][0] = x;
                j[i][1] = y;
                xs += x; ys += y;
            }

            comb(0, 0);

            System.out.printf("#%d %d\n", tc, answer);
        }
    }
}