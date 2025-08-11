import java.io.*;
import java.util.*;

public class Solution {
    static int answer, n, m, init;
    static int[][] a;

    static void find() {
        int prevSum = 0;
        for (int i = 0; i <= n - m; i++) {
            for (int j = 0; j <= n - m; j++) {
                if (j == 0) {
                    prevSum = init;
                } else {
                    for (int k = i; k < i + m; k++)
                        prevSum -= a[k][j - 1];
                    for (int k = i; k < i + m; k++)
                        prevSum += a[k][j + m - 1];
                }
                if (prevSum > answer)
                    answer = prevSum;
            }
            if (i == n - m)
                break;
            for (int j = 0; j < m; j++) {
                init -= a[i][j];
                init += a[i + m][j];
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer nm = new StringTokenizer(br.readLine());
            n = Integer.parseInt(nm.nextToken());
            m = Integer.parseInt(nm.nextToken());
            a = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer line = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(line.nextToken());
                }
            }

            init = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++)
                    init += a[i][j];
            }
            answer = init;
            find();

            System.out.printf("#%d %d\n", tc, answer);
        }

    }
}
