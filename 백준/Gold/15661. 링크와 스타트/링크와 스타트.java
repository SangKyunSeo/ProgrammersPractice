
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[] visit;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n];

        for(int i = 0; i < map.length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < map[i].length; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sol(0, n);
        System.out.println(result);

    }
    public static void sol(int depth, int end){
        if(depth == end){
            getMinDiff();
            return;
        }

        visit[depth] = true;
        sol(depth + 1, end);
        visit[depth] = false;
        sol(depth + 1, end);
    }

    public static void getMinDiff(){
        int start = 0;
        int link = 0;

        for(int i = 0; i < map.length - 1; i++){
            for(int j = i+1; j < map[i].length; j++){
                if(visit[i] && visit[j]){
                    start += map[i][j] + map[j][i];
                }

                if(!visit[i] && !visit[j]){
                    link += map[i][j] + map[j][i];
                }
            }
        }

        result = Math.min(result, Math.abs(start - link));
    }
}
