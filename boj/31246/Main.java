import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer nkSt = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nkSt.nextToken());
        int k = Integer.parseInt(nkSt.nextToken());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            StringTokenizer lineSt = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(lineSt.nextToken());
            int b = Integer.parseInt(lineSt.nextToken());
            arr[i] = b - a;
        }
        Arrays.sort(arr);
        if(arr[k-1] <= 0) System.out.println(0);    
        else System.out.println(arr[k-1]);
	}
}