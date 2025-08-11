import java.util.*;
import java.io.*;

public class Main {
	public static boolean isGood(int[] arr, int idx){
		int target = arr[idx];
		int st = 0;
		int en = idx - 1;
		while(st < en){
			int sum = arr[st] + arr[en];
			if(sum == target) return true;
			else if(sum > target) en--;
			else st++;
		}
		return false;
	}
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int answer = 0;

		for(int i = 0; i < n; i++){
			if(isGood(arr, i)) answer++;
		}

		System.out.println(answer);
	}
}