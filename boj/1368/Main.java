import java.util.*;
import java.io.*;

public class Main {
    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] W = new int[N]; int[][] matrix = new int[N + 1][N + 1];
        for(int i = 0; i < N; i++) W[i] = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) matrix[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N; i++){
            matrix[N][i] = W[i];
            matrix[i][N] = W[i];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });
        boolean[] check = new boolean[N + 1];

        int mst = 0; int now = N;
        check[now] = true;
        for(int i = 0; i < N + 1; i++){
            if(i == now) continue;
            pq.offer(new int[]{i, matrix[now][i]});
        }
        
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            if(check[p[0]]) continue;
            mst += p[1];
            check[p[0]] = true; now = p[0];
            for(int i = 0; i < N; i++){
                if(i == now) continue;
                pq.offer(new int[]{i, matrix[now][i]});
            }
        }
        System.out.println(mst);
    }
}