import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        boolean[][] light = new boolean[N][N];

        HashMap<String, List<int[]>> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            String key = x + ", " + y;
            if(!hm.containsKey(key)){
                hm.put(key, new ArrayList<>());
            }
            hm.get(key).add(new int[]{a, b});
            hs.add(a + ", " + b);
        };
        Queue<int[]> q = new ArrayDeque<>(); q.offer(new int[]{0, 0}); light[0][0] = true; 
        int answer = 1; boolean[][][] v = new boolean[N][N][2];
        v[0][0][1] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if(hm.containsKey(x + ", " + y)){
                List<int[]> con = hm.get(x + ", " + y);
                for(int[] p : con){
                    if(light[p[0]][p[1]]) continue;
                    light[p[0]][p[1]] = true;
                    if(v[p[0]][p[1]][0]) {
                        v[p[0]][p[1]][1] = true;
                        q.offer(new int[]{p[0], p[1]});
                    }
                    answer++;
                }
            }

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i], ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(!light[nx][ny]){
                    v[nx][ny][0] = true;
                    continue;
                } if(v[nx][ny][1]) continue;
                q.offer(new int[]{nx, ny}); v[nx][ny][1] = true;
            }
        }
        System.out.println(answer);
    }
}