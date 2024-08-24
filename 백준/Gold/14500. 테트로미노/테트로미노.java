
import com.sun.jdi.IntegerType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int result = Integer.MIN_VALUE;
    static boolean[][] visit;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0 , -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0; i < map.length; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < map[i].length; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                visit[i][j] = true;
                sol(1, i, j, map[i][j]);
                visit[i][j] = false;
            }
        }

        System.out.println(result);
    }
    public static void sol(int depth, int x, int y, int sum){
        if(depth == 4){
            result = Math.max(result, sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length){
                if(!visit[nx][ny]){
                    if(depth == 2){
                        visit[nx][ny] = true;
                        sol(depth + 1, x, y, sum + map[nx][ny]);
                        visit[nx][ny] = false;
                    }
                    visit[nx][ny] = true;
                    sol(depth + 1, nx, ny, sum + map[nx][ny]);
                    visit[nx][ny] = false;

                }
            }

        }
    }
}
