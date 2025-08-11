import java.io.*;
import java.util.*;

public class Solution {

    static int answer, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            answer = 1;
            n = Integer.parseInt(br.readLine());
            int[] tree = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                StringTokenizer line = new StringTokenizer(br.readLine());
                line.nextToken();
                String val = line.nextToken();
                if (val.charAt(0) < '0' || val.charAt(0) > '9')
                    tree[i] = 0;
                else
                    tree[i] = Integer.parseInt(val);
            }

            for (int i = 1; i <= n; i++) {
                int left = i * 2;
                int right = left + 1;
                if (left <= n || right <= n) { // 자식 있음
                    if (tree[i] != 0) {
                        answer = 0;
                        break;
                    }
                } else if (tree[i] == 0) {
                    answer = 0;
                    break;
                }
            }
            System.out.printf("#%d %d\n", tc, answer);
        }
    }
}
