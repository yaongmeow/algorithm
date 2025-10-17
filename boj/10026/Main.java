import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static void bfs1(int[] st, char[][] g, boolean[][] v, int N){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(st);
        while(!q.isEmpty()){
            int[] cur = q.poll();
            char color = g[cur[0]][cur[1]];
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i], ny = cur[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || v[nx][ny]) continue;
                if(g[nx][ny] != color) continue;
                v[nx][ny] = true; q.offer(new int[]{nx, ny});
            }
        }
    }

    static void bfs2(int[] st, char[][] g, boolean[][] v, int N){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(st);
        while(!q.isEmpty()){
            int[] cur = q.poll();
            char color = g[cur[0]][cur[1]];
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i], ny = cur[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || v[nx][ny]) continue;
                if(color == 'B' && g[nx][ny] != 'B') continue;
                if(color != 'B' && g[nx][ny] == 'B') continue;
                v[nx][ny] = true; q.offer(new int[]{nx, ny});
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] g = new char[N][N]; boolean[][] v = new boolean[N][N];
        for(int i = 0; i < N; i++) g[i] = br.readLine().toCharArray();
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(v[i][j]) continue;
                bfs1(new int[]{i, j}, g, v, N);
                cnt++;
            }
        }
        System.out.print(cnt + " ");
        cnt = 0; for(int i = 0; i < N; i++) Arrays.fill(v[i], false);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(v[i][j]) continue;
                bfs2(new int[]{i, j}, g, v, N);
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}

