import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = { 0, 0, -1, 1 }, dy = { -1, 1, 0, 0 };
    static int N, M, P;
    static int[][] a;
    static int[][][] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        int[][] a = new int[N][M];
        int[] s = new int[P];
        int[] answer = new int[P];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < P; i++) s[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == '.') continue;
                else if (input.charAt(j) == '#') a[i][j] = -1;
                else a[i][j] = input.charAt(j) - '0';
            }
        }

        Queue<int[]>[] q = new Queue[P];
        boolean[][] v = new boolean[N][M];
        for (int i = 0; i < P; i++)
            q[i] = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] >= 1) {
                    q[a[i][j] - 1].offer(new int[] { i, j });
                    v[i][j] = true;
                    answer[a[i][j] - 1]++;
                }
            }
        }
        boolean[] e = new boolean[P];
        int emptyCnt = 0;
        int turn = 0;
        while (emptyCnt != P) {
            int idx = turn % P;
            if (q[idx].isEmpty()) {
                if(!e[idx]){
                    e[idx] = true;
                    emptyCnt++;
                }
                turn++;
                continue;
            }

            for (int r = 0; r < s[idx]; r++) {
                Queue<int[]> tmp = new ArrayDeque<>();
                while (!q[idx].isEmpty()) {
                    int[] cur = q[idx].poll();
                    int x = cur[0], y = cur[1];
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i], ny = y + dy[i];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= M || v[nx][ny] || a[nx][ny] != 0) continue;
                        v[nx][ny] = true;
                        a[nx][ny] = a[x][y];
                        tmp.offer(new int[] { nx, ny });
                        answer[a[nx][ny] - 1]++;
                    }
                }
                if (tmp.size() == 0) {
                    e[idx] = true; emptyCnt++;
                    break;
                }
                q[idx].addAll(tmp);
            }
            turn++;
        }
        for (int i = 0; i < P; i++) System.out.print(answer[i] + " ");
    }
}