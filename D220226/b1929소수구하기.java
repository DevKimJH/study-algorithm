package studyAlgorithm.D220226;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// M이상 N이하의 소수를 모두 출력하는 프로그램 작성
public class b1929소수구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int answer = 0;
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] chkArr = new boolean[N+1];

        // chk가 True인 경우 지워진 것
        chkArr[0] = chkArr[1] = true;

        for(int i = 2 ; i * i <= N ; i++){
            if(chkArr[i] == true) continue;

            if(chkArr[i] == false){
                for(int j = i + i ; j <= N ; j += i){
                    chkArr[j] = true;
                }
            }
        }

        for(int i = M ; i <= N ; i++){
            if (chkArr[i] == false) {
                System.out.println(i);
            }
        }
    }
}
