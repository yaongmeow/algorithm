import java.io.*;
import java.util.*;


public class Solution {

    static int answer, total, N;
    static int[][] a;
    static int[] g1, g2;

    static void combi(int cnt, int start) {
        if(cnt == N / 2){
            int sum1 = 0; int sum2 = 0;
            HashSet<Integer> hs = new HashSet<>();
            for(int num: g1) hs.add(num);
            int idx = 0;
            for(int i = 0; i < N; i++){
                if(hs.contains(i)) continue;
                else g2[idx++] = i;
            }
            for(int i = 0; i < N / 2; i++){
                for(int j = i + 1; j < N / 2; j++){
                    sum1 += a[g1[i]][g1[j]];
                    sum1 += a[g1[j]][g1[i]];
                    sum2 += a[g2[i]][g2[j]];
                    sum2 += a[g2[j]][g2[i]];
                }
            }
            if(Math.abs(sum1 - sum2) < answer) answer = (int) Math.abs(sum1 - sum2);
            return;
        }
        for(int i = start; i < N; i++){
            g1[cnt] = i;
            combi(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            a = new int[N][N]; g1 = new int[N / 2]; g2 = new int[N / 2]; answer = 0; total = 0;
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                    total += a[i][j];
                }
            }
            answer = Integer.MAX_VALUE;
            combi(0, 0);
            System.out.printf("#%d %d\n", tc, answer);
        }
    }

}
