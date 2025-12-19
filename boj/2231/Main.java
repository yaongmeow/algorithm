import java.util.*;
import java.io.*;

public class Main {

    static int getSize(int n){
        int t = 1000000;
        int answer = 7;
        while(n / t == 0 && t >= 1){
            t /= 10;
            answer--;
        }
        return answer;
    }


    static int getSum(int size, int n){
        int answer = 0;
        int t = 1;
        for(int i = 0; i < size - 1; i++) t *= 10;
        while(t >= 1){
            answer += n / t;
            n %= t;
            t /= 10;
        }
        return answer;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int size = getSize(n);
        int max = n - size * 9;
        int answer = getSum(size, max) + max;

        while(max < n && answer != n){
            max += 1;
            answer = getSum(size, max) + max;
        }
        if(answer != n) System.out.println(0);
        else System.out.println(max);
        
    }
}