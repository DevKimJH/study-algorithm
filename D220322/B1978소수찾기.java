package studyAlgorithm.D220322;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1978소수찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;

        for(int i = 0 ; i < N ; i++){
            int inputNum = Integer.parseInt(st.nextToken());
            boolean chkFlag = true;
            // 소수인지 판단
            for(int j = 2 ; j * j <= inputNum ; j++){
                if(inputNum % j == 0){
                    chkFlag = false;
                    break;
                }
            }
            if(inputNum == 1) chkFlag = false;

            if(chkFlag == true) answer++;
        }

        System.out.println(answer);
    }
}
