import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer nm = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(nm.nextToken());
            int m = Integer.parseInt(nm.nextToken());
            int[] a = new int[n];
            int[] b = new int[m];
            StringTokenizer aLine = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(aLine.nextToken());
            }
            StringTokenizer bLine = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(bLine.nextToken());
            }

            int answer = 0;

            if (n <= m) {
                int bIdx = 0;
                int aIdx;

                while (bIdx + n <= m) {
                    aIdx = 0;
                    int tmp = 0;
                    for (int i = bIdx; i < bIdx + n; i++) {
                        tmp += b[i] * a[aIdx++];
                    }
                    bIdx++;
                    if (tmp > answer)
                        answer = tmp;
                }
            }

            else {
                int bIdx;
                int aIdx = 0;

                while (aIdx + m <= n) {
                    bIdx = 0;
                    int tmp = 0;
                    for (int i = aIdx; i < aIdx + m; i++) {
                        tmp += a[i] * b[bIdx++];
                    }
                    aIdx++;
                    if (tmp > answer)
                        answer = tmp;
                }
            }

            System.out.print("#");
            System.out.print(test_case);
            System.out.print(" ");
            System.out.println(answer);
        }
    }
}