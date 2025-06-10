import java.util.*;
import java.io.*;

public class Main {
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tip = new int[n];
        for(int i = 0; i < n; i++){
            tip[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tip);
        long answer = 0;
        for(int i = n-1; i >= 0; i--){
            if(tip[i] + (i - n + 1) >= 0)
                answer += tip[i] + (i - n + 1);
        }
        System.out.println(answer);
	} 
}