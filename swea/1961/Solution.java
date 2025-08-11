import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            List<StringBuilder> answer = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = n-1; j >= 0; j--){
                    sb.append(Integer.toString(arr[j][i]));
                }
                answer.add(sb);
            }
            
            int idx = 0;
            
            for(int i = n-1; i >= 0; i--){
                StringBuilder sb = answer.get(idx);
                sb.append(" ");
                for(int j = n-1; j >= 0; j--){
                    sb.append(Integer.toString(arr[i][j]));
                }
                answer.set(idx++, sb);
            }
            idx = 0;
            for(int i = n-1; i >= 0; i--){
                StringBuilder sb = answer.get(idx);
                sb.append(" ");
                for(int j = 0; j < n; j++){
                    sb.append(Integer.toString(arr[j][i]));
                }
                answer.set(idx++, sb);
            }
            System.out.println("#" + Integer.toString(test_case));
            for(StringBuilder sb : answer){
                System.out.println(sb.toString());
            }
		}
	}
}