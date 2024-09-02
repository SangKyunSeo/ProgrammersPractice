/**
 * Subject : BruteForce
 * Problem Number : 6603
 * Title : 로또
 * Solution Trial Date : 2024-09-02
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());


            if(size == 0) {
                System.out.println(sb);
                return;
            }

            int[] numbers = new int[size];
            int[] result = new int[6];
            for(int i = 0; i < numbers.length; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            sol(0,0, 6, numbers, result, sb);
            sb.append("\n");
        }
    }

    public static void sol(int depth, int idx, int size, int[] numbers, int[] result, StringBuilder sb){
        if(depth == size){
            printResult(result, sb);
            return;
        }

        for(int i = idx; i < numbers.length; i++){
            result[depth] = numbers[i];
            sol(depth + 1, i + 1, size, numbers, result, sb);
        }
    }

    public static void printResult(int[] result, StringBuilder sb){
        for(int i = 0; i < result.length; i++){
            sb.append(result[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n");
    }
}
