import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        int n;
        long cnt;
        long number;
        while((s = br.readLine()) != null) {
            n = Integer.parseInt(s);
            number = 1;
            cnt = 1;
            while (true) {
                if(number % n == 0){
                    System.out.println(cnt);
                    break;
                }
                number = (number * 10) + 1;
                number %= n;
                cnt++;
            }
        }
    }
}