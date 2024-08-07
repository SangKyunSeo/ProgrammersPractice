import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = Integer.parseInt(br.readLine());
        int numbers[] = new int[count];
        int midIdx = 0;

        st =  new StringTokenizer(br.readLine());
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 배열의 오름차순 정렬
        Arrays.sort(numbers);
        // 진짜의 약수의 개수가 홀수인지 짝수인지 분기 처리
        if(count % 2 == 0){ // 짝수
            midIdx = count / 2;
            System.out.println(Long.valueOf(numbers[midIdx - 1] * numbers[midIdx]));
        }else{ // 홀수
            if(count == 1){
                System.out.println(Long.valueOf(numbers[0] * numbers[0]));
                return;
            }
            midIdx = count / 2;
            System.out.println(Long.valueOf(numbers[midIdx] * numbers[midIdx]));
        }
    }
}