package studyAlgorithm.M2207.D17;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2742 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = N ; i >= 1 ; i--){
            System.out.println(i);
        }
    }
}
