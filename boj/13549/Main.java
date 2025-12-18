import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        boolean[] v = new boolean[100001];
        v[N] = true; int answer = Integer.MAX_VALUE;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{N, 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], mv = cur[1];
            if(x == K){
                answer = Integer.min(answer, mv);
                continue;
            }
            int nx = x * 2;
            if(nx <= 100000 && nx >= 0 && !v[nx]){
                v[nx] = true; q.offer(new int[]{nx, mv});
            }
            for(int i = 0; i < 2; i++){
                nx = x + dx[i];
                if(nx > 100000 || nx < 0 || v[nx]) continue;
                v[nx] = true; q.offer(new int[]{nx, mv + 1});
            }
        }
        System.out.println(answer);
    }
}