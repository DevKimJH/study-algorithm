package studyAlgorithm.D220306;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지이다.
 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
 2. X가 2로 나누어 떨어지면, 2로 나눈다.
 3. 1을 뺀다.

 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 사용해서 1을 만들려고 한다. 
 연산을 사용하는 횟수의 최솟값을 출력하시오

 */
public class b1463_1로만들기 {

    static int[] memArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        memArr = new int[10000000];

        int X = Integer.parseInt(br.readLine());

        System.out.println(process(X));
    }

    static int process(int X){
        if(X == 1) return 0;

        if(memArr[X] > 0) return memArr[X];

        int result = process(X-1) + 1;
        memArr[X] = result;

        if(X % 2 == 0){
            int temp = process(X/2) + 1;
            if(memArr[X] > temp) memArr[X] = temp;
        }

        if(X % 3 == 0){
            int temp = process(X/3) + 1;
            if(memArr[X] > temp) memArr[X] = temp;
        }

        return memArr[X];
    }
}
