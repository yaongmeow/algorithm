import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[][] v = new int[100001][2]; for(int i = 0; i < 100001; i++) Arrays.fill(v[i], -1);
        v[N][0] = 0; int answer = Integer.MAX_VALUE; int idx = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{N, 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], mv = cur[1];
            if(x == K){
                if(mv < answer){
                    answer = mv; idx = x;
                    continue;
                }
            }
            int nx = x * 2;
            if(nx <= 100000 && nx >= 0 && v[nx][0] == -1){
                v[nx][0] = mv + 1; v[nx][1] = x; q.offer(new int[]{nx, mv + 1});
            }
            for(int i = 0; i < 2; i++){
                nx = x + dx[i];
                if(nx > 100000 || nx < 0 || v[nx][0] != -1) continue;
                v[nx][0] = mv + 1; v[nx][1] = x; q.offer(new int[]{nx, mv + 1});
            }
        }

        StringBuilder sb = new StringBuilder("");
        while(idx != -1){
            sb.insert( 0, idx + " ");
            idx = v[idx][1];
        }
        System.out.println(answer);
        System.out.println(sb.toString());
    }
}