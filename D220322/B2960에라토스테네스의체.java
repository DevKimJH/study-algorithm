package studyAlgorithm.D220322;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2960에라토스테네스의체 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int ans = 0;
        boolean[] chkFlag = new boolean[N+1];
        int cnt = 0;

        for(int i = 2 ; i <= N ; i++){
            if(cnt == K) return;
            for(int j = 1 ; j <= N/i ; j++){
                if(!chkFlag[i*j]){
                    chkFlag[i*j] = true;
                    ans = i * j;
                    cnt++;
                }

                if(cnt == K){
                    System.out.println(ans);
                    return;
                }
            }
        }
    }
}
