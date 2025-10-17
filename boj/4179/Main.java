import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static char[][] a;
    static int[][] fire;
    static boolean[][] v;
    static int answer = 0;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        a = new char[N][M]; v = new boolean[N][M]; fire = new int[N][M];
        for(int i = 0; i < N; i++) a[i] = br.readLine().toCharArray();
        Queue<int[]> jh = new ArrayDeque<>();
        Queue<int[]> f = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(a[i][j] == 'J'){
                    jh.offer(new int[]{i, j, 1});
                    v[i][j] = true;
                }else if(a[i][j] == 'F'){
                    f.offer(new int[]{i, j, 1});
                    fire[i][j] = 1;
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        while(!f.isEmpty()){
            int[] cur = f.poll();
            int x = cur[0], y = cur[1], t = cur[2];
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i], ny = y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || fire[nx][ny] != 0 || a[nx][ny] == '#') continue;
                fire[nx][ny] = t + 1; f.offer(new int[]{nx, ny, t + 1});
            }
        }

        while(!jh.isEmpty()){
            int[] cur = jh.poll();
            int x = cur[0], y = cur[1], t = cur[2];
            if(x == 0 || y == 0 || x == N - 1 || y == M - 1){
                answer = Integer.min(answer, t);
            }
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i], ny = y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || v[nx][ny] || a[nx][ny] == '#' || (fire[nx][ny] != 0 && fire[nx][ny] <= t + 1)) continue;
                v[nx][ny] = true; jh.offer(new int[]{nx, ny, t + 1});
            }
        }
        if(answer == Integer.MAX_VALUE) System.out.println("IMPOSSIBLE");
        else System.out.println(answer);
    }
}
