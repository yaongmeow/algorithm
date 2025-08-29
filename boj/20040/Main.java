import java.io.*;
import java.util.*;

public class Main {
    static int[] g;
    static int find(int n){
        if(g[n] < 0) return n;
        g[n] = find(g[n]);
        return g[n];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nm.nextToken());
        int m = Integer.parseInt(nm.nextToken());
        g = new int[n]; Arrays.fill(g, -1);
        boolean end = false; int answer = 0;
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(end) continue;
            a = find(a);
            b = find(b);
            if(a == b) {
                end = true;
                answer = i + 1;
                continue;
            }

            if(g[a] < g[b]){
                g[b] = a;
            } else if(g[a] == g[b]){
                g[a] --;
                g[b] = a;
            } else {
                g[a] = b;
            }
        }
        System.out.println(answer);
    }
}