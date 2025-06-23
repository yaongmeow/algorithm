import java.util.*;
import java.io.*;

public class Main {
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =  Integer.parseInt(st.nextToken());
        int k =  Integer.parseInt(st.nextToken());

        StringTokenizer line = new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(line.nextToken());
        }
        int s = 0;
        int e = 0;
        int cnt;
        int answer;
        int length;

        if(arr[s] % 2 == 0){
            cnt = 0;
            answer = 1;
            length = 1;
        } else{
            cnt = 1;
            answer = 0;
            length = 0;
        }

        while(e < n){
            while(cnt > k){
                if(arr[s] % 2 == 1){
                    cnt--;
                    s++;
                } else {
                    length--;
                    s++;
                }
            }

            e++;
            if(e >= n) break;

            int nxt = arr[e];
            if(nxt % 2 == 0){
                length += 1;
                if(answer < length) answer = length;
                continue;
            }
            cnt++;
        }

        System.out.println(answer);
	} 
}