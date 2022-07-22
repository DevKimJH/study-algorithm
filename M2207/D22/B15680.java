package studyAlgorithm.M2207.D22;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B15680 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputStr = br.readLine();

        if(inputStr.equals("0")){
            System.out.print("YONSEI");
        }
        else if(inputStr.equals("1")){
            System.out.print("Leading the Way to the Future");
        }
    }
}
