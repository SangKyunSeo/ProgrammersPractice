
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int max = s.length();
        int n = Integer.parseInt(s);
        int count = 1;
        int result = 0;

        // 1의 자리 수 일때
        if(n < 10){
            System.out.println(n);
            return;
        }

        // 2의 자리 수 일때
        if(n < 100){
            System.out.println(9 + (n - 10 + 1) * 2);
            return;
        }

        for(int i = 2; i <= max-1; i++){
            count = count * 10;
            result += count * 9 * i;
        }
        result += (n - (count * 10) + 1) * max;
        System.out.println(result + 9);

    }
}
