import java.util.*;
import java.io.*;

public class Main {

    public static int findMax(int[] pcnt){
        for(int i = 9; i >=1; i--){
            if(pcnt[i] != 0) return i;
        }
        return 0;
    }
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++){
            StringTokenizer nm = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(nm.nextToken());
            int pos = Integer.parseInt(nm.nextToken());
            
            int[] pcnt = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            
            Queue<Integer> q = new LinkedList<>();

            StringTokenizer parr = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++){
                int priority = Integer.parseInt(parr.nextToken());
                q.add(priority);
                pcnt[priority]++;
            }

            int max = findMax(pcnt);
            int cnt = 0;
            while(true){
                int front = q.poll();
                if (front != max)
                    q.add(front);
                else {
                    pcnt[front]--;
                    max = findMax(pcnt);
                    cnt++;
                    if(pos == 0){
                        System.out.println(cnt);
                        break;
                    }
                }
                pos = (pos != 0) ? pos - 1 : q.size() - 1;
            }
        }
	} 
}