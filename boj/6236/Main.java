import java.io.*;
import java.util.*;

public class Main {
    public static boolean check(int[] arr, long p, int target){
        long now = p;
        int cnt = 1;
        for(int i = 0; i < arr.length; i++){
            if (now < arr[i]) {
                now = p - arr[i];
                cnt++;
            } else {
                now -= arr[i];
            }
        }
        if(cnt <= target) return true;
        else return false;
    }

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nm.nextToken());
        int m = Integer.parseInt(nm.nextToken());
        int[] arr = new int[n];
        long st = 0L;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > st){
                st = arr[i];
            }
        }
        st--;
        long en = 100000L * 10000L + 1L;
        long answer = en;
        while(st < en - 1){
            long mid = (long)(st + en) / 2;
            if(check(arr, mid, m)){
                answer = mid;
                en = mid;
            } else {
                st = mid;
            }
        }
        System.out.println(answer);
	} 
}