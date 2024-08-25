/**
 * Subject : BruteForce
 * Problem Number : 1759
 * Title : 암호 만들기
 * Solution Trial Date : 2024-08-25
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[] map;
    static char[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        map = new char[c];
        result = new char[l];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < map.length; i++){
            map[i] = st.nextToken().toString().charAt(0);
        }

        Arrays.sort(map);

        sol(0,0, l);
        System.out.println(sb);
    }

    public static void sol(int idx, int depth, int end){
        if(depth == end){
            // 한 개 이상 모음 두 개 이상 자음 검사
            if(check()){
                // 조건 통과 시 print
                printResult();
                return;
            }
            return;
        }

        for(int i = idx; i < map.length; i++){
            result[depth] = map[i];
            sol(i+1, depth + 1, end);
        }
    }

    public static boolean check(){
        int[] count = checkCount();
        if(count[0] >= 1 && count[1] >= 2) return true;
        return false;
    }

    public static int[] checkCount(){
        int[] count = new int[2];
        for(char c : result){
            switch(c){
                case 'a':
                    count[0]++;
                    break;
                case 'e':
                    count[0]++;
                    break;
                case 'i':
                    count[0]++;
                    break;
                case 'o':
                    count[0]++;
                    break;
                case 'u':
                    count[0]++;
                    break;
                default:
                    count[1]++;
                    break;
            }
        }
        return count;
    }

    public static void printResult(){
        for(char c : result){
            sb.append(c);
        }
        sb.append("\n");
    }
}
