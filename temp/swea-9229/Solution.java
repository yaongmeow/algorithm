import java.util.*;
import java.io.*;

class Solution{
  static int answer;
  static int n, m, r = 2;

  static void combi(int cnt, int start, int[] a, int[] b){
    if(cnt == r){
      int sum = 0;
      for(int i = 0; i < r; i++) sum += b[i];
      if(sum <= m && sum > answer) answer = sum;
      return;
    }

    for(int i = start; i < n; i++){
      b[cnt] = a[i];
      combi(cnt + 1, i + 1, a, b);
    }
  }

  static public void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for(int tc = 1; tc <= T; tc++){
      answer = 0;
      StringTokenizer nm = new StringTokenizer(br.readLine());
      n = Integer.parseInt(nm.nextToken());
      m = Integer.parseInt(nm.nextToken());
      StringTokenizer line = new StringTokenizer(br.readLine());
      int a[] = new int[n];
      for(int i = 0; i < n; i++) a[i] = Integer.parseInt(line.nextToken());
      int[] b = new int[r];
      combi(0, 0, a, b);
      System.out.printf("#%d %d\n", tc, answer);
    }
    return;
  }
}