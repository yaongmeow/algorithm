import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int size = 100001; boolean[] v = new boolean[size]; v[N] = true;
        int answer = Integer.MAX_VALUE;
        Queue<int[]> q = new ArrayDeque<>(); q.offer(new int[]{N, 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int now = cur[0], t = cur[1];
            if(now == K){
                answer = Integer.min(answer, t);
                break;
            }
            for(int i = 0; i < 2; i++){
                int nx = dx[i] + now;
                if(nx < 0 || nx >= size || v[nx]) continue;
                q.offer(new int[]{nx, t + 1}); v[nx] = true;
            }
            int nx = now * 2;
            if(nx < 0 || nx >= size || v[nx]) continue;
            q.offer(new int[]{nx, t + 1}); v[nx] = true;
        }
        System.out.println(answer);   
    }
}
