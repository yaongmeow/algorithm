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
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        g = new int[N]; Arrays.fill(g, -1);
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1){
                    int a = find(i);
                    int b = find(j);
                    if(a == b) continue;
                    if(g[a] < g[b]){
                        g[b] = a;
                    } else if(g[a] == g[b]){
                        g[b]--;
                        g[a] = b;
                    } else g[a] = b;
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] plan = new int[M];
        for(int i = 0; i < M; i++) plan[i] = Integer.parseInt(st.nextToken()) - 1;
        for(int i = 1; i < M; i++){
            if (find(plan[i - 1]) != find(plan[i])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}