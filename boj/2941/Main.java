import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int res = 0;
        int idx = 0;
        while ((idx = s.indexOf("=", idx)) != -1) {
            res++;
            idx++;
        }
        idx = 0;
        while ((idx = s.indexOf("-", idx)) != -1) {
            res++;
            idx++;
        }
        idx = 0;
        while ((idx = s.indexOf("lj", idx)) != -1) {
            res++;
            idx++;
        }
        while ((idx = s.indexOf("nj", idx)) != -1) {
            res++;
            idx++;
        }
        String p = s.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", "");
        System.out.println(res + p.length());
	} 
}