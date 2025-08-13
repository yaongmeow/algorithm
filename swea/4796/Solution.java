import java.io.*;
import java.util.*;


public class Solution {

    static long answer;
    static int N;
    static int[] m;

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            answer = 0;
            N = sc.nextInt();
            m = new int[N];
            for(int i = 0; i < N; i++) m[i] = sc.nextInt();
            int st = 0, en = 0, top = 0;
            while(en < N - 1){
                while(en + 1 < N && m[en] < m[en + 1]) en++;
                top = en;
                while(en + 1 < N && m[en] > m[en + 1]) en++;
                answer += (top - st) * (en - top);
                st = en;
            }
            System.out.printf("#%d %d\n", tc, answer);
        }
        sc.close();
    }

}
