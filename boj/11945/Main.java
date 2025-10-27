import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        String[] input = new String[n];
        for(int i = 0; i < n; i++) input[i] = br.readLine();
        for(int i = 0; i < n; i++){
            for(int j = m - 1; j >= 0; j--) System.out.print(input[i].charAt(j));
            System.out.println();
        }
    }
}
