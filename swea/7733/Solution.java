import java.util.*;
import java.io.*;

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int min;
    static int max;

    public static int bfs(int day, int n, int[][] arr) {
        if (day < min)
            return 1;
        else if (day >= max)
            return 0;
        Queue<Pos> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] > day && !vis[i][j]) {
                    q.clear();
                    vis[i][j] = true;
                    Pos start = new Pos(i, j);
                    q.add(start);
                    while (!q.isEmpty()) {
                        Pos now = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int tx = now.x + dx[k];
                            int ty = now.y + dy[k];
                            if (tx < 0 || ty < 0 || tx >= n || ty >= n || vis[tx][ty] || arr[tx][ty] <= day)
                                continue;
                            Pos t = new Pos(tx, ty);
                            q.add(t);
                            vis[tx][ty] = true;
                        }
                    }
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            min = 101;
            max = 0;
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer line = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(line.nextToken());
                    if (min > arr[i][j])
                        min = arr[i][j];
                    if (max < arr[i][j])
                        max = arr[i][j];
                }
            }

            int answer = 0;
            for (int day = 0; day <= 100; day++) {
                int tmp = bfs(day, n, arr);
                if (tmp > answer)
                    answer = tmp;
            }
            System.out.print("#" + Integer.toString(test_case) + " ");
            System.out.println(answer);
        }
    }
}