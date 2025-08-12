import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(a > b){
            if(a == 3 && b == 1) System.out.println("B");
            else System.out.println("A");
            return;
        }
        if(a == 1 && b == 3) System.out.println("A");
        else System.out.println("B");
	}
}