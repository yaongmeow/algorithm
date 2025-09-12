import java.io.*;
import java.util.*;

public class Main{
    static int N, Q;
    static int[] g;

    static int find(int n){
        if(g[n] < 0) return n;
        g[n] = find(g[n]);
        return g[n];
    }

    static void union(int a, int b){
        if(g[a] < g[b]){
            g[b] = a;
        } else if(g[a] == g[b]){
            g[a]--;
            g[b] = a;
        } else g[a] = b;
        return;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder("");
        N = Integer.parseInt(st.nextToken()); Q = Integer.parseInt(st.nextToken());
        int[][] d = new int [N][4]; g = new int[N + 1]; Arrays.fill(g, -1);

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            d[i][0] = x1;
            d[i][1] = x2;
            d[i][2] = y;
            d[i][3] = i + 1;
        }

        Arrays.sort(d, (a, b) -> Integer.compare(a[0], b[0]));
        int x1 = d[0][0]; int x2 = d[0][1]; int group = d[0][3];
        for(int i = 1; i < N; i++){
            if(d[i][0] <= x2) {
                int a = find(d[i][3]); int b = find(group); union(a, b);
                x2 = Integer.max(x2, d[i][1]);
                continue;
            }
            x1 = d[i][0]; x2 = d[i][1]; group = d[i][3];
        }

        //System.out.println(Arrays.toString(g));

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            a = find(a);
            b = find(b);
            if(a == b) answer.append("1\n");
            else answer.append("0\n");
        }
        System.out.print(answer.toString());
    }
}