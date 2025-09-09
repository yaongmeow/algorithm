import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static char[][] b;
    static boolean[][][] v;
    static int[] key = new int[6];
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        b = new char[N][M]; for(int i = 0; i < N; i++) b[i] = br.readLine().toCharArray();
        int[] pos = new int[2];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(b[i][j] == '0'){
                    pos[0] = i; pos[1] = j;
                    break;
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {pos[0], pos[1], 0, 0});
        v = new boolean[N][M][1<<6]; int answer = -1;
        v[pos[0]][pos[1]][0] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(b[now[0]][now[1]] == '1'){
                answer = now[3];
                break;
            }
            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || b[nx][ny] == '#') continue;
                int nMask = now[2];
                if ('a' <= b[nx][ny] && b[nx][ny] <= 'f') {
                    nMask |= (1 << (b[nx][ny] - 'a'));
                }

                if ('A' <= b[nx][ny] && b[nx][ny] <= 'F') {
                    if ((nMask & (1 << (b[nx][ny] - 'A'))) == 0) continue;
                }
                if(v[nx][ny][nMask]) continue;

                v[nx][ny][nMask] = true;
                q.offer(new int[]{nx, ny, nMask, now[3] + 1});
            }
        }
        System.out.println(answer);

    }
}