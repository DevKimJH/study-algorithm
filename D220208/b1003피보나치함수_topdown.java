package studyAlgorithm.D220208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1003피보나치함수_topdown {

    static class Node{
        Node(int number, int countZero, int countOne){
            this.number = number;
            this.countZero = countZero;
            this.countOne = countOne;
        }

        int number;
        int countZero;
        int countOne;
    }

    static Node[] dp = new Node[41];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++){
            int N = Integer.parseInt(br.readLine());

            process(new Node(N,0,0));
        }
    }

    static Node process(Node node){
        if(node.number==0){
            return new Node(0, 1, 0);
        }
        else if(node.number==1){
            return new Node(0, 0, 1);
        }

        if(dp[node.number].number != 0){
            return dp[N];
        }
        else{
//            return new Node(process(dp[N-2].number + dp[N-1].number, dp[N-2].countZero + dp[N-1].countZero, dp[N-2].countOne + dp[N-1].countOne);
        }
    }
}
