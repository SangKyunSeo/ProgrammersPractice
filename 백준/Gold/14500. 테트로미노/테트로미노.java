
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * dfs 깊이우선탐색으로 접근 가능해 보임
 * 깊이가 3일때 깊이가 2였던곳으로가서 방문하지 않은 x, y좌표로 다시 이동 하게된다면 ㅗ 모양 경우를 따질 수 있음
 * 깊이가 4일때 까지 돌고, 방문 여부를 초기화해줌
 *
 */
public class Main {

    private static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 입력 부
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 솔루션 부
        solution(n, m, map);
    }

    private static void solution(int n, int m, int[][] map){

        int[] dx = new int[]{0,0,-1,1}; // x좌표 이동
        int[] dy = new int[]{-1,1,0,0}; // y좌표 이동

        // 방문 여부 판단 배열 생성
        boolean[][] visited = new boolean[n][m];
        initVisited(visited); // 모든 방문 여부 초기화

        // 시작점에서 dfs 탐색
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visited[i][j] = true;
                findMaxValue(i, j, map, 1, map[i][j], visited, dx, dy);
                initVisited(visited);
            }
        }

        // 탐색 종료 및 결과 도출
        System.out.println(result);

    }

    /**
     * 방문 여부 초기화 메서드
     * @param visited
     */
    private static void initVisited(boolean[][] visited){
        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }
    }

    private static void findMaxValue(int x, int y, int[][] map, int depth, int sum, boolean[][] visited, int[] dx, int[] dy){

        // 종료 조건
        if(depth == 4){
            result = Math.max(result, sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX > -1 && newY > -1 && newX < map.length && newY < map[newX].length && !visited[newX][newY]){
                if(depth == 2){
                    visited[newX][newY] = true;
                    findMaxValue(x, y, map,depth + 1, sum + map[newX][newY], visited, dx, dy);
                    visited[newX][newY] = false;
                }
                
                visited[newX][newY] = true;
                findMaxValue(newX, newY, map, depth + 1, sum + map[newX][newY], visited, dx, dy);
                visited[newX][newY] = false;
            }
        }
    }
}
