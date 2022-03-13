package studyAlgorithm.D220311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2960에라토스테네스의체 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " " );

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[N+1];

        // 1. 2부터 N까지 모든 정수를 적는다.

        // 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고
        // 이 수는 소수이다.
        int idx = 2;
        int countDelete = 0;
        while(true){

            boolean flag = check(idx);

            if(flag){
                for(int i = idx ; i <= N ; i+=idx){
                    if(arr[i] == false){
                        arr[i] = true;
                        countDelete++;

                        if(countDelete == K){
                            System.out.print(i);
                        }
                    }
                }
            }

            idx++;

            if(idx > N){
                break;
            }
        }
    }

    static boolean check(int N){
        for(int i = 2 ; i * i <= N ; i++){
            if(N % i == 0){
                return false;
            }
            else{
                continue;
            }
        }

        return true;
    }
}
