package studyAlgorithm.D220311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2609최대공약수최소공배수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        st = new StringTokenizer(br.readLine(), " ");

        int inputFirstNum = Integer.parseInt(st.nextToken());
        int inputSecondNum = Integer.parseInt(st.nextToken());

        int gcd = GCD(inputFirstNum, inputSecondNum);

        System.out.println(gcd);

        System.out.println(inputFirstNum * inputSecondNum / gcd);
    }

    static int GCD(int inputFirstNum, int inputSecondNum){
        if(inputSecondNum == 0){
            return inputFirstNum;
        }

        return GCD(inputSecondNum, inputFirstNum % inputSecondNum);
    }
}
