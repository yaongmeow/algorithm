import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = -1, min = Integer.MAX_VALUE;
        for(int i = 0; i < 7; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp % 2 == 1) {
                answer += tmp;
                min = Integer.min(min, tmp);
            }
        }
        if(answer == -1) {
            System.out.println(answer);
            return;
        }
        System.out.println(answer + 1);
        System.out.println(min);
    }
}
