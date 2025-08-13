import java.io.*;
import java.util.*;

public class Solution {

    static long answer;
    static int N, facto;
    static int[] w, p;
    static boolean[] v;

    static void bt(int idx, int r, int l){
        if(r > l) return;
        if(idx == N){
            answer ++;
            return;
        }
        bt(idx+1, r + p[idx], l);
        bt(idx+1, r, l + p[idx]);
    }

    static void perm(int idx){
        if(idx == N){
            bt(0, 0, 0);
            return;
        }
        for(int i = 0; i < N; i++){
            if(v[i]) continue;
            v[i] = true;
            p[idx] = w[i];
            perm(idx + 1);
            v[i] = false;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            answer = 0;
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = new int[N]; p = new int[N]; v = new boolean[N];
            for(int i = 0; i < N; i++) w[i] = Integer.parseInt(st.nextToken());
            perm(0);
            System.out.printf("#%d %d\n", tc, answer);
        }
    }

}
