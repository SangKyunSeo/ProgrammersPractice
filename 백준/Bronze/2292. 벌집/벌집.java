

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int init = 1;
        int cnt = 1;
        while(true){
            if(n == 1){
                System.out.println(1);
                return;
            }

            int max = init + cnt * 6;
            if(n <= max){
                System.out.println(cnt + 1);
                return;
            }

            init = max;
            cnt++;
        }

    }
}
