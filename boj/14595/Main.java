import java.io.*;
import java.util.*;

public class Main{
    static int N, M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); M = Integer.parseInt(br.readLine());
        if(M == 0){
            System.out.println(N);
            return;
        }

        int[][] d = new int[M][2];

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            d[i][0] = x;
            d[i][1] = y;
        }

        Arrays.sort(d, (a, b) -> {
            for (int j = 0; j < Math.min(a.length, b.length); j++) {
                int t = Integer.compare(a[j], b[j]);
                if (t != 0) return t;
            }
            return Integer.compare(a.length, b.length);
        });
        int x = d[0][0];
        int y = d[0][1];
        int answer = x - 1;
        for(int i = 1; i < M; i++){
            if(d[i][0] == x){
                y = Integer.max(d[i][1], y);
                continue;
            }
            x = d[i][0];
            if(x > y) {
                answer += (x - y - 1);
                y = d[i][1];
                answer++;
            }
            y = Integer.max(d[i][1], y);
        }
        answer++;
        answer += N - y;
        System.out.println(answer);
    }
}