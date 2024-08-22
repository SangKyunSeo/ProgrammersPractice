
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static char notUse[];
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        if(m > 0) {
            st = new StringTokenizer(br.readLine());
        }else{
            result = Math.min(Math.abs(n - 100), Integer.toString(n).length());
            System.out.println(result);
            return;
        }

        notUse = new char[m];

        for(int i = 0; i < notUse.length; i++){
            notUse[i] = st.nextToken().charAt(0);
        }

        if(n == 100){
            System.out.println(0);
            return;
        }

        if(m == 10){
            System.out.println(Math.abs(100 - n));
            return;
        }
        result = Math.min(result, Math.abs(100 - n));
        sol(n);
        System.out.println(result);
    }

    public static void sol(int n){
        for(int i = 0; i <= 999999; i++){
            check(i, Math.abs(n - i));
        }
    }

    public static void check(int n, int sum){
        String s = Integer.toString(n);
        char sArr[] = s.toCharArray();

        for(char c : sArr){
            for(char nc : notUse){
                if(c == nc) return;
            }
        }

        result = Math.min(result, sum + sArr.length);

    }

}
