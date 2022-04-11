package studyAlgorithm.D220411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 '큰 수의 법칙'은 일반적으로 통계 분야에서 다루어지는 내용이지만 동빈이는 본인만의 방식으로 다르게 사용하고 있다.
 동빈이의 큰 수의 법칙은 다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙
 단 배열의 특정한 인덱스(번호)에 해당하는 수가 연속해서 K번을 초과하여 더해질 수 없는 것이 이 법칙의 특징

 ex) 2,4,5,4,6으로 이루어진 배열이 있을 때 M이 8이고, K가 3이라고 한다면
 이 경우 특정한 인덱스의 수가 연속해서 세 번까지만 더해질 수 있으므로 큰 수의 법칙에 따른 결과는 6 + 6 + 6 + 5 + 6 + 6 + 6 + 5 인 46이 된다.

 단, 서로 다른 인덱스에 해당하는 수가 같은 경우에도 서로 다른 것으로 간주한다.
 ex) 3,4,3,4,3으로 일어진 배열이 있을 때 M이 7이고, K가 2라고 가정
 이 경우 두 번째 원소에 해당하는 4와 네 번째 원소에 해당하는 4를 번갈아 두 번씩 더하는 것이 가능하다. 결과적으로 4 + 4 + 4 + 4 + 4 + 4 + 4 = 28
 */

public class P02큰수의법칙 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        // 배열의 크기
        int N = Integer.parseInt(st.nextToken());

        // 숫자가 더해지는 횟수
        int M = Integer.parseInt(st.nextToken());

        // 초과 idx
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        // 배열 세팅
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        int idx = 0;

        for(int i = 0 ; i < M ; i++){

            if(idx == K){
                answer = answer + arr[N-2];
                idx = 0;
                continue;
            }

            answer = answer + arr[N-1];
            idx++;
        }

        System.out.println(answer);

    }
}
