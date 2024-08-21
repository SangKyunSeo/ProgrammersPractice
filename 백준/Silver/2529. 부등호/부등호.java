
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static char[] command;
    static int[] result;
    static List<String> resultList = new ArrayList<>();

    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        command = new char[n];
        result = new int[n + 1];
        visit = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < command.length; i++){
            command[i] = st.nextToken().charAt(0);
        }

        sol(0, 0, n);

        Collections.sort(resultList);
        System.out.println(resultList.get(resultList.size() - 1));
        System.out.println(resultList.get(0));

    }

    public static void sol(int depth, int start, int end){
        if(depth > end){
            getMaxResult();
            return;
        }

        for(int i = 0; i <= 9; i++){
            if(depth == 0 || check(i, start)){
                if(!visit[i]){
                    visit[i] = true;
                    result[depth] = i;
                    sol(depth+1, start+1, end);
                    visit[i] = false;
                }

            }
        }
    }

    public static boolean check(int number, int idx){
        if(command[idx - 1] == '<'){
            if(result[idx - 1] < number) return true;
            return false;
        }else{
            if(result[idx - 1] > number) return true;
            return false;
        }
    }

    public static void getMaxResult(){
        StringBuilder sb = new StringBuilder();
        for(int i : result){
            sb.append(i);
        }
        resultList.add(sb.toString());
    }
}
