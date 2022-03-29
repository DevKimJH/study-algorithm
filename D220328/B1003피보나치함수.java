package studyAlgorithm.D220328;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1003피보나치함수 {

    static int[][] memo = new int[41][2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스의 수
        int T = Integer.parseInt(br.readLine());

        memo[0][0] = 1;
        memo[0][1] = 0;
        memo[1][0] = 0;
        memo[1][1] = 1;

        for(int i = 2 ; i <= 40 ; i++){
            memo[i][0] = memo[i-2][0] + memo[i-1][0];
            memo[i][1] = memo[i-2][1] + memo[i-1][1];
        }

        for(int i = 0 ; i < T ; i++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(memo[N][0] + " " + memo[N][1]);
        }
    }
}
