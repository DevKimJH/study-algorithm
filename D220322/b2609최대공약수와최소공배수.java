package studyAlgorithm.D220322;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2609최대공약수와최소공배수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " " );
        int inputNumOne = Integer.parseInt(st.nextToken());
        int inputNumTwo = Integer.parseInt(st.nextToken());

        int GCD = GCD(inputNumOne, inputNumTwo);

        System.out.println(GCD);

        int LCM = GCD * (inputNumOne / GCD) * (inputNumTwo / GCD);

        System.out.println(LCM);
    }

    static int GCD(int numOne, int numTwo){
        if(numTwo == 0){
            return numOne;
        }
        else{
            return GCD(numTwo, numOne % numTwo);
        }
    }
}
