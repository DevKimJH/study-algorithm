package studyAlgorithm.D220222;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b14396수열순열 {


    /**
     M번 인접한 두 수의 위치를 교환
     M번 인접한 두 수의 위치를 교환한다. 만들 수 있는
     수열의 개수를 1,000,000,009로 나눈 나머지를 출력
     */

    //static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<Integer>();
        int[] numArr = new int[N+1];

        for(int i = 1  ; i <= N ; i++){
            numArr[i] = i;
        }

        /**
         1 2
         --1 3
         2 3

         */
        //System.out.println(factorial(5));



        //process(0, numArr, N, M, stack);


    }

    static void process(int idx, int N, int M){
        if(idx == M){

        }


        for(int i = 0 ; i < N-1 ; i++){

        }
    }
}
