package studyAlgorithm.D220213;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 1부터 N까지 자연수중에서 중복 없이 M개를 고른 수열
 */
public class b15649N과M1 {
    static int[] answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] chkArr = new boolean[N+1];
        answer = new int[N+1];
        for(int i = 1 ; i <= N ; i++){
            chkArr[i] = false;
        }

        process(0, chkArr,  N,  M);
    }

    static void process(int index, boolean[] chkArr, int N, int M){

        // M개 뽑았을 경우
        /*
        if(cntOfChk == M){

            for(int i = 1 ; i <= N ; i++){
                if(chkArr[i] == true){
                    System.out.print(answer[i] + " ");
                }
            }
            System.out.println("");


            return;
        }
        */

        if(index == M){
            for(int i = 0 ; i < M ; i++){
                System.out.print(answer[i] + " " );
            }
            System.out.println("");
        }

        // M개보다 적게 뽑은 경우 + 선택하지 않은 index인 경우

        /*
        for(int i = 1 ; i <= N ; i++){
        //for(int i = 1 ; i <= N ; i++){
            if(chkArr[i] == false){
                chkArr[i] = true;
                //answer[i] = i;

                process(i+1, chkArr, cntOfChk+1, N, M);
                chkArr[i] = false;
            }
        }
         */

        // M개보다 적게 뽑은 경우 + 선택하지 않은 index인 경우 다시 찾기
        for(int i = 1 ; i <= N ; i++){
            if(chkArr[i] == false){
                chkArr[i] = true;
                answer[index] = i;
                process(index+1, chkArr, N, M);
                chkArr[i] = false;
            }
        }
    }
}
