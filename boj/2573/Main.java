import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
    static int[][] a;
    static int N, M;

    static int melt() {
        int[][] newA = new int[N][M];
        int zeros = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] == 0) continue;
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k], ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || a[nx][ny] > 0) continue;
                    cnt++;
                }
                newA[i][j] = a[i][j] - cnt;
                if (newA[i][j] <= 0) {
                    zeros++;
                    newA[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < N; i++) a[i] = newA[i];
        return zeros;
    }

    static int check() {
        boolean[][] v = new boolean[N][M];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (v[i][j] || a[i][j] == 0) continue;
                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[] { i, j });
                v[i][j] = true;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur[0] + dx[k], ny = cur[1] + dy[k];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= M || a[nx][ny] == 0 || v[nx][ny]) continue;
                        q.offer(new int[] { nx, ny });
                        v[nx][ny] = true;
                    }
                }
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(st.nextToken());
        }

        int years = 1;
        int zero = melt();
        int piece = check();

        while (piece == 1) {
            years++;
            zero = melt();
            if (zero > 0) piece = check();
        }
        if (piece < 2) System.out.println(0);
        else System.out.println(years);
    }
}
