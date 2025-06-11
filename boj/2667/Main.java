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

    public static int bfs(int[][] board, boolean[][] vis, int n, Pair p){
        Queue<Pair> q = new LinkedList<>();
        q.add(p);
        int cnt = 1;
        while(!q.isEmpty()){
            Pair now = q.poll();
            for(int i = 0; i < 4; i++){
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];
                if(newX < 0 || newX >= n || newY < 0 || newY >= n || vis[newX][newY] == true || board[newX][newY] == 0){
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
        int n = Integer.parseInt(br.readLine());
        
        int[][] board = new int[n][n];
        boolean[][] vis = new boolean[n][n];
        
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < line.length(); j++){
                if(line.charAt(j) == '0') board[i][j] = 0;
                else board[i][j] = 1;
            }
        }

        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == false && board[i][j] == 1){
                    vis[i][j] = true;
                    answer.add(bfs(board, vis, n, new Pair(i, j)));
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());

        for(Integer cnt: answer){
            System.out.println(cnt);
        }
    }
    
}
