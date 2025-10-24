import java.io.*;
import java.util.*;

public class Main {
    static int answer, n, m;
    static StringBuilder sb = new StringBuilder();
    static void bt(int cnt, String s){
        if(cnt == m){
            sb.append(s + "\n");
            return;
        }
        for(int i = 1; i <= n; i++){
            bt(cnt + 1, s + i + " ");
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        bt(0, "");
        System.out.println(sb.toString());
    }
}
