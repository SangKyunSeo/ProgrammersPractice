
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1. 이중 포문을 사용해 전체 탐색을 진행 할 수 있음
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문제 입력부
        int max = 9;
        int numbers[] = new int[max];
        int totalSum = 0;
        for(int i = 0; i < max; i++){
            int num = Integer.parseInt(br.readLine());
            numbers[i] = num;
            totalSum += num;
        }

        // 문제 솔루션 부
        solution(numbers, totalSum, max);
    }

    public static void solution(int[] numbers, int totalSum, int max){
        int[] copyNumbers = numbers.clone();
        for(int i = 0; i < max - 1; i++){
            int subSum = numbers[i];
            for(int j = i+1; j < max; j++){
                subSum += numbers[j];

                if(totalSum - subSum == 100){
                    copyNumbers[i] = -1;
                    copyNumbers[j] = -1;

                    Arrays.sort(copyNumbers);
                    for(int item : copyNumbers){
                        if(item == -1) continue;
                        System.out.println(item);
                    }
                    return;
                }
                subSum -= numbers[j];
            }
        }
        
    }

}
