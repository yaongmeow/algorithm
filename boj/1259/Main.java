import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while(line.equals("0") == false){
            boolean isPal = true;
            for(int i = 0; i < line.length(); i++){
                if (line.charAt(i) != line.charAt(line.length()-1-i)) {
                    isPal = false;
                    break;
                }
            }
            if(isPal) System.out.println("yes");
            else System.out.println("no");
            line = br.readLine();
        }
	}
}