import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double a = Double.parseDouble(br.readLine())/100.0;
		double b = Double.parseDouble(br.readLine())/100.0;
		
		int[] notp = {0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18};
		double[][][] arr = new double[2][18][19]; // 어느 팀이, 몇번째에, 누적 몇점
		
		arr[0][0][0] = 1 - a;
		arr[0][0][1] = a;
		arr[1][0][0] = 1 - b;
		arr[1][0][1] = b;

		for(int i = 1; i < 18; i++){
			for (int j = 0; j <= i+1; j++){
				arr[0][i][j] = arr[0][i-1][j] * (1-a);
				if (j > 0) arr[0][i][j] += arr[0][i-1][j-1] * a;
				arr[1][i][j] = arr[1][i-1][j] * (1-b);
				if (j > 0) arr[1][i][j] += arr[1][i-1][j-1] * b;
			}
		}

		double aSum = 0;
		double bSum = 0;

		for(int i = 0; i < notp.length; i++){
			aSum += arr[0][17][notp[i]];
			bSum += arr[1][17][notp[i]];
		}

		System.out.println(1 - aSum * bSum);
	} 
}