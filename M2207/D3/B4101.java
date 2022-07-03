package studyAlgorithm.M2207.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B4101 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int firstNumber = Integer.parseInt(st.nextToken());
            int secondNumber = Integer.parseInt(st.nextToken());

            if(firstNumber == 0 && secondNumber == 0){
                break;
            }

            if(firstNumber > secondNumber){
                sb.append("Yes").append("\n");
            }
            else{
                sb.append("No").append("\n");
            }
        }

        bw.write(sb+"");
        bw.close();
    }

}
