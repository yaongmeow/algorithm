import java.io.*;
import java.util.*;

public class Main {
    static int[] g = new int[1000001];
    static int find(int n){
        if(g[n] < 0) return n;
        g[n] = find(g[n]);
        return g[n];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Arrays.fill(g, -1);
        int cnt[] = new int[1000001]; Arrays.fill(cnt, 1);
        for(int i = 0; i < N; i++){
            StringTokenizer cmd = new StringTokenizer(br.readLine());
            char query = cmd.nextToken().charAt(0);
            if(query == 'I'){
                int a = Integer.parseInt(cmd.nextToken());
                int b = Integer.parseInt(cmd.nextToken());
                a = find(a);
                b = find(b);
                if(a == b) continue;
                if(g[a] < g[b]) {
                    g[b] = a;
                    cnt[a] += cnt[b];
                }
                else if(g[a] == g[b]){
                    g[a]--;
                    g[b] = a;
                    cnt[a] += cnt[b];
                } else {
                    g[a] = b;
                    cnt[b] += cnt[a];
                }
                continue;
            }
            int c = Integer.parseInt(cmd.nextToken());
            System.out.println(cnt[find(c)]);
        }
    }
}