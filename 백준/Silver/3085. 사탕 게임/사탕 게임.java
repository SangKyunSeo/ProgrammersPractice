
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char map[][] = new char[n][n];
        int result = -1;
        // input 값 배열 세팅
        for(int i = 0; i < map.length; i++){
            String input = br.readLine();
            for(int j = 0; j < map[0].length; j++){
                map[i][j] = input.charAt(j);
            }
        }

        // 교환전 result max값 구하기
        for(int i = 0; i < map.length; i++){
            result = Math.max(result, colMax(i, map.length, map));
            result = Math.max(result, rowMax(i, map.length, map));
        }
        // 로직
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                int col = j + 1;
                int row = i + 1;

                // 왼쪽 열 변경
                if(col < map.length){
                    char temp = map[i][j];
                    map[i][j] = map[i][col];
                    map[i][col] = temp;

                    // result max값 구하기
                    result = Math.max(result, colMax(i, map.length, map)); // 열에 해당하는 result Max
                    result = Math.max(result,Math.max(rowMax(j, map.length, map), rowMax(col, map.length, map))); // 바뀐 열에 따른 행에 해당하는 result Max
                    map[i][col] = map[i][j];
                    map[i][j] = temp;
                }

                // 아래쪽 행 변경
                if(row < map[i].length){
                    char temp = map[i][j];
                    map[i][j] = map[row][j];
                    map[row][j] = temp;

                    // result max값 구하기
                    result = Math.max(result, rowMax(j, map.length, map));
                    result = Math.max(result, Math.max(colMax(i, map[i].length, map), colMax(row, map[i].length, map)));
                    map[row][j] = map[i][j];
                    map[i][j] = temp;
                }
            }
        }

        System.out.println(result);
    }

    public static int rowMax(int col, int n, char[][] map){
        char start = map[0][col];
        int cnt = 1;
        int max = 1;
        for(int i = 1; i < n; i++){
            if(start == map[i][col]){
                cnt++;
            }else{
                if(max < cnt) max = cnt;
                start = map[i][col];
                cnt = 1;
            }
        }
        return Math.max(max, cnt);
    }

    public static int colMax(int row, int n, char[][] map){
        char start = map[row][0];
        int cnt = 1;
        int max = 1;
        for(int i = 1; i < n; i++){
            if(start == map[row][i]){
                cnt++;
            }else{
                if(max < cnt) max = cnt;
                start = map[row][i];
                cnt = 1;
            }
        }
        return Math.max(max, cnt);
    }
}
