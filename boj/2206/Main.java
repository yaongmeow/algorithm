import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] a = new int[N][M]; boolean[][][] v = new boolean[N][M][2]; // 0: 그냥 지나감 1: 부수고 지나감 (부순 시점부터)
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < M; j++) a[i][j] = input.charAt(j) - '0';
        }

        Queue<int[]> q = new ArrayDeque<>(); int answer = Integer.MAX_VALUE;
        q.offer(new int[]{0, 0, 0, 0}); // x, y, 거리, 벽 부순 횟수
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2], wb = cur[3];
            if(x == N - 1 && y == M - 1){
                answer = Integer.min(answer, dist);
            }
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i], ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(wb == 1){ // 이미 벽을 부숨
                    if(v[nx][ny][1] || a[nx][ny] == 1) continue;
                    q.offer(new int[]{nx, ny, dist + 1, wb});
                    v[nx][ny][1] = true;
                    continue;
                }
                if(wb != 1 && a[nx][ny] == 1 && !v[nx][ny][1]){
                    q.offer(new int[]{nx, ny, dist + 1, 1});
                    v[nx][ny][1] = true;
                    continue;
                }
                if(v[nx][ny][0] || a[nx][ny] == 1) continue;
                q.offer(new int[]{nx, ny, dist + 1, wb});
                v[nx][ny][0] = true;
            }
        }
        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer + 1);
        
    }
}