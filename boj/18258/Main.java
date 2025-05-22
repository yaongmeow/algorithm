import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        int last = 0;

        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            if(input.length == 2){
                q.add(Integer.parseInt(input[1]));
                last = Integer.parseInt(input[1]);
            } else {
                if(input[0].equals("front")){
                    if (q.isEmpty()) bw.write("-1\n");
                    else bw.write(Integer.toString(q.element()) + "\n");
                } else if(input[0].equals("back")){
                    if (q.isEmpty()) bw.write("-1\n");
                    else bw.write(Integer.toString(last) + "\n");
                } else if(input[0].equals("pop")){
                    if (q.isEmpty()) bw.write("-1\n");
                    else bw.write(Integer.toString(q.poll())+ "\n");
                } else if(input[0].equals("size")){
                    bw.write(Integer.toString(q.size())+ "\n");
                } else if(input[0].equals("empty")){
                    if (q.isEmpty()) bw.write("1\n");
                    else bw.write("0\n");
                }
                bw.flush();
            }
        }
        bw.close();
	} 
}