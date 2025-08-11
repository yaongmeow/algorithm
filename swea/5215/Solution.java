import java.util.*;
import java.io.*;

public class Solution {
    static int n, limit, answer;
    static int[][] ingr;

    static public void subs(int cnt, int scoreSum, int kcalSum) {
        if (cnt == n) {
            if (kcalSum <= limit && scoreSum > answer)
                answer = scoreSum;
            return;
        }
        subs(cnt + 1, scoreSum + ingr[cnt][0], kcalSum + ingr[cnt][1]);
        subs(cnt + 1, scoreSum, kcalSum);
    }

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer info = new StringTokenizer(br.readLine());
            n = Integer.parseInt(info.nextToken());
            limit = Integer.parseInt(info.nextToken());
            ingr = new int[n][2];

            for (int i = 0; i < n; i++) {
                StringTokenizer line = new StringTokenizer(br.readLine());
                ingr[i][0] = Integer.parseInt(line.nextToken());
                ingr[i][1] = Integer.parseInt(line.nextToken());
            }

            answer = 0;
            subs(0, 0, 0);

            System.out.printf("#%d %d\n", tc, answer);
        }
        return;
    }
}