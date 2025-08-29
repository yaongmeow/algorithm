import java.io.*;
import java.util.*;

class Main{
    static int[] g;

    static int find(int n){
        while(g[n] >= 0){
            n = g[n];
        }
        return n;
    }

    public static void main(String[]  args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        g = new int[n + 1];
        Arrays.fill(g, -1);
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            a = find(a);
            b = find(b);

            switch(cmd){
                case 0:
                    if(a == b) break;
                    if(g[a] < g[b]){
                        g[b] = a;
                    } else if(g[a] == g[b]){
                        g[a]--;
                        g[b] = a;
                    } else g[a] = b;
                    break;
                case 1:
                    if(a == b) System.out.println("yes");
                    else System.out.println("no");
                    break;
            }
        }
    }
}