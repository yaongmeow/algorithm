import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nm.nextToken());
        int m = Integer.parseInt(nm.nextToken());
        StringTokenizer a = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(a.nextToken());
        }
        Arrays.sort(arr);
        int s = 0;
        int e = arr.length - 1;
        int answer = 0;
        while(s < e){
            if (arr[s] + arr[e] >= m){
                answer++;
                s++;
                e--;
            }
            else{
                s++;
            }
        }
        System.out.println(answer);

	}
}