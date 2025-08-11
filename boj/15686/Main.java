import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer> tmp = new ArrayList<>();

    public static int calDist(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static int calChickenDist(int[] home, int[][]c, int size){
        int min = -1;
        for(int i = 0; i < size; i++){
            int dist = calDist(home[0], home[1], c[i][0], c[i][1]);
            if (min == -1) min = dist;
            else min = min > dist ? dist : min;
        }
        return min;
    }

    public static void comb(int cnt, int start, int m, int [] b, int[][] c, int[][] h){
        if(cnt == m){
            int sum = 0;
            int [][] selected = new int[m][2];
            for(int i = 0; i < m; i++){
                selected[i][0] = c[b[i]][0];
                selected[i][1] = c[b[i]][1];
            }
            for(int i = 0; i < h.length; i++){
                sum += calChickenDist(h[i], selected, m);
            }
            tmp.add(sum);
            return;
        }
        for(int i = start; i < c.length; i++) {
			b[cnt] = i;
			comb(cnt + 1, i + 1, m, b, c, h);
		}
    }


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer nmSt = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nmSt.nextToken());
        int m = Integer.parseInt(nmSt.nextToken());

        int[][] arr = new int[n][n];
        int totalChicken = 0, totalHome = 0;

        for(int i = 0; i < n; i++){
            StringTokenizer lineSt = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(lineSt.nextToken());
                if(arr[i][j] == 2) totalChicken++;
                else if(arr[i][j] == 1) totalHome++;
            }
        }

        int[][] chicken = new int[totalChicken][2];
        int[][] home = new int[totalHome][2];
        int cIdx = 0, hIdx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 2){
                    chicken[cIdx][0] = i;
                    chicken[cIdx++][1] = j;
                } else if(arr[i][j] == 1){
                    home[hIdx][0] = i;
                    home[hIdx++][1] = j;
                }
            }
        }
        
        int[] b = new int[m];
        comb(0, 0, m, b, chicken, home);

        
        System.out.println(Collections.min(tmp));

	}
}