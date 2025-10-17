import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 0, 0, 1, -1}, dy = {0, 0, 1, -1, 0, 0}, dz = {1, -1, 0, 0, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), H = Integer.parseInt(st.nextToken());
        int[][][] b = new int[H][N][M]; boolean[][][] v = new boolean[H][N][M];
        Queue<int[]> q = new ArrayDeque<>();
        int cnt = 0;
        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++) {
                    b[i][j][k] = Integer.parseInt(st.nextToken());
                    if(b[i][j][k] == 1){
                        q.offer(new int[]{i, j, k, 0});
                    } else if(b[i][j][k] == 0) cnt ++;
                }
            }
        }

        if(cnt == 0){
            System.out.println(0);
            return;
        }

        int answer = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int z = cur[0], x = cur[1], y = cur[2], day = cur[3];
            for(int i = 0; i < 6; i++){
                int nz = z + dz[i], nx = x + dx[i], ny = y + dy[i];
                if(nz < 0 || nx < 0 || ny < 0 || nz >= H || nx >= N || ny >= M || b[nz][nx][ny] == -1 || b[nz][nx][ny] == 1) continue;
                q.offer(new int[]{nz, nx, ny, day + 1}); b[nz][nx][ny] = 1; cnt--; answer = Integer.max(day + 1, answer);
            }
        }

        if(cnt > 0){
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }
}

