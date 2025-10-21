import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int N, M, K;
    static int[][] a;
    static int[][][] v;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        a = new int[N][M]; v = new int[N][M][K + 1];
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < M; j++){
                a[i][j] = input.charAt(j) - '0';
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 1, 0});
        int answer = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2], breaks = cur[3];
            if(x == N - 1 && y == M - 1){
                answer = Integer.min(answer, dist);
                continue;
            }
            // 안부수고 이동
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i], ny = y + dy[i];
                if(nx < 0 ||  ny < 0 || nx >= N || ny >= M || a[nx][ny] == 1 || v[nx][ny][breaks] != 0) continue;
                v[nx][ny][breaks] = dist + 1; q.offer(new int[]{nx, ny, dist + 1, breaks});
            }
            if(breaks == K) continue;
            // 부수고 이동
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i], ny = y + dy[i];
                if(nx < 0 ||  ny < 0 || nx >= N || ny >= M || a[nx][ny] == 0 || v[nx][ny][breaks + 1] != 0) continue;
                v[nx][ny][breaks + 1] = dist + 1; q.offer(new int[]{nx, ny, dist + 1, breaks + 1});
            }
        }
        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }
}