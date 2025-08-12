import java.io.*;
import java.util.*;

public class Solution {

    static int answer, N;
    static int[] p, num;

    static void swap(int i, int j) {
		int T = p[i];
		p[i] = p[j];
		p[j] = T;
	}

    static boolean nPn() {
		//교환할 위치 찾기
		int i = N - 2;
		while(i > 0 && p[i - 1] >= p[i]) i--;
		if(i == 0) return false;//더 이상 next permutation 불가
		
		//교환할 값 찾기
		int j = N - 2;
		while(p[j] <= p[i - 1]) j--;
		swap(i-1, j);
		
		//오름차순 정렬
		int k = N - 2;
		while(i < k) swap(i++, k--);
		return true;
	}

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            num = new int[N]; p = new int[N - 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = 0;
            for(int i = 0; i < 4; i++){
                int tmp = Integer.parseInt(st.nextToken());
                while(tmp-- > 0) p[idx++] = i;
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            do{
                idx = 0;
                int res = 0;
                for(int i = 0; i < N - 1; i++){
                    if(p[i] == 0){
                        if(i == 0){
                            res = num[idx] + num[idx+1];
                            idx+= 2;
                        } else res += num[idx++];
                    } else if(p[i] == 1){
                        if(i == 0){
                            res = num[idx] - num[idx+1];
                            idx+= 2;
                        } else res -= num[idx++];
                    } else if(p[i] == 2){
                        if(i == 0){
                            res = num[idx] * num[idx+1];
                            idx+= 2;
                        } else res *= num[idx++];

                    } else if(p[i] == 3){
                        if(i == 0){
                            res = num[idx] / num[idx+1];
                            idx+= 2;
                        } else res /= num[idx++];
                    }
                }
                if(res > max) max = res;
                if(res < min) min = res;
            }while(nPn());
            answer = max - min;
            System.out.printf("#%d %d\n", tc, answer);
        }
    }

}
