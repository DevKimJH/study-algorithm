package studyAlgorithm.D220305;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 정수 N이 주어졌을 때, N이 1이상 9 이하의 두 수 a, b의 곱으로 표현될 수 있는지 판단하라.

 */
public class s12004구구단 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < TC ; i++){
            int inputNumber = Integer.parseInt(br.readLine());
            boolean chkFlag = false;
            for(int j = 1 ; j <= 9 ; j++){
                int dividedValue = inputNumber / j;
                if(dividedValue < 10 && dividedValue * j == inputNumber){
                    chkFlag = true;
                    break;
                }
                else{
                    continue;
                }
            }

            if(chkFlag == true){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
}
