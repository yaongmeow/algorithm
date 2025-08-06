import java.util.*;
import java.io.*;

class Solution{
  static int n;
  static int limit;
  static int r;
  static int answer;
  static int sum;

  static public void perm(int cnt, int start, int[][] ingr, int[][] selection){
    if(cnt == r){
      int kcal = 0;
      int score = 0;
      for(int i = 0; i < r; i++){
        kcal += selection[i][1];
        score += selection[i][0];
      }
      if(kcal > limit) return;  
      if(score > answer) answer = score;
      return;
    }
    for(int i = start; i < n; i++){
      selection[cnt] = ingr[i];
      sum +=  ingr[i][1];
      if(sum > limit){
        sum -=  ingr[i][1];
        continue;
      }
      perm(cnt + 1, i + 1, ingr, selection);
      sum -=  ingr[i][1];
    }
  }
  static public void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for(int tc = 1; tc <= T; tc++){
      StringTokenizer info = new StringTokenizer(br.readLine());
      n = Integer.parseInt(info.nextToken());
      limit = Integer.parseInt(info.nextToken());

      int[][] ingr = new int[n][2];
      
      for(int i = 0; i < n; i++){
        StringTokenizer line = new StringTokenizer(br.readLine());
        ingr[i][0] = Integer.parseInt(line.nextToken());
        ingr[i][1] = Integer.parseInt(line.nextToken());
      }

      answer = 0;

      for(int i = 1; i <= n; i++){
        r = i;
        sum = 0;
        int[][] selection = new int[i][2];
        perm(0, 0, ingr, selection);
      }

      System.out.printf("#%d %d\n", tc, answer);
    }
    return;
  }
}