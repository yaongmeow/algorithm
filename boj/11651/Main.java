import java.util.*;
import java.io.*;

class Dot{
    public final Integer x;
    public final Integer y;
    
    public Dot(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public void print(){
        System.out.println(Integer.toString(this.x) + " " + Integer.toString(this.y));
    }
}

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Dot> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Dot(x, y));
        }

        Collections.sort(list, Comparator.comparing((Dot d) -> d.y).thenComparing(d -> d.x));
        for(Dot item: list){
            item.print();
        }
	}
}