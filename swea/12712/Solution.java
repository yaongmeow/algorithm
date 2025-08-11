import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static int n;
    static int m;

    static int diagonal(int a, int b, int[][] arr){
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {1, -1, -1, 1};
        int result = arr[a][b];
        for(int i = 0; i < 4; i++){
            for(int j = 1; j < m; j++){
                int x = a + dx[i] * j;
                int y = b + dy[i] * j;
                if(x < 0 || y < 0 || x >= n || y >= n) break;
                result += arr[x][y];
            }
        }
        return result;
    }

    static int vertical(int a, int b, int[][] arr){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int result = arr[a][b];
        for(int i = 0; i < 4; i++){
            for(int j = 1; j < m; j++){
                int x = a + dx[i] * j;
                int y = b + dy[i] * j;
                if(x < 0 || y < 0 || x >= n || y >= n) break;
                result += arr[x][y];
            }
        }
        return result;
    }

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			StringTokenizer nm = new StringTokenizer(br.readLine());
            n = Integer.parseInt(nm.nextToken());
            m = Integer.parseInt(nm.nextToken());
            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    int d = diagonal(i, j, arr);
                    int v = vertical(i, j, arr);
                    if(v > d && v > answer) answer = v;
                    else if(d > v && d > answer) answer = d;
                }
            }

            System.out.println("#" + Integer.toString(test_case) + " " + Integer.toString(answer));
		}
	}
}