package studyAlgorithm.D220306;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 2 x n 크기의 직사각형을 1 x 2 , 2 x 1 타일로 채우는 방법의 수를 구하는 프로그램을 작성
 D[1] = 1;
 D[2] = 2;
 D[3] =
 */
public class b11726_2xN스타일링 {
    static int memArr[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        memArr = new int[1000];
        int N = Integer.parseInt(br.readLine());

        System.out.println(process(N));
    }

    static int process(int N){
        if( N <= 2) return N;

        if(memArr[N] > 0 )  return memArr[N];

        else {
            memArr[N-1] = process(N-1);
            memArr[N-2] = process(N-2);
            return memArr[N-1] + memArr[N-2];
        }
    }


}
