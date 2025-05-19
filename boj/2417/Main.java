import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long st = -1;
        long en = Long.MAX_VALUE;
        long result = 0;

        while(st < en - 1){
            long mid = (long)(st + en) / 2;
            if(Math.pow(mid, 2) > n){
                result = mid;
                en = mid;
            } else if(Math.pow(mid, 2) == n){
                result = mid;
                break;
            } else {
                st = mid;
            }
        }

        System.out.println(result);
	} 
}