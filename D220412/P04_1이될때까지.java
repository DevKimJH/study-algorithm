package studyAlgorithm.D220412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고 한다. 단, 두 번째 연산은 N이 K로 나누어 떨어질 때만 선택할 수 있다.

 1. N에서 1을 뺀다.
 2. N을 K로 나눈다.

 ex)
 N이 17, K가 4라고 가정하자. 이때 1번의 과정을 한 번 수행하면 N은 16이 된다. 이후에 2번의 과정을 두 번 수행하면 N은 1이 된다.
 결과적으로 이 경우 전체 과정을 실행한 횟수는 3이다. 이는 N을 1로 만드는 최소 횟수이다.



 */

public class P04_1이될때까지 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());

        int idx = 0;

        while(true){
            if(N % K == 0){
                N = N / K;
            }
            else{
                N = N-1;
            }

            idx++;

            if(N == 1){
                break;
            }
        }

        System.out.println(idx);

    }
}
