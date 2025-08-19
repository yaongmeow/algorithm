import java.io.*;
import java.util.*;

public class Solution {

    static int answer, H, W, N, x, y;
    static int dir;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            char[][] a = new char[H][W];
            for(int i = 0; i < H; i++){
                String input = br.readLine();
                for(int j = 0; j < W; j++){
                    a[i][j] = input.charAt(j);
                    if(a[i][j] == '>' || a[i][j] == '<' || a[i][j] == '^' || a[i][j] == 'v'){
                        x = i; y = j;
                        if(a[i][j] == '>') dir = 1;
                        if(a[i][j] == '<') dir = 2;
                        if(a[i][j] == '^') dir = 3;
                        if(a[i][j] == 'v') dir = 4;

                    }
                }
            }

            N = Integer.parseInt(br.readLine());
            String cmd = br.readLine();


            for(int i = 0; i < N; i++){
                char c = cmd.charAt(i);
                if(c == 'U'){
                    dir = 3;
                    a[x][y] = '^';
                    if(x - 1 >= 0 && a[x-1][y] == '.'){
                        a[x--][y] = '.';
                        a[x][y] = '^';
                    }
                } else if(c == 'D') {
                    dir = 4;
                    a[x][y] = 'v';
                    if(x + 1 < H && a[x+1][y] == '.'){
                        a[x++][y] = '.';
                        a[x][y] = 'v';
                    }
                } else if(c == 'L'){
                    dir = 2;
                    a[x][y] = '<';
                    if(y - 1 >= 0 && a[x][y - 1] == '.'){
                        a[x][y--] = '.';
                        a[x][y] = '<';
                    }
                } else if(c == 'R'){
                    dir = 1;
                    a[x][y] = '>';
                    if(y + 1 < W && a[x][y + 1] == '.'){
                        a[x][y++] = '.';
                        a[x][y] = '>';
                    }
                } else if(c == 'S'){
                    int nx = x;
                    int ny = y;
                    if(dir == 1){
                        while(ny < W && a[x][ny] != '*' && a[x][ny] != '#') ny++;
                        if(ny != W && a[x][ny] == '*'){
                            a[x][ny] = '.';
                        }
                    } else if(dir == 2){
                        while(ny >= 0 && a[x][ny] != '*' && a[x][ny] != '#') ny--;
                        if(ny >= 0 && a[x][ny] == '*'){
                            a[x][ny] = '.';
                        }
                    } else if(dir == 3){
                        while(nx >= 0 && a[nx][y] != '*' && a[nx][y] != '#') nx--;
                        if(nx >= 0 && a[nx][y] == '*'){
                            a[nx][y] = '.';
                        }
                    } else {
                        while(nx < H && a[nx][y] != '*' && a[nx][y] != '#') nx++;
                        if(nx < H && a[nx][y] == '*'){
                            a[nx][y] = '.';
                        }
                    }
                }
            }

            System.out.printf("#%d ", tc);
            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++) System.out.print(a[i][j]);
                System.out.println();
            }
        }
    }

}
