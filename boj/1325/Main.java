import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer, cnt;
    static List<Integer>[] g;
    static boolean[] v;

    static void dfs(int com) {
        v[com] = true; cnt++;
        //System.out.println("cnt - " + cnt);
        List<Integer> chain = g[com];
        for (Integer t : chain) {
            if (v[t]) continue;
            //System.out.println(com + " chain " + t);
            dfs(t);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        g = new List[N + 1];

        for (int i = 0; i <= N; i++)
            g[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(line.nextToken());
            int b = Integer.parseInt(line.nextToken());
            g[b].add(a);
        }
        answer = 0;
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for (int com = 1; com <= N; com++) {
            v = new boolean[N + 1];
            v[com] = true; cnt = 1;
            List<Integer> chain = g[com];
            for (Integer t : chain) {
                if (v[t]) continue;
                dfs(t);
            }
            //System.out.println("cnt: " + cnt);
            if(!hm.containsKey(cnt)) hm.put(cnt, new ArrayList<>());
            hm.get(cnt).add(com);
            if(cnt > answer) answer = cnt;
        }
        for(Integer com: hm.get(answer)) sb.append(com).append(" ");
        System.out.println(sb.toString());
        //System.out.println(answer);
    }
}
