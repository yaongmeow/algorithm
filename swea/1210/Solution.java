import java.util.*;
import java.io.*;

public class Solution {

    static int answer;
    static int[][] a = new int[100][100];
    static boolean[][] v;
    static int goal;

    static int mv(int start) {
        int x = 0;
        int y = start;

        while (x < 99) {
            v[x][y] = true;
            if (y - 1 >= 0 && !v[x][y - 1] && a[x][y - 1] == 1) { // 왼쪽
                y -= 1;

            } else if (y + 1 < 100 && !v[x][y + 1] && a[x][y + 1] == 1) { // 오른쪽
                y += 1;
            } else
                x++;
        }
        return y;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new ArrayDeque<>();
        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                    if (i == 0 && a[i][j] == 1) {
                        q.offer(j); // 시작점의 인덱스 추가
                    }
                    if (a[i][j] == 2)
                        goal = j;
                }
            }

            answer = 0;
            while (!q.isEmpty()) {
                v = new boolean[100][100];
                int start = q.poll();
                int arrival = mv(start);
                if (arrival == goal) {
                    answer = start;
                    break;
                }
            }
            q.clear();

            System.out.printf("#%d %d\n", tc, answer);
        }
    }
}
