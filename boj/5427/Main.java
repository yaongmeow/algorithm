import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("");
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
            char[][] b = new char[h][w]; boolean[][] v = new boolean[h][w];
            Queue<int[]> q = new ArrayDeque<>(); Queue<int[]> f = new ArrayDeque<>();
            int[][] fire = new int[h][w]; for(int i = 0; i < h; i++) Arrays.fill(fire[i], -1);
            for(int i = 0; i < h; i++) {
                b[i] = br.readLine().toCharArray();
                for(int j = 0; j < w; j++){
                    if(b[i][j] == '@'){
                        q.offer(new int[]{i, j, 0});
                        v[i][j] = true;
                    }
                    else if(b[i][j] == '*'){
                        f.offer(new int[]{i, j, 0});
                        fire[i][j] = 0;
                    }
                }
            }
            while(!f.isEmpty()){
                int[] cur = f.poll();
                int x = cur[0], y = cur[1], t = cur[2];
                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i], ny = y + dy[i];
                    if(nx < 0 || ny < 0 || nx >= h || ny >= w || b[nx][ny] == '#' || fire[nx][ny] > -1) continue;
                    f.offer(new int[]{nx, ny, t + 1}); fire[nx][ny] = t + 1;
                }
            }

            int answer = Integer.MAX_VALUE;
            
            while(!q.isEmpty()){
                int[] cur = q.poll();
                int x = cur[0], y = cur[1], t = cur[2];
                if(x == 0 || y == 0 || x == h - 1 || y == w - 1){
                    answer = Integer.min(answer, t + 1);
                    continue;
                }
                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i], ny = y + dy[i];
                    if(nx < 0 || ny < 0 || nx >= h || ny >= w || b[nx][ny] == '#' || v[nx][ny] || (fire[nx][ny] != -1 && fire[nx][ny] <= t + 1)) continue;
                    q.offer(new int[]{nx, ny, t + 1}); v[nx][ny] = true;
                }
            }

            if(answer == Integer.MAX_VALUE){
                sb.append("IMPOSSIBLE\n");
                continue;
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb.toString());
    }
}