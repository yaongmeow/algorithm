import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 1;
        if(h % (n + 1) != 0){
            answer *= (h / (n + 1) + 1);
        } else answer *= (h / (n + 1));
        if(w % (m + 1) != 0){
            answer *= (w / (m + 1) + 1);
        } else answer *= (w / (m + 1));
        System.out.println(answer);
    }
}