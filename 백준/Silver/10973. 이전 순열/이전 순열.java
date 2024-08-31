/**
 * Subject : BruteForce
 * Problem Number : 10973
 * Title : 이전 순열
 * Solution Trial Date : 2024-08-31
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        inputData();
        int target = findBigSpot();

        if(target == -1){
            System.out.println(-1);
            return;
        }

        changeNumbers(target);
        sortArray(target);
        printResult();
    }

    // 데이터 입력
    public static void inputData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[n];

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    // 변경 대상 인덱스 찾기 -> 배열의 뒤부터 탐색하며 오름차순이 되는 그 지점을 찾음
    public static int findBigSpot(){
        int idx = -1;
        for(int i = numbers.length - 1; i > 0; i--){
            if(numbers[i] < numbers[i - 1]){
                idx = i - 1;
                break;
            }
        }

        return idx;
    }

    // 뒤에서 가장 큰 값을 찾아 타겟 인데스와 바꿈
    public static void changeNumbers(int idx){
        int max = numbers[idx + 1];
        int index = idx + 1;

        for(int i = idx + 2; i < numbers.length; i++){
            if(max < numbers[i] && numbers[i] < numbers[idx]){
                max = numbers[i];
                index = i;
            }
        }

        swap(idx, index);
    }

    public static void sortArray(int idx){
        int startIdx = idx + 1;
        int endIdx = numbers.length - 1;

        while(startIdx < endIdx){
            swap(startIdx++, endIdx--);
        }
    }

    public static void swap(int idx1, int idx2){
        int temp = numbers[idx1];
        numbers[idx1] = numbers[idx2];
        numbers[idx2] = temp;
    }

    public static void printResult(){
        StringBuilder sb = new StringBuilder();
        for(int i : numbers){
            sb.append(i);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
    }
}
