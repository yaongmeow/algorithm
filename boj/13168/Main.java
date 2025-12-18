import java.util.*;
import java.io.*;

public class Main {
    static int N, R, M, K;
    static double[][] g, ng;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hm = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int idx = 0;
        for (int i = 0; i < N; i++) {
            String city = st.nextToken();
            if (hm.containsKey(city))
                continue;
            hm.put(city, idx++);
        }
        
        N = idx; M = Integer.parseInt(br.readLine());
        int[] target = new int[M]; // 방문할 도시 번호 목록

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            String city = st.nextToken();
            target[i] = hm.get(city);
        }

        g = new double[N][N];
        ng = new double[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], Double.MAX_VALUE / 2);
            Arrays.fill(ng[i], Double.MAX_VALUE / 2);
        }

        for (int i = 0; i < N; i++) {
            g[i][i] = 0;
            ng[i][i] = 0;
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int from = hm.get(st.nextToken());
            int to = hm.get(st.nextToken());
            double cost = Double.parseDouble(st.nextToken()); // 기본 가격
            double nCost = cost; // 내일로 가격
            if (type.equals("Mugunghwa") 
            || type.equals("ITX-Saemaeul") 
            || type.equals("ITX-Cheongchun")) nCost = 0;
            else if (type.equals("S-Train") || type.equals("V-Train")) nCost /= 2.0;

            g[from][to] = Double.min(g[from][to], cost);
            g[to][from] = Double.min(g[to][from], cost);
            ng[from][to] = Double.min(ng[from][to], nCost);
            ng[to][from] = Double.min(ng[to][from], nCost);
        }

        for (int via = 0; via < N; via++) {
            for (int f = 0; f < N; f++) {
                for (int t = 0; t < N; t++) {
                    double newDist = g[f][via] + g[via][t];
                    if (newDist < g[f][t]) g[f][t] = newDist;

                    newDist = ng[f][via] + ng[via][t];
                    if (newDist < ng[f][t]) ng[f][t] = newDist;
                }
            }
        }

        double noNail = 0;
        double nail = (double) R;

        for (int i = 0; i < M - 1; i++) {
            int from = target[i];
            int to = target[i + 1];
            noNail += g[from][to];
            nail += ng[from][to];
        }

        if (nail < noNail)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
