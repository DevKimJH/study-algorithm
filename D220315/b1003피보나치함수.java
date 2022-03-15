package studyAlgorithm.D220315;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 fibonacci(n) 을 호출했을 때 0과 1이 각각 몇 번 출력되는지 구하는 프로그램?
 */
public class b1003피보나치함수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        // N
        for(int i = 0 ; i < T ; i++){
            System.out.println(fibonacci(Integer.parseInt(br.readLine())));
        }
    }

    static int fibonacci(int n){
        if(n < 2) return n;
        else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}

/*
fib 1 : 1
fib 2 : 1
fib 3 : 2
fib 4 : 3
*/