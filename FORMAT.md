## 백준 Java PS 포맷
```java
import java.util.*;
import java.io.*;

public class Main {
    static int answer;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        answer = 0;
        System.out.println(answer);
	} 
}
```


## swea Java PS 포맷
```java
import java.util.*;
import java.io.*;

public class Solution {
    static int answer;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            answer = 0;

            System.out.printf("#%d %d", tc, answer);
        }
	} 
}
```