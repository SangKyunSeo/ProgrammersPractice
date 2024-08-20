
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        map = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sol(0, 0);
        System.out.println(result);
    }

    public static void sol(int idx, int sum){
        if(idx > map.length){ // 일을 못해
            return;
        }

        if(idx == map.length){
            result = Math.max(sum, result);
            return;
        }

        sol(idx + map[idx][0], sum + map[idx][1]);
        sol(idx+1, sum);
    }
}
