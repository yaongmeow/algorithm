import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static boolean cmp(HashMap<String, Integer> target, HashMap<String, Integer> tmp){
        for(String key: target.keySet()){
            if (target.get(key) > tmp.get(key))
                return false;
        }
        return true;
    }

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer spSt = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(spSt.nextToken());
        int p = Integer.parseInt(spSt.nextToken());

        String str = br.readLine();

        StringTokenizer arrSt = new StringTokenizer(br.readLine());
        int[] arr = new int[4];
        for(int i = 0; i < 4; i++) arr[i] = Integer.parseInt(arrSt.nextToken());

        HashMap<String, Integer> target = new HashMap<>();
        target.put("A", arr[0]);
        target.put("C", arr[1]);
        target.put("G", arr[2]);
        target.put("T", arr[3]);

        int start = 0;
        int end = p - 1;
        
        HashMap<String, Integer> tmp = new HashMap<>();

        tmp.put("A", 0);
        tmp.put("C", 0);
        tmp.put("G", 0);
        tmp.put("T", 0);

        for(int i = 0; i < p; i++)
            tmp.put(str.substring(i, i+1), tmp.get(str.substring(i, i+1)) + 1);
        
        int cnt = 0;

        while(end < s){
            if(cmp(target, tmp)) cnt++;
            tmp.put(str.substring(start, start+1), tmp.get(str.substring(start, start+1))-1);
            start++;
            end++;
            if (end == s) break;
            tmp.put(str.substring(end, end+1), tmp.get(str.substring(end, end+1))+1);
        }

        System.out.println(cnt);
	} 
}