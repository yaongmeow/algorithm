import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            Stack<Character> st = new Stack<>();
            boolean decided = false;
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == '(') st.push(s.charAt(j));
                else{
                    if (st.isEmpty()){
                        System.out.println("NO");
                        decided = true;
                        break;
                    }
                    st.pop();
                }
            }
            if (decided) continue;
            if (st.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
	} 
}