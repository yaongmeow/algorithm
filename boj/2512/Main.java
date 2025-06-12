import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max) max = arr[i];
        }
        Long m = Long.parseLong(br.readLine());
        int min = 0;
        max += 1;
        int res = 0;
        long answer = 0;
        while(min - 1 < max){
            long sum = 0;
            int mid = (int)((min + max)/2);
            
            for(int i = 0; i < n; i++){
                if(arr[i] >= mid) sum += mid;
                else sum += arr[i];
            }
            
            if (sum > m){
                max = mid - 1;
                continue;
            }
            if(sum > answer){
                answer = sum;
                res = mid;
            }
            min = mid + 1;
        }
        System.out.println(res);
    }
}