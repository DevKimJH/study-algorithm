package studyAlgorithm.M2207.D24;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B5522 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        for(int i = 0 ; i < 5 ; i++){
            int inputNum = Integer.parseInt(br.readLine());
             answer = answer + inputNum;
        }

        System.out.println(answer);
    }
}
