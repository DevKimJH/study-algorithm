package studyAlgorithm.D220505;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class P이취코_시각 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        //int H = N / 3600;
        //int M = N % 3600 / 60;
        //int S = N % 60;
        //System.out.println(H);
        //System.out.println(M);
        //System.out.println(S);

        int toNumber = (N * 3600) + (59 * 60) + 59;

        System.out.println(toNumber);
        int answer = 0;
        int number = 0;
        while(toNumber > number){
            int H = number / 3600;      // 정수를 시간단위로 변환
            int M = number % 3600 / 60; // 정수를 분단위로 변환
            int S = number % 60;        // 정수를 초단위로 변환

            String time = H + "" + M + "" + S;

            for(int i = 0; i < time.length() ; i++){
                if(time.charAt(i) == '3'){
                    answer++;
                    break;
                }
            }

            number++;
        }

        System.out.println(answer);
    }
}
