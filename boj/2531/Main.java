import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> now = new HashMap<>();
        int cnt = 0;
        int answer = 0;

        for(int i = 0; i < n + k; i++){
            int original = i;
            if(i >= n) i -= n;
            if (cnt == k){
                now.put(arr[original - k], now.get(arr[original - k]) - 1);
            } else if(cnt < k) cnt++;
            if (now.get(arr[i]) == null) now.put(arr[i], 1);
            else now.put(arr[i], now.get(arr[i]) + 1);
            if(cnt == k){
                int kinds = 0;
                for (Map.Entry<Integer, Integer> entry : now.entrySet()) {
                    Integer key = entry.getKey();
                    Integer value = entry.getValue();
                    if(value > 0) kinds++;
                    if(key == c && value > 0) kinds--;
                }
                kinds++;
                if (answer < kinds) answer = kinds;
            }
            if(original >= n) i = original;
        }

        System.out.println(answer);
    }
}