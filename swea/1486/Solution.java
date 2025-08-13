import java.io.*;
import java.util.*;

public class Solution {

    static int answer, N, B;
    static int[] p, H;

    static void swap(int i, int j) {
		int T = p[i];
		p[i] = p[j];
		p[j] = T;
	}

    static boolean nPn() {
		//교환할 위치 찾기
		int i = N - 1;
		while(i > 0 && p[i - 1] >= p[i]) i--;
		if(i == 0) return false;//더 이상 next permutation 불가
		
		//교환할 값 찾기
		int j = N - 1;
		while(p[j] <= p[i - 1]) j--;
		swap(i-1, j);
		
		//오름차순 정렬
		int k = N - 1;
		while(i < k) swap(i++, k--);
		return true;
	}

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            H = new int[N]; p = new int[N];
            answer = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) H[i] = Integer.parseInt(st.nextToken());
            for(int i = N - 1; i >= 0; i--){
                Arrays.fill(p, 1);
                for(int j = 0; j < i; j++) p[j] = 0;
                do{
                    int sum = 0;
                    for(int j = 0; j < N; j++) if (p[j] == 1) sum += H[j];
                    if(sum >= B && (answer == 0 || answer > sum)) answer = sum;
                }while(nPn());
            }
            System.out.printf("#%d %d\n", tc, answer - B);
        }
    }

}
