import java.io.*;
import java.util.*;

public class Solution {
    static List<Queue<Integer>> q = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        for (int i = 0; i <= 100; i++)
            q.add(new LinkedList<>());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            int lim = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int maxHeight = 0;
            int minHeight = 100;
            for (int boxNum = 1; boxNum <= 100; boxNum++) {
                int height = Integer.parseInt(st.nextToken());
                if (height > maxHeight)
                    maxHeight = height;
                if (height < minHeight)
                    minHeight = height;
                q.get(height).add(boxNum);
            }
            int cnt = 0;

            while (maxHeight - minHeight > 1 && cnt < lim) {
                if (q.get(maxHeight).isEmpty()) {
                    maxHeight--;
                    continue;
                }
                int maxBoxNum = q.get(maxHeight).poll();
                int minBoxNum = q.get(minHeight).poll();
                q.get(minHeight + 1).add(minBoxNum);
                q.get(maxHeight - 1).add(maxBoxNum);
                if (q.get(minHeight).isEmpty())
                    minHeight++;
                cnt++;
            }

            int answer = maxHeight - minHeight;
            System.out.printf("#%d %d\n", tc, answer);
            for (int i = 0; i <= 100; i++)
                q.get(i).clear();
        }
    }

}
