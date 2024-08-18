
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean visit[];
    static int end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visit = new boolean[n];
        end = m;

        for(int i = 0; i < n; i++){
            Arrays.fill(visit, false);
            sol(i, 1);
        }
    }

    public static void sol(int idx, int depth){
        visit[idx] = true;

        if(depth == end){
            printSol();
            return;
        }

        for(int i = idx+1; i < visit.length; i++){
            if(!visit[i]){
                sol(i, depth+1);
                visit[i] = false;
            }
        }
    }

    public static void printSol(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < visit.length; i++){
            if(visit[i]){
                sb.append(i+1).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
