import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() > s2.length()) return 1;
                else if (s1.length() == s2.length()){
                    int aSum = 0;
                    int bSum = 0;
                    for(int i = 0; i < s1.length(); i++){
                        if(Character.isDigit(s1.charAt(i))){
                            aSum += (s1.charAt(i) - '0');
                        }
                        if(Character.isDigit(s2.charAt(i))){
                            bSum += (s2.charAt(i) - '0');
                        }
                    }
                    if(aSum == bSum)
                        return s1.compareTo(s2);
                    else if (aSum > bSum) return 1;
                    else return -1;
                }
                return -1;
            }
        });
        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }
	} 
}