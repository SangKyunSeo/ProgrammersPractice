
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 앞에 순서에서 구한 값을 이용해 도출할 수 있을것임 -> DP 자료구조일 것으로 보임
 * 1 -> 1
 * 2 -> 2
 * 3 -> 4
 * 4 -> 7
 * 5 -> 13
 * 6 -> 24 : 13 + 11 (앞에거 3개를 더해야함)
 */
public class Main {

    // static 변수 선언부
    private static int[] dp = null;
    private static final int[] INIT_VALUE = new int[]{1,2,4};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t > 0) {
            // 입력부
            int n = Integer.parseInt(br.readLine());

            // 솔루션 부
            solution(n);

            t--;
        }
    }

    private static void solution(int n){
        // dp 배열 초기화
        dp = new int[n];
        initDp();

        // 초기값 세팅한 영역의 값은 바로 출력
        if(dp[n - 1] > 0){
            printResult(dp[n - 1]);
            return;
        }

        for(int i = 3; i < n; i++){
           dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        printResult(dp[n - 1]);

    }

    private static void initDp(){
        for(int i = 0; i < INIT_VALUE.length; i++){
            if(i < dp.length){
                dp[i] = INIT_VALUE[i];
            }
        }
    }

    private static void printResult(int result){
        System.out.println(result);
    }

}
