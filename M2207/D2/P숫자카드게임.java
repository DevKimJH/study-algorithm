package studyAlgorithm.M2207.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
TEST(1)
3 3
3 1 2
4 1 4
2 2 2

TEST(2)
2 4
7 3 1 8
3 3 3 4

 */
public class P숫자카드게임 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 행
        int N = Integer.parseInt(st.nextToken());

        // 열
        int M = Integer.parseInt(st.nextToken());

        int answer = Integer.MIN_VALUE;

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int minNumber = Integer.MAX_VALUE;
            for(int j = 0 ; j < M ; j++){
                int inputNumber = Integer.parseInt(st.nextToken());

                // 행에서 가장 작은 수 찾기
                if(inputNumber < minNumber) minNumber = inputNumber;
            }

            if(answer < minNumber ) answer = minNumber;
        }

        System.out.println(answer);
    }
}
