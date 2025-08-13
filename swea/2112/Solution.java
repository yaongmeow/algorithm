import java.io.*;
import java.util.*;

public class Solution {

    static int answer, D, W, K;
    static int[][] film;

    static void swap(int[] p, int i, int j) {
		int T = p[i];
		p[i] = p[j];
		p[j] = T;
	}

    static boolean nPn(int []a , int size) {
		//교환할 위치 찾기
		int i = size - 1;
		while(i > 0 && a[i - 1] >= a[i]) i--;
		if(i == 0) return false;//더 이상 next permutation 불가
		
		//교환할 값 찾기
		int j = size - 1;
		while(a[j] <= a[i - 1]) j--;
		swap(a, i-1, j);
		
		//오름차순 정렬
		int k = size - 1;
		while(i < k) swap(a, i++, k--);
		return true;
	}

    static boolean check(int[][] a){
        for(int i = 0; i < W; i++){
            int cnt = 0; int prev = -1;
            for(int j = 0; j < D; j++){
                if(prev == a[j][i]) cnt++;
                else{
                    prev = a[j][i]; cnt = 1;
                }
                if(cnt == K) break;
            }
            if(cnt < K) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            film = new int[D][W]; int[] p = new int[D];
            for(int i = 0; i < D; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++) film[i][j] = Integer.parseInt(st.nextToken());
            }

            List<int[]> selectList = new ArrayList<>();
            for(int i = D; i >= 0; i--){
                Arrays.fill(p, 1);
                for(int j = 0; j < i; j++) p[j] = 0;
                do{
                    selectList.add(Arrays.copyOf(p, D));
                }while(nPn(p, D));
            } // 어디를 골라 바꿀건지 목록 뽑기

            answer = Integer.MAX_VALUE;
            for(int[] s : selectList){
                int size = 0;
                for(int i = 0; i < D; i++) if(s[i] == 1) size++;
                if(size == 0 && check(film)){
                    answer = 0;
                    break;
                } else if(size == 0) continue;
                int[] tp = new int[size];
                boolean end = false;
                for(int i = size; i >= 0; i--){
                    Arrays.fill(tp, 1);
                    for(int j = 0; j < i; j++) tp[j] = 0;
                    do{
                        int[][] tmp = new int[D][W];
                        for(int j = 0; j < D; j++) tmp[j] = Arrays.copyOf(film[j], W);
                        int idx = 0;
                        for(int j = 0; j < D; j++){
                            if(s[j] == 1) Arrays.fill(tmp[j], tp[idx++]);
                        }
                        if(check(tmp) && answer > size) {
                            answer = size;
                            end = true;
                            break;
                        }
                    }while(nPn(tp, size));
                    if(end) break;
                }
                if(end) break;
            }
            System.out.printf("#%d %d\n", tc, answer);
        }
    }

}
