
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class Main {

    private static int[] map = null;
    private static boolean[] visit = null;
    private static int[] result = null;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력부
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n];
        visit = new boolean[n];
        result = new int[m];

        for(int i = 1; i <= n; i++) {
            map[i-1] = i;
        }

        // 솔루션부
        solution(n, m);
    }

    private static void solution(int n, int m){

        for(int i = 0; i < n; i++){
            result[0] = map[i];
            visit[i] = true;
            dfs(i, 1, n, m);
        }
    }

    private static void dfs(int index, int depth, int n, int end){
        if(depth == end){
            printResult();
            return;
        }

        for(int i = index; i < n; i++){
            if(!visit[i]){
                visit[i] = true;
                result[depth] = map[i];
                dfs(i, depth + 1, n, end);
                visit[i] = false;
            }
        }
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();

        for(int i : result){
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString().trim());
    }


}
