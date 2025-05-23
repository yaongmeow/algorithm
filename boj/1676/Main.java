import java.io.*;

public class Main {
    public static int countT(int n, int t){
        int answer = 0;
        while(n%t == 0){
            n /= t;
            answer++;
        }
        return answer;
    }

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n < 5){
            System.out.println(0);
            return;
        }
        int[] cnt = {0, 0};
        for(int i = 1; i <= n; i++){
            int two = countT(i, 2);
            int five = countT(i, 5);
            cnt[0] += two;
            cnt[1] += five;
        }
        if(cnt[0] > cnt[1]) System.out.println(cnt[1]);
        else System.out.println(cnt[0]);
	} 
}