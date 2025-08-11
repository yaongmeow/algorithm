import java.io.*;
import java.util.*;

public class Solution {
    static int answer, n, m;

    static List<Integer>[] rules;
    // static int[][] rules;
    static int[] used;

    static void subs(int cnt, String a) {
        if (cnt == n + 1) {
            answer++;
            return;
        }
        if (used[cnt] == 0) { // 전에 안사용됨
            // 사용하는 상황
            for (Integer num : rules[cnt]) {
                used[num]++;
            }
            subs(cnt + 1, a + cnt);
            for (Integer num : rules[cnt]) {
                used[num]--;
            }
        }
        // 전에 사용됨
        subs(cnt + 1, a + "."); // 사용하지 않는 상황
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer nm = new StringTokenizer(br.readLine());
            n = Integer.parseInt(nm.nextToken());
            m = Integer.parseInt(nm.nextToken());
            rules = new List[n + 1];
            for (int i = 1; i <= n; i++)
                rules[i] = new ArrayList<>();
            used = new int[n + 1];
            for (int i = 0; i < m; i++) {
                StringTokenizer line = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(line.nextToken());
                int b = Integer.parseInt(line.nextToken());
                if (a > b)
                    rules[b].add(a);
                else
                    rules[a].add(b);
            }
            answer = 0;
            subs(1, "");
            System.out.printf("#%d %d\n", tc, answer);
        }
    }
}
