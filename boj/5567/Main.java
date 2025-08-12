import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] g;
    static boolean[] vis;
    static int answer;

    static void bfs(int sId, int depth) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { sId, depth });
        vis[sId] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int id = now[0];
            int d = now[1];

            for (Integer f : g[id]) {
                if (!vis[f] && d + 1 < 3) {
                    answer++;
                    vis[f] = true;
                    q.add(new int[] { f, d + 1 });
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // System.setErr(new PrintStream("res.txt"));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        g = new List[N + 1];
        vis = new boolean[N + 1];
        for (int i = 1; i <= N; i++)
            g[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }
        answer = 0;
        bfs(1, 0);
        System.out.println(answer);
    }
}
