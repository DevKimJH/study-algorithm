package studyAlgorithm.D220428;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14501퇴사방법2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N];
        int[] P = new int[N];
        int[] dp = new int[N];
        int maxValue = 0;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(go(0, 0, N, T, P));
    }

    static int go(int day, int sum, int N, int[] T, int[] P){
        if(day > N) return 0;
        if(day == N) return sum;
        int result = 0;
        int ans = 0;

        // 상담을 하는 경우
        result = go(day + T[day], sum + P[day], N, T, P);

        if(ans < result) ans = result;

        // 상담을 하지 않는 경우
        result = go(day+1, sum, N, T, P);

        if(ans < result) ans = result;

        return ans;
    }
}
