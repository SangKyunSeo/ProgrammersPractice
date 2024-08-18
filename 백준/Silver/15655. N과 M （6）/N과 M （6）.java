
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int numbers[];
    static int solution[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        solution = new int[m];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        sol(0, 0, m);
        System.out.println(sb);
    }

    public static void sol(int idx, int depth, int end){
        if(depth == end){
            printResult();
            return;
        }

        for(int i = idx; i < numbers.length; i++){
            solution[depth] = numbers[i];
            sol(i+1, depth+1 ,end);
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

