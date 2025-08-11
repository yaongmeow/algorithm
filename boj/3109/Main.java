import java.io.*;
import java.util.*;

public class Main {
    static int R, C, answer = 0;
    static int[][] a;
    static boolean[][] v;

    static boolean find(int i, int j) {
        if (j == C - 1) {
            v[i][j] = true;
            return true;
        }
        // 오른쪽 위
        if (i - 1 >= 0 && j + 1 < C && !v[i - 1][j + 1] && a[i - 1][j + 1] == 0) {
            v[i][j] = true;
            if (find(i - 1, j + 1)) {
                return true;
            }
            v[i][j] = false;
        }

        // 오른쪽
        if (j + 1 < C && !v[i][j + 1] && a[i][j + 1] == 0) {
            v[i][j] = true;
            if (find(i, j + 1)) {
                return true;
            }
            v[i][j] = false;
        }

        // 오른쪽 아래
        if (i + 1 < R && j + 1 < C && !v[i + 1][j + 1] && a[i + 1][j + 1] == 0) {
            v[i][j] = true;
            if (find(i + 1, j + 1)) {
                return true;
            }
            v[i][j] = false;
        }

        v[i][j] = true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer rc = new StringTokenizer(br.readLine());

        R = Integer.parseInt(rc.nextToken());
        C = Integer.parseInt(rc.nextToken());
        a = new int[R][C];
        v = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                if (input.charAt(j) == '.')
                    a[i][j] = 0;
                else
                    a[i][j] = 1;
            }
        }

        for (int i = 0; i < R; i++) {
            if (find(i, 0)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
