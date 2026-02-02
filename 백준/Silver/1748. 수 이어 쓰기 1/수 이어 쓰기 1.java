

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 10으로 나누면서 풀 수 있을것으로 보임
 * 2자리들은 10으로 나눴을때 몫이 10보다 작을거임. 그럼 10부터 해당 수 만큼은 2를 곱하고 한자릿수들은 더해주면됨
 * 조건문을 잘 작성할 것
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문제 입력부
        int n = Integer.parseInt(br.readLine());

        // 솔루션 부
        solution(n);
    }

    private static void solution(int n){
        int cdtNum = n; // 입력부 복사
        int digit = 10; // 10, 100, 1000,,,
        int size = 1; // 자릿수
        int result = 0; // 결과
        int subSum = 9;
        while(cdtNum > 9) {
            cdtNum = cdtNum / 10;

            if(cdtNum >= 10){
                size += 1;
                subSum = digit * 9 + subSum;
                result += (subSum - digit + 1) * size;
                digit *= 10;
            }else{
                break;
            }
        }

        if(n > 9){
            result += (n - digit + 1) * (size + 1) + 9;
        }else{
            result += n;
        }
        System.out.println(result);
    }
}
