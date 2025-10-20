import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 0, 1, -1, 0, 0}, dy = {1, -1, 0, 0, 0, 0}, dz = {0, 0, 0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(true){
            int L = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
            if(L == 0 && R == 0 && C == 0) break;
            int answer = Integer.MAX_VALUE;

            char[][][] a = new char[L][R][C];
            int[][][] v = new int[L][R][C];
            for(int i = 0; i < L; i++) {
                for(int j = 0; j < R; j++) Arrays.fill(v[i][j], -1);
            }
            Queue<int[]> q = new ArrayDeque<>();

            for(int layer = 0; layer < L; layer++){
                for(int i = 0; i < R; i++){
                    a[layer][i] = br.readLine().toCharArray();
                    for(int j = 0; j < C; j++){
                        if(a[layer][i][j] == 'S'){
                            q.offer(new int[]{layer, i, j});
                            v[layer][i][j] = 0;
                        }
                    }
                }
                br.readLine();
            }
            while(!q.isEmpty()){
                int[] cur = q.poll();
                int z = cur[0], x = cur[1], y = cur[2];
                if(a[z][x][y] == 'E'){
                    answer = Integer.min(answer, v[z][x][y]);
                }
                for(int i = 0; i < 6; i++){
                    int nx = x + dx[i], ny = y + dy[i], nz = z + dz[i];
                    if(nz < 0 || nx < 0 || ny < 0 || nz >= L || nx >= R || ny >= C || v[nz][nx][ny] != -1 || a[nz][nx][ny] == '#') continue;
                    v[nz][nx][ny] = v[z][x][y] + 1; q.offer(new int[]{nz, nx, ny});
                }
            }

            if(answer == Integer.MAX_VALUE) System.out.println("Trapped!");
            else System.out.printf("Escaped in %d minute(s).\n", answer);
            st = new StringTokenizer(br.readLine());
        }
    }
}
