import java.util.*;
import java.io.*;

public class Main {
    static int[] uf;

    static int find(int n){
        if(uf[n] < 0) return n;
        uf[n] = find(uf[n]);
        return uf[n];
    }

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ve = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(ve.nextToken());
        int E = Integer.parseInt(ve.nextToken());
        int[][] g = new int[E][3];
        for(int i = 0; i < E; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[i][0] = c;
            g[i][1] = a;
            g[i][2] = b;
        }
        Arrays.sort(g, (o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });

        uf = new int[V + 1];
        Arrays.fill(uf, -1);

        int mst = 0;
        for(int i = 0; i < E; i++){
            int a = g[i][1]; int b = g[i][2];
            int w = g[i][0];
            a = find(a); b = find(b);
            if(a == b) continue;
            if(uf[a] == uf[b]){
                uf[a]--;
                uf[b] = a;
            }
            else if(uf[a] < uf[b]) uf[b] = a;
            else uf[a] = b;
            mst += w;
        }
        System.out.println(mst);
    }
}