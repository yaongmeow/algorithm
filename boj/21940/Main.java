import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[][] g = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) Arrays.fill(g[i], Integer.MAX_VALUE / 2);
        for(int i = 1; i <= N; i++) g[i][i] = 0;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            g[a][b] = t;
        }

        K = Integer.parseInt(br.readLine()); int[] cities = new int[K];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;  i < K; i++) cities[i] = Integer.parseInt(st.nextToken());

        for(int v = 1; v <= N; v++){
            for(int f = 1; f <= N; f++){
                for(int t = 1; t <= N; t++){
                    int newDist = g[f][v] + g[v][t];
                    if(newDist < g[f][t]) g[f][t] = newDist;
                }
            }
        }

        int minX = 0;
        int minSum = Integer.MAX_VALUE;
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int x = 1; x <= N; x++){
            int sum = 0;
            for(int j = 0; j < K; j++){
                int mv = g[cities[j]][x] + g[x][cities[j]];
                sum = Integer.max(sum, mv);
            }
            if(sum < minSum){
                minSum = sum;
                minX = x;
                hm.put(sum, new ArrayList<>());
                hm.get(sum).add(x);
            } else if(sum == minSum){
                hm.get(sum).add(x);
            }
        }

        List<Integer> answer = hm.get(minSum);
        Collections.sort(answer);
        for(Integer a: answer) System.out.print(a + " ");
    }
}
