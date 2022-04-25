package studyAlgorithm.D220425;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 가로의 길이가 N, 세로의 길이가 2인 직사각형 형태의 얇은 바닥이 있음. 태일이는 이 얇은 바닥을
 1 * 2 의 덮개, 2 * 1 의 덮개, 2 * 2의 덮개를 이용해 채우고자 한다.

 이때 바닥을 채우는 모든 경우의 수를 구하는 프로그램을 작성하기. 예를 들어 2 * 3 크기의 바닥을 채우는 경우의 수는 5가지이다.
 */

public class P바닥공사 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3 ; i <= N ; i++){
            dp[i] = dp[i-1] + dp[i-2] * 2;
        }

        System.out.println(dp[N]);

    }
}
