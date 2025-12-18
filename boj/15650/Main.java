import java.io.*;
import java.util.*;

public class Main {
    static int answer, n, m;
    static StringBuilder s = new StringBuilder();
    static void bt(int now, int cnt, String s){
        if(cnt == m) {
            System.out.println(s);
            return;
        }
        if(now > n) return;
        bt(now + 1, cnt + 1, s + now + " ");
        bt(now + 1, cnt, s);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        bt(1, 0, "");
    }
}