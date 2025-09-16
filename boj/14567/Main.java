import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        int[] d = new int[N + 1]; List<Integer>[] g = new List[N + 1]; for(int i = 1; i <= N; i++) g[i] = new ArrayList<>(); 
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b); d[b]++;
        }
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            if(d[i] == 0) q.offer(new int[]{i, 1});
        }

        int[] answer = new int[N + 1];
        while(!q.isEmpty()){
            int[] now = q.poll();
            answer[now[0]] = now[1];
            for(int b : g[now[0]]) {
                d[b]--;
                if(d[b] == 0) q.offer(new int[]{b, now[1] + 1});
            }
        }

        for(int i = 1; i <= N; i++){
            System.out.print(answer[i] + " ");
        }
    }
}