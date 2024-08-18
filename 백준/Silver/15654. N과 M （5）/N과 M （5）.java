
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] solution;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int map[] = new int[n];
        solution = new int[m];
        visit = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < map.length; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);

        sol(0, 0, m, map);
        System.out.println(sb);
    }

    public static void sol(int idx, int depth, int end, int[] map){
        if(depth == end){
            printResult();
            return;
        }

        for(int i = 0; i < map.length; i++){
            if(!visit[i]){
                visit[i] = true;
                solution[depth] = map[i];
                sol(i+1, depth+1, end, map);
                visit[i] = false;
            }
        }
    }

    public static void printResult(){
        for(int i : solution){
            sb.append(i);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n");
    }
}
