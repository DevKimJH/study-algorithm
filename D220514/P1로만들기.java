package studyAlgorithm.D220514;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1로만들기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int X = Integer.parseInt(br.readLine());

        int[] dp = new int[30001];

        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 1;

        for(int i = 6 ; i <= X ; i++){
            int compareValue = Integer.MAX_VALUE;
            //int value = 0;

            if(i % 2 == 0){
                compareValue = Math.min(compareValue, dp[i/2] +1);
            }

            if(i % 3 == 0){
                compareValue = Math.min(compareValue, dp[i/3]+1);
            }

            if(i % 5 == 0){
                compareValue = Math.min(compareValue, dp[i/5]+1);
            }

            compareValue = Math.min(compareValue, dp[i-1]+1);

            dp[i] = compareValue;
        }

        System.out.println(dp[X]);
    }


}
