package studyAlgorithm.D220421;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P피보나치메모이제이션 {

    static int[] memo = new int[100];

    // 피보나치 함수(Fibonacci Function)를 재귀함수로 구현(탑다운 다이나믹 프로그래밍)
    static int fiboTopdown(int number){
        // 종료 조건 ( 1 혹은 2일 때 1을 반환)
        if(number == 1 || number == 2){
            return 1;
        }

        // 이미 계산한 적 있는 문제라면 그대로 반환
        if(memo[number] != 0){
            return memo[number];
        }

        // 아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 반환

        return fiboTopdown(number-1) + fiboTopdown(number-2);
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        System.out.println(fiboTopdown(10));

        memo = new int[100];

        // 첫 번째 피보나치 수와 두 번째 피보나치 수는 1
        memo[1] = 1;
        memo[2] = 1;

        for(int i = 3 ; i < 100 ; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }

        System.out.println(memo[10]);



    }


}
