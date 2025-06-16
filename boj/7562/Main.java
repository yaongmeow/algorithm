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

public class Main{
    public static int[] dx = {-2, 2, -1, 1, -2, 2, -1, 1};
    public static int[] dy = {-1, -1, -2, -2, 1, 1, 2, 2};

    public static void bfs(int[][] vis, int L, Pair start, Pair target){
        Queue<Pair> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            Pair now = q.poll();
            if(target.x == now.x && target.y == now.y) break;
            for(int i = 0; i < 8; i++){
                Pair mv = new Pair(now.x + dx[i], now.y + dy[i]);
                if(mv.x < 0 || mv. x >= L || mv.y < 0 || mv.y >= L || vis[mv.x][mv.y] != 0){
                    continue;
                }
                q.add(mv);
                vis[mv.x][mv.y] = vis[now.x][now.y] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i  = 0; i < tc; i++){
            int L = Integer.parseInt(br.readLine());
            int[][] vis = new int[L][L];

            StringTokenizer nowSt = new StringTokenizer(br.readLine());
            Pair now = new Pair(Integer.parseInt(nowSt.nextToken()), Integer.parseInt(nowSt.nextToken()));
            StringTokenizer targetSt = new StringTokenizer(br.readLine());
            Pair target = new Pair(Integer.parseInt(targetSt.nextToken()), Integer.parseInt(targetSt.nextToken()));
            if(target.x != now.x || target.y != now.y)
                bfs(vis, L, now, target);
            System.out.println(vis[target.x][target.y]);
        }
    }
}