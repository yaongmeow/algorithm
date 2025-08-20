import java.io.*;
import java.util.*;

public class Solution {
    static List<Integer>[] list;
    static int[] depthInfo;
    static boolean[] v;

    static void bfs(int[] startInfo){ // {위치, depth}
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(startInfo);
        v[startInfo[0]] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowPos = now[0];
            int nowDepth = now[1];
            depthInfo[nowPos] = nowDepth;
            for(Integer p : list[nowPos]){
                if(!v[p]){
                    v[p] = true;
                    q.offer(new int[]{p, nowDepth + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        for(int tc = 1; tc <= 10; tc++){
            int answer = 0, max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken(); // 길이 값 사용하지 않음
            int start = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            list = new List[101];
            v = new boolean[101];
            depthInfo = new int[101];
            for(int i = 0; i < 101; i++) list[i] = new ArrayList<>();

            while(st.hasMoreTokens()){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list[from].add(to);
            }

            bfs(new int[]{start, 0});
            for(int i = 1; i <= 100; i++){
                if(depthInfo[i] >= max){
                    max = depthInfo[i];
                    answer = i;
                }
            }

            sb.append("#" + tc + " " + answer + "\n");
        }
        System.out.print(sb.toString());
    }
}
