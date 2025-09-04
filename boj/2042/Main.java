import java.util.*;
import java.io.*;

public class Main {
    static long[] tree, input;
    static int size;
    static void fill(int node, int start, int end){
        if(start == end){
            tree[node] = input[start];
            return;
        }

        fill(node * 2, start, (start + end) / 2);
        fill(node * 2 + 1, (start + end) / 2 + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static void change(int node, int idx, long t, int start, int end){
        if(idx < start || idx > end) return;
        tree[node] += t;
        if(start == idx && start == end) return;
        change(node * 2, idx, t, start, (start + end) / 2);
        change(node * 2 + 1, idx, t, (start + end) / 2 + 1, end);
        return;
    }

    static long getSum(int node, int left, int right, int start, int end){
        if(left > end || right < start) return 0;
        if(left <= start && end <= right) return tree[node];
        return getSum(node * 2, left, right, start, (start + end) / 2) + getSum(node*2 + 1, left, right, (start + end) / 2 + 1, end);
    }
    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        size = N * 4;
        tree = new long[size];
        input = new long[N];

        for(int i = 0; i < N; i++){
            input[i] = Long.parseLong(br.readLine());
        }
        fill(1, 0, N - 1);
        for(int i = 0; i < M + K ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a == 1){
                change(1, b - 1, c - input[b - 1], 0, N - 1);
                input[b - 1] = c;
                continue;
            }
            System.out.println(getSum(1, b - 1, (int)c - 1, 0, N - 1));
        }

    }
}