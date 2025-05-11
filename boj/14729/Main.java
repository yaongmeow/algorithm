import java.util.*;
import java.io.*;
import java.text.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];
        for(int i = 0; i < n; i++)
            arr[i] = Double.parseDouble(br.readLine());
        Arrays.sort(arr);
        DecimalFormat df = new DecimalFormat("0.000");
        for(int i = 0; i < 7; i++)
            System.out.println(df.format(arr[i]));
	} 
}