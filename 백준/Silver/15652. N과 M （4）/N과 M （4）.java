
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int solution[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        solution = new int[m];

        sol(1, n, 0, m);
        System.out.println(sb);
    }

    public static void sol(int idx, int size, int depth, int end){

        if(depth == end){
            printResult();
            return;
        }

        for(int i = idx; i <= size; i++){
            solution[depth] = i;
            sol(i, size, depth + 1, end);
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

