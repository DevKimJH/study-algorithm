package studyAlgorithm.D220206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14501퇴사 {
    static int N;
    static int[] T;
    static int[] P;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // N+1 일째 되는 날 퇴사, N일동안 상담

        T = new int[N];
        P = new int[N];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }


        System.out.println(go(0, 0));
    }

    static int go(int day, int sum){
        if(day > N) return 0;
        if(day == N) return sum;
        int result = 0;
        int ans = 0;
        // 상담을 하는 경우
        result = go(day + T[day], sum + P[day]);

        if(ans < result) ans = result;

        // 상담을 하지 않는 경우
        result = go(day + 1 , sum);

        if(ans< result) ans = result;

        return ans;
    }
}
