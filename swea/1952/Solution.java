import java.io.*;
import java.util.*;

public class Solution {

    static int answer;
    static int[] price = new int[4], plan = new int[12];

    static void bt(int m, int sum){
        if(m > 11){
            if(sum < answer) answer = sum;
            return;
        }
        int day = plan[m] * price[0];
        int month = price[1];
        int threeMonth = price[2];
        bt(m + 1, sum + day);
        bt(m + 1, sum + month);
        bt(m + 3, sum + threeMonth);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 4; i++) price[i] = Integer.parseInt(st.nextToken());
            answer = price[3]; // 1년 이용권
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 12; i++) plan[i] = Integer.parseInt(st.nextToken());
            bt(0, 0);
            System.out.printf("#%d %d\n", tc, answer);
        }
    }

}
