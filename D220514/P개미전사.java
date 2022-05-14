package studyAlgorithm.D220514;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 - 왼쪽부터 차례대로 식량창고를 털지 안 털지를 결정하는 경우
 - 특정한 i번째 식량창고에 대해서 털지 안 털지의 여부를 결정 ?

 ai = max(ai-1, ai_2 + ki)
 */
public class P개미전사 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " " );

        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[100];
        
        // 다이나믹 프로그래밍 진행
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for(int i = 2 ; i < N ; i++){
            dp[i] = Math.max(dp[i-1] , dp[i-2] + arr[i]);
        }

        System.out.println(dp[N-1]);
    }
}
