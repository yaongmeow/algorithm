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

        Queue<Integer> q = new LinkedList<>();
        int[] vis = new int[n + 1];
        for(int i = 0; i < n+1; i++) vis[i] = -1;

        q.add(r);
        vis[r] = 0;
        long cnt = 1;
        long result = 0;

        while(q.size() > 0){
            int pos = q.poll();
            result += (cnt++) * vis[pos];
            if(hm.get(pos) == null) continue;
            List<Integer> nodes = hm.get(pos);
            for(Integer node : nodes){
                if(vis[node] != -1) continue;
                q.add(node);
                vis[node] = vis[pos] + 1;
            }
        }
        System.out.println(result);
	} 
}