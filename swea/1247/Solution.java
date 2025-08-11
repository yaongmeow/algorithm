
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{

    static int[] h = new int[2];
    static int[] c = new int[2];
    static List<Integer> distList = new ArrayList<>();

    public static int calDist(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void perm(int cnt, int n, boolean[] v, int[] b, int[][] arr){
        if(cnt == n){
            int dist = calDist(c[0], c[1], arr[b[0]][0], arr[b[0]][1]);
            for(int i = 1; i < n; i++){
                dist += calDist(arr[b[i-1]][0], arr[b[i-1]][1], arr[b[i]][0], arr[b[i]][1]);
            }
            dist += calDist(arr[b[n-1]][0], arr[b[n-1]][1], h[0], h[1]);
            distList.add(dist);
            return;
        }
        
        for(int i = 0; i < n; i++) {
			if(v[i]) continue;
			v[i] = true;
			b[cnt] = i;
			perm(cnt + 1, n, v, b, arr);
			v[i] = false;
		}
    }

	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input.txt"));


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            distList.clear();

            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            int[] b = new int[n];
            boolean[] v = new boolean[n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            c[0] = Integer.parseInt(st.nextToken());
            c[1] = Integer.parseInt(st.nextToken());

            h[0] = Integer.parseInt(st.nextToken());
            h[1] = Integer.parseInt(st.nextToken());

            for(int i = 0; i < n; i++){
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            perm(0, n, v, b, arr);
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
            /// 
            int answer = Collections.min(distList);
            System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}