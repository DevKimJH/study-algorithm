package studyAlgorithm.D220208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 테스트 케이스의 개수 T가 주어진다.
 *
 * 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.
 *
 * f(3)은 f(2)와 f(1)[첫 번째 호출]을 호출한다.
 * f(2)는 f(1)[두 번째 호출]과 f(0)을 호출한다.
 *
 * 두 번째 호출한 f(1)은 1을 출력하고 1을 리턴한다.
 * f(0)은 0을 출력하고 0을 리턴한다.
 *
 *
 */
public class b1003피보나치함수 {

    static class Node{

        Node(int number, int countZero, int countOne){
            this.number = number;
            this.countZero = countZero;
            this.countOne = countOne;
        }

        int number;
        int countZero;
        int countOne;
    }

    static Node[] dp = new Node[41];
    static int[] countArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++){
            int N = Integer.parseInt(br.readLine());
            countArr = new int[2];
            process(N);


            //System.out.println(countArr[0] + " " + countArr[1]);
        }

    }



    static void process(int N){
        dp[0] = new Node(0, 1, 0);
        dp[1] = new Node(1, 0, 1);

        for(int i = 2; i <= N ; i++){
            dp[i] = new Node(dp[i-2].number + dp[i-1].number, dp[i-2].countZero + dp[i-1].countZero, dp[i-2].countOne + dp[i-1].countOne);
        }

        System.out.println(dp[N].countZero + " " + dp[N].countOne);
    }

}
