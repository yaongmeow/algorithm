import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] a = new int[N][N];
            int answer = 0;

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < N; j++) {
                    a[i][j] = input.charAt(j) - '0';
                    answer += a[i][j];
                }
            }

            int num = N / 2;
            int size = num;
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < size; j++) {
                    answer -= a[i][j];
                }
                size--;
            }

            size = 1;
            for (int i = 0; i < num; i++) {
                for (int j = num + size; j < N; j++) {
                    answer -= a[i][j];
                }
                size++;
            }

            size = 1;
            for (int i = num + 1; i < N; i++) {
                for (int j = 0; j < size; j++) {
                    answer -= a[i][j];
                }
                size++;
            }

            size = 1;
            for (int i = num + 1; i < N; i++) {
                for (int j = N - size; j < N; j++) {
                    answer -= a[i][j];
                }
                size++;
            }
            System.out.printf("#%d %d", tc, answer);
        }
    }
}
