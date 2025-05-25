import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nmr = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nmr.nextToken());
        int m = Integer.parseInt(nmr.nextToken());
        int r = Integer.parseInt(nmr.nextToken());

        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        for(int i = 0; i < m; i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(line.nextToken());
            int b = Integer.parseInt(line.nextToken());
            if(hm.get(a) != null) hm.get(a).add(b);
            else {
                hm.put(a, new ArrayList<>());
                hm.get(a).add(b);
            }
            if(hm.get(b) != null) hm.get(b).add(a);
            else {
                hm.put(b, new ArrayList<>());
                hm.get(b).add(a);
            }
        }

        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[n + 1];
        long[] cnt = new long[n + 1];
        long turn = 1;

        s.add(r);

        while(s.size() > 0){
            int pos = s.pop();
            if(vis[pos]) continue;
            vis[pos] = true;
            cnt[pos] = turn++;
            if(hm.get(pos) == null) continue;
            List<Integer> nodes = hm.get(pos);
            Collections.sort(nodes);
            for(Integer node : nodes){
                if(vis[node]) continue;
                s.add(node);
            }
        }
        for(int i = 1; i <= n; i++) System.out.println(cnt[i]);
	} 
}