import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int n = 0;
        for(int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            long diff = 0;
            int buy[] = new int[n];

            for (int i = 0; i < n; i++)
                buy[i] = sc.nextInt();

            int max_value = buy[n-1];

            for(int i=n-1;i>=0;i--){
                if(max_value-buy[i]>0)
                    diff+=max_value-buy[i];
                if(max_value<buy[i])
                    max_value = buy[i];
            }

            System.out.println("#"+test_case+" "+diff);
        }
    }
}