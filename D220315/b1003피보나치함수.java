package studyAlgorithm.D220315;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 fibonacci(n) 을 호출했을 때 0과 1이 각각 몇 번 출력되는지 구하는 프로그램?
 */
public class b1003피보나치함수 {

    static int[][] memo = new int[41][2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        //memo[0] = 0;
        //memo[1] = 1;

        memo[0][0] = 1;
        memo[0][1] = 0;
        memo[1][0] = 0;
        memo[1][1] = 1;
        memo[2][0] = 0;
        memo[2][1] = 2;


        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        for(int i = 2; i <= 40 ; i++){
            memo[i][0] = memo[i-1][0] + memo[i-2][0];
            memo[i][1] = memo[i-1][1] + memo[i-2][1];
        }


        // N
        for(int i = 0 ; i < T ; i++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(memo[N][0] + " " + memo[N][1]);
        }
    }
}

/*
fib 1 : 1
fib 2 : 1
fib 3 : 2
fib 4 : 3
*/