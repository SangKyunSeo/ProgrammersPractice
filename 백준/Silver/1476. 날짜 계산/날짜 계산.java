
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 각 숫자의 제한수 만큼 조건을 주어 계속 더하면서 값을 조정하는 방법이 있음
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력부 세팅
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 솔루션 부
        solution(E, S, M);
    }

    private static void solution(int E, int S, int M){
        int startE = 1;
        int startS = 1;
        int startM = 1;
        int result = 1;

        while(true){

            // 조건 검색부
            if(startE == E && startS == S && startM == M){
                System.out.println(result);
                return;
            }

            startE += 1;
            startS += 1;
            startM += 1;

            startE = startE % 16 == 0 ? 1 : startE % 16;
            startS = startS % 29 == 0 ? 1 : startS % 29;
            startM = startM % 20 == 0 ? 1 : startM % 20;

            result += 1;

        }
    }
}
