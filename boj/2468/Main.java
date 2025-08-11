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

    public static void bfs(int n, int water, int[][] arr, boolean[][] vis, Pair pos){
        Queue<Pair> q = new LinkedList<>();
        q.add(pos);
        while(!q.isEmpty()){
            Pair now = q.poll();
            for(int i = 0; i < 4; i++){
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                if(x < 0 || x >= n || y < 0 || y >= n) continue;
                if(vis[x][y] || arr[x][y] <= water) continue;
                vis[x][y] = true;
                q.add(new Pair(x, y));
            }
        }
    }
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] arr = new int[n][n];
        int min = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > max) max = arr[i][j];
                if(arr[i][j] < min) min = arr[i][j];
            }
        }

        int answer = 1;
        for(int water = min; water <= max; water++){
            int cnt = 0;
            boolean[][] vis = new boolean[n][n];
            for(int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if(arr[i][j] > water && vis[i][j] == false){
                        bfs(n, water, arr, vis, new Pair(i, j));
                        cnt++;
                    }
                }
            }
            if (answer < cnt) answer = cnt;
        }

        System.out.println(answer);
	} 
}