import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> left = new Stack<>(); Stack<Integer> right = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            hm.put(height, i); left.push(height);
        }

        int[] cnt = new int[N];
        
        right.push(left.pop());
        int rtop = right.peek();
        int ltop = left.peek();

        Loop1 :
        while(!right.isEmpty() && !left.isEmpty()){
            while(ltop > rtop){
                cnt[hm.get(rtop)] = hm.get(ltop) + 1;
                right.pop();
                if(right.isEmpty()){
                    right.push(left.pop());
                    if(left.isEmpty()) break Loop1;
                    ltop = left.peek();
                }
                rtop = right.peek();
            }
            while(ltop < rtop){
                right.push(left.pop());
                if(left.isEmpty()) break;
                rtop = right.peek();
                ltop = left.peek();
            }
        }
        for(int i = 0; i < N; i++) System.out.print(cnt[i] + " ");
    }
}