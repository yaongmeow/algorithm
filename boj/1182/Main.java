import java.io.*;
import java.util.*;

public class Main {
    static int sum = 0, answer = 0, n, s;
    static int[] a;
    static void perm(int idx, int cnt){
        if(sum == s && cnt > 0) answer++;
        if(idx == n) return;
        sum += a[idx];
        perm(idx + 1, 1);
        sum -= a[idx];
        perm(idx + 1, 0);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()); a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        perm(0, 0);
        System.out.println(answer);
    }
}
