import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sizeCnt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int totalPeople = 0;
        int resultT = 0;
        for(int i = 0; i < 6; i++){
            totalPeople += sizeCnt[i];
            resultT += (int)(sizeCnt[i] / t);
            if (sizeCnt[i] % t != 0) resultT++;
        }
        System.out.println(resultT);
        int resultP = (int)(totalPeople / p);
        int resultPOne = 0;
        if (totalPeople % p != 0) resultPOne += totalPeople % p;
        System.out.println(Integer.toString(resultP) + " " + Integer.toString(resultPOne));
        
	}
}