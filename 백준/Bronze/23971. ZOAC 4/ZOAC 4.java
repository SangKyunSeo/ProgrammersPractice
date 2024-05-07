import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigDecimal result = new BigDecimal("0");
        int colCnt = 0;
        int rowCnt = 0;

        for(int i = 0; i < h; i += n + 1){
            rowCnt++;
        }

        for(int i = 0; i < w; i += m + 1){
            colCnt++;
        }

        result = BigDecimal.valueOf(colCnt * rowCnt);
        System.out.println(result);
    }
}