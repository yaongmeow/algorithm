import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] a;
    static int answer = 0;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
        a = new int[N][M];
        int cnt = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if(a[i][j] != 0) cnt++;
            }
        }

        if(cnt == N * M){
            System.out.println(0);
            return;
        }

        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(a[i][j] == 1) q.offer(new int[]{i, j});
            }
        }

        int possible = N * M - cnt, answer = 0; cnt = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || a[nx][ny] >= 1 || a[nx][ny] == -1) continue;
                a[nx][ny] = a[x][y] + 1; cnt++;
                if(a[nx][ny] > answer) answer = a[nx][ny];
                q.offer(new int[]{nx, ny});
            }
        }

        //for(int i = 0; i < N; i++) System.out.println(Arrays.toString(a[i]));

        if(cnt != possible){
            System.out.println(-1);
            return;
        }
        
        System.out.println(answer - 1);
    }
}
