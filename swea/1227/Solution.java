import java.io.*;
import java.util.*;

public class Solution {
    static int sx, sy;
    static int answer;
    static int[][] a = new int[100][100];
    static boolean[][] v;

    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    static public void dfs(int x, int y) {
        if (a[x][y] == 3) {
            answer = 1;
            return;
        }
        v[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx < 0 || ny < 0 || nx >= 100 || ny >= 100 || v[nx][ny] || a[nx][ny] == 1)
                continue;
            dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();

            answer = 0;
            v = new boolean[100][100];

            for (int i = 0; i < 100; i++) {
                String input = br.readLine();
                for (int j = 0; j < 100; j++) {
                    a[i][j] = input.charAt(j) - '0';
                    if (a[i][j] == 2) {
                        sx = i;
                        sy = j;
                    }
                }
            }

            dfs(sx, sy);
            System.out.printf("#%d %d\n", tc, answer);
        }
    }

}
