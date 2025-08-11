//6808

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static long answerWin, answerLose;
    static int[] cards, gyu = new int[9], in = new int[9], tmp = new int[9];
    static boolean[] v;
    static int gscore, iscore;

    static void perm(int cnt) {
        if (cnt == 9) {
            gscore = 0;
            iscore = 0;
            for (int i = 0; i < 9; i++) {
                if (gyu[i] > tmp[i])
                    gscore += (gyu[i] + tmp[i]);
                else if (tmp[i] > gyu[i])
                    iscore += (gyu[i] + tmp[i]);
            }
            if (gscore > iscore)
                answerWin++;
            else if (gscore < iscore)
                answerLose++;
        }

        for (int i = 0; i < 9; i++) {
            if (v[i])
                continue;
            v[i] = true;
            tmp[cnt] = in[i];
            perm(cnt + 1);
            v[i] = false;
        }
    }

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("s_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("hehe");
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cards = new int[18];
            for (int i = 0; i < 9; i++) {
                int input = Integer.parseInt(st.nextToken());
                cards[input - 1] = 1;
                gyu[i] = input;
            }
            int idx = 0;
            for (int i = 0; i < 18; i++) {
                if (cards[i] == 0)
                    in[idx++] = i + 1;
            }
            answerWin = answerLose = 0;
            v = new boolean[9];
            perm(0);
            System.out.printf("#%d %d %d\n", tc, answerWin, answerLose);
        }
    }
}
