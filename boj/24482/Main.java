import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int i = 0; i < m; i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(line.nextToken());
            int b = Integer.parseInt(line.nextToken());
            if(hm.get(a) == null) hm.put(a, new ArrayList<>());
            if(hm.get(b) == null) hm.put(b, new ArrayList<>());
            hm.get(a).add(b);
            hm.get(b).add(a);
        }

        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean [n+1];
        int[] depth = new int [n+1];
        for(int i = 0; i <= n; i++) depth[i] = -1;

        s.push(r);
        depth[r] = 0;

        while(s.isEmpty() != true){
            int pos = s.pop();
            if(vis[pos]) continue;
            vis[pos] = true;
            if(hm.get(pos) == null) continue;
            List<Integer> nodes = hm.get(pos);
            Collections.sort(nodes);
            for(Integer node: nodes){
                if(vis[node] == false){
                    s.push(node);
                    depth[node] = depth[pos] + 1;
                }
            }
        }
        for(int i = 1; i < n+1; i++) System.out.println(depth[i]);
	}
}