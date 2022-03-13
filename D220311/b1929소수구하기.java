package studyAlgorithm.D220311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1929소수구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " " );

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] array = new boolean[N+1];

        array[0] = array[1] = true;

        // M부터 N까지 체크
        for(int i = 2 ; i <= N ; i++){
            // i가 소수면
            boolean flag = check(i);
            if(flag){
                // i만큼 증가하면서 N까지 제거
                for(int j = i+i ; j <= N ; j+=i){
                    array[j] = true;
                }
            }
        }

        for(int i = M ; i <= N ; i++){
            if(array[i] == false){
                System.out.println(i);
            }
        }
    }


    static boolean check(int number){
        if(number < 2){
            return false;
        }

        for(int i = 2 ; i * i <= number ; i++){
            if(number % i == 0){
                return false;
            }
            else{
                continue;
            }
        }

        return true;
    }
}
