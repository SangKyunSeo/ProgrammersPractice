

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] map = null;
    private static boolean[] visit = null;
    private static int[] result = null;
    private static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력부
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n];
        visit = new boolean[n];
        result = new int[m];

        for(int i = 1; i <= n; i++){
            map[i-1] = i;
        }

        solution(n, m);
    }

    private static void solution(int n, int m){
        for(int i = 0; i < n; i++){
            visit[i] = true;
            result[index] = map[i];
            index += 1;
            dfs(n, 1, m);
            visit[i] = false;
            index = 0;
        }
    }

    private static void dfs(int n, int depth, int end){
        if(depth == end){
            printResult();
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visit[i]){
                visit[i] = true;
                result[index] = map[i];
                index += 1;
                dfs(n, depth + 1, end);
                visit[i] = false;
                index -= 1;

            }
        }
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for(int i : result){
            sb.append(i);
            sb.append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
