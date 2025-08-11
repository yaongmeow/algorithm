import java.util.*;
import java.io.*;

public class Main {

    public static boolean isPossible(int n, int c, long d, int[] h){
        int cnt = 1;
        for(int i = 0; i < n; i++){
            int target = h[i] + (int)d;
            
            int idx = Arrays.binarySearch(h, target);
            if (idx < 0) idx = -idx - 1;
            if (idx == n) break;
            i = idx - 1;
            cnt++;
            if(cnt == c) break;
        }
        if(cnt < c) return false;
        return true;
    }
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] h = new int[n];
        
        for(int i = 0; i < n; i++){
            h[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(h);
        
        int s = 0;
        int e = 1000000000;

        long answer = 0;
        while(s - 1 < e){
            long mid = (long)((s+e)/2);
            if (isPossible(n, c, mid, h)){
                if(answer < mid) answer = mid;
                s = (int)mid + 1;
                continue;
            }
            e = (int)mid - 1;
        }
        System.out.println(answer);
	} 
}