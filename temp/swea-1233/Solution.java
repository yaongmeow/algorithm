import java.util.*;
import java.io.*;

class Tree{
  Boolean isNum;
  Boolean isLeaf;
  String content;
  Integer number;

  public void setNum(int number){
    this.number = number;
    isNum = true;
  }

  public void setContent(String content){
    this.content = content;
    isNum = false;
  }
}

class Solution{
  static int answer;
  static int n;

  static public void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = 10;
    for(int tc = 1; tc <= T; tc++){
      n = Integer.parseInt(br.readLine());
      Tree[] t = new Tree[n + 1];

      for(int i = 0; i < n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeId = Integer.parseInt(st.nextToken());
        String value = st.nextToken();
        Tree node = new Tree();
        node.isLeaf = true;
        while(st.hasMoreTokens()){
          st.nextToken();
          node.isLeaf = false;
        }

        try{
          int valueNum = Integer.parseInt(value);
          node.setNum(valueNum);
        } catch(NumberFormatException e){
          node.setContent(value);
        }
        t[nodeId] = node;
      }

      answer = 1;

      for(int i = n; i > 0; i--){
        Tree node = t[i];
        if(node.isLeaf && !node.isNum){
          answer = 0;
          break;
        }
      }

      System.out.printf("#%d %d\n", tc, answer);
    }
    return;
  }
}