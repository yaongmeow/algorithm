import java.io.*;
import java.util.*;

public class Main {
    static int answer, n, k, m;
    static int[] g;

    static int find(int n){
        if(g[n] < 0) return n;
        g[n] = find(g[n]);
        return g[n];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            answer = 0;
            n = Integer.parseInt(br.readLine());
            k = Integer.parseInt(br.readLine());
            g = new int[n]; Arrays.fill(g, -1);
            for(int i = 0; i < k; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                a = find(a);
                b = find(b);
                if(a == b) continue;
                if(g[a] < g[b]){
                    g[b] = a;
                } else if(g[a] == g[b]){
                    g[a] = b;
                    g[b]--;
                } else {
                    g[a] = b;
                }
            }
            m = Integer.parseInt(br.readLine());
            System.out.printf("Scenario %d:\n", tc);
            for(int i = 0; i < m; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                a = find(a);
                b = find(b);
                if(a == b) System.out.println(1);
                else System.out.println(0);
            }
            System.out.println();
        }
    }
}
