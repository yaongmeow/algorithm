import java.io.*;
import java.util.*;

class Main{
    static int V, E;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        int T = 10;
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            int[] indegree = new int [V + 1];
            List<Integer>[] g = new List[V + 1]; for(int i = 1; i <= V; i++) g[i] = new ArrayList<>();
            for(int i = 0; i < E; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                indegree[to] += 1;
                g[from].add(to);
            }

            Queue<Integer> q = new ArrayDeque<>();
            boolean[] v = new boolean[V + 1];
            for(int i = 1; i <= V; i++){
                if(indegree[i] == 0){
                    q.offer(i);
                    v[i] = true;
                }
            }

            int[] answer = new int [V];
            int idx = 0;

            while(!q.isEmpty()){
                int now = q.poll();
                answer[idx++] = now;
                for(Integer p: g[now]){
                    if(v[p]) continue;
                    indegree[p]--;
                    if(indegree[p] == 0){
                        v[p] = true;
                        q.offer(p);
                    }
                }
            }

            sb.append("#" + tc + " ");
            for(int n : answer) sb.append(n + " ");
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}