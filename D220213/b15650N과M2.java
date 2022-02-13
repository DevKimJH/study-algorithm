package studyAlgorithm.D220213;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15650N과M2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] chkArr = new boolean[N+1];
        for(int i = 1 ; i <= N ; i++){
            chkArr[i] = false;
        }

        process(0, chkArr, 0,  N,  M);
    }

    static void process(int index, boolean[] chkArr, int cnt, int N, int M){
        if(cnt == M){
            for(int i = 1 ; i <= N ; i++){
                if(chkArr[i] == true){
                    System.out.print(i + " ");
                }
            }
            System.out.println("");
        }


        for(int i = index+1 ; i <= N ; i++){
            if(chkArr[i] == false){
                chkArr[i] = true;
                process(i, chkArr, cnt+1, N, M);
                chkArr[i] = false;
            }
        }
    }
}
