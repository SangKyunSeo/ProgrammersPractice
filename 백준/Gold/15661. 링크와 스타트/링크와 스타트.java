/**
 * 주제 : bruteForce
 * 문제 : 15661
 * 제목 : 링크와 스타트
 * 날짜 : 2024-08-25
 */

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
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n];

        for(int i = 0; i < map.length; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < map[i].length; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sol(n, 0);


        System.out.println(result);
    }

    public static void sol(int teamSize, int depth){
        if(depth == teamSize){
            // 두 팀의 능력치 계산 및 최소 값 갱신
            getScore();
            return;
        }

        visit[depth] = true;
        sol(teamSize, depth + 1);
        visit[depth] = false;
        sol(teamSize, depth + 1);

    }

    public static void getScore(){
        int startScore = 0;
        int linkScore = 0;

        for(int i = 0; i < map.length - 1; i++){
            for(int j = i + 1; j < map[i].length; j++){
                if(visit[i] && visit[j]){ // 스타트 팀
                    startScore += map[i][j] + map[j][i];
                }else if(!visit[i] && !visit[j]){
                    linkScore += map[i][j] + map[j][i];
                }
            }
        }

        result = Math.min(result, Math.abs(linkScore - startScore));
    }
}
