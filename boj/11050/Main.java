import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long result = 1;
        for(int i = 0; i < k; i++){
            result *= (n - i);
        }
        for(int i = 1; i <= k; i++){
            result /= i;
        }
        System.out.println(result);
	}
}