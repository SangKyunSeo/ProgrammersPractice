
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[] visit;
    static int startScore = 0;
    static int linkScore = 0;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n];

        for(int i = 0; i < map.length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < map[0].length; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int end = n / 2;

        sol(0,0, end);
        System.out.println(result);

    }

    public static void sol(int idx, int depth, int end){
        if(depth == end){
            getResult();
            return;
        }
        for(int i = idx; i < map.length; i++){
            if(!visit[i]){
                visit[i] = true;
                sol(i, depth + 1, end);
                visit[i] = false;
            }
        }
    }

    public static void getResult(){
        startScore = 0;
        linkScore = 0;
        for(int i = 0; i < map.length - 1; i++){
            for(int j = i+1; j < map[0].length; j++){
                if(visit[i] && visit[j] && i != j){
                    startScore += map[i][j];
                    startScore += map[j][i];
                }else if(!visit[i] && !visit[j] && i != j){
                    linkScore += map[i][j];
                    linkScore += map[j][i];
                }
            }
        }

        result = Math.min(Math.abs(startScore - linkScore), result);
    }


}
