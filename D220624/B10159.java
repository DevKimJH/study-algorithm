package studyAlgorithm.D220624;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 무게가 서로 다른 N개의 물건(1~N)

 ex) 총 6개의 물건이 있음
 [1] > [2]
 [2] > [3]
 [3] > [4]
 [5] > [4]
 [6] > [5]


 6
 5
 1 2
 2 3
 3 4
 5 4
 6 5
 */
public class B10159 {
    static int answer;
    static Node[] nodes;
    static boolean[] chkArr;
    public static class Node{
        ArrayList<Integer> prevNode;
        ArrayList<Integer> nextNode;
        public int value;



        Node(int value){
            this.value = value;
            prevNode = new ArrayList();
            nextNode = new ArrayList();
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 물건의 개수
        int N = Integer.parseInt(br.readLine());

        // 측정
        int M = Integer.parseInt(br.readLine());

        nodes = new Node[N+1];
        //boolean[] chkArr = new boolean[N+1];

        for(int i = 1 ; i <= N ; i++){
            nodes[i] = new Node(i);
        }

        // SetValue
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int inputFirstNum  = Integer.parseInt(st.nextToken());
            int inputSecondNum = Integer.parseInt(st.nextToken());

            nodes[inputFirstNum].prevNode.add(inputSecondNum);
            nodes[inputSecondNum].nextNode.add(inputFirstNum);
        }

        /*
        for(int i = 1 ; i <= N ; i++) {
            System.out.println(nodes[i].prevNode + " " + i + " " + nodes[i].nextNode);
        }
         */


        for(int i = 1 ; i <= N ; i++){
            Node node = nodes[i];
            int answer = 0;
            chkArr = new boolean[N+1];
            chkArr[i] = true;
            process(node);
            process2(node);

            for(int j = 1 ; j<= N ; j++){
                if(chkArr[j] == false){
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }


    static void process2(Node node){
        for(int i = 0 ; i < node.prevNode.size() ; i++){
            int idx = node.prevNode.get(i);
            if(chkArr[idx] == false){
                chkArr[idx] = true;
                Node tmpNode = nodes[idx];
                process2(tmpNode);
            }
        }
    }

    static void process(Node node){
        for(int i = 0 ; i < node.nextNode.size() ; i++){
            int idx = node.nextNode.get(i);
            if(chkArr[idx] == false){
                chkArr[idx] = true;
                Node tmpNode = nodes[idx];
                process(tmpNode);
            }
        }
    }
}


