package studyAlgorithm.D220329;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
 */
public class B11047동전0 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        st = new StringTokenizer(br.readLine(), " ");

        // 동전의 종류
        int N = Integer.parseInt(st.nextToken());

        // 동전의 정보를 담을 array 세팅
        int[] coinArray = new int[N];

        // 동전으로 만들어야 하는 금액
        int K = Integer.parseInt(st.nextToken());

        // 총 동전 갯수
        int totalCoinCount = 0;

        for(int i = 0 ; i < N ; i++){
            coinArray[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N-1 ; i >= 0 ; i--){
            // 금액이 현재 돈으로 나누어지면
            if(K / coinArray[i] >= 1){
                int coinCount = K / coinArray[i];
                totalCoinCount += coinCount;
                K = K - (coinArray[i] * coinCount);
            }

            if(K == 0){
                break;
            }
        }

        System.out.println(totalCoinCount);
    }
}
