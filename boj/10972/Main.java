import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] a;

    static void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        
        int idx = n - 1;
        while(idx > 0 && a[idx] <= a[idx-1]) idx--;
        if(idx == 0){
            System.out.println("-1");
            return;
        }
        int swapIdx = idx;
        for(int i = n - 1; i > idx; i--){
            if(a[i] > a[idx - 1]){
                swapIdx = i;
                break;
            }
        }
        swap(idx - 1, swapIdx);
        int s = idx, e = n - 1;
        while(s < e) swap(s++, e--);
        for(int i = 0; i < n; i++) System.out.print(a[i] + " ");
    }

}
