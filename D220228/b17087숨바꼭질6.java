package studyAlgorithm.D220228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

수빈이는 동생 N명과 숨바꼭질을 하고 있다. 수빈이는 현재 점 S에 있고, 동생은
 A1, A2, A3, ... AN에 있다.
 수빈이는 걸어서 이동을 할 수 있다. 수빈이의 위치가 X일때 걷는다면 1초 후에 X+D나 X-D로 이동할 수 있다.
 수빈이의 위치가 동생이 있는 위치와 같으면, 동생을 찾았다고 한다.
 모든 동생을 찾기 위해 D의 값을 정하려고 한다.

 */
public class b17087숨바꼭질6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 동생수
        int S = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int[] positionArr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;

        // 동생 위치 세팅
        // + 현재 수빈이 위치와 얼마나 떨어져있는지 계산
        for(int i = 0 ; i < N ; i++){
            //positionArr[N] = Integer.parseInt(st.nextToken());
            positionArr[i] = Math.abs(Integer.parseInt(st.nextToken()) - S);
        }

        answer = positionArr[0];

        for(int i = 1 ; i < N ; i++){
            answer = GCD(answer, positionArr[i]);
        }

        System.out.println(answer);
    }

    static int GCD(int num1, int num2){
        if(num2 == 0){
            return num1;
        }
        else{
            return GCD(num2, num1%num2);
        }
    }
}
