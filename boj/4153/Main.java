import java.util.*;
import java.io.*;

public class Main {
    public static boolean isRec(int[] arr){
        int result = 0;
        int maxSide = max(arr);
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != maxSide) {
                result += Math.pow(arr[i], 2);
                sum += arr[i];
            }
        }
        if(Math.pow(maxSide, 2) == result && sum > maxSide) return true;
        return false;
    }

    public static int max(int[] arr){
        int result = arr[0];
        for(int i = 0; i < arr.length; i++){
            if (arr[i] > result) result = arr[i];
        }
        return result;
    }

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while(line.equals("0 0 0") == false){
            int[] sides = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (isRec(sides)) System.out.println("right");
            else System.out.println("wrong");
            line = br.readLine();
        }
	}
}