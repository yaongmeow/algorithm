import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int st = 0;
        int en = 0;
        int cnt = 0;
        int answer = 0;

        HashMap<String, Integer> hm = new HashMap<>();
        int idx = 0;
        while(idx < input.length()){
            if(hm.get(input.substring(idx, idx+1)) == null || hm.get(input.substring(idx, idx+1)) == 0){
                hm.put(input.substring(idx, idx+1), 1);
                cnt +=1;
            } else hm.put(input.substring(idx, idx+1), hm.get(input.substring(idx, idx+1))+1);
            en = idx;
            while(cnt > n){
                hm.put(input.substring(st, st+1), hm.get(input.substring(st, st+1))-1);
                if (hm.get(input.substring(st, st+1)) == 0)
                    cnt -= 1;
                st += 1;
            }
            if(en - st + 1 > answer) answer = en - st + 1;
            idx++;
        }
        System.out.println(answer);
	} 
}