import java.io.*;
import java.util.*;

public class Main{
    static boolean[] done;
    static int[] dist, s;
    static int answer;

    static void dfs(int num){
        int nxt = s[num];
        if(dist[nxt] == -1) {
            dist[nxt] = dist[num] + 1;
            dfs(nxt);
        }
        else if(!done[nxt]){
            answer -= (dist[num] - dist[nxt] + 1);
        }
        done[num] = true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("");
        for(int tc = 0; tc < T; tc++){
            int n = Integer.parseInt(br.readLine());
            s = new int[n + 1]; answer = n;
            dist = new int[n + 1]; done = new boolean[n + 1]; Arrays.fill(dist, -1);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++){
                s[i] = Integer.parseInt(st.nextToken());
                if(i == s[i]){
                    dist[i] = 0; done[i] = true;
                    answer--;
                }
            }

            for(int i = 1; i <= n; i++){
                if(dist[i] != -1) continue;
                dist[i] = 1; dfs(i);
            }

            sb.append(answer + "\n");
        }
        System.out.println(sb.toString());
    }
}
