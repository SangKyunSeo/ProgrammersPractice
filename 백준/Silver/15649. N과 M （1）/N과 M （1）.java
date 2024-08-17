
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean visit[];
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];

        for(int i = 1; i <= n; i++){
            Arrays.fill(visit, false);
            sb = new StringBuilder();
            visit[i] = true;
            sb.append(i).append(" ");
            solution(1, m);
        }
    }
    public static void solution(int count, int end){
        if(count == end){
           System.out.println(sb.toString().trim());
            return;
        }

        for(int i = 1; i < visit.length; i++){
            if(!visit[i]){
                visit[i] = true;
                sb.append(i).append(" ");
                solution(count+1, end);
                visit[i] = false;
                sb.delete(sb.length() - 2, sb.length());
            }
        }
    }
}
