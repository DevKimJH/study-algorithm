package studyAlgorithm.D220421;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 정수 X가 주어질 때 정수 X에 사용할 수 있는 연산은 다음과 같이 4가지이다.
 1. X가 5로 나누어떨어지면, 5로 나눈다.
 2. X가 3으로 나누어떨어지면, 3으로 나눈다.
 3. X가 2로 나누어떨어지면, 2로 나눈다.
 4. X에서 1을 뺀다.

 정수 X가 주어졌을 때, 연산 4개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

 정수가 26이면 다음과 같이 계산해서 3번의 연산이 최솟값이다.

 1. 26 - 1 = 25
 2. 25 / 5 = 5
 3. 5 / 5 = 1

 */


public class P1로만들기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int inputNumber = Integer.parseInt(br.readLine());

        // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
        int[] dp = new int[30001];
        dp[1] = 0;

        // 다이나믹 프로그래밍 진행(바텀업)
        for(int i = 2 ; i <= inputNumber ; i++){
            // 현재의 수에서 1을 빼는 경우
            dp[i] = dp[i-1] + 1;

            // 현재의 수가 2로 나누어 떨어지는 경우
            if(i % 2 == 0){
                //System.out.print(dp[i]);
                //System.out.print(dp[i/2]+1);
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }

            // 현재의 수가 3으로 나누어 떨어지는 경우
            if(i % 3 == 0){
                //System.out.print(dp[i]);
                //System.out.print(dp[i/3]+1);
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }

            // 현재의 수가 5로 나누어 떨어지는 경우
            if(i % 5 == 0){
                //System.out.print(dp[i]);
                //System.out.print(dp[i/5]+1);
                dp[i] = Math.min(dp[i], dp[i/5]+1);
            }
        }

        System.out.println(dp[inputNumber]);

        /*
        while(true){
            if(inputNumber % 5 == 0){
                inputNumber = inputNumber / 5;
            }
            else if(inputNumber % 3 == 0){
                inputNumber = inputNumber / 3;
            }
            else if(inputNumber % 2 == 0){
                inputNumber = inputNumber / 2;
            }
            else{
                inputNumber = inputNumber -1;
            }
        }

         */
    }
}
