/**
 * Subject : BruteForce
 * Problem Number : 10974
 * Title : 모든 순열
 * Solution Trial Date : 2024-08-31
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] visit;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visit = new boolean[n];
        arr = new int[n];
        sol(0, n);
        System.out.println(sb);
    }

    public static void sol(int depth, int end){
        if(depth == end){
            printResult();
        }

        for(int i = 0; i < visit.length; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i + 1;
                sol(depth + 1, end);
                visit[i] = false;
            }
        }
    }

    public static void printResult(){
        for(int i : arr){
            sb.append(i);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n");
    }

}
