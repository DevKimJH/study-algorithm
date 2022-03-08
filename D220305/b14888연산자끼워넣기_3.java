package studyAlgorithm.D220305;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

 N개의 수로 이루어진 수열 A1 A2 ... AN이 주어진다.
 또 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다.
 연산자는 덧셈(+) 뺄셈(-) 곱셈(x) 나눗셈(/) 로만 이루어진다.

 식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 한다. 또, 나눗셈은 정수 나눗셈으로 몫만 취한다.
 음수를 양수로 나눌 때는 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다.

 N개의 수와 N-1개의 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을
 작성하시오

 */

public class b14888연산자끼워넣기_3 {

    static int maxNum = Integer.MIN_VALUE;
    static int minNum = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];
        int[] processArr = new int[4];
        int[] processArrBackup = new int[4];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < 4; i++) {
            processArr[i] = Integer.parseInt(st.nextToken());
        }

        process(N, 0, numArr, processArr, 0);

        System.out.println(maxNum);
        System.out.println(minNum);
    }

   static void process(int N, int idx, int[] numArr, int[] processArr, int number){
        if(idx == N){
            if(number > maxNum){
                maxNum = number;
            }

            if(number < minNum){
                minNum = number;
            }
            return;
        }


        for(int i = 0 ; i < N ; i++){
            //if(processArr[i])
            process(N, idx+1, numArr, processArr, number);
        }
   }
}
