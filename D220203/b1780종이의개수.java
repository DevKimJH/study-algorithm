package studyAlgorithm.D220203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다. 우리는 이 행렬을 다음과 같은 규칙에 따라 적절한 크기로 자르려고 한다.

 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
 (1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
 이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.

 * 입력
 첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.

 * 출력
 *


 */
public class b1780종이의개수 {
    static int[] answer = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        process(arr, N, 0, 0);


        for(int i = 0 ; i < 3 ; i++){
            System.out.println(answer[i]);
        }
    }

    static void process(int[][] arr, int N, int y, int x){

        int num = arr[y][x];
        boolean chkDiff = false;

        for(int i = y ; i < y+N ; i++){
            for(int j = x ; j < x+N ; j++){
                if(num != arr[i][j]){
                    chkDiff = true;
                    break;
                }
            }

            if(chkDiff) break;
        }

        /*
        if(chkDiff){
            for(int i = y ; i < y+3 ; i++){
                for(int j = x ; j < x+3 ; j++){
                    // 0, 0
                    // 0, 3
                    // 0, 6
                    // 3, 0
                    // 3, 3
                    // 3, 6
                    // 6, 0
                    // 6, 3
                    // 6, 6
                    process(arr, N/3, i * N/3, j * N/3);
                }
            }
        }
        */
        if(chkDiff){
            for(int i = 0 ; i < 3 ; i++){
                for(int j = 0 ; j < 3 ; j++){
                    process(arr, N/3, y + ((N/3) * i), x + ((N/3) * j));
                }
            }
        }
        else if(!chkDiff){
            answer[num+1] += 1;
        }
    }
}

