import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, answer, min, max;
    static char[][] a;
    static boolean[][] v, vis;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    
    static void spread(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(v[i][j] || a[i][j] != '*') continue;
                v[i][j] = true;
                for(int k = 0; k < 4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M || v[nx][ny] || a[nx][ny] != '.') continue;
                    a[nx][ny] = '*';
                    v[nx][ny] = true;
                }
            }
        }
    }

    static void bfs(int[] start){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        vis[start[0]][start[1]] = true;
        int prevDepth = -1;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int depth = now[2];
            if(depth > prevDepth){
                v = new boolean[N][M];
                spread();
                prevDepth = depth;
            }
            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || vis[nx][ny] || a[nx][ny] == '*' || a[nx][ny] == 'X') continue;
                if(a[nx][ny] == 'D') answer = Integer.min(answer, depth + 1);
                else{
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny, depth + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            a = new char[N][M]; answer = Integer. MAX_VALUE;
            int[] suyeon = new int[2];
            for(int i = 0; i < N; i++){
                a[i] = br.readLine().toCharArray();
                for(int j = 0; j < M; j++){
                    if(a[i][j] == 'S'){
                        suyeon[0] = i;
                        suyeon[1] = j;
                        a[i][j] = '.';
                    }
                }
            }
            vis = new boolean[N][M];
            bfs(new int[]{suyeon[0], suyeon[1], 0});
            if(answer == Integer.MAX_VALUE) sb.append("#" + tc + " GAME OVER\n");
            else sb.append("#" + tc + " " + answer + "\n");
        }
        System.out.print(sb.toString());
    }
}
