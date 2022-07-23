package studyAlgorithm.M2207.D23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class B11718 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true){
            String inputStr = br.readLine();

            if(inputStr == null || inputStr.isEmpty()){
                break;
            }

            sb.append(inputStr).append("\n");
        }


        bw.write(sb+"");
        bw.close();
        br.close();
    }
}
