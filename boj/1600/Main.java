import java.io.*;
import java.util.*;

public class Main {
    static int W, H, K;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static int[] hx = {2, 2, -2, -2, 1, 1, -1, -1}, hy = {1, -1, 1, -1, 2, -2, 2, -2};
    static int[][] a;
    static boolean [][][] v;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken()); H = Integer.parseInt(st.nextToken());
        a = new int[H][W]; v = new boolean[H][W][K + 1];
        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) a[i][j] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0, 0}); // x, y, mv, horse
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[2] > answer) continue;
            if(now[0] == H - 1 && now[1] == W - 1){
                if(answer > now[2]) answer = now[2];
                continue;
            }
            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= H || ny >= W || v[nx][ny][now[3]] || a[nx][ny] == 1) continue;
                v[nx][ny][now[3]] = true;
                q.offer(new int[]{nx, ny, now[2] + 1, now[3]});
            }

            if(now[3] >= K) continue;

            for(int i = 0; i < 8; i++){
                int nx = now[0] + hx[i];
                int ny = now[1] + hy[i];
                if(nx < 0 || ny < 0 || nx >= H || ny >= W || v[nx][ny][now[3] + 1] || a[nx][ny] == 1) continue;
                v[nx][ny][now[3] + 1] = true;
                q.offer(new int[]{nx, ny, now[2] + 1, now[3] + 1});
            }
        }
        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }
}