package studyAlgorithm.M2207.D11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E1이될때까지 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;

        while(N != 1){
            if(N % K == 0){
                N = N / K;
            }
            else{
                N = N-1;
            }
            answer++;
        }

        System.out.println(answer);
    }
}
