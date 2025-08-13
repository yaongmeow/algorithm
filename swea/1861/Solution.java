import java.io.*;
import java.util.*;

//1861 D4 정사각형 방

public class Solution {

    static int answer, answerNum, cnt, N;
    static int[][] a;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    static void move(int i, int j){
        int now = a[i][j];
        for(int d = 0; d < 4; d++){
            int ni = i + dx[d];
            int nj = j + dy[d];
            if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
            if(a[ni][nj] == now + 1){
                cnt++;
                move(ni, nj);
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            a = new int[N][N];
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    a[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            answer = 0; answerNum = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    cnt = 1;
                    move(i, j);
                    if(cnt == answer && answerNum > a[i][j]) answerNum = a[i][j];
                    if(cnt > answer){
                        answer = cnt;
                        answerNum = a[i][j];
                    }
                }
            }
            System.out.printf("#%d %d %d", tc, answerNum, answer);
        }
    }

}
