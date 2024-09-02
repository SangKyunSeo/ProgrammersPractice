/**
 * Subject : BruteForce
 * Problem Number : 10819
 * Title : 차이를 최대로
 * Solution Trial Date : 2024-09-02
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result = Integer.MIN_VALUE;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int numbers[] = new int[n];
        visit = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        sol(0, 0, n, numbers, 0);
        System.out.println(result);
    }

    public static void sol(int sum, int depth, int end, int[] numbers, int preValue){
        if(depth == end){
            result = Math.max(result, sum);
            return;
        }

        for(int i = 0; i < numbers.length; i++){
            if(!visit[i] && depth != 0){
                visit[i] = true;
                sol(sum + Math.abs(preValue - numbers[i]), depth + 1, end, numbers, numbers[i]);
                visit[i] = false;
            }

            if(!visit[i] && depth == 0){
                visit[i] = true;
                sol(0, depth + 1, end, numbers, numbers[i]);
                visit[i] = false;
            }
        }
    }
}
