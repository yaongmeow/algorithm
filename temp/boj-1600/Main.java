import java.io.*;
import java.util.*;


public class Main {
  static int k, w, h, answer;
  static int[] dxH = {2, 1};
  static int[] dyH = {1, 2};
  static int[] dx = {1, 0};
  static int[] dy = {0, 1};

  public static void mv(int[][] board){
    Stack<int[]> st = new Stack<>();
    st.add(new int[] {0, 0, k, 0});

    while(!st.isEmpty()){
      int[] now = st.pop();
      int x = now[0];
      int y = now[1];
      int kLeft = now[2];
      int cnt = now[3];

      if(x == w - 1 && y == h - 1){
        if(answer == -1) answer = cnt;
        else if(cnt < answer) answer = cnt;
      }

      if(kLeft > 0){
        for(int i = 0; i < 2; i++){
          int nx = dxH[i] + x;
          int ny = dyH[i] + y;
          if(nx < 0 || ny < 0 || nx >= h || ny >= w || board[nx][ny] == 1) continue;
          //System.out.println("from " + x + ", " + y + " to " + nx + ", " + ny);
          st.add(new int [] {nx, ny, kLeft-1, cnt + 1});
        }
      }
      
      for(int i = 0; i < 2; i++){
        int nx = dx[i] + x;
        int ny = dy[i] + y;
        if(nx < 0 || ny < 0 || nx >= h || ny >= w || board[nx][ny] == 1) continue;
        //System.out.println("from " + x + ", " + y + " to " + nx + ", " + ny);
        st.add(new int [] {nx, ny, kLeft, cnt + 1});
      }
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    k = Integer.parseInt(br.readLine());
    StringTokenizer wh = new StringTokenizer(br.readLine());
    w = Integer.parseInt(wh.nextToken());
    h = Integer.parseInt(wh.nextToken());

    int[][] board = new int[h][w];
    for(int i = 0; i < h; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0; j < w; j++)
        board[i][j] = Integer.parseInt(st.nextToken());
    }
    answer = -1;
    mv(board);
    System.out.println(answer);
  }
}
