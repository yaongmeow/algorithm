import java.util.*;
import java.io.*;

public class Main {

    public static int checkMax(char[][] arr, int n){
        // 행 겁사
        int maxCnt = 0;

        for(int i = 0; i < n; i++){
            int cnt = 1;
            char prev = arr[i][0];
            for(int j = 1; j < n; j++){
                if(arr[i][j] == prev) cnt++;
                else{
                    if(cnt > maxCnt) maxCnt = cnt;
                    prev = arr[i][j];
                    cnt = 1;
                }
            }
            if(cnt > maxCnt) maxCnt = cnt;
        }

        // 열 겁사
        for(int i = 0; i < n; i++){
            int cnt = 1;
            char prev = arr[0][i];
            for(int j = 1; j < n; j++){
                if(arr[j][i] == prev) cnt++;
                else{
                    if(cnt > maxCnt) maxCnt = cnt;
                    prev = arr[j][i];
                    cnt = 1;
                }
            }
            if(cnt > maxCnt) maxCnt = cnt;
        }
        return maxCnt;
    }

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char [][] arr = new char[n][n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        int answer = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-1; j++){
                if(arr[i][j] != arr[i][j + 1]){
                    // 오른쪽과 교체
                    char tmp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = tmp;

                    int candy = checkMax(arr, n);
                    if (candy > answer) answer = candy;

                    // 원상복구
                    tmp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = tmp;
                }
                if(arr[i][j] != arr[i + 1][j]){
                    // 아래쪽과 교체
                    char tmp = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = tmp;

                    int candy = checkMax(arr, n);
                    if (candy > answer) answer = candy;
                    
                    // 원상복구
                    tmp = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = tmp;
                }
            }
        }

        for(int i = 0; i < n-1; i++){
            if(arr[n-1][i] != arr[n-1][i + 1]){
                // 오른쪽과 교체
                char tmp = arr[n-1][i];
                arr[n-1][i] = arr[n-1][i + 1];
                arr[n-1][i + 1] = tmp;

                int candy = checkMax(arr, n);
                if (candy > answer) answer = candy;

                // 원상복구
                tmp = arr[n-1][i];
                arr[n-1][i] = arr[n-1][i + 1];
                arr[n-1][i + 1] = tmp;
            }
        }

        for(int i = 0; i < n-1; i++){
            if(arr[i][n-1] != arr[i+1][n-1]){
                // 오른쪽과 교체
                char tmp = arr[i][n-1];
                arr[i][n-1] = arr[i+1][n-1];
                arr[i+1][n-1] = tmp;

                int candy = checkMax(arr, n);
                if (candy > answer) answer = candy;

                // 원상복구
                tmp = arr[i][n-1];
                arr[i][n-1] = arr[i+1][n-1];
                arr[i+1][n-1] = tmp;
            }
        }
        System.out.println(answer);
	}
}