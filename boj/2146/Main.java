import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
    static int[][] a;
    static int N, answer = Integer.MAX_VALUE;
    static int[][] v;
    static List<int[]> outline = new ArrayList<>();

    static void bfs(int[] st, int val){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(st); v[st[0]][st[1]] = val;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1]; boolean ol = false;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i], ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || v[nx][ny] != 0) continue;
                if(a[nx][ny] == 0){
                    ol = true;
                    continue;
                }
                v[nx][ny] = val; q.offer(new int[]{nx, ny});
            }
            if(ol) outline.add(new int[]{x, y, val});
        }
    }

    static void bridge(int[] st, int val){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(st); int[][] d = new int[N][N];
        for(int i = 0; i < N; i++) Arrays.fill(d[i], -1); d[st[0]][st[1]] = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = d[x][y];
            if(dist > answer) continue;
            if(a[x][y]!= 0 && v[x][y] != val){
                answer = Integer.min(answer, dist - 1);
                continue;
            }
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i], ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || d[nx][ny] != -1 || a[nx][ny] == val) continue;
                d[nx][ny] = dist + 1; q.offer(new int[]{nx, ny});
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new int[N][N]; v = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) a[i][j] = Integer.parseInt(st.nextToken());
        }

        int val = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(v[i][j] != 0 || a[i][j] == 0) continue;
                bfs(new int[]{i, j}, val++);
                
            }
        }
        
        for(int[] st: outline){
            bridge(new int[]{st[0], st[1]}, st[2]);
        }
        System.out.println(answer);
    }
}
