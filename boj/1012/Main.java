import java.util.*;
import java.io.*;

class Pair{
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void bfs(int[][] arr, boolean[][] vis, int n, int m, Pair pos){
        Queue<Pair> q = new LinkedList<>();
        q.add(pos);
        while(!q.isEmpty()){
            Pair now = q.poll();
            for(int i = 0; i < 4; i++){
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                if(x < 0 || x >= m || y < 0 || y >= n || vis[y][x] || arr[y][x] == 0) continue;
                vis[y][x]= true;
                q.add(new Pair(x, y));
            }
        }
    }
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<Integer> answer = new ArrayList<>();
        while(t > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];
            boolean[][] vis = new boolean[n][m];
            for(int i = 0; i < k; i++){
                StringTokenizer line = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(line.nextToken());
                int y = Integer.parseInt(line.nextToken());
                arr[y][x] = 1;
            }

            int cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(arr[i][j] == 1 && vis[i][j] == false){
                        bfs(arr, vis, n, m, new Pair(j, i));
                        cnt++;
                    }
                }
            }
            answer.add(cnt);
            t--;
        }
        for(Integer num: answer){
            System.out.println(num);
        }
	} 
}