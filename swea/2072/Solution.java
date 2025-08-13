import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int answer = 0;
            for(int i = 0; i < 10; i++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp%2 == 0) continue;
                answer += tmp;
            }
            System.out.print("#" + Integer.toString(test_case) + " ");
            System.out.println(answer);

        }
    }
}