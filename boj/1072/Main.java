import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer xy = new StringTokenizer(br.readLine());
        long x = Long.parseLong(xy.nextToken());
        long y = Long.parseLong(xy.nextToken());
        long z = (y * 100) / x;
        if(z >= 99){
            System.out.println("-1");
            return;
        }
        long st = 0;
        long en = 1000000001;
        long answer = -1;
        while (st < en - 1){
            long mid = (long)((st + en) / 2);
            long newZ = ((y + mid)*100) / (x + mid);
            if (newZ > z){
                en = mid;
                answer = mid;
            } else {
                st = mid;
            }
        }
        System.out.println(answer);
	} 
}