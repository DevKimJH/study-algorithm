package studyAlgorithm.M2207.D25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15963 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Long N = Long.parseLong(st.nextToken());
        Long M = Long.parseLong(st.nextToken());


        if(N == M){
            System.out.print("1");
        }
        else{
            System.out.print("0");
        }
    }
}

