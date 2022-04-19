package studyAlgorithm.D220419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 주에서 3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램 작성
 ex) 1을 입력했을 때 다음은 3이 하나라도 포함되어 있으므로 세어야 하는 시각.

 - 00시 00분 03초
 - 00시 13분 30초

 다음은 3이 하나도 포함되어 있지 않으므로 세면 안 되는 시각

 - 00시 02분 55초
 - 01시 27분 45초

 */

public class P04_2시각 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 입력되는 정수 N
        int N = Integer.parseInt(br.readLine());
        String s = String.format("%02d", N);
        String maxNumber = s + "5959";

        //int N = Integer.parseInt(br.readLine());

        //000000~XX5959

        int answer = 0;
        //String number = "0";

        outloop:for(int i = 0 ; i < N+1 ; i++){
            for(int j = 0 ; j < 60 ; j++){
                for(int k = 0 ; k < 60 ; k++){
                    String number = String.valueOf(i) + String.valueOf(j) + String.valueOf(k);

                    if(number.contains("3")){
                        answer++;
                    }

                    if (Integer.parseInt(number) > Integer.parseInt(maxNumber)) {
                        break outloop;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
