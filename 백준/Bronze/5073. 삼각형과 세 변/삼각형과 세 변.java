import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static String E = "Equilateral";
    private static String I = "Isosceles";
    private static String S = "Scalene";
    private static String X = "Invalid";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a, b, c, sum = 0, max = 0;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            sum = a + b + c;
            max = a;
            if(a == 0 && b == 0 && c == 0) return;

            if(a == b && b == c){
                System.out.println(E);
                continue;
            }

            if(max < b) max = b;
            if(max < c) max = c;

            if(sum - max <= max){
                System.out.println(X);
            }else{
                if(a == b && b != c || a == c && c != b || b == c && b != a){
                    System.out.println(I);
                    continue;
                }

                if(a != b && b != c && a != c){
                    System.out.println(S);
                }
            }
        }
    }
}