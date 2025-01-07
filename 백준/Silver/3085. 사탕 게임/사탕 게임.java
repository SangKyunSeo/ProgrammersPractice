
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int result = 0;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    char map[][] = new char[n][n];
    for(int i = 0; i < n; i++){
      char inputArr[] = br.readLine().toCharArray();
      for(int j = 0; j < inputArr.length; j++){
        map[i][j] = inputArr[j];
      }
    }

    for(int i = 0; i < n; i++){
      calMaxCol(map, i);
      calMaxRow(map, i);
    }

    for(int i = 0; i < n; i++ ){
      for(int j = 0; j < n; j++){
        char temp = map[i][j];
        // 행 바꿈
        if(i + 1 < n){
          map[i][j] = map[i+1][j];
          map[i+1][j] = temp;
          calMaxCol(map, i);
          calMaxCol(map, i+1);
          calMaxRow(map, j);
          map[i+1][j] = map[i][j];
          map[i][j] = temp;
        }

        // 열 바꿈
        if(j + 1 < n){
          map[i][j] = map[i][j+1];
          map[i][j+1] = temp;
          calMaxRow(map, j);
          calMaxRow(map, j+1);
          calMaxCol(map, i);
          map[i][j+1] = map[i][j];
          map[i][j] = temp;
        }
      }
    }

    System.out.println(result);
  }

  public static void calMaxCol(char[][] map, int row){
    char start = map[row][0];
    int sum = 1;
    for(int i = 1; i < map.length; i++){
      if(start == map[row][i]) sum += 1;
      else{
        result = Math.max(result, sum);
        sum = 1;
        start = map[row][i];
      }
    }
    result = Math.max(result, sum);
  }

  public static void calMaxRow(char[][] map, int col){
    char start = map[0][col];
    int sum = 1;
    for(int i = 1; i < map[0].length; i++){
      if(start == map[i][col]) sum += 1;
      else{
        result = Math.max(result, sum);
        sum = 1;
        start = map[i][col];
      }
    }
    result = Math.max(result, sum);
  }

}
