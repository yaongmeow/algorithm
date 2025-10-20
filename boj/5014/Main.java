import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int v[] = new int[F + 1]; Arrays.fill(v, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(S); v[S] = 0; int answer = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int now = q.poll();
            int up = now + U, down = now - D;
            if(now == G) answer = Integer.min(answer, v[now]);
            if(1 <= up && up <= F && v[up] == -1){
                v[up] = v[now] + 1; q.offer(up);
            }
            if(1 <= down && down <= F && v[down] == -1){
                v[down] = v[now] + 1; q.offer(down);
            }
        }

        if(answer == Integer.MAX_VALUE) System.out.println("use the stairs");
        else System.out.println(answer);
    }
}
