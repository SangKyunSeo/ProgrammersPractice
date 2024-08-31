/**
 * Subject : BruteForce
 * Problem Number : 10972
 * Title : 다음 순열
 * Solution Trial Date : 2024-08-29
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] numbers;

    public static void main(String[] args) throws IOException {

        inputData();
        int target = findSmallSpot(); // 다음 차례 순열은 배열의 뒤부터 내림차순이 되는 지점을 찾는다. 그 지점의 값과 배열의 뒤에서 그 지점의 값보다 큰것중 제일 작은 값과 바꾼다

        if(target == -1){
            System.out.println(-1);
            return;
        }

        changeNumbers(target);
        sortArray(target);
        printResult();

    }
    public static void inputData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[n];

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    // 다음 순열을 구하기 위한 배열의 뒤부터 내림차순이 되는 그 지점을 찾음 -> 바뀌는 대상의 index를 반환
    public static int findSmallSpot(){
        int idx = -1;
        for(int i = numbers.length - 1; i > 0; i--){
            if(numbers[i] > numbers[i-1]){
                idx = i - 1;
                break;
            }
        }
        return idx;
    }

    // 바꿀 대상의 index의 배열 값보다 큰 것중 가장 작은 값과 바꾼다.
    public static void changeNumbers(int idx){
        int min = numbers[idx + 1];
        int index = idx + 1;
        for(int i = idx + 2; i < numbers.length; i++){
            if(min > numbers[i] && numbers[i] > numbers[idx]){
                index = i;
                min = numbers[i];
            }
        }

        swap(idx,index);
    }

    // 값을 바꾼후 대상 index 뒤로 정렬을 해야함.
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
        for(int i : numbers){
            sb.append(i);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

}
