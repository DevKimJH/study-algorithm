package studyAlgorithm.D220404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 N개의 숫자가 공백 없이 써 있다. 이 숫자를 모두 합해 출력하는 프로그램을 작성하시오.

 */

public class B11720숫자의합구하기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 숫자의 개수
        int N = Integer.parseInt(br.readLine());

        String inputNumber = br.readLine();

        int answer = 0;

        for(int i = 0 ; i < N ; i++){
            answer += Integer.parseInt(inputNumber.substring(i, i+1));
        }

        System.out.println(answer);

    }
}
