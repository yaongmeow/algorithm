import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int min = 0;
        if (a > b) min = b;
        else min = a;
        int cgy = 1;
        
        for(int i = 1; i <= min; i++){
            if (a%i == 0 && b%i == 0) cgy = i;
        }
        int cgb = cgy * (a / cgy) * (b / cgy);
        System.out.println(Integer.toString(cgy) + " " + Integer.toString(cgb));
	}
}