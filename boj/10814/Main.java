import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<Integer> s = new HashSet<>();
        HashMap<Integer, List<String>> hm = new HashMap<>();

        for(int i = 0; i < n; i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(line.nextToken());
            String name = line.nextToken();
            if(hm.get(age) == null)
                hm.put(age, new ArrayList<>());
            hm.get(age).add(name);
            s.add(age);
        }
        List<Integer> l = new ArrayList<>(s);
        Collections.sort(l);
        for(Integer a : l){
            List<String> people = hm.get(a);
            for(String person: people){
                System.out.println(Integer.toString(a) + " " + person);
            }
        }
	} 
}