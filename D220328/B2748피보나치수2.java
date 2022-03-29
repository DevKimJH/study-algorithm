package studyAlgorithm.D220328;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2748피보나치수2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        System.out.println(process(N));
    }

    static int process(int N){
        if(N == 0){
            return 0;
        }
        else if(N == 1){
            return 1;
        }
        else{
            return process(N-1) + process(N-2);
        }
    }
}
