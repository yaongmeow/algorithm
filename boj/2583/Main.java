import java.util.*;
import java.io.*;

class Pair{
    public Integer x;
    public Integer y;
    
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}


public class Main {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static int bfs(int[][] board, boolean[][] vis, int m, int n, Pair p){
        Queue<Pair> q = new LinkedList<>();
        q.add(p);
        int cnt = 1;
        while(!q.isEmpty()){
            Pair now = q.poll();
            for(int i = 0; i < 4; i++){
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];
                if(newX < 0 || newX >= m || newY < 0 || newY >= n || vis[newX][newY] == true || board[newX][newY] == 1){
                    continue;
                }
                q.add(new Pair(newX, newY));
                vis[newX][newY] = true;
                cnt += 1;
            }
        }
        return cnt;
    }
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        
        for(int i = 0; i < k; i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            int stX = Integer.parseInt(line.nextToken());
            int stY = Integer.parseInt(line.nextToken());
            int enX = Integer.parseInt(line.nextToken()) - 1;
            int enY = Integer.parseInt(line.nextToken()) - 1;
            for(int j = stX; j <= enX; j++){
                for(int l = stY; l <= enY; l++){
                    board[l][j] = 1;
                }
            }
        }

        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == false && board[i][j] == 0){
                    vis[i][j] = true;
                    answer.add(bfs(board, vis, m, n, new Pair(i, j)));
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.size(); i++){
            sb.append(Integer.toString(answer.get(i)));
            if(i != answer.size() - 1) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
    
}
