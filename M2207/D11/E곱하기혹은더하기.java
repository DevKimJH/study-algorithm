package studyAlgorithm.M2207.D11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E곱하기혹은더하기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int lengthOfString = S.length();
        int answer = 0;


        for(int i = 0 ; i < lengthOfString; i++){
            int number = Integer.valueOf(S.substring(i, i+1));
            // if(number == 0 || answer == 0 || number == 1 || answer == 1){
            if(number <= 1 || answer <= 1){
                answer = answer + number;
            }
            else{
                answer = answer * number;
            }
        }
        System.out.print(answer);
    }
}
