package studyAlgorithm.D220226;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b2609최대공약수최소공배수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " " );

        int inputFirstNum = Integer.parseInt(st.nextToken());
        int inputSecondNum = Integer.parseInt(st.nextToken());

        int gcd = GCD(inputFirstNum, inputSecondNum);

        // 최대 공약수 출력
        System.out.println(gcd);

        // 최소 공배수 출력 방법 1
        System.out.println(gcd * (inputFirstNum / gcd) * (inputSecondNum / gcd));

        // 최소 공배수 출력 방법 2
        //System.out.println((inputFirstNum * inputSecondNum) / gcd);
    }

    static int GCD(int inputFirstNum, int inputSecondNum){
        if(inputSecondNum == 0){
            return inputFirstNum;
        }
        else{
            return GCD(inputSecondNum, inputFirstNum % inputSecondNum);
        }
    }
}
