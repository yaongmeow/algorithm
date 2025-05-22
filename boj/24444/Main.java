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

        HashMap<Integer, Integer> am = new HashMap<>();
        for(int i = 1; i <= n; i++) am.put(i, 0);

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];
        int cnt = 1;

        q.add(r);
        vis[r] = true;

        while(q.size() > 0){
            int pos = q.poll();
            am.put(pos, cnt++);
            List<Integer> nodes = hm.get(pos);
            Collections.sort(nodes);
            for(Integer node : nodes){
                if(vis[node]) continue;
                vis[node] = true;
                q.add(node);
            }
        }
        for(int i = 1; i <= n; i++) System.out.println(am.get(i));
	} 
}