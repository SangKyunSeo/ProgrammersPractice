
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 삼중 포문을 사용해 전체 탐색을 진행 할 수 있음
 * 행과 열로 바꾸기 가능
 * 행(세로)으로 바꾸게 된다면 해당 열 1개 검사, 바뀐 행 2개 검사
 * 열(가로)으로 바꾸게 된다면 해당 행 1개 검사, 바뀐 열 2개 검사
 * 행 검사 : 왼쪽부터 첫번째 값 기준으로 다음 값이랑 같으면 개수 증가, 다음 값이 다르면 기준을 그 값으로 바꾸고 개수는 1로 초기화
 * 열 검사 : 위부터 첫번째 값 기준으로 다음 값이랑 같으면 개수 증가, 다음 값이 다르면 기준을 그 값으로 바꾸고 개수는 1로 초기화
 * 반복문으로 오른쪽, 아래 값을 스위칭 할 것이기에 끝까지 안가도됨
 * 이렇게 바꾸는 작업에서 이중 포문이 들어가고 그안에 포문을 통해 행, 열 개수를 세는 작업을 해야함 -> 비효율적인데,,,,
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문제 입력부
        int n = Integer.parseInt(br.readLine()); // 배열 개수 세팅
        String[][] map = new String[n][n]; // 배열 세팅
        for(int i = 0; i < n; i++){ // 배열 값 세팅
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < n; j++){
                map[i][j] = Character.toString(input[j]);
            }
        }

        // 문제 솔루션 부
        solution(map, n);
    }

    public static void solution(String[][] map, int n){
        String[][] copyMap = new String[map.length][];
        for(int i = 0; i < map.length; i++){
            copyMap[i] = map[i].clone();
        }
        int result = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // 행 스위치 (세로 2개 변경)
                if(i < n - 1){ // 마지막 행이 아닌 경우
                    String basis = copyMap[i][j]; // 기준 값
                    copyMap[i][j] = copyMap[i+1][j];
                    copyMap[i+1][j] = basis;

                    // 열 개수 검사 , 행 개수 검사
                    int sum1 = 1;
                    int sum2 = 1;
                    int sum3 = 1;
                    String start1 = copyMap[i][0];
                    String start2 = copyMap[i+1][0];
                    String start3 = copyMap[0][j];
                    for(int k = 1; k < n; k++){
                        if(copyMap[i][k].equals(start1)){// 첫번째 행의 열 기준값과 같다면
                            sum1 += 1;
                            result = Math.max(sum1, result);
                        }else{ // 첫번째 행의 열 기준값과 다르다면
                            sum1 = 1;
                            start1 = copyMap[i][k];
                        }

                        if(copyMap[i+1][k].equals(start2)){ // 두번째 행의 열 기준값과 같다면
                            sum2 += 1;
                            result = Math.max(result, sum2);
                        }else{ // 두번쨰 행의 열 기준값과 다르다면
                            sum2 = 1;
                            start2 = copyMap[i+1][k];
                        }

                        if(copyMap[k][j].equals(start3)){ // 첫번째 행의 기준값과 같다면
                            sum3 += 1;
                            result = Math.max(result, sum3);
                        }else{
                            sum3 = 1;
                            start3 = copyMap[k][j];
                        }
                    }

                    // 바꾼 2값 원상태로 복구
                    copyMap[i+1][j] = copyMap[i][j];
                    copyMap[i][j] = basis;

                }


                // 열 스위치 (가로 2개 변경)
                if(j < n - 1){ // 마지막 열이 아닌경우 (마지막 열은 바꿀 다음 열이 없음)
                    String basis = copyMap[i][j];
                    copyMap[i][j] = copyMap[i][j+1];
                    copyMap[i][j+1] = basis;

                    // 행 개수 검사 , 열 개수 검사
                    int sum1 = 1;
                    int sum2 = 1;
                    int sum3 = 1;
                    String start1 = copyMap[0][j];
                    String start2 = copyMap[0][j+1];
                    String start3 = copyMap[i][0];

                    for(int k = 1; k < n; k++){
                        if(copyMap[k][j].equals(start1)){ // 첫번째 열의 행 값과 같다면
                            sum1 += 1;
                            result = Math.max(result, sum1);
                        }else{
                            sum1 = 1;
                            start1 = copyMap[k][j];
                        }

                        if(copyMap[k][j+1].equals(start2)){ // 두번째 열의 행 값과 같다면
                            sum2 += 1;
                            result = Math.max(result, sum2);
                        }else{
                            sum2 = 1;
                            start2 = copyMap[k][j+1];
                        }

                        if(copyMap[i][k].equals(start3)){ // 해당번쨰의 첫번째 열 값으로 부터 검사
                            sum3 += 1;
                            result = Math.max(result, sum3);
                        }else{
                            sum3 = 1;
                            start3 = copyMap[i][k];
                        }
                    }

                    // 바꾼 2개의 열 값 원상복구
                    copyMap[i][j+1] = copyMap[i][j];
                    copyMap[i][j] = basis;
                }
            }
        }

        System.out.println(result);

    }

    private static void print(String[][] map){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }


}
