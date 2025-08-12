import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String mem = br.readLine();
            int len = mem.length();
            int answer = 0;
            if (mem.charAt(0) == '1')
                answer++;
            char prev = mem.charAt(len - 1);
            int cnt = 1;
            for (int i = len - 2; i >= 0; i--) {
                char now = mem.charAt(i);
                if (now == prev) {
                    cnt++;
                    continue;
                }
                answer += 1;
                cnt = 1;
                prev = now;
            }
            System.out.print("#" + Integer.toString(test_case) + " ");
            System.out.println(answer);

        }
    }
}