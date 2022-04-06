package studyAlgorithm.D220406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 수빈이가 세상에서 가장 좋아하는 것은 소수이고, 취미는 소수를 이용해 노는 것이다. 요즘 수빈이가 가장 관심 있어 하는 소수는 7331.
 7331은 신기하게도 733도 소수, 73도 소수, 7도 소수다. 즉 왼쪽부터 1,2,3,4자릿수 모두 소수다. 수빈이는 이런 숫자를 신기한 소수라고 이름 붙였다.
 수빈이는 N의 자리의 숫자 중 어떤 수들이 신기한 소수인지 궁금해졌다. 숫자 N이 주어졌을 때 N의 자리 숫자 중 신기한 소수를 모두 찾아보자.
 */


public class B2023신기한소수찾기 {

    static int[] firstArr = { 2, 3, 5, 7};
    static int[] lastArr = {1,3,5,7,9};



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < firstArr.length ; i++){
            process(1, N, firstArr[i]);
        }
        //process(1, N, 0);
    }

    static void process(int idx, int N, int number){
        if(idx == N){
            System.out.println(number);
            return;
        }

        /*
        if(idx == 1){
            for(int i = 0 ; i < firstArr.length ; i++){

            }
        }
        */

        for(int i = 0 ; i < lastArr.length ; i++){
            int nextNumber = number * 10 + lastArr[i];
            boolean result = chkPrimeNumber(nextNumber, idx+1);

            if(result == true){
                process(idx+1, N, nextNumber);
            }
        }

    }

    // 소수인지 아닌지 체크하는 곳
    static boolean chkPrimeNumber(int nextNumber, int idx){
        boolean flag = true;

        while(nextNumber > 0){
            for(int i = 2 ; i * i <= nextNumber ; i++){
                if(nextNumber % i == 0){
                    flag = false;
                    break;
                }
            }

            if(flag == true){
                nextNumber = nextNumber / 10;
            }
            else{
                break;
            }
        }
        return flag;
    }
}