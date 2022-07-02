package studyAlgorithm.M2207.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
TEST(1)
5 8 3
2 4 5 4 6
---
46

TEST(2)
5 7 2
3 4 3 4 3
---
28
 */

public class P큰수의법칙 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 배열의 크기
        int N = Integer.parseInt(st.nextToken());
        int[] numberArr = new int[N];

        // 숫자가 더해지는 횟수
        int M = Integer.parseInt(st.nextToken());

        // 최대 연속해서 합할 수 있는 횟수
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            numberArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numberArr);


        int exceptCount = M / K;

        int answer = numberArr[N-1] * (M - exceptCount) + numberArr[N-2] * exceptCount;

        System.out.println(answer);
    }
}
