import java.util.*;
import java.io.*;

public class Main {
    static int[] tree, A;
    static int size;

    static void fill(int node, int start, int end){
        if(start == end){
            tree[node] = A[start];
            return;
        }
        fill(node * 2, start, (start + end) / 2);
        fill(node * 2 + 1, (start + end) / 2 + 1, end);
        tree[node] = Integer.min(tree[node * 2], tree[node * 2 + 1]);
    }

    static void change(int node, int idx, int t, int start, int end){
        if(idx < start || idx > end) return;
        tree[node] = Integer.min(tree[node], t);
        if(tree[node] == A[idx])
        if(start == idx && start == end) return;
        change(node * 2, idx, t, start, (start + end) / 2);
        change(node * 2 + 1, idx, t, (start + end) / 2 + 1, end);
        return;
    }

    static void update(int node, int start, int end, int idx, int t){
        if(idx < start || idx > end) return;
        if(start == end){
            A[idx] = t;
            tree[node] = t;
            return;
        }
        update(node * 2, start, (start + end) / 2, idx, t);
        update(node * 2 + 1, (start + end) / 2 + 1, end, idx, t);
        tree[node] = Integer.min(tree[node * 2], tree[node * 2 + 1]);
    }

    static int getMin(int node, int left, int right, int start, int end){
        if(left > end || right < start) return Integer.MAX_VALUE;
        if(left <= start && end <= right) return tree[node];
        return Integer.min(getMin(node * 2, left, right, start, (start + end) / 2) , getMin(node*2 + 1, left, right, (start + end) / 2 + 1, end));
    }
    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); A  = new int[N]; tree = new int[N * 4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken()); fill(1, 0, N - 1);
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if(cmd == 1){
                int idx = Integer.parseInt(st.nextToken()) - 1;
                int val = Integer.parseInt(st.nextToken());
                update(1, 0, N - 1, idx, val);
            } else {
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                System.out.println(getMin(1, from, to, 0, N - 1));
            }
        }

    }
}