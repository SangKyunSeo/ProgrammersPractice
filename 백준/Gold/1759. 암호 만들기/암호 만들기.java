
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static char[] map;
    static StringBuilder sb = new StringBuilder();

    static char[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new char[c];
        result = new char[l];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < map.length; i++){
            map[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(map);

        sol(0,0, l);
        System.out.println(sb);
    }

    public static void sol(int depth,int idx, int end){
        if(depth == end){
            if(checkValidate()) printResult();
            return;
        }

        for(int i = idx; i < map.length; i++){
            result[depth] = map[i];
            sol(depth+1, i+1, end);
        }


    }

    public static boolean checkValidate(){
        int mo = 0;
        int za = 0;
        for(char c : result){
            if(c == 'a') mo++;
            else if(c == 'e') mo++;
            else if(c == 'i') mo++;
            else if(c == 'o') mo++;
            else if(c == 'u') mo++;
            else za++;
        }

        if(mo >= 1 && za >= 2) return true;
        return false;
    }

    public static void printResult(){
        for(char c : result){
            sb.append(c);
        }
        sb.append("\n");
    }


}
