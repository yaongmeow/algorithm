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
            st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int b = Integer.parseInt(st.nextToken());
                g[a].add(b);
                d[b]++;
                a = b;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        Queue<Integer> order = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            if(d[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();
            order.offer(now);
            for(int b : g[now]) {
                d[b]--;
                if(d[b] == 0) q.offer(b);
            }
        }
        if (order.size() != N){
            System.out.println(0);
            return;
        }

        while (!order.isEmpty()) {
            System.out.println(order.poll());
        }
    }
}