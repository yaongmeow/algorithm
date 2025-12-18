import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[][] g;
    static boolean[] v;
    static int sum = 0;
    static int answer = Integer.MAX_VALUE;

    static void bt(int idx, int cnt) {
        if (cnt == N) {
            answer = Integer.min(sum, answer);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (v[i])
                continue;
            sum += g[idx][i];
            v[i] = true;
            bt(i, cnt + 1);
            sum -= g[idx][i];
            v[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        g = new int[N][N];
        v = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                g[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int v = 0; v < N; v++) {
            for (int f = 0; f < N; f++) {
                for (int t = 0; t < N; t++) {
                    int newDist = g[f][v] + g[v][t];
                    if (newDist < g[f][t])
                        g[f][t] = newDist;
                }
            }
        }
        v[K] = true;
        bt(K, 1);
        System.out.println(answer);
    }
}
