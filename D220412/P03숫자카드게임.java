package studyAlgorithm.D220412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 숫자 카드 게임은 여러 개의 숫자 카드 중에서 가장 높은 숫자가 쓰인 카드 한 장을 뽑는 게임이다.
 단, 게임의 룰을 지키며 카드를 뽑아야 하고 룰은 다음과 같다.

 1. 숫자가 쓰인 카드들이 N * M 형태로 놓여 있다. 이때 N은 행의 개수를 의미, M은 열의 개수

 2. 먼저 뽑고자 하는 카드가 포함되어 있는 행을 선택한다.

 3. 그다음 선택된 행에 포함된 카드들 중 가장 숫자가 낮은 카드를 뽑아야 한다.

 4. 따라서 처음에 카드를 골라낼 행을 선택할 때, 이후에 해당 행에서 가장 숫자가 낮은 카드를 뽑을 것을 고려하여 최종적으로 가장 높은 숫자의 카드를 뽑을 수 있도록
    전략을 세워야 한다.

 ex) 3 * 3 형태로 카드들이 다음과 같이 놓여 있다
3 1 2
4 1 4
2 2 2

 여기서 카드를 골라낼 행을 고를 때 첫 번째 혹은 두번째 행을 선택하는 경우, 최종적으로 뽑는 카드는 1이다.
 하지만 세번째 행을 선택하는 경우 최종적으로 뽑는 카드는 2이다. 따라서 이 예제에서는 세 번째 행을 선택하여 숫자 2가 쓰여진 카드를 뽑는 것이 정답이다.
 카드들이 N*M형태로 놓여 있을 때, 게임의 룰에 맞게 카드를 뽑는 프로그램을 만드시오.

3 3
3 1 2
4 1 4
2 2 2
 ---
 2

2 4
7 3 1 8
3 3 3 4
 ---
 3
 */


public class P03숫자카드게임 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        // 숫자 카드들이 놓인 행의 개수
        int N = Integer.parseInt(st.nextToken());

        // 숫자 카드들이 놓인 열의 개수
        int M = Integer.parseInt(st.nextToken());



        // 카드 세팅
        int[][] cardArr = new int[N][M];
        int maxOfTotalMinNumber = Integer.MIN_VALUE;
        int rowIdx = 0;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            // 행 마다 가장 작은 수 찾기
            int minNumber = Integer.MAX_VALUE;
            for(int j = 0 ; j < M ; j++){
                int inputNumber = Integer.parseInt(st.nextToken());
                if(inputNumber < minNumber){
                    // 가장 작은수 넣기
                    minNumber = inputNumber;
                }
                cardArr[i][j] = inputNumber;
            }

            if(maxOfTotalMinNumber <= minNumber){
                maxOfTotalMinNumber = minNumber;
                rowIdx = i;
            }
        }

        System.out.println(maxOfTotalMinNumber);
    }
}
