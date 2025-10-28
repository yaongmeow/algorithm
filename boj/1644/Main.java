import java.io.*;
import java.util.*;

public class Main {
    static boolean isPrime(int n){
        if(n < 2) return false;
        for(int i = 2; i < Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] primes = new boolean[n + 1];
        boolean[] checked = new boolean[n + 1];
        checked[0] = true; checked[1] = true;
        List<Integer> p = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            if(checked[i]) continue;
            if(isPrime(i)){
                for(int j = i; j <= n; j += i) checked[j] = true;
                primes[i] = true;
                p.add(i);
            }
        }
        if(p.size() == 0){
            System.out.println(0);
            return;
        }
        int st = 0, en = 1, answer = 0;
        int sum = p.get(0);
        while(en < p.size() || st < p.size()){
            if(sum == n){
                answer++;
                if(en >= p.size() || st >= p.size()) break;
                sum -= p.get(st++);
                sum += p.get(en++);
            } else if(sum > n){
                sum -= p.get(st++);
            } else {
                if(en >= p.size()) break;
                sum += p.get(en++);
            }
        }
        System.out.println(answer);

    }
}
